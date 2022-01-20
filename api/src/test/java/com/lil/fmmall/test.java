package com.lil.fmmall;

import com.lil.fmmall.util.MD5Utils;

/**
 * @author Lil
 * @date 2022/01/10 23:02
 **/
public class test {
    public static void main(String[] args) {
        String pwd = "666";
        String md5Pwd = MD5Utils.md5(pwd);
        System.out.println(md5Pwd);

        String pwd2 = "666";
        String md5Pwd2 = MD5Utils.md5(pwd2);
        System.out.println(md5Pwd2);
    }
}