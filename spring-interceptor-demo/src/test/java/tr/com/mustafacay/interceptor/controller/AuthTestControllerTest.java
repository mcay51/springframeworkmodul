package tr.com.mustafacay.interceptor.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthTestController.class)
public class AuthTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPublicEndpoint() throws Exception {
        mockMvc.perform(get("/api/public/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdminEndpoint() throws Exception {
        mockMvc.perform(get("/api/admin/test")
                .header("Authorization", "Bearer valid_token")
                .header("X-User-Role", "ADMIN"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUserEndpoint() throws Exception {
        mockMvc.perform(get("/api/user/test")
                .header("Authorization", "Bearer valid_token")
                .header("X-User-Role", "USER"))
                .andExpect(status().isOk());
    }
} 