package models.department;

import models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DboDepartment extends DAO<Department> {

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<Department>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM departamentos";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setCode(rs.getInt("codigo"));
                department.setName(rs.getString("nombre"));
                department.setIdManagemen(rs.getInt("idEncargado"));
                department.setLocation(rs.getString("ubicacion"));
                department.setPhone(rs.getString("telefono"));
                department.setEmail(rs.getString("correo"));

                departments.add(department);
            }
            this.close(rs, stmt);

        } catch (Exception e) {
            return null;
        }

        return departments;
    }

    @Override
    public Department getById(int code) {
        Department department = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM departamentos WHERE codigo = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, code);
            rs = stmt.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.setCode(rs.getInt("codigo"));
                department.setName(rs.getString("nombre"));
                department.setIdManagemen(rs.getInt("idEncargado"));
                department.setLocation(rs.getString("ubicacion"));
                department.setPhone(rs.getString("telefono"));
                department.setEmail(rs.getString("correo"));
            }
            this.close(rs, stmt);
            return department;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(Department department) {
        boolean rowUpdated;
        PreparedStatement stmt = null;
        String sql = "UPDATE departamentos SET nombre = ?, idEncargado = ?, "
                + "ubicacion = ?,telefono = ?, correo = ? WHERE codigo = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, department.getName());
            stmt.setInt(2, department.getIdManagemen());
            stmt.setString(3, department.getLocation());
            stmt.setString(4, department.getPhone());
            stmt.setString(5, department.getEmail());

            stmt.setInt(6, department.getCode());
            rowUpdated = stmt.executeUpdate() > 0;
            this.close(stmt);
            return rowUpdated;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int code) {
        boolean rowDeleted;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM departamentos WHERE codigo = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, code);
            rowDeleted = stmt.executeUpdate() > 0;
            this.close(stmt);
            return rowDeleted;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean store(Department department) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO departamentos(codigo,nombre,"
                + "idEncargado,ubicacion,telefono,correo"
                + ") VALUES(?,?,?,?,?,?)";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, department.getCode());
            stmt.setString(2, department.getName());
            stmt.setInt(3, department.getIdManagemen());
            stmt.setString(4, department.getLocation());
            stmt.setString(5, department.getPhone());
            stmt.setString(6, department.getEmail());

            stmt.execute();
            this.close(stmt);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
