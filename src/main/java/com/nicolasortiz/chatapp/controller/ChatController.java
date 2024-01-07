package com.nicolasortiz.chatapp.controller;

import com.nicolasortiz.chatapp.model.dto.ResponseDto;
import com.nicolasortiz.chatapp.model.entity.Message;
import com.nicolasortiz.chatapp.service.IChatService;
import com.nicolasortiz.chatapp.service.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
@CrossOrigin
public class ChatController {

    private final IMessageService messageService;
    private final IChatService chatService;

    @GetMapping("/{chatId}")
    public ResponseEntity<ResponseDto> getMessagesFromChatByChatId(@PathVariable Long chatId){
        return ResponseEntity.ok()
                .body(ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .message("OK")
                        .response(messageService.getMessages(chatId))
                        .build());
    }

    @GetMapping("/{user1}/{user2}")
    public ResponseEntity<ResponseDto> findChatByUserIds(@PathVariable Long user1, @PathVariable Long user2){
        Long chatId = chatService.findChatByUserIds(user1, user2).getId();
        return ResponseEntity.ok()
                .body(ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .message("Chat encontrado")
                        // Devuelve el ID del chat, no la info completa.
//                        .response(chatService.findChatByUserIds(user1, user2).getId())
                        .response(messageService.getMessages(chatId))
                        .build());
    }

}
