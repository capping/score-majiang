package com.sevengod.score.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JwtUtilTest {
    @Test
    public void testGenerateToken() {
        JwtUtil jwtUtil = new JwtUtil();
        String s = jwtUtil.generateToken(1);
        System.out.println(s);
    }

    @Test
    public void testVerifyToken() {
        JwtUtil jwtUtil = new JwtUtil();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiIxIn0.N2Sd46ofcC22mVUNgAjlqmnu4SJB9VWZuOHvRKNV14c";
        Integer userId = jwtUtil.verifyToken(token);
        assert userId.equals(1);
    }
}
