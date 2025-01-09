package models.product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.DAO;

public class DBOProduct extends DAO<Product> {

    @Override
    public List<Product> getAll() {
        List<Product> prod = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setCode(rs.getInt("codigo"));
                product.setDescription(rs.getString("descripcion"));
                product.setIdCategory(rs.getInt("idCategoria"));
                product.setCurrentExist(rs.getInt("existencias"));
                product.setMinimum(rs.getInt("minimo"));
                product.setMaximum(rs.getInt("maximo"));
                String imageName = rs.getString("nombre_imagen");
                product.setImageName(imageName); // Cambia aquí según tu estructura de carpetas
                Blob blob = rs.getBlob("imagen");
                if (blob != null) {
                    product.setImage(blob.getBytes(1, (int) blob.length()));
                }
                prod.add(product);
            }
            this.close(rs, stmt);

        } catch (Exception e) {
        }

        return prod;
    }

    public Product getByCode(int code) {
        Product product = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, code);
            rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setCode(rs.getInt("codigo"));
                product.setDescription(rs.getString("descripcion"));
                product.setIdCategory(rs.getInt("idCategoria"));
                product.setCurrentExist(rs.getInt("existencias"));
                product.setMinimum(rs.getInt("minimo"));
                product.setMaximum(rs.getInt("maximo"));
                String imageName = rs.getString("nombre_imagen");
                product.setImageName(imageName); // Cambia aquí según tu estructura de carpetas

                Blob blob = rs.getBlob("imagen");
                if (blob != null) {
                    product.setImage(blob.getBytes(1, (int) blob.length()));
                }
            }

            this.close(rs, stmt);
            return product;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean update(Product product) {
        boolean rowsAffected;
        PreparedStatement stmt = null;
        String sql = "UPDATE productos SET descripcion = ?, idCategoria = ?, existencias = ?, minimo = ?, maximo = ?, nombre_imagen = ? WHERE codigo = ?";

        try {
            stmt = this.getConnection().prepareStatement(sql);
            // Configura los parámetros
            stmt.setString(1, product.getDescription());
            stmt.setInt(2, product.getIdCategory());
            stmt.setInt(3, product.getCurrentExist());
            stmt.setInt(4, product.getMinimum());
            stmt.setInt(5, product.getMaximum());

            // Solo actualiza el nombre de la imagen si se proporciona uno nuevo
            if (product.getImageName() != null && !product.getImageName().isBlank()) {
                stmt.setString(6, product.getImageName());
            } else {
                stmt.setString(6, null);
            }
            stmt.setInt(7, product.getCode()); // Código del producto para identificar la actualización

            rowsAffected = stmt.executeUpdate() > 0; // Verifica si se actualizó alguna fila
            this.close(null, stmt);
            return rowsAffected; // Retorna true si la actualización fue exitosa
        } catch (Exception ex) {
            return false;
        }

    }

    public byte[] loadImage(String imagePath) {
        try {
            File imgFile = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(imgFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos); // Cambiar el formato segun se necesite
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean delete(int code) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM productos WHERE codigo = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, code);
            int rowsAffected = stmt.executeUpdate();  // Verifica si se eliminó alguna fila
            this.close(null, stmt);
            return rowsAffected > 0;  // Retorna true si se eliminó correctamente
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean store(Product product) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO productos(codigo, descripcion, idCategoria, existencias, minimo, maximo, imagen, nombre_imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, product.getCode());
            stmt.setString(2, product.getDescription());
            stmt.setInt(3, product.getIdCategory());
            stmt.setInt(4, product.getCurrentExist());
            stmt.setInt(5, product.getMinimum());
            stmt.setInt(6, product.getMaximum());

            if (product.getImage() != null && product.getImageName() != null) {
                stmt.setBinaryStream(7, new ByteArrayInputStream(product.getImage()));
                stmt.setString(8, product.getImageName());
            } else {
                stmt.setBinaryStream(7, null);  // Almacena null si no hay imagen
                stmt.setString(8, product.getImageName() != null ? product.getImageName() : ""); // Guarda un string vacío si no hay nombre de imagen
            }
            stmt.executeUpdate();
            this.close(null, stmt);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean categoryExists(int idCategory) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM categorias WHERE codigo = ?";
        try {
            stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(1, idCategory);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si la categoría existe
            }
        } catch (SQLException e) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.close(rs, stmt);
        }
        return false; // Devuelve false si la categoría no existe
    }

    @Override
    public Product getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
