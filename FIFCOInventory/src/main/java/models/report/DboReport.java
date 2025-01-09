/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.report;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.DBConnection;
import models.product.Product;

/**
 *
 * @author jenif
 */
public class DboReport extends DBConnection {

    public DboReport() {
        super("localhost", "fifcodb", "root", "");
    }

    // Método para obtener productos por categoría
    public List<Product> getProductosPorCategoria(int idCategoria) {
        List<Product> productos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos WHERE idCategoria = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, idCategoria);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Product producto = extractProductFromResultSet(rs);
                productos.add(producto);
            }
        } catch (Exception e) {
        }
        return productos;
    }

    // Método para obtener productos con stock mínimo
    public List<Product> getProductosConStockMinimo() {
        List<Product> productos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos WHERE existencias <= minimo";

        try {
            stmt = this.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product producto = extractProductFromResultSet(rs);
                productos.add(producto);
            }

        } catch (Exception e) {
            return null;
        }

        return productos;
    }

    // Método para obtener productos con espacio limitado
    public List<Product> getProductosConEspacioLimitado() {
        List<Product> productos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos WHERE existencias >= maximo * 0.75";

        try {
            stmt = this.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product producto = extractProductFromResultSet(rs);
                productos.add(producto);
            }

        } catch (Exception e) {
             return null;
        }

        return productos;
    }

    // Método para obtener productos por descripción
    public List<Product> getProductosPorDescripcion(String descripcion) {
        List<Product> productos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos WHERE descripcion LIKE ?";

        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + descripcion + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Product producto = extractProductFromResultSet(rs);
                productos.add(producto);
            }
            this.close(rs, stmt);

        } catch (Exception e) {
             return null;
        }
        return productos;
    }

    private Product extractProductFromResultSet(ResultSet rs) throws Exception {
        Product producto = new Product();
        producto.setCode(rs.getInt("codigo"));
        producto.setDescription(rs.getString("descripcion"));
        producto.setIdCategory(rs.getInt("idCategoria"));
        producto.setCurrentExist(rs.getInt("existencias"));
        producto.setMinimum(rs.getInt("minimo"));
        producto.setMaximum(rs.getInt("maximo"));
        
        return producto;
    }

}
