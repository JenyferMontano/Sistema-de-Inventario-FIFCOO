/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Pattern;

/**
 *
 * @author jenif
 */
public class Validator {

    private static Validator instance;

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    private Validator() {
    }

    public boolean isEmailValid(String email) {
        Pattern emailPattern = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$");
        return emailPattern.matcher(email).find();
    }

    /**
     * Valida un password bajo las siguientes reglas 1- Contenga minúsculas 2-
     * Contenga Mayúsculas 3- Contenga números 4- Contenga carácteres especiales
     * (¿?+*!¡#$%&/) 5- Tamaño 8-32 carácteres
     *
     */
    public boolean isPasswordValid(String password) {
        Pattern passwordPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[¿?+*!¡#$%&/])(?=.*[\\W]).{8,32})");
        return passwordPattern.matcher(password).find();
    }

}
