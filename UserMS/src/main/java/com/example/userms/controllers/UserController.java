package com.example.userms.controllers;

import com.example.userms.dto.UserDTO;
import com.example.userms.entities.UserApp;
import com.example.userms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public UserApp AfficherUser(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/users/all")
    public List<UserApp> AfficherUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users")
    public UserApp getByEmail(@RequestParam("email") String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("/users/add")
    public UserApp AddUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @DeleteMapping("/users/delete/{id}")
    public void DeleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/users/update/{id}")
    public UserApp UpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }
}
