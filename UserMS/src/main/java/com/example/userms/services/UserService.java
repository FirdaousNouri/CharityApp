package com.example.userms.services;

import com.example.userms.dto.UserDTO;
import com.example.userms.entities.UserApp;
import com.example.userms.mappers.UserDTOMapper;
import com.example.userms.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDTOMapper userDTOMapper;

    public UserApp addUser(UserDTO userDTO) {
        return userRepository.save(userDTOMapper.ConvertToUserApp(userDTO));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<UserApp> getAllUsers() {
        return userRepository.findAll();
    }

    public UserApp getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserApp updateUser(Long userId, UserDTO userDTO) {
        UserApp userApp = getUserById(userId);
        if (userApp != null) {
            throw new RuntimeException("User Not Found!");
        }
        else {
        userApp.setName(userDTO.getName());
        userApp.setEmail(userDTO.getEmail());
        userApp.setPassword(userDTO.getPassword());
        return userRepository.save(userApp);}
    }

    public UserApp getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @KafkaListener(topics = "topic", groupId = "group_id")
    public void Notify(String message){
        System.out.println(message);
    }
}
