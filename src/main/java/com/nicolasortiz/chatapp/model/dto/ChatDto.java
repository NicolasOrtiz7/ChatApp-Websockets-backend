package com.nicolasortiz.chatapp.model.dto;

import com.nicolasortiz.chatapp.model.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ChatDto {

    private Chat chat;
    private List<MessageDto> messages;

}
