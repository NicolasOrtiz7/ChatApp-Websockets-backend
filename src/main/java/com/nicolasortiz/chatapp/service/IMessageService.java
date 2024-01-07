package com.nicolasortiz.chatapp.service;

import com.nicolasortiz.chatapp.model.dto.ChatDto;
import com.nicolasortiz.chatapp.model.dto.MessageDto;
import com.nicolasortiz.chatapp.model.entity.Message;

import java.util.List;

public interface IMessageService {

    List<MessageDto> findMessagesByChatId(Long chatId);

    void sendMessage(Message message);

    ChatDto getMessages(Long chatId);

}
