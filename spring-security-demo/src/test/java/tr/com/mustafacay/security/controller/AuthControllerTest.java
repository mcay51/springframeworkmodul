package tr.com.mustafacay.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.mustafacay.security.entity.Role;
import tr.com.mustafacay.security.entity.RoleType;
import tr.com.mustafacay.security.entity.User;
import tr.com.mustafacay.security.payload.request.LoginRequest;
import tr.com.mustafacay.security.payload.request.SignupRequest;
import tr.com.mustafacay.security.repository.RoleRepository;
import tr.com.mustafacay.security.repository.UserRepository;
import tr.com.mustafacay.security.security.jwt.JwtUtils;
import tr.com.mustafacay.security.security.service.UserDetailsImpl;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
class AuthControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AuthenticationManager authenticationManager;
    
    @MockBean
    private UserRepository userRepository;
    
    @MockBean
    private RoleRepository roleRepository;
    
    @MockBean
    private PasswordEncoder encoder;
    
    @MockBean
    private JwtUtils jwtUtils;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private LoginRequest loginRequest;
    private SignupRequest signupRequest;
    private User testUser;
    private Role userRole;
    
    @BeforeEach
    void setUp() {
        loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("password");
        
        signupRequest = new SignupRequest();
        signupRequest.setUsername("newuser");
        signupRequest.setEmail("newuser@example.com");
        signupRequest.setPassword("password");
        
        userRole = new Role(RoleType.ROLE_USER);
        
        testUser = new User();
        testUser.setId(1L);
        testUser.setUsername("testuser");
        testUser.setEmail("testuser@example.com");
        testUser.setPassword("encodedPassword");
        testUser.setRoles(Collections.singleton(userRole));
    }
    
    @Test
    void authenticateUser_Success() throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            UserDetailsImpl.build(testUser),
            null,
            UserDetailsImpl.build(testUser).getAuthorities()
        );
        
        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(jwtUtils.generateJwtToken(any())).thenReturn("test-jwt-token");
        
        mockMvc.perform(post("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.token").value("test-jwt-token"))
            .andExpect(jsonPath("$.username").value("testuser"));
    }
    
    @Test
    void registerUser_Success() throws Exception {
        when(userRepository.existsByUsername(any())).thenReturn(false);
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(roleRepository.findByName(RoleType.ROLE_USER)).thenReturn(Optional.of(userRole));
        when(encoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.save(any())).thenReturn(testUser);
        
        mockMvc.perform(post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(signupRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("User registered successfully!"));
    }
    
    @Test
    void registerUser_DuplicateUsername() throws Exception {
        when(userRepository.existsByUsername("newuser")).thenReturn(true);
        
        mockMvc.perform(post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(signupRequest)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Error: Username is already taken!"));
    }
} 