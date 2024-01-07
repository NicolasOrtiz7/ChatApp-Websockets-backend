package com.nicolasortiz.chatapp.controller;

import com.nicolasortiz.chatapp.model.dto.ResponseDto;
import com.nicolasortiz.chatapp.service.IChatService;
import com.nicolasortiz.chatapp.service.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
@CrossOrigin
public class ChatController {

    private final IMessageService messageService;
    private final IChatService chatService;

    // Obtiene los datos del chat y todos los mensajes
    @GetMapping("/{user1}/{user2}")
    public ResponseEntity<ResponseDto> findChatByUserIds(@PathVariable Long user1, @PathVariable Long user2){

        // Busca si existen los dos usuarios (mover esta línea al service)
        Long chatId = chatService.findChatByUserIds(user1, user2).getId();

        return ResponseEntity.ok()
                .body(ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .message("Chat encontrado")
                        .response(messageService.findChatAndMessages(chatId))
                        .build());
    }

}
