/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.report;

import java.util.List;
import models.product.Product;
import models.report.DboReport;

/**
 *
 * @author jenif
 */
public class ReportController implements ReportInterface {

    private DboReport dbo;

    public ReportController() {
        try {
            dbo = new DboReport();
        } catch (Exception e) {
        }
    }

    @Override
    public String[][] getProductosPorCategoria(int idCategoria) {
        List<Product> products = dbo.getProductosPorCategoria(idCategoria);
        String[][] data = new String[products.size()][6];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = String.valueOf(product.getCode());    
            data[i][1] = product.getDescription();               
            data[i][2] = String.valueOf(product.getIdCategory());  
            data[i][3] = String.valueOf(product.getCurrentExist());  
            data[i][4] = String.valueOf(product.getMinimum());     
            data[i][5] = String.valueOf(product.getMaximum());
        }
        return data;
    }

    @Override
    public String[][] listMinStockProducts() {

        List<Product> products = dbo.getProductosConStockMinimo();
        String[][] data = new String[products.size()][6];

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = String.valueOf(product.getCode());
            data[i][1] = product.getDescription();
            data[i][2] = String.valueOf(product.getIdCategory());
            data[i][3] = String.valueOf(product.getCurrentExist());
            data[i][4] = String.valueOf(product.getMinimum());
            data[i][5] = String.valueOf(product.getMaximum());

        }

        return data;
    }

    public String[][] listLimitSpaceP() {
        try {
            List<Product> limitS = dbo.getProductosConEspacioLimitado();
            String[][] data = new String[limitS.size()][6]; 
            for (int i = 0; i < limitS.size(); i++) {
                Product aux = limitS.get(i);
                data[i][0] = String.valueOf(aux.getCode()); //Código del producto
                data[i][1] = aux.getDescription();          //Descripción
                data[i][2] = String.valueOf(aux.getIdCategory()); //Categoría
                data[i][3] = String.valueOf(aux.getCurrentExist()); //Existencias actuales
                data[i][4] = String.valueOf(aux.getMinimum()); //Stock mínimo
                data[i][5] = String.valueOf(aux.getMaximum()); //Stock máximo
            }
            return data;
        } catch (Exception e) {
            return null;
        }

    }

    public String[][] listProductosPorDescripcion(String descripcion) {
        try {
            List<Product> lista = dbo.getProductosPorDescripcion(descripcion);
            String[][] data = new String[lista.size()][6];
            for (int i = 0; i < lista.size(); i++) {
                Product aux = lista.get(i);
                data[i][0] = String.valueOf(aux.getCode());
                data[i][1] = aux.getDescription();
                data[i][2] = String.valueOf(aux.getIdCategory());
                data[i][3] = String.valueOf(aux.getCurrentExist());
                data[i][4] = String.valueOf(aux.getMinimum());
                data[i][5] = String.valueOf(aux.getMaximum());
            }
            return data;
        } catch (Exception e) {
            return null;
        }
    }

}
