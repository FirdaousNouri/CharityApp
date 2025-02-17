package com.example.userms.mappers;

import com.example.userms.dto.UserDTO;
import com.example.userms.entities.UserApp;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    public UserApp ConvertToUserApp(UserDTO userDTO) {
        return UserApp.builder().email(userDTO.getEmail())
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .build();
    }
}
