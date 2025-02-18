package tr.com.mustafacay.context.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.mustafacay.context.scope.RequestScopedBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageSource messageSource;

    @MockBean
    private RequestScopedBean requestScopedBean;

    @Test
    void whenGetGreeting_thenReturnsWelcomeMessage() throws Exception {
        when(messageSource.getMessage(eq("welcome"), any(), any()))
            .thenReturn("Welcome, Test User!");

        mockMvc.perform(get("/api/demo/greeting")
                .param("name", "Test User"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome, Test User!"));
    }
} 