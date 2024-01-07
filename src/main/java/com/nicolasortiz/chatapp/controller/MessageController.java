package com.nicolasortiz.chatapp.controller;

import com.nicolasortiz.chatapp.model.entity.Message;
import com.nicolasortiz.chatapp.service.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final IMessageService messageService;


    @MessageMapping("/chat/{receiverUser}")
    @SendTo("/topic/{receiverUser}")
    public Message chat(@DestinationVariable String receiverUser, Message message){
        messageService.sendMessage(message);

        return new Message(
                message.getContent(),
                message.getDatetime(),
                message.getSenderUser()
        );
    }

}
