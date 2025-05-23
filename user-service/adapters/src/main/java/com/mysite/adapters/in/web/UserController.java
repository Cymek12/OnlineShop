package com.mysite.adapters.in.web;

import com.mysite.core.service.UserService;
import com.mysite.model.CartDTO;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable("id") String id){
        return userService.getProduct(id);
    }

    @GetMapping("/products")
    public PageContent<ProductDTO> getAllProducts(Pageable pageable, @RequestParam(name = "productType", required = false) String productType) {
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        return userService.getAllProducts(myPageable, productType);
    }

    @PostMapping("/carts")
    public CartDTO addProductToCart(@RequestBody AddProductToCartCommand addProductToCartCommand) {
        return userService.addProductToCart(addProductToCartCommand);
    }
}
