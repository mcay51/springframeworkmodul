package tr.com.mustafacay.interceptor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mustafacay.interceptor.annotation.RequiresRole;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthTestController {

    @GetMapping("/public/test")
    public ResponseEntity<String> publicEndpoint() {
        return ResponseEntity.ok("Bu endpoint herkese açık!");
    }

    @RequiresRole("ADMIN")
    @GetMapping("/admin/test")
    public ResponseEntity<String> adminEndpoint() {
        return ResponseEntity.ok("Bu endpoint sadece ADMIN rolüne sahip kullanıcılara açık!");
    }

    @RequiresRole(value = {"ADMIN", "USER"}, anyRole = true)
    @GetMapping("/user/test")
    public ResponseEntity<String> userEndpoint() {
        return ResponseEntity.ok("Bu endpoint ADMIN veya USER rolüne sahip kullanıcılara açık!");
    }
} 