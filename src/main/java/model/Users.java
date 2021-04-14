package model;

public class Users {
    private String firstName;
    private String lastName;
    private int age;

    public Users(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printUsersInfo() {
        String newLine = System.lineSeparator();
        System.out.println("------------" + newLine +"First Name: " + firstName + newLine +
                "Last Name: " + lastName + newLine + "Age: " + age + newLine + "------------");

    }
}

