package com.mysite.adapters.in.web;

import com.mysite.adapters.in.web.mapper.CartMapper;
import com.mysite.core.port.in.CartService;
import com.mysite.model.Cart;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import com.mysite.modelpublic.command.DeleteProductCommand;
import com.mysite.modelpublic.dto.cart.CartDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    @GetMapping
    public PageContent<CartDTO> getCarts(Pageable pageable){
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        PageContent<Cart> cartPageContent = cartService.getCarts(myPageable);
        List<CartDTO> list = cartPageContent.getContent().stream().map(cartMapper::toDto).collect(Collectors.toList());
        return new PageContent<>(cartPageContent.getTotalElements(),
                cartPageContent.getCurrentPage(),
                cartPageContent.getTotalPageNumber(),
                list);
    }

    @GetMapping("/{cartId}")
    public CartDTO getCartById(@PathVariable("cartId") String cartId) {
        return cartMapper.toDto(cartService.getCartById(Long.valueOf(cartId)));
    }

    @PostMapping
    public CartDTO addProductToCart(@RequestBody AddProductToCartCommand addProductToCartCommand) {
        return cartMapper.toDto(cartService.addProductToCart(addProductToCartCommand));
    }

    @DeleteMapping
    public CartDTO deleteCartItem(@RequestBody DeleteProductCommand deleteProductCommand) {
        return cartMapper.toDto(cartService.deleteCartItem(deleteProductCommand.getCartId(), deleteProductCommand.getCartItemId(), deleteProductCommand.getQuantity()));
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable("cartId") Long id) {
        cartService.deleteCart(id);
    }
}
