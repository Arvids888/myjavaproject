package com.app.security;

import com.app.dao.NoteDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private NoteDao noteDao;

    @Override
    public UserDetails getUser(String username) {
        List<User> users = noteDao.getUsersByEmail(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException(username + "not found");
        }



        return new CustomUserDetails(users);
    }
}
