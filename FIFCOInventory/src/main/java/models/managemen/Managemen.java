package models.managemen;

import java.time.LocalDate;
import models.Person;

public class Managemen extends Person {

    private Integer dCode;

    public Managemen() {
    }

    ;
    public Managemen(Integer dCode, Integer id, String name, String lastName, String email,
            String phone, String location, LocalDate birthDate) {
        super(id, name, lastName, email, phone, location, birthDate);
        this.dCode = dCode;
    }

    public Integer getdCode() {
        return dCode;
    }

    public void setdCode(Integer dCode) {
        this.dCode = dCode;
    }
}
