package models.Category.Block;

import models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBOBlock extends DAO<Block> {

    @Override
    public List<Block> getAll() {
        List<Block> blocks = new ArrayList<>();
        String sql = "SELECT id, nombre, estado FROM bloques";

        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Block block = new Block();
                block.setId(rs.getInt("id"));
                block.setName(rs.getString("nombre"));
                block.setState(rs.getString("estado"));

                blocks.add(block);
            }
        } catch (Exception ex) {
        }

        return blocks;
    }

    @Override
    public Block getById(int id) {
        Block block = null;
        String sql = "SELECT * FROM bloques WHERE id = ?";

        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    block = new Block();
                    block.setId(rs.getInt("id"));
                    block.setName(rs.getString("nombre"));
                    block.setState(rs.getString("estado"));
                }
            }
        } catch (Exception ex) {
        }

        return block;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM bloques WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Block block) {
        String sql = "UPDATE bloques SET nombre = ?, estado = ? WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, block.getName());
            stmt.setString(2, block.getState());
            stmt.setInt(3, block.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean store(Block block) {

        String sql = "INSERT INTO bloques (id, nombre, estado) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, block.getId());
            stmt.setString(2, block.getName());
            stmt.setString(3, block.getState());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
