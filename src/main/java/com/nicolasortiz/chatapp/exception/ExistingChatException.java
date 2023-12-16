package com.nicolasortiz.chatapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingChatException extends RuntimeException{

    public ExistingChatException(String message) {
        super(message);
    }
}
