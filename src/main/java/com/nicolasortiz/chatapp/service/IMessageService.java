package com.nicolasortiz.chatapp.service;

import com.nicolasortiz.chatapp.model.entity.Message;

import java.util.List;

public interface IMessageService {

    List<Message> findMessagesByChatId(Long chatId);

    void sendMessage(Message message);

}
