package com.mysite.modelpublic.command;

import java.util.List;

public class CartCommand {
    private String userName;
    private List<CartItemCommand> items;

    public CartCommand(String userName, List<CartItemCommand> items) {
        this.userName = userName;
        this.items = items;
    }

    public CartCommand() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<CartItemCommand> getItems() {
        return items;
    }

    public void setItems(List<CartItemCommand> items) {
        this.items = items;
    }
}
