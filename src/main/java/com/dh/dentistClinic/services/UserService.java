package com.dh.dentistClinic.services;

import com.dh.dentistClinic.entities.User;
import com.dh.dentistClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userSearch = userRepository.findByEmail(email);
        if(userSearch.isPresent()){
            return userSearch.get();
        }else{
            throw new UsernameNotFoundException("Did not find a user with that provided email");
        }
    }
}