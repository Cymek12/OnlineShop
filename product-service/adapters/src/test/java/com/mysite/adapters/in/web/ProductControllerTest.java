package com.mysite.adapters.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.core.exception.ProductAlreadyExistsException;
import com.mysite.core.exception.ProductDataCannotBeNull;
import com.mysite.core.exception.ProductNotFoundException;
import com.mysite.core.port.in.ProductUseCase;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.model.Product;
import com.mysite.model.ProductConfiguration;
import com.mysite.publicmodel.command.ProductCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.mysite.adapters.TestDataBuilder.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        Product product = buildProduct(1L);

        when(productUseCase.addProduct(any())).thenReturn(product);
        mockMvc.perform(post("/products")
                        .content(objectMapper.writeValueAsString(productCommand))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("computer"))
                .andExpect(jsonPath("$.price").value(100.00))
                .andExpect(jsonPath("$.productType").value("COMPUTER"))
                .andExpect(jsonPath("$.configurations").isArray());
    }

    @Test
    void addProduct_returnBadRequest() throws Exception {
        ProductCommand productCommand = buildProductCommand();
        when(productUseCase.addProduct(any())).thenThrow(new ProductAlreadyExistsException("Product already exists"));

        mockMvc.perform(post("/products")
                        .content(objectMapper.writeValueAsString(productCommand))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Product already exists"))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"));
    }

    @Test
    void getProductById_returnProductDTO() throws Exception {
        String id = "1";
        Product product = buildProduct(1L);

        when(productUseCase.getProductById(Long.valueOf(id))).thenReturn(product);
        mockMvc.perform(get("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("computer"))
                .andExpect(jsonPath("$.price").value(100.00))
                .andExpect(jsonPath("$.productType").value("COMPUTER"))
                .andExpect(jsonPath("$.configurations").isArray())
                .andExpect(jsonPath("$.configurations[0].id").value(1L))
                .andExpect(jsonPath("$.configurations[0].name").value("processor"))
                .andExpect(jsonPath("$.configurations[0].value").value("intel"))
                .andExpect(jsonPath("$.configurations[0].additionalPrice").value(100.00))
                .andExpect(jsonPath("$.configurations[1].id").value(2L))
                .andExpect(jsonPath("$.configurations[1].name").value("processor"))
                .andExpect(jsonPath("$.configurations[1].value").value("amd"))
                .andExpect(jsonPath("$.configurations[1].additionalPrice").value(100.00));
    }

    @Test
    void getProductById_returnNotFound() throws Exception {
        String id = "1";

        when(productUseCase.getProductById(Long.valueOf(id))).thenThrow(new ProductNotFoundException("Product not found"));
        mockMvc.perform(get("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found"))
                .andExpect(jsonPath("$.status").value("NOT_FOUND"));
    }

    @Test
    void getAllProducts_returnPageContentDTO() throws Exception {
        List<Product> products = List.of(
                buildProduct(1L),
                buildProduct(2L)
        );
        PageContent<Product> pageContent = new PageContent<>(2L, 0, 1, products);
        when(productUseCase.getAllProducts(any(MyPageable.class), eq(null))).thenReturn(pageContent);
        mockMvc.perform(get("/products")
                        .param("size", "5")
                        .param("page", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(2L))
                .andExpect(jsonPath("$.currentPage").value(0))
                .andExpect(jsonPath("$.totalPageNumber").value(1))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].name").value("computer"))
                .andExpect(jsonPath("$.content[0].price").value(100.00))
                .andExpect(jsonPath("$.content[0].productType").value("COMPUTER"))
                .andExpect(jsonPath("$.content[0].configurations").isArray())
                .andExpect(jsonPath("$.content[0].configurations[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].configurations[0].name").value("processor"))
                .andExpect(jsonPath("$.content[0].configurations[0].value").value("intel"))
                .andExpect(jsonPath("$.content[0].configurations[0].additionalPrice").value(100.00))
                .andExpect(jsonPath("$.content[0].configurations[1].id").value(2L))
                .andExpect(jsonPath("$.content[0].configurations[1].name").value("processor"))
                .andExpect(jsonPath("$.content[0].configurations[1].value").value("amd"))
                .andExpect(jsonPath("$.content[0].configurations[1].additionalPrice").value(100.00))
                .andExpect(jsonPath("$.content[1].id").value(2L))
                .andExpect(jsonPath("$.content[1].name").value("computer"))
                .andExpect(jsonPath("$.content[1].price").value(100.00))
                .andExpect(jsonPath("$.content[1].productType").value("COMPUTER"))
                .andExpect(jsonPath("$.content[1].configurations").isArray())
                .andExpect(jsonPath("$.content[1].configurations[0].id").value(1L))
                .andExpect(jsonPath("$.content[1].configurations[0].name").value("processor"))
                .andExpect(jsonPath("$.content[1].configurations[0].value").value("intel"))
                .andExpect(jsonPath("$.content[1].configurations[0].additionalPrice").value(100.00))
                .andExpect(jsonPath("$.content[1].configurations[1].id").value(2L))
                .andExpect(jsonPath("$.content[1].configurations[1].name").value("processor"))
                .andExpect(jsonPath("$.content[1].configurations[1].value").value("amd"))
                .andExpect(jsonPath("$.content[1].configurations[1].additionalPrice").value(100.00));
    }

    @Test
    void updateProductById_returnProductDTO() throws Exception {
        String id = "1";
        Product product = buildProduct(1L);
        ProductCommand productCommand = buildProductCommand();

        when(productUseCase.updateProduct(eq(Long.valueOf(id)), any(Product.class))).thenReturn(product);
        mockMvc.perform(patch("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productCommand)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("computer"))
                .andExpect(jsonPath("$.price").value(100.00))
                .andExpect(jsonPath("$.productType").value("COMPUTER"))
                .andExpect(jsonPath("$.configurations").isArray())
                .andExpect(jsonPath("$.configurations[0].id").value(1L))
                .andExpect(jsonPath("$.configurations[0].name").value("processor"))
                .andExpect(jsonPath("$.configurations[0].value").value("intel"))
                .andExpect(jsonPath("$.configurations[0].additionalPrice").value(100.00))
                .andExpect(jsonPath("$.configurations[1].id").value(2L))
                .andExpect(jsonPath("$.configurations[1].name").value("processor"))
                .andExpect(jsonPath("$.configurations[1].value").value("amd"))
                .andExpect(jsonPath("$.configurations[1].additionalPrice").value(100.00));
    }

    @Test
    void updateProductById_returnBadRequest() throws Exception {
        String id = "1";
        ProductCommand productCommand = buildProductCommand();

        when(productUseCase.updateProduct(eq(Long.valueOf(id)), any(Product.class))).thenThrow(new ProductDataCannotBeNull("Product data is null"));
        mockMvc.perform(patch("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productCommand)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Product data is null"))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"));
    }

    @Test
    void deleteProductById_returnOkStatus() throws Exception {
        String id = "1";

        mockMvc.perform(delete("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteProductById_returnNotFoundStatus() throws Exception {
        String id = "1";

        doThrow(new ProductNotFoundException("Product not found")).when(productUseCase).deleteProduct(Long.valueOf(id));
        mockMvc.perform(delete("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found"))
                .andExpect(jsonPath("$.status").value("NOT_FOUND"));
    }

    @Test
    void getProductConfigurationById_returnProductConfigurationDTOList() throws Exception {
        String id = "1";

        Product product = buildProduct(1L);
        when(productUseCase.getProductById(Long.valueOf(id))).thenReturn(product);

        mockMvc.perform(get("/products/{id}/configuration", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("processor"))
                .andExpect(jsonPath("$[0].value").value("intel"))
                .andExpect(jsonPath("$[0].additionalPrice").value(100.00))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("processor"))
                .andExpect(jsonPath("$[1].value").value("amd"))
                .andExpect(jsonPath("$[1].additionalPrice").value(100.00));
    }

    @Test
    void getProductConfigurationById_returnNotFoundStatus() throws Exception {
        String id = "1";

        when(productUseCase.getProductById(Long.valueOf(id))).thenThrow(new ProductNotFoundException("Product not found"));
        mockMvc.perform(get("/products/{id}/configuration", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found"))
                .andExpect(jsonPath("$.status").value("NOT_FOUND"));
    }




}
