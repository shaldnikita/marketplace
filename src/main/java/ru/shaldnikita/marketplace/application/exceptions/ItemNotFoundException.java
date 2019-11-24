package ru.shaldnikita.marketplace.application.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(code = NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String itemId) {
        super("Item with id " + itemId + "not found.");
    }
}
