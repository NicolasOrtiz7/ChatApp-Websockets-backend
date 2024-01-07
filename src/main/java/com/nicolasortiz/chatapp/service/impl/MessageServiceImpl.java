package com.nicolasortiz.chatapp.service.impl;

import com.nicolasortiz.chatapp.exception.ChatNotFoundException;
import com.nicolasortiz.chatapp.model.dto.ChatDto;
import com.nicolasortiz.chatapp.model.dto.MessageDto;
import com.nicolasortiz.chatapp.model.entity.Chat;
import com.nicolasortiz.chatapp.model.entity.Message;
import com.nicolasortiz.chatapp.model.entity.User;
import com.nicolasortiz.chatapp.model.mapper.MessageMapper;
import com.nicolasortiz.chatapp.repository.IMessageRepository;
import com.nicolasortiz.chatapp.service.IChatService;
import com.nicolasortiz.chatapp.service.IMessageService;
import com.nicolasortiz.chatapp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService {

    private final IMessageRepository messageRepository;

    private final IChatService chatService;
    private final IUserService userService;


    // Busca todos los mensajes de un chat
    @Override
    public List<MessageDto> findMessagesByChatId(Long chatId) {

        List<Message> messageList = messageRepository.findByChatId(chatId);

        return  messageList.stream().map(
                m -> MessageMapper.INSTANCE.messageToDto(m)).collect(Collectors.toList());
    }


    @Override
    public ChatDto getMessages(Long chatId) {
        // Verifica si el chat existe o lanza error
        Chat chatExists = chatService.findChatByChatId(chatId);

        // Asigna el chat y la lista de mensajes
        ChatDto chatDto = new ChatDto();
        chatDto.setChat(chatExists);
        chatDto.setMessages(findMessagesByChatId(chatId));

        return chatDto;
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
