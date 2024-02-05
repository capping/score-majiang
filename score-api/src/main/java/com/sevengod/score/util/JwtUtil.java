package com.sevengod.score.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static final String SECRET = "nnn";
    private static final long EXPIRE = 60 * 24 * 7;
    public static final String HEADER = "Authorization";

    /**
     * 生成jwt token
     */
    public static String generateToken(Integer userId) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create().withIssuer(userId.toString()).sign(algorithm);
    }

    /*
    * Verify a JWT
     */
    public static Integer verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT verify = verifier.verify(token);
        String issuer = verify.getIssuer();
        return Integer.valueOf(issuer);
    }
}
