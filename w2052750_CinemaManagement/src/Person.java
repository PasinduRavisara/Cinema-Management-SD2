public class Person {

    // Declare private variables to store user information
    private String userName;
    private String userSurname;
    private String userEmail;

    // Using a constructor ot initialize Person object with user details
    public Person(String user_name, String user_surname, String user_email) {
        this.userName = user_name;
        this.userSurname = user_surname;
        this.userEmail = user_email;
    }

    @Override
    public String toString() {
        return "Name: " + userName + ", Surname: " + userSurname + ", Email: " + userEmail;
    }

    // Create getters and setters to get and set names and emails
    public String get_name() {
        return userName;
    }

    public void set_name(String user_name) {
        this.userName = user_name;
    }

    public String get_surname() {
        return userSurname;
    }

    public void set_surname(String user_surname) {
        this.userSurname = user_surname;
    }

    public String get_email() {
        return userEmail;
    }

    public void set_email(String user_email) {
        this.userEmail = user_email;
    }


    //The method to return person's information as a formatted string.
    public String person_detail() {
        return ("\nName:" + userName + "\nSurname:" + userSurname + "\nEmail:" + userEmail);


    }
}