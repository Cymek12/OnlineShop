package com.mysite.adapters.in.web;

import com.mysite.core.service.UserService;
import com.mysite.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable String id){
        return userService.getProduct(id);
    }
}
