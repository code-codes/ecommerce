package com.ecommerce.ecommerce.payload;

import com.ecommerce.ecommerce.security.response.UserInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseCookie;

@Data
@AllArgsConstructor
public class AuthenticationResult {
    private final UserInfoResponse response;
//    private final ResponseCookie jwtCookie;
}
