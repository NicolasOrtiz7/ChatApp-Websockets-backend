package com.nicolasortiz.chatapp.service.impl;

import com.nicolasortiz.chatapp.exception.ChatNotFoundException;
import com.nicolasortiz.chatapp.model.entity.Chat;
import com.nicolasortiz.chatapp.model.entity.Message;
import com.nicolasortiz.chatapp.model.entity.User;
import com.nicolasortiz.chatapp.repository.IMessageRepository;
import com.nicolasortiz.chatapp.service.IChatService;
import com.nicolasortiz.chatapp.service.IMessageService;
import com.nicolasortiz.chatapp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService {

    private final IMessageRepository messageRepository;

    private final IChatService chatService;
    private final IUserService userService;


    // Busca todos los mensajes de un chat
    @Override
    public List<Message> findMessagesByChatId(Long chatId) {
        // Verifica si el chat existe o lanza error
        Chat chatExists = chatService.findChatByChatId(chatId);

        return messageRepository.findByChatId(chatId);
    }

    @Override
    public void sendMessage(Message message){
        Chat chat;
        User sender = message.getSenderUser();
        User receiver = message.getReceiverUser();

        try{
            chat = chatService.findChatByUserIds(sender.getId(), receiver.getId());
        }catch (ChatNotFoundException ex){
            chat = chatService.createChat(sender, receiver);
        }

        message.setChat(chat);
        message.setDatetime(new Date());
        messageRepository.save(message);
    }

}
