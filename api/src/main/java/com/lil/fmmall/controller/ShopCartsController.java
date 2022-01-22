package com.lil.fmmall.controller;

import com.lil.fmmall.util.Base64Utils;
import com.lil.fmmall.vo.ResStatus;
import com.lil.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lil
 * @date 2022/01/22 16:53
 **/
@RestController
@CrossOrigin
@Api
@RequestMapping("/shopcart")
public class ShopCartsController {

    @GetMapping("/list")
    public ResultVO listCart(String token) {
        System.out.println("购物车列表接口");
        if (token == null) {
            return new ResultVO(ResStatus.NO,"请先登录",null);
        }else {
            String decode = Base64Utils.decode(token);
            if (decode.endsWith("QIANfeng6666")) {
                return new ResultVO(ResStatus.OK, "success",null);
            }else {
                return new ResultVO(ResStatus.OK, "请重新登录",null);
            }
        }
    }
}