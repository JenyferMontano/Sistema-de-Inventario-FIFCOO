/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers.report;

/**
 *
 * @author jenif
 */
public interface ReportInterface{
     public String[][] getProductosPorCategoria(int idCategoria);
     public String[][] listMinStockProducts();
     public String[][] listLimitSpaceP();
     public String[][] listProductosPorDescripcion(String descripcion);
    
}
