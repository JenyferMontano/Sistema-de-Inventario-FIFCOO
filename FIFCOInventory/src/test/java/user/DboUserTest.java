/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;
import java.sql.Connection;
import java.sql.SQLException;
import models.user.DboUser;
import models.user.User;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author jenif
 */
public class DboUserTest {
    DboUser instance;
    Connection connection;
    
    @BeforeEach
    public void setUp() throws Exception {
        instance = new DboUser();
    }
    
       @AfterEach
    public void tearDown() {
        instance = null;
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void TestStoreDboUser(){
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPass");
        user.setId(1);
        user.setName("Test");
        user.setLastName("User");
        user.setEmail("test@example.com");
        user.setPhone("1234567890");
        user.setLocation("Test Location");
        user.setBirthDate(java.time.LocalDate.of(2000, 1, 1));

        boolean result = instance.store(user);
        assertEquals(result,true);
        //assertTrue(result, "User should be stored successfully");

//        // Verifica si el usuario se ha almacenado correctamente
//        User retrievedUser = instance.getById(1);
//        assertNotNull(retrievedUser, "Retrieved user should not be null");
//        assertEquals("testUser", retrievedUser.getUsername());
        
    }
    
    
}
