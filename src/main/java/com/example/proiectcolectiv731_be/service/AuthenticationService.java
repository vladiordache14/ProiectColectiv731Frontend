package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.User;
import com.example.proiectcolectiv731_be.model.UserDto;
import com.example.proiectcolectiv731_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int LOCK_DURATION_MINUTES = 3;

    public boolean doesUserExistAndIsPasswordCorrect(String username, String password) throws Exception {
        Optional<User> optionalUser = userRepository.getUserByUsername(username);
        if(optionalUser.isPresent())
        {
            User user = optionalUser.get();
            if(isUserLocked(user)){
                throw new Exception("User is locked.");
            }
            boolean result = user.getPassword().equals(password);
            if(!result)
            {
                addAttempt(user);
            }
            return result;
        }
        else
        {
            throw new IllegalArgumentException("Wrong username and/or password.");
        }
    }

    public void login(UserDto userDto) throws Exception {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        try
        {
            if (!doesUserExistAndIsPasswordCorrect(username, password))
            {
                throw new IllegalArgumentException("Wrong username and/or password.");
            }
        }catch (Exception exception) {
            throw exception;
        }
    }


    private boolean isUserLocked(User user) {
        if(user.getLockedUntil() == null)
            return false;

        Instant instant = user.getLockedUntil().toInstant();
        LocalDateTime userLockedUntil = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        int comparisonResult = LocalDateTime.now().compareTo(userLockedUntil);
        if (comparisonResult < 0) {
            return true;
        } else {
            return false;
        }
    }

    private void addAttempt(User user){
        user.setNumberOfTries(user.getNumberOfTries()+1);
        if(user.getNumberOfTries() >= MAX_LOGIN_ATTEMPTS)
        {
            Timestamp ts = Timestamp.from(Instant.now());
            ts.setTime(ts.getTime() + TimeUnit.MINUTES.toMillis(LOCK_DURATION_MINUTES));
            user.setLockedUntil(ts);
            user.setNumberOfTries(0);
        }

        userRepository.save(user);
    }
}
