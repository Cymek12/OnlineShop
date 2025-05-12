package com.mysite.adapters.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.core.port.in.ProductUseCase;
import com.mysite.model.Product;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.mysite.adapters.TestDataBuilder.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class ProductControllerTest {
    @MockitoBean
    private ProductUseCase productUseCase;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addProduct_returnProductDTO() throws Exception {
        ProductCommand productCommand = buildProductCommand();
        ProductDTO productDTO = buildProductDTO();
        Product product = buildProduct();

        when(productUseCase.addProduct(any())).thenReturn(product);
        mockMvc.perform(post("/doctors")
                        .content(objectMapper.writeValueAsString(productCommand))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.firstName").value("jan"))
                .andExpect(jsonPath("$.lastName").value("kowalski"))
                .andExpect(jsonPath("$.email").value("new@gmail.com"))
                .andExpect(jsonPath("$.specialization").value("kardiolog"))
                .andExpect(jsonPath("$.institutionIds").isArray());
    }


}
