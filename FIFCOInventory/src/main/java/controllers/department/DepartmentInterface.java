package controllers.department;

public interface DepartmentInterface {
    public String add(String[] data);
    public String[] find(String id);
    public String update(String[] data);
    public String delete(String id);
    public String[][] list();
}
