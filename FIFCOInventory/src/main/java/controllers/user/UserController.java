package controllers.user;

import models.user.DboUser;
import models.user.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController implements UserInterface {

    private DboUser dbo;

    public UserController() throws SQLException {
        dbo = new DboUser();
    }

    @Override
    public String add(String[] data) {
        String response = "Error al guardar los datos!!!";
        User user = new User();
        user.setUsername(data[0]);
        user.setPassword(data[1]);
        user.setId(Integer.parseInt(data[2]));
        user.setName(data[3]);
        user.setLastName(data[4]);
        user.setEmail(data[5]);
        user.setPhone(data[6]);
        user.setLocation(data[7]);
        user.setBirthDate(LocalDate.parse(data[8]));
        if (dbo.store(user)) {
            response = "Usuario guardado correctamente!";
        }
        return response;
    }

    @Override
    public String[] find(String id) {
        String data[] = null;
        User user = dbo.getById(Integer.parseInt(id));
        if (user != null) {
            data = new String[9];
            data[0] = user.getUsername();
            data[1] = user.getPassword();
            data[2] = String.valueOf(user.getId());
            data[3] = user.getName();
            data[4] = user.getLastName();
            data[5] = user.getEmail();
            data[6] = user.getPhone();
            data[7] = user.getLocation();
            data[8] = user.getBirthDate().toString();
        }
        return data;
    }

    @Override
    public String[] findByUsername(String username) {
        String data[] = null;
        User user = null;
        try {
            user = dbo.getByUsername(username);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
        }
        if (user != null) {
            data = new String[9];
            data[0] = user.getUsername();
            data[1] = user.getPassword();
            data[2] = String.valueOf(user.getId());
            data[3] = user.getName();
            data[4] = user.getLastName();
            data[5] = user.getEmail();
            data[6] = user.getPhone();
            data[7] = user.getLocation();
            data[8] = user.getBirthDate().toString();
        }
        return data;
    }

    @Override
    public String update(String[] data) {
        String response = "Error al actualizar los datos!!!";
        try {
            User user = new User();
            user.setUsername(data[0]);
            user.setPassword(data[1]);
            user.setId(Integer.parseInt(data[2]));
            user.setName(data[3]);
            user.setLastName(data[4]);
            user.setEmail(data[5]);
            user.setPhone(data[6]);
            user.setLocation(data[7]);
            user.setBirthDate(LocalDate.parse(data[8]));

            if (dbo.update(user)) {
                response = "Usuario actualizado correctamente!";
            }
        } catch (NumberFormatException e) {
            response = "Error: El ID debe ser un número entero válido!!!";
        } catch (DateTimeParseException e) {
            response = "Error: Formato de fecha incorrecto. Use el formato yyyy-MM-dd";
        }

        return response;
    }

    @Override
    public String delete(String id) {
        String response = "Error: tal vez el usuario no exista.";
        try {
            if (dbo.delete(Integer.parseInt(id))) {
                response = "Usuario eliminado correctamente!";
            }
        } catch (Exception e) {
            response = "Error al eliminar el usuario: " + e.getMessage();
        }
        return response;
    }

    @Override
    public String[][] list() {
        var users = dbo.getAll();
        String[][] data = new String[users.size()][9];

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            data[i][0] = user.getUsername();
            data[i][1] = user.getPassword();
            data[i][2] = String.valueOf(user.getId());
            data[i][3] = user.getName();
            data[i][4] = user.getLastName();
            data[i][5] = user.getEmail();
            data[i][6] = user.getPhone();
            data[i][7] = user.getLocation();
            data[i][8] = user.getBirthDate().toString();
        }

        return data;
    }
}
