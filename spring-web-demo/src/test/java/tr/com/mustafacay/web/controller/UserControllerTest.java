package tr.com.mustafacay.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.mustafacay.web.dto.UserDto;
import tr.com.mustafacay.web.exception.UserNotFoundException;
import tr.com.mustafacay.web.service.UserService;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserDto testUserDto;

    @BeforeEach
    void setUp() {
        testUserDto = new UserDto();
        testUserDto.setId(1L);
        testUserDto.setName("Test User");
        testUserDto.setEmail("test@example.com");
        testUserDto.setPhone("5551234567");
    }

    @Test
    void createUser_Success() throws Exception {
        when(userService.createUser(any(UserDto.class))).thenReturn(testUserDto);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUserDto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(testUserDto.getId()))
            .andExpect(jsonPath("$.name").value(testUserDto.getName()));
    }

    @Test
    void getUserById_Success() throws Exception {
        when(userService.getUserById(1L)).thenReturn(testUserDto);

        mockMvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(testUserDto.getId()))
            .andExpect(jsonPath("$.name").value(testUserDto.getName()));
    }

    @Test
    void getUserById_NotFound() throws Exception {
        when(userService.getUserById(99L)).thenThrow(new UserNotFoundException("Kullanıcı bulunamadı: 99"));

        mockMvc.perform(get("/api/users/99"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.error").exists());
    }

    @Test
    void getAllUsers_Success() throws Exception {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(testUserDto));

        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(testUserDto.getId()))
            .andExpect(jsonPath("$[0].name").value(testUserDto.getName()));
    }

    @Test
    void updateUser_Success() throws Exception {
        when(userService.updateUser(eq(1L), any(UserDto.class))).thenReturn(testUserDto);

        mockMvc.perform(put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUserDto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(testUserDto.getId()))
            .andExpect(jsonPath("$.name").value(testUserDto.getName()));
    }

    @Test
    void deleteUser_Success() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
            .andExpect(status().isNoContent());
    }

    @Test
    void deleteUser_NotFound() throws Exception {
        doThrow(new UserNotFoundException("Silinecek kullanıcı bulunamadı: 99"))
            .when(userService).deleteUser(99L);

        mockMvc.perform(delete("/api/users/99"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.error").exists());
    }
} 