package com.booking_API.demo.services;

import com.booking_API.demo.dto.UserPrincipal;
import com.booking_API.demo.dto.Users;
import com.booking_API.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Users user = userRepo.findByusername(username);
        if(user == null){
            System.out.println("User Not found!...");
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }

        return new UserPrincipal(user);
    }
}