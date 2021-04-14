package model;

public class Note {
    private String notes;


    public Note(String notes) {
        this.notes = notes;

    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void printNoteInfo() {
        System.out.println("------------");
        System.out.println("Note " + notes);
        System.out.println("------------");
    }
}
