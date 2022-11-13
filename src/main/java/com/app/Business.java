package com.app;

import com.app.services.Note;
import com.app.services.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Business {
    public static void main(String[] args) {
        SpringApplication.run(Business.class, args);

//        User scott = new User("Scoot", "Peterson", 45);
//        User albert = new User("Albert", "Evans", 23);
//
//
//        scott.addNote(new Note("ScootsNoteOne", "ScootOne"));
//        albert.addNote(new Note("AlbertsNoteOne", "AlbertOne"));
//
//
//        List<Note> scootNotes = scott.getNotes();
//        List<Note> albertNotes = albert.getNotes();
//
//
//
//        for (Note sn : scootNotes) {
//            if (sn.getId().startsWith("Scoot")) {
//                System.out.println(sn.getId());
//            } else {
//                System.out.println("Wrong");
//            }
//
//            System.out.println();
//        }
//
//        for (Note sn : scootNotes) {
//            for (Note an : albertNotes) {
//                if (sn.getId().startsWith("Scoot") && an.getId().startsWith("Albert")) {
//                    System.out.println(sn.getId() + " " + an.getId());
//                }
//            }


        /*for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i).getId());
        }*/



        /*        User usersList = new User();

        usersList.addNote(new User("Scoot", "Peterson", 45));
        usersList.addNote(new User("Albert", "Evans", 23));
        usersList.addNote(new User("Danna", "Jenkins", 64));
        usersList.addNote(new User("Valentina", "Rivera", 27));

        List<User> users = usersList.getUsers();

        Note notesList = new Note();

        notesList.addUser(new User("Scoot", "Peterson", 45));
        notesList.addUser(new User("Albert", "Evans", 23));
        notesList.addUser(new User("Danna", "Jenkins", 64));
        notesList.addUser(new User("Valentina", "Rivera", 27));

        List<Note> notes = notesList.getNotes();

        for (User user : users) {
            for (Note note : notes)
                if (user.getFirstName().equals("Scoot")) {
                    System.out.println(note.getId());
                }

            }







    }

}*/
        }
    }
