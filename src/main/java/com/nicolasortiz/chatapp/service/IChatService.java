package com.nicolasortiz.chatapp.service;

import com.nicolasortiz.chatapp.model.entity.Chat;
import com.nicolasortiz.chatapp.model.entity.User;


public interface IChatService {

    Chat findChatByChatId(Long chatId);

    Chat findChatByUserIds(Long user1, Long user2);

    Chat createChat(User user1, User user2);

//    Chat deleteChatByChatId(Long chatId);

}
