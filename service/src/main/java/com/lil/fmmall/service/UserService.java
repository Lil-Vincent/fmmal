package com.lil.fmmall.service;

import com.lil.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @author Lil
 * @date 2022/01/06 22:27
 **/
@Service
public interface UserService {

    //注册
    public ResultVO userRegister(String name, String pwd);

    //登录
    public ResultVO checkLogin(String name, String pwd);

}