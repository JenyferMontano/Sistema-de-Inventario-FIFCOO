package models.Category.Block;

public class Block {

    private int id;
    private String name;
    private String state;

    public Block() {
    }

    public Block(int id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
