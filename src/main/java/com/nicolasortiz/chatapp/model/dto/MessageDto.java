package com.nicolasortiz.chatapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MessageDto {

    private String content;
    private Date datetime;
    private UserDto receiverUser;

}
