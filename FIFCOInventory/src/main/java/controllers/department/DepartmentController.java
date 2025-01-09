package controllers.department;

import models.department.*;
import java.util.List;

public class DepartmentController implements DepartmentInterface {

    private DboDepartment dbo;

    public DepartmentController() {
        try {
            dbo = new DboDepartment();
        } catch (Exception e) {
        }

    }

    @Override
    public String add(String[] data) {
        String response = "Error al guardar los datos!!!";
        Department department = new Department();
        department.setCode(Integer.parseInt(data[0]));
        department.setName(data[1]);
        department.setIdManagemen(Integer.parseInt(data[2]));
        department.setLocation(data[3]);
        department.setPhone(data[4]);
        department.setEmail(data[5]);

        if (dbo.store(department)) {
            response = "Departamento guardado correctamente!";
        }

        return response;
    }

    @Override
    public String[] find(String id) {
        Integer iD = Integer.parseInt(id);
        Department department = dbo.getById(iD);
        if (department != null) {
            String[] data = new String[6];
            data[0] = String.valueOf(department.getCode());
            data[1] = department.getName();
            data[2] = String.valueOf(department.getIdManagemen());
            data[3] = department.getLocation();
            data[4] = department.getPhone();
            data[5] = department.getEmail();
            return data;
        }
        return null;
    }

    @Override
    public String update(String[] data) {
        String response = "Error al actualizar el departamento!";

        Department department = dbo.getById(Integer.parseInt(data[0]));

        if (department != null) {
            department.setCode(Integer.parseInt(data[0]));
            department.setName(data[1]);
            department.setIdManagemen(Integer.parseInt(data[2]));
            department.setLocation(data[3]);
            department.setPhone(data[4]);
            department.setEmail(data[5]);
            response = "a";
            if (dbo.update(department)) {
                response = "Departamento actualizado correctamente!";
            }
        } else {
            response = "Departamento no encontrado!";
        }
        return response;
    }

    @Override
    public String delete(String id) {
        String response = "Error al eliminar el departamento!!!";

        Department department = dbo.getById(Integer.parseInt(id));

        if (department != null) {
            if (dbo.delete(Integer.parseInt(id))) {
                response = "Departamento eliminado correctamente!";
            }
        } else {
            response = "Departamento no encontrado!";
        }

        return response;
    }

    @Override
    public String[][] list() {
        List<Department> departments = dbo.getAll();

        if (departments == null || departments.isEmpty()) {
            return new String[0][];
        }

        String[][] data = new String[departments.size()][6];

        for (int i = 0; i < departments.size(); i++) {
            Department department = departments.get(i);
            data[i][0] = String.valueOf(department.getCode());
            data[i][1] = department.getName();
            data[i][2] = String.valueOf(department.getIdManagemen());
            data[i][3] = department.getLocation();
            data[i][4] = department.getPhone();
            data[i][5] = department.getEmail();
        }

        return data;
    }
}
