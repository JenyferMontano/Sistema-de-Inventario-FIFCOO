package models.department;

public class Department {

    private Integer code;
    private String name;
    private Integer idManagemen;
    private String location;
    private String phone;
    private String email;

    public Department() {
    }

    ;
    public Department(Integer code, String name, Integer idManagemen, String location, String phone,
            String email) {
        this.code = code;
        this.name = name;
        this.idManagemen = idManagemen;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdManagemen() {
        return idManagemen;
    }

    public void setIdManagemen(Integer idManagemen) {
        this.idManagemen = idManagemen;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
