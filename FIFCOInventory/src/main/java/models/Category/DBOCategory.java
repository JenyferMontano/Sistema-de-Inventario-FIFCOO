package models.Category;

import models.Category.Block.Block;
import models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBOCategory extends DAO<Category> {

    public DBOCategory() {
        super();
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT c.codigo, c.descripcion, b.id AS idBloque, b.nombre AS nombreBloque, b.estado AS estadoBloque "
                + "FROM categorias c "
                + "JOIN bloques b ON c.idBloque = b.id";

        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setCode(rs.getInt("codigo"));
                category.setDescription(rs.getString("descripcion"));

                Block block = new Block();
                block.setId(rs.getInt("idBloque"));
                block.setName(rs.getString("nombreBloque"));
                block.setState(rs.getString("estadoBloque"));

                category.setBlock(block);
                categories.add(category);
            }
        } catch (Exception ex) {
            return null;
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category category = null;
        String sql = "SELECT c.codigo, c.descripcion, b.id AS idBloque, b.nombre, b.estado "
                + "FROM categorias c "
                + "LEFT JOIN bloques b ON c.idBloque = b.id "
                + "WHERE c.codigo = ?";

        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    category = new Category();
                    category.setCode(rs.getInt("codigo"));
                    category.setDescription(rs.getString("descripcion"));

                    Block blo = new Block();
                    blo.setId(rs.getInt("idBloque"));
                    blo.setName(rs.getString("nombre"));
                    blo.setState(rs.getString("estado"));

                    category.setBlock(blo);
                }
            }
        } catch (Exception ex) {
            return null;
        }

        return category;
    }

    @Override
    public boolean update(Category category) {

        String sql = "UPDATE categorias SET descripcion = ?, idBloque = ? WHERE codigo = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, category.getDescription());
            stmt.setInt(2, category.getBlock().getId());
            stmt.setInt(3, category.getCode());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean delete(int code) {
        String sql = "DELETE FROM categorias WHERE codigo = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, code);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean store(Category category) {
        String sql = "INSERT INTO categorias (codigo, descripcion, idBloque) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, category.getCode());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getBlock().getId());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
