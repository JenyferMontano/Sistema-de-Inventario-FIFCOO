package models;

import java.util.List;

public  abstract class DAO <T> extends DBConnection {

    public DAO() {
        super("localhost","fifcodb","root","");
    }

    public abstract List<T> getAll();
    public abstract  T getById(int id);
    public abstract boolean update(T t);
    public abstract boolean delete(int id);
    public abstract boolean store(T t);
}
