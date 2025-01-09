/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import java.sql.SQLException;
import java.util.List;
import models.product.Product;
import models.report.DboReport;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jenif
 */
public class DboReportTest {

    DboReport instance;

    @BeforeEach
    public void setUp() throws SQLException {
        instance = new DboReport();

    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
    
        @Test
    public void testGetProductosPorCategoria() {
        int idCategoria = 201;
        List<Product> productos = instance.getProductosPorCategoria(idCategoria);
        assertNotNull(productos);
        assertFalse(productos.isEmpty(), "La lista de productos no debe estar vacía");
        for (Product producto : productos) {
            assertEquals(idCategoria, producto.getIdCategory(), "El ID de categoría del producto no coincide");
        }
    }

   
    @Test
    public void testGetProductosConStockMinimo() {
        List<Product> productos = instance.getProductosConStockMinimo();
        assertNotNull(productos);
        assertFalse(productos.isEmpty(), "La lista de productos con stock mínimo no debe estar vacía");
        for (Product producto : productos) {
            assertTrue(producto.getCurrentExist() <= producto.getMinimum(), "El producto debería tener existencias actuales menores o iguales al mínimo");
        }

}
}
