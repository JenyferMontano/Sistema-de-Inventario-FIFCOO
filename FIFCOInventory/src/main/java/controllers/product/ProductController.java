package controllers.product;

import models.product.Product;
import models.product.DBOProduct;

import javax.swing.*;

public class ProductController implements ProductInterface {

    private byte[] tempFile;

    public String add(String[] data) {
        String response = "Error al agregar el producto";
        Product product = new Product();

        try {
            // Validar que todos los campos necesarios estén presentes
            if (data.length < 7) {
                return "Datos insuficientes para agregar el producto";
            }

            int code = Integer.parseInt(data[0]); // El índice 0 debe ser el código
            String imageName = data[6] != null && !data[6].isBlank() ? data[6] : null;
            int idCategory = Integer.parseInt(data[2]);
            DBOProduct dboProduct = new DBOProduct();
            if (!dboProduct.categoryExists(idCategory)) {
                return "La categoría ingresada no existe.";
            }

            product.setCode(code);
            product.setDescription(data[1]);
            product.setIdCategory(idCategory);
            product.setCurrentExist(Integer.parseInt(data[3]));
            product.setMinimum(Integer.parseInt(data[4]));
            product.setMaximum(Integer.parseInt(data[5]));
            product.setImageName(imageName);
            if (this.tempFile != null) {
                product.setImage(this.tempFile);
            }

            if (dboProduct.store(product)) {
                response = "Producto agregado correctamente";
            }
        } catch (NumberFormatException e) {
            return "Por favor, ingrese valores numéricos válidos para Código, ID de Categoría, Existencia Actual, Mínimo y Máximo.";
        } catch (Exception e) {
            return "Ocurrió un error al agregar el producto: " + e.getMessage();
        }

        return response;
    }

    @Override
    public String[] find(String code) {
        // Validación del código
        if (code == null || code.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El código no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Retorna null si el código es vacío
        }

        String[] data = null;
        DBOProduct dbo = new DBOProduct();

        try {
            // Intentamos convertir el código a entero
            int productCode = Integer.parseInt(code);
            Product product = dbo.getByCode(productCode);

            if (product != null) {
                data = new String[7];
                data[0] = String.valueOf(product.getCode());
                data[1] = product.getDescription();
                data[2] = String.valueOf(product.getIdCategory());
                data[3] = String.valueOf(product.getCurrentExist());
                data[4] = String.valueOf(product.getMinimum());
                data[5] = String.valueOf(product.getMaximum());
                data[6] = product.getImageName();
                this.tempFile = product.getImage();
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return data;
    }

    @Override
    public String update(String[] data) {
        String response = "Error al actualizar los datos";
        Product product = new Product();

        try {
            // Validación de datos
            if (data.length < 7) {
                return "Datos insuficientes para la actualización";
            }

            int code = Integer.parseInt(data[0]);
            String imageName = data[6] != null && !data[6].isBlank() ? data[6] : null;

            int idCategory = Integer.parseInt(data[2]);
            // Verificar si el idCategory existe
            DBOProduct dboProduct = new DBOProduct();
            if (!dboProduct.categoryExists(idCategory)) {
                return "La categoría ingresada no existe.";
            }

            // Si no existe, proceder a actualizar el producto
            product.setCode(code);
            product.setDescription(data[1]);
            product.setIdCategory(idCategory); //verifica por la llave foranea
            product.setCurrentExist(Integer.parseInt(data[3]));
            product.setMinimum(Integer.parseInt(data[4]));
            product.setMaximum(Integer.parseInt(data[5]));
            product.setImageName(imageName);

            // Manejo de la imagen temporal
            if (this.tempFile != null) {
                product.setImage(this.tempFile);
            }
            if (dboProduct.update(product)) {
                response = "Producto actualizado correctamente";
            }

        } catch (NumberFormatException e) {
            return "Error: Verifica los datos ingresados.";
        } catch (Exception e) {
        }

        return response;
    }

    @Override
    public String delete(String code) {
        String response = "Error al eliminar el producto";

        // Validar si el código está vacío
        if (code == null || code.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El código del producto no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return response;
        }
        try {
            // Convertir el código a un número entero
            int productCode = Integer.parseInt(code);
            
            // Verificar si el código es un número positivo
            if (productCode <= 0) {
                JOptionPane.showMessageDialog(null, "El código del producto debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return response;
            }
            
            //Intentar eliminar el producto
            if (new DBOProduct().delete(productCode)) {
                response = "Producto eliminado correctamente";
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado con el código proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                response = "Producto no encontrado con el código proporcionado."; // Cambia la respuesta aquí
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return response; // Retorna la respuesta final
    }

    @Override
    public String[][] list() {
        return new String[0][];
    }

    @Override
    public byte[] download() {
        return new byte[0];
    }

    @Override
    public void upload(byte[] data) {
        this.tempFile = data;

    }

    @Override
    public boolean codeOrImageExists(int code, String imageName) {
        return false;
    }
}
