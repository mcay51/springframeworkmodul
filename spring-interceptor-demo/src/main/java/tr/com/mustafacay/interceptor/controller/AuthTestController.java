package tr.com.mustafacay.interceptor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthTestController {

    @GetMapping("/public/test")
    public ResponseEntity<String> publicEndpoint() {
        return ResponseEntity.ok("Bu endpoint herkese açık!");
    }

    @GetMapping("/secure/test")
    public ResponseEntity<String> secureEndpoint() {
        return ResponseEntity.ok("Bu endpoint sadece yetkili kullanıcılara açık!");
    }
} 