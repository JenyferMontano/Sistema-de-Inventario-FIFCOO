package controllers.user;

public interface UserInterface {
    public String add(String[] data);
    public String[] find(String id);
    public String[] findByUsername(String username);
    public String update(String[] data);
    public String delete(String id);
    public String[][] list();
}
