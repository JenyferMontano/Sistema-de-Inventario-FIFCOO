/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import static org.junit.jupiter.api.Assertions.*;

import controllers.user.UserController;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jenif
 */
public class UserControllerTest {

    UserController instance;

    @BeforeEach
    public void setUp() throws SQLException {
        instance = new UserController();

    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testAddUser() {
        String data[] = {"Blue",
            "Par12#34",
            "7",
            "Gojo",
            "Saturo",
            "partidoendos@gmail.com",
            "20202",
            "Tokio",
            "1990-01-11"};

        String expected = "Usuario guardado correctamente!";
        String result = instance.add(data);
        assertEquals(expected, result);
        
         String[] foundUser = instance.find("7");
        assertNotNull(foundUser);
        assertEquals("Blue", foundUser[0]);
    }
    
      
  @Test
  public void testDeleteUser(){
   String expected = "Usuario eliminado correctamente!";
    String result = instance.delete("7");
    
    assertEquals(expected, result);
  }
  
  @Test
public void testUpdateUser() {
    String[] initialData = {
        "RURU",
        "123#mA",
        "10", 
        "Init",
        "tial",
        "initial@gmail.com",
        "12345",
        "Direccion",
        "2000-01-01"
    };
    instance.add(initialData);

    String[] updateData = {
        "Toilet",
        "No digas",
        "10",
        "Juan",
        "Porras",
        "NoDigasToilet@gmail.com",
        "87968542",
        "Nicoya",
        "1990-01-09"
    };

    String expectedResponse = "Usuario actualizado correctamente!";
    String actualResponse = instance.update(updateData);
    Assertions.assertEquals(expectedResponse, actualResponse);
}

 @Test
    public void testFindByUsername() throws Exception {

        try {
            String username = "Toilet";
            String[] data = instance.findByUsername(username);
            Assertions.assertNotNull(data);
            Assertions.assertEquals(9, data.length);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
    @Test
    public void testListUsers() {
        String[][] users = instance.list();
        assertEquals(4, users.length);
    }

}
