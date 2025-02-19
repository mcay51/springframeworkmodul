package tr.com.mustafacay.spel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.mustafacay.spel.dto.SpELRequestDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpELControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testEvaluateExpression() throws Exception {
        SpELRequestDTO request = new SpELRequestDTO();
        request.setExpression("2 + 2");

        mockMvc.perform(post("/api/spel/evaluate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(4))
                .andExpect(jsonPath("$.successful").value(true));
    }

    @Test
    void testEvaluateInvalidExpression() throws Exception {
        SpELRequestDTO request = new SpELRequestDTO();
        request.setExpression("invalid + expression");

        mockMvc.perform(post("/api/spel/evaluate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
} 