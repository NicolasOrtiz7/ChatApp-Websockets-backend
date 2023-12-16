package com.nicolasortiz.chatapp.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseDto {

    private HttpStatus status;
    private String message;
    private Object response;

}
