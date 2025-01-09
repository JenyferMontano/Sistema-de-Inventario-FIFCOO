package controllers.product;

public interface ProductInterface {
    public String add(String[] data);
    public String[] find(String id);
    public String update(String[] data);
    public String delete(String id);
    public String[][] list();
    public byte[] download();
    public void upload(byte[] data);
    public boolean codeOrImageExists(int code, String imageName);
}
