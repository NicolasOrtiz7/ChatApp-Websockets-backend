package com.nicolasortiz.chatapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String username;

}
