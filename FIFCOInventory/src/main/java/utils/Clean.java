/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JTextField;

/**
 *
 * @author jenif
 */
public class Clean {
          public static void clearSpaces(JTextField... fields) {
          // JTextField... fields -> varags permite de cero a mas argumentos,  tipo_retorno nombre_método(tipo_datos... nombre_variable){}  
        for (JTextField field : fields) { 
            field.setText("");
        }
    }
    
}
