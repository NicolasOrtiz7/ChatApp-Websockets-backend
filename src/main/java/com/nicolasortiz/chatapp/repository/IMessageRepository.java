package com.nicolasortiz.chatapp.repository;

import com.nicolasortiz.chatapp.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Long> {

    // Busca la lista de mensajes de un chat. Recibe el ID del chat.
    List<Message> findByChatId(Long chatId);

}
