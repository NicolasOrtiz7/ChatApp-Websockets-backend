package com.nicolasortiz.chatapp.model.mapper;


import com.nicolasortiz.chatapp.model.dto.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    MessageDto dtoToMessage(MessageDto dto);

}
