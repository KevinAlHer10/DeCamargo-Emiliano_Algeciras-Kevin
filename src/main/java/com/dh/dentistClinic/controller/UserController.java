package com.dh.dentistClinic.controller;

import com.dh.dentistClinic.dto.UserDTO;
import com.dh.dentistClinic.services.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
 @RestController
 @RequestMapping("/users")
 public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
            UserDetails savedUser = userService.loadUserByUsername(user.getName());
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(savedUser.getUsername());
            return ResponseEntity.ok().body(userDTO);
        }


    }

