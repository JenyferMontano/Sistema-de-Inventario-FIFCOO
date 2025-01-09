package models.Category;

import models.Category.Block.Block;

public class Category {

    private int code;
    private String description;
    private Block block;

    public Category() {
    }

    public Category(int code, String description, String block) {
        this.code = code;
        this.description = description;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

}
