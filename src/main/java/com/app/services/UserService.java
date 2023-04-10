package com.app.services;

import com.app.dao.NoteDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private NoteDao noteDao;

    public List<User> getUsers() {
        return noteDao.getUsers();
    }

    public User validateUser(User user) {
        if (!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() &&
                !user.geteMail().isEmpty() && !user.getPhone().isEmpty()) {

            String phone = user.getPhone().trim().replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            user.setPhone(phone);
            noteDao.storeUser(user);
            return user;
        }

        return null;
    }
}
