package com.sevengod.score.interceptor;

import com.sevengod.score.domain.vo.TokenInfo;
import com.sevengod.score.model.User;
import com.sevengod.score.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        // 只有返回true才会继续向下执行，返回false取消当前请求
        if (token == null || StringUtils.isEmpty(JwtUtil.verifyToken(token))) {
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        TokenInfo.set("user_id", JwtUtil.verifyToken(token));
        return true;
    }
}
