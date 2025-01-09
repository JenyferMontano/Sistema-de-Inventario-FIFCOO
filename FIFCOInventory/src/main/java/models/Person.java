package models;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String location;
    private LocalDate birthDate;
    public Person() {}
    public Person(int id, String name, String lastName,
                  String email, String phone, String location, LocalDate birthDate) {

        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}


}
