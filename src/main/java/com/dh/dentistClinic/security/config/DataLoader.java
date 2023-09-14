package com.dh.dentistClinic.security.config;

import com.dh.dentistClinic.entities.User;
import com.dh.dentistClinic.entities.UserRole;
import com.dh.dentistClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encrypter = new BCryptPasswordEncoder();
        String passSinCifrar= "user";
        String passCifrado= encrypter.encode(passSinCifrar);
        System.out.println("PASSWORD CIFRADO:::::::::"+passCifrado);
        User userInsert= new User("Jorgito","user","user@user.com",passCifrado, UserRole.USER);
        User adminInsert= new User("Lorenza","user","user@user.com",passCifrado, UserRole.ADMIN);
        userRepository.save(userInsert);
        userRepository.save(adminInsert);
    }
}
