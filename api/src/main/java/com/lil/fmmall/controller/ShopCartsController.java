package com.lil.fmmall.controller;

import com.lil.fmmall.util.Base64Utils;
import com.lil.fmmall.vo.ResStatus;
import com.lil.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lil
 * @date 2022/01/22 16:53
 **/
@RestController
@CrossOrigin
@Api(tags = "购物车模块")
@RequestMapping("/shopcart")
public class ShopCartsController {

    @PostMapping("/list")
    public ResultVO listCart() {

        return new ResultVO(ResStatus.OK, "success", null);
    }
}