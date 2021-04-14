import model.Category;
import model.Note;
import model.Users;

public class Business {
    public static void main(String[] args) {
        Users scoot = new Users("Scoot", "Peterson", 45);
        Users albert = new Users("Albert", "Evans", 23);
        Users danna = new Users("Danna", "Jenkins", 64);
        Users valentina = new Users("Valentina", "Rivera", 27);

        scoot.printUsersInfo();
        albert.printUsersInfo();
        danna.printUsersInfo();
        valentina.printUsersInfo();

        Category tierOne = new Category("Public", 1);
        Category tierTwo = new Category("Private",2);

        tierOne.printCategoryInfo();
        tierTwo.printCategoryInfo();

        Note school = new Note("School");
        Note work = new Note("Work");

        school.printNoteInfo();
        work.printNoteInfo();
    }
}
