package com.nicolasortiz.chatapp.model.mapper;


import com.nicolasortiz.chatapp.model.dto.MessageDto;
import com.nicolasortiz.chatapp.model.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto messageToDto(Message message);

}
