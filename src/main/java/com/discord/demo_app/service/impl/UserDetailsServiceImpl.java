package com.discord.demo_app.service.impl;

import com.discord.demo_app.config.security.UserDetailsWrapper;
import com.discord.demo_app.model.User;
import com.discord.demo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) throw new UsernameNotFoundException("USER NOT FOUND");
        if (!user.get().isStatus()) throw new RuntimeException("DISABLE USER");

        User userTemp = user.orElseThrow(() -> new UsernameNotFoundException("EMAIL OR PASSWORD INVALID"));

        return new UserDetailsWrapper(userTemp);
    }
}
