package com.mysite.adapters.in.web;

import com.mysite.core.port.in.UserUseCase;
import com.mysite.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserUseCase userUseCase;

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable String id){
        return userUseCase.getProduct(id);
    }
}
