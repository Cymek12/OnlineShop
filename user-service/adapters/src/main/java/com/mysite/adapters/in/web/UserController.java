package com.mysite.adapters.in.web;

import com.mysite.core.port.in.UserService;
import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.ProductDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/products")
    public PageContent<ProductDTO> getAllProducts(Pageable pageable, @RequestParam(name = "productType", required = false) String productType) {
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        return userService.getAllProducts(myPageable, productType);
    }

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable("id") String id){
        return userService.getProduct(id);
    }

    @PostMapping("/carts")
    public CartDTO addProductToCart(@RequestBody AddProductToCartCommand addProductToCartCommand) {
        return userService.addProductToCart(addProductToCartCommand);
    }

    @GetMapping("/carts")
    public PageContent<CartDTO> getAllCarts(Pageable pageable) {
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        return userService.getAllCarts(myPageable);
    }

//    @DeleteMapping("/carts")
//    public CartDTO deleteProductFromCart(@RequestBody )
}



//lista endpointow:
// - getAllProducts ok
// - getProductById ok
// - addProductToCart
// - deleteProductFromCart
// - clearCart
// - createOrder(cartId, Address, UserData) - generuje nam fakture