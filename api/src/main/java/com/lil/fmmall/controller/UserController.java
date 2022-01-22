package com.lil.fmmall.controller;

import com.lil.fmmall.entity.Users;
import com.lil.fmmall.service.UserService;
import com.lil.fmmall.service.impl.UserServiceImpl;
import com.lil.fmmall.util.Base64Utils;
import com.lil.fmmall.vo.ResStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.lil.fmmall.vo.ResultVO;

import java.sql.ResultSet;


/**
 * @author Lil
 * @date 2022/01/06 16:16
 **/
@CrossOrigin
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/login")
    public ResultVO login(String name, String pwd) {
        ResultVO resultVO = userService.checkLogin(name, pwd);
        return resultVO;
    }

    @PostMapping("/register")
    public ResultVO register (@RequestBody Users users) {
        ResultVO resultVO = userService.userRegister(users.getUsername(), users.getPassword());
        return resultVO;
    }

}