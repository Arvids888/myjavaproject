package com.app.security;

import com.app.dao.NoteDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class SecurityService implements UserDetailsService {
    @Autowired
    private NoteDao noteDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<User> users = noteDao.getUsersByEmail(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException(username + "not found");
        }

        User user = users.get(0);

        return new CustomUserDetails(user);
    }
}
