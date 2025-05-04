package com.mysite.adapters.in.web;

import com.mysite.adapters.in.web.mapper.CartMapper;
import com.mysite.core.port.in.CartUseCase;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import com.mysite.modelpublic.dto.CartDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//DODAC TO DO PRODUCT-SERVICE TO PRODUCT
//  private int stock;  // Ilość dostępna w magazynie
@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartUseCase cartUseCase;
    private final CartMapper cartMapper;

    @PostMapping
    public CartDTO addProductToCart(@RequestBody AddProductToCartCommand addProductToCartCommand) {
        return cartMapper.toDto(cartUseCase.addProductToCart(addProductToCartCommand));
    }

    @DeleteMapping("/{cartId}/{cartItemId}/{quantity}")
    public void deleteCartItem(@PathVariable("cartId") String cartId,
                               @PathVariable("cartItemId") String cartItemId,
                               @PathVariable("quantity") String quantity) {
        cartUseCase.deleteCartItem(Long.valueOf(cartId), Long.valueOf(cartItemId), Long.valueOf(quantity));
    }

    @GetMapping("/{cartId}")
    public CartDTO getCartById(@PathVariable("cartId") String cartId) {
        return cartMapper.toDto(cartUseCase.getCartById(Long.valueOf(cartId)));
    }

}
