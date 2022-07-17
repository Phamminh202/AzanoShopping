package com.example.azanoshop.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.azanoshop.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.Arrays.stream;

public class ApiAuthorizationFilter extends OncePerRequestFilter {
    private static final String[] IGNORE_PATHS = {"/api/v1/login", "/api/v1/register", "/api/v1/token/refresh"};

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // nếu client gửi request đến 1 trong các url được bỏ qua thì không cần xử lý
        String requestPath = request.getServletPath();
        if (Arrays.asList(IGNORE_PATHS).contains(requestPath)) {
            filterChain.doFilter(request, response);
            return;
        }
        // trường hợp client không có request header theo format cần thiết
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            // cho qua (không có dấu kiểm duyệt)
            filterChain.doFilter(request, response);
            return;
        }
        //lấy token từ request header
        try {
            // remove chữ Bearer
            String token = authorizationHeader.replace("Bearer", "").trim();

            // dịch ngược JWT
            DecodedJWT decodedJWT = JwtUtil.getDecodedJwt(token);

            // lấy thông tin username
            String username = decodedJWT.getSubject();

            //lấy thông tin của role đăng nhập
            String[] roles = decodedJWT.getClaim(JwtUtil.ROLE_CLAIM_KEY).asArray(String.class);

            // tạo danh sách các role
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            stream(roles).forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role));
            });

            // lưu thông tin nguời dùng đăng nhập vào spring context
            // để cho các controller hay filter có thể sử dụng
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            Map<String, String> errors = new HashMap<>();
            errors.put("error", ex.getMessage());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), errors);
        }
    }
}