import model.Note;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Business {
    public static void main(String[] args) {

        User usersList = new User();

        usersList.addUser(new User("Scoot", "Peterson", 45));
        usersList.addUser(new User("Albert", "Evans", 23));
        usersList.addUser(new User("Danna", "Jenkins", 64));
        usersList.addUser(new User("Valentina", "Rivera", 27));

        List<User> users = usersList.getUsers();

        Note notesList = new Note();
        notesList.addNote(new Note("NoteOne", "Scoots Note"));
        notesList.addNote(new Note("NoteTwo", "Alberts Note"));
        notesList.addNote(new Note("NoteThree", "Dannas Note"));
        notesList.addNote(new Note("NoteFour", "Valentinas Note"));

        List<Note> notes = notesList.getNotes();

        for (User user : users) {
            for (Note note : notes)
                if (user.getFirstName().startsWith("Scoot")) {
                    System.out.println(note.getId());
                }

            }



            //        for (User user : users)
//            for (Note note : notes)
//                if(user.getFirstName().startsWith(note.getId()));




    }
    //public static void test()
}
