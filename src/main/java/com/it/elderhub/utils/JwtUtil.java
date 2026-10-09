package com.it.elderhub.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final long expirationMs;

    public JwtUtil(@Value("${jwt.secret}") String secret,
                   @Value("${jwt.expiration-ms}") long expirationMs) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    /**
     * 负责签发token
     * 用户ID + 用户名
     *     ↓
     * 写入 JWT payload
     *     ↓
     * 设置签发时间、过期时间
     *     ↓
     * 用 secretKey 签名
     *     ↓
     * 返回字符串 Token
     *
     * Jwts.builder()：启动一个 JWT 的构建器。
     * .subject(String.valueOf(userId))：设置 Token 的“主体（sub）”。这里我们把用户 ID 存进去，因为 JWT 解析出来默认就能通过 getSubject() 拿到它。
     * .claim("username", username)：设置自定义的“声明（claim）”。我们额外把用户名写进去。
     * .issuedAt(now)：设置签发时间，即这个 Token 是什么时候生成的。
     * .expiration(...)：设置过期时间。当前时间 + 配置好的有效期。一旦过期，这个 Token 就作废了。
     * .signWith(secretKey)：最关键的一步。用我们在配置文件中设置的密钥（Secret Key）对前面所有的信息进行数字签名。这就相当于给身份证盖了一个防伪钢印。
     * .compact()：将以上所有的信息打包、压缩，生成最终的、长字符串形式的 JWT Token。
     *
     * @param userId
     * @param username
     * @return
     */
    public String generateToken(Integer userId, String username,String roleName) {
        Date now = new Date();
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("username", username)
                .claim("roleName",roleName)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + expirationMs))
                .signWith(secretKey)
                .compact();
    }

    /**
     * 负责解析token
     * 收到 Token
     *     ↓
     * 用相同密钥验签
     *     ↓
     * 解析出 payload
     *     ↓
     * 返回 Claims
     *
     * Jwts.parser()：启动一个 JWT 的解析器。
     * .verifyWith(secretKey)：安全校验的核心。使用相同的 Secret Key 去验证 Token 上的签名。如果 Token 被篡改过（比如用户自己把 ID 改成别人的），因为无法通过签名验证，这里会直接抛出异常。
     * .build()：完成解析器的构建。
     * .parseSignedClaims(token)：解析并验证 Token，确保它既没有被篡改，也没有过期。
     * .getPayload()：如果前几步都通过了，就可以安全地取出 Token 里面的“载荷”，也就是 Claims 对象。
     *
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}