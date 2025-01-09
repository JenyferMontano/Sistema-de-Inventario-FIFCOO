package models.user;

import models.Person;

import java.time.LocalDate;

public class User extends Person {
    private String username;
    private String password;

    public User(){}

    public User(String username, String password, int id, String name, String lastName,
                       String email, String phone, String location, LocalDate birthDate) {

        super(id, name, lastName, email, phone, location, birthDate);
        this.username = username;
        this.password = password;

    }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

}
