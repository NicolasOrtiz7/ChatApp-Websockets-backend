package com.nicolasortiz.chatapp.repository;

import com.nicolasortiz.chatapp.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Long> {

    // Busca un Chat entre dos usuarios. Recibe el ID de ambos usuarios.
    @Query("SELECT c FROM Chat c WHERE (c.user1.id = :userId1 AND c.user2.id = :userId2) " +
            "OR (c.user1.id = :userId2 AND c.user2.id = :userId1)")
    Optional<Chat> findChatByUserIds(@Param("userId1") Long userId1,
                                     @Param("userId2") Long userId2);

    // Busca un Chat entre dos usuarios. Recibe el username de ambos usuarios.
    @Query("SELECT c FROM Chat c WHERE " +
            "   (c.user1.username = :username1 AND c.user2.username = :username2) " +
            "OR (c.user1.username = :username2 AND c.user2.username = :username1)")
    Optional<Chat> findChatByUsernames(@Param("username1") String username1,
                                       @Param("username2") String username2);


}
