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


        User user1 = new User("John", "Mid", 45);
        User user2 = new User("Jane", "Grub", 34);

        Note note1 = new Note("Buy milk", "n1");
        Note note2 = new Note("Call mom", "n2");
        Note note3 = new Note("Meeting with team", "n3");

        user1.addNote(note1);
        user1.addNote(note2);
        user2.addNote(note3);

        Note user1Note = user1.getNote("n2");
        System.out.println("Note of user " + user1.getFirstName() + " : " + user1Note.getpersonalNote());
    }
//        User user = new User();
//
//        user.addUser(new User("ted", "fed", 30, "eee"));
//        user.addUser(new User("chad", "gad", 40, "aaa"));
//
//        Note note = new Note();
//
//        note.addNote(new Note("ted", "10"));
//        note.addNote(new Note("chad", "20"));
//
//        List<User> users = user.getUsers();
//        List<Note> notes = note.getNotes();
//
//        for (User u : users) {
//            for (Note n : notes) {
//                if (u.getFirstName().startsWith("t")) {
//                    System.out.println(user.getNote("ted"));
//                }
//            }
//        }




//        User scott = new User("Scoot", "Peterson", 45);
//        User albert = new User("Albert", "Evans", 23);
//
//
//        scott.addNote(new Note("ScootsNoteOne", "ScootOne"));
//        albert.addNote(new Note("AlbertsNoteOne", "AlbertOne"));
//
////
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

