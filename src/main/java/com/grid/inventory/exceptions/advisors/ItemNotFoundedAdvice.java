package com.grid.inventory.exceptions.advisors;

import com.grid.inventory.exceptions.ItemNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemNotFoundedAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundedException.class)
    public String itemNotFoundHandler(final ItemNotFoundedException e) {
        return e.getMessage();
    }

}
