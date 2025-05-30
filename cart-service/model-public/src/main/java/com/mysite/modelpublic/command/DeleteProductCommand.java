package com.mysite.modelpublic.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteProductCommand {
    private Long cartId;
    private Long cartItemId;
    private Long quantity;
}
