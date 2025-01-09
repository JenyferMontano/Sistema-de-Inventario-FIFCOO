package report;

import controllers.report.ReportController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ReportControllerTest {

    ReportController instance;

    @BeforeEach
    public void setUp() throws SQLException {
        instance = new ReportController();

    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testListProductsByAllDesc() {
        String descripcion = "MILORY KOLITA 600 ML"; // Cambia este ID a uno que tengas en la base de datos
        String[][] result = instance.listProductosPorDescripcion(descripcion);
        assertNotNull(result, "El resultado no debe ser nulo");
        assertTrue(result.length > 0, "La lista de productos no debe estar vacía");
        assertEquals("69952", result[0][0]);
        assertEquals("MILORY KOLITA 600 ML", result[0][1]);
        assertEquals("201", result[0][2]);
        assertEquals("450", result[0][3]);
        assertEquals("100", result[0][4]);
        assertEquals("500", result[0][5]);
    }
    
    @Test
    public void testListMinStockProducts() {
        String[][] result = instance.listMinStockProducts();

        assertNotNull(result, "El resultado no debe ser nulo");

        int expectedSize = 1;
        assertEquals(expectedSize, result.length, "El tamaño de la matriz no es el esperado");

        //Verifica algunos valores específicos, ajusta según los productos que agregaste a la DB
        
        // Producto 1
        assertEquals("180512", result[0][0]);
        assertEquals("TROPICAL LIMON 500 ML", result[0][1]);
        assertEquals("202", result[0][2]);
        assertEquals("60", result[0][3]);
        assertEquals("60", result[0][4]);

    }

    @Test
    public void testListProductosQueContienenTropical() {
        String descripcion = "TROPICAL";
        String[][] result = instance.listProductosPorDescripcion(descripcion);
        assertNotNull(result, "El resultado no debe ser nulo");
        assertTrue(result.length > 0, "La lista de productos no debe estar vacía");
        for (String[] producto : result) {
            assertTrue(producto[1].toLowerCase().contains("tropical"),
                    "La descripción del producto debe contener 'TROPICAL'. Descripción: " + producto[1]);
        }
    }

    @Test
    public void testListProductosQueContienenCola() {
        String descripcion = "COLA"; // Este es el término que buscamos
        String[][] result = instance.listProductosPorDescripcion(descripcion);
        assertNotNull(result, "El resultado no debe ser nulo");
        assertEquals(2, result.length, "El número de productos que contienen 'COLA' debería ser 2");
        for (String[] producto : result) {
            assertTrue(producto[1].toLowerCase().contains("cola"),
                    "La descripción del producto debe contener 'cola'. Descripción: " + producto[1]);
        }
    }

}
