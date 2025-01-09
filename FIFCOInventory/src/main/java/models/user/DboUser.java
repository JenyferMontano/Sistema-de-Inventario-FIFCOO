package models.user;

import models.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DboUser extends DAO<User> {

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("nUsuario"));
                user.setPassword(rs.getString("contrasena"));
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setLastName(rs.getString("apellidos"));
                user.setEmail(rs.getString("correo"));
                user.setPhone(rs.getString("telefono"));
                user.setLocation(rs.getString("direccion"));
                Date sqlDate = rs.getDate("fNacimiento");
                if (sqlDate != null) {
                    user.setBirthDate(sqlDate.toLocalDate());//Convierte a LocalDate
                }
                users.add(user);
            }
            this.close(rs, stmt);

        } catch (Exception e) {
        }

        return users;
    }

    @Override
    public User getById(int id) {
        User user = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("nUsuario"));
                user.setPassword(rs.getString("contrasena"));
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setLastName(rs.getString("apellidos"));
                user.setEmail(rs.getString("correo"));
                user.setPhone(rs.getString("telefono"));
                user.setLocation(rs.getString("direccion"));
                Date sqlDate = rs.getDate("fNacimiento");
                if (sqlDate != null) {
                    user.setBirthDate(sqlDate.toLocalDate());//Convierte a LocalDate
                }
            }
            this.close(rs, stmt);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean update(User user) {
        boolean rowUpdated;
        PreparedStatement stmt = null;
        String sql = "UPDATE usuarios SET nUsuario = ?, contrasena = ?,"
                + "nombre = ?, apellidos = ?, correo = ?, telefono = ?,"
                + " direccion = ?, fNacimiento = ? WHERE id = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getLocation());
            stmt.setDate(8, java.sql.Date.valueOf(user.getBirthDate()));
            stmt.setInt(9, user.getId());
            rowUpdated = stmt.executeUpdate() > 0;
            this.close(stmt);
            return rowUpdated;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, id); //Consulta el Id
            rowDeleted = stmt.executeUpdate() > 0;//Al menos una fila se elimina o algo asi
            this.close(stmt);
            return rowDeleted;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean store(User user) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO usuarios(nUsuario, contrasena,id, nombre,"
                + " apellidos, correo, telefono, direccion,fNacimiento ) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";

        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId());
            stmt.setString(4, user.getName());
            stmt.setString(5, user.getLastName());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getPhone());
            stmt.setString(8, user.getLocation());
            stmt.setDate(9, java.sql.Date.valueOf(user.getBirthDate()));
            stmt.execute();
            this.close(stmt); //Cerrar el PreparedStatement
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User getByUsername(String username) throws Exception {
        User user = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios WHERE nUsuario = ?";

        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("nUsuario"));
                user.setPassword(rs.getString("contrasena"));
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setLastName(rs.getString("apellidos"));
                user.setEmail(rs.getString("correo"));
                user.setPhone(rs.getString("telefono"));
                user.setLocation(rs.getString("direccion"));
                Date sqlDate = rs.getDate("fNacimiento");
                if (sqlDate != null) {
                    user.setBirthDate(sqlDate.toLocalDate()); // Convert to LocalDate
                }
            }
        } catch (SQLException e) {
        } finally {
            this.close(rs, stmt);
        }
        return user;
    }
}
