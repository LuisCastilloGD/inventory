package com.grid.inventory.exceptions;

public class ItemNotFoundedException extends RuntimeException{

    public ItemNotFoundedException() {
        super("Item not found");
    }
}
