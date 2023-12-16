package com.nicolasortiz.chatapp.service.impl;

import com.nicolasortiz.chatapp.exception.ChatNotFoundException;
import com.nicolasortiz.chatapp.exception.ExistingChatException;
import com.nicolasortiz.chatapp.exception.ExistingUserException;
import com.nicolasortiz.chatapp.model.entity.Chat;
import com.nicolasortiz.chatapp.model.entity.User;
import com.nicolasortiz.chatapp.repository.IChatRepository;
import com.nicolasortiz.chatapp.service.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements IChatService {

    private final IChatRepository chatRepository;


    @Override
    public Chat findChatByChatId(Long chatId) {
        return chatRepository
                .findById(chatId)
                .orElseThrow(()-> new ChatNotFoundException("Chat no encontrado"));
    }

    @Override
    public boolean chatExists(Long chatId) {
        return chatRepository.existsById(chatId);
    }

    @Override
    public Chat findChatByUserIds(Long user1, Long user2) {
        return chatRepository.findChatByUserIds(user1, user2)
                .orElseThrow(()-> new ChatNotFoundException("No existe el chat con esos usuarios"));
    }

    @Override
    public Chat findChatByUsernames(String username1, String username2) {
        return chatRepository.findChatByUsernames(username1, username2)
                .orElseThrow(()-> new ChatNotFoundException("No existe el chat con esos usuarios"));
    }

    @Override
    public Chat createChat(User user1, User user2) {
        Optional<Chat> chatExists = chatRepository.findChatByUserIds(user1.getId(), user2.getId());
        if (chatExists.isPresent()){
            throw new ExistingUserException("Ya existe un chat entre los dos usuarios");
        }

        Chat newChat = new Chat();
        newChat.setUser1(user1);
        newChat.setUser2(user2);

        return chatRepository.save(newChat);
    }

}
