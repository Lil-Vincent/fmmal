package com.lil.fmmall.service.impl;

import com.lil.fmmall.dao.UsersMapper;
import com.lil.fmmall.entity.Users;
import com.lil.fmmall.service.UserService;
import com.lil.fmmall.util.MD5Utils;
import com.lil.fmmall.vo.ResStatus;
import com.lil.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author Lil
 * @date 2022/01/06 22:32
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ResultVO userRegister(String name, String pwd) {
        synchronized (this) {
//1.根据用户查询，这个用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", name);
            List<Users> user = usersMapper.selectByExample(example);
//2.如果没有被注册则进行保存操作
            if (user.size() == 0) {
                String md5Pwd = MD5Utils.md5(pwd);
                Users user1 = new Users();
                user1.setUsername(name);
                user1.setPassword(md5Pwd);
                user1.setUserImg("img/default.png");
                user1.setUserRegtime(new Date());
                user1.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user1);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功!", user1);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败!", null);
                }
            } else {
                return new ResultVO(ResStatus.NO, "用户名已经被注册!", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String pwd) {
        //1. 判断是否存在name
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> user = usersMapper.selectByExample(example);
        //2. 账号密码不能为空

        if (user.size() == 0) {
            return new ResultVO(ResStatus.NO, "登录失败， 用户名不存在!", null);
        }else {
            System.out.println(pwd);
            String pwd1 = MD5Utils.md5(pwd);
            if (pwd1.equals(user.get(0).getPassword())) {
                return new ResultVO(ResStatus.OK, "登录成功", user);
            }else {
                return new ResultVO(ResStatus.NO, "登录失败，密码错误", null);
            }
        }

    }
}