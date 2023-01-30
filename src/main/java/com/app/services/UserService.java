package com.app.services;

import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("test1", "test1", "01", "test1@test.lv"));
        users.add(new User("test2", "test2", "02", "test2@test.lv"));
        users.add(new User("test3", "test3", "03", "test3@test.lv"));
        users.add(new User("test4", "test4", "04", "test4@test.lv"));
        users.add(new User("test5", "test5", "05", "test5@test.lv"));
        users.add(new User("test6", "test6", "06", "test6@test.lv"));
        users.add(new User("test7", "test7", "07", "test7@test.lv"));
        users.add(new User("test8", "test8", "08", "test8@test.lv"));

        for (User usersList : users)
            usersList.displayNotes();

        return users;
    }
}
