package com.lil.fmmall.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lil.fmmall.vo.ResStatus;
import com.lil.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Lil
 * @date 2022/01/23 16:10
 **/
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if ("OPTIONs".equalsIgnoreCase(method)) {
            return true;
        }

        String token = request.getHeader("token");
        System.out.println("----------------");
        System.out.println(token);
        if (token == null) {
            ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录!", null);
            doResponse(response, resultVO);
        } else {
            try { //验证token
                JwtParser parser = Jwts.parser();
                //解析token的SigningKey必须和生成token时设置密码一致 //如果token正确(密码正确，有效期内)则正常执行，否则抛出异常
                parser.setSigningKey("QIANfeng6666");
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch (ExpiredJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "登录过期，请重新登录!", null);
                doResponse(response, resultVO);
            } catch (UnsupportedJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "Tonken不合法,请自重!", null);
                doResponse(response, resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "请重新登录!", null);
                doResponse(response, resultVO);
            }
        }
        return false;
    }


    public void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }
}