package models.managemen;

import models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DboManagemen extends DAO<Managemen> {

    @Override
    public List<Managemen> getAll() {
        List<Managemen> managemens = new ArrayList<Managemen>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM encargados";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Managemen managemen = new Managemen();
                managemen.setId(rs.getInt("id"));
                managemen.setName(rs.getString("nombre"));
                managemen.setLastName(rs.getString("apellidos"));
                managemen.setPhone(rs.getString("telefono"));
                managemen.setLocation(rs.getString("direccion"));
                managemen.setBirthDate(rs.getDate("fNacimiento").toLocalDate());

                managemens.add(managemen);
            }
            this.close(rs, stmt);

        } catch (Exception e) {
            return null;
        }

        return managemens;
    }

    @Override
    public Managemen getById(int id) {
        Managemen managemen = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM encargados WHERE id = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                managemen = new Managemen();
                managemen.setId(rs.getInt("id"));
                managemen.setName(rs.getString("nombre"));
                managemen.setLastName(rs.getString("apellidos"));
                managemen.setPhone(rs.getString("telefono"));
                managemen.setLocation(rs.getString("direccion"));
                managemen.setBirthDate(rs.getDate("fNacimiento").toLocalDate());
            }
            this.close(rs, stmt);
            return managemen;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(Managemen managemen) {
        boolean rowUpdated;
        PreparedStatement stmt = null;
        String sql = "UPDATE encargados SET nombre = ?, apellidos = ?, telefono = ?, fNacimiento = ?, direccion = ? WHERE id = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, managemen.getName());
            stmt.setString(2, managemen.getLastName());
            stmt.setString(3, managemen.getPhone());
            stmt.setString(4, managemen.getBirthDate().toString());
            stmt.setString(5, managemen.getLocation());

            stmt.setInt(6, managemen.getId());
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
        String sql = "DELETE FROM encargados WHERE id = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
            this.close(stmt);
            return rowDeleted;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean store(Managemen managemen) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO encargados(id,nombre,apellidos,"
                + "telefono,fNacimiento,direccion"
                + ") VALUES(?,?,?,?,?,?)";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, managemen.getId());
            stmt.setString(2, managemen.getName());
            stmt.setString(3, managemen.getLastName());
            stmt.setString(4, managemen.getPhone());
            stmt.setString(6, managemen.getLocation());
            stmt.setString(5, managemen.getBirthDate().toString());

            stmt.execute();
            this.close(stmt);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
