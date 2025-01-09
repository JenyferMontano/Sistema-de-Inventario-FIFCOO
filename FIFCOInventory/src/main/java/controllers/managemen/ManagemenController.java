package controllers.managemen;

import models.managemen.DboManagemen;
import models.managemen.Managemen;
import java.time.LocalDate;
import java.util.List;

public class ManagemenController implements ManagemenInterface {

    private DboManagemen dbo = new DboManagemen();

    @Override
    public String add(String[] data) {
        String response = "Error al guardar los datos!!!";
        Managemen managemen = new Managemen();
        managemen.setId(Integer.parseInt(data[0]));
        managemen.setName(data[1]);
        managemen.setLastName(data[2]);
        managemen.setPhone(data[3]);
        managemen.setLocation(data[4]);
        managemen.setBirthDate(LocalDate.parse(data[5]));

        if (dbo.store(managemen)) {
            response = "Encargado guardado correctamente!";
        }
        return response;
    }

    @Override
    public String update(String[] data) {
        String response = "Error al actualizar al encargado!";

        Managemen managemen = dbo.getById(Integer.parseInt(data[0]));

        if (managemen != null) {
            managemen.setName(data[1]);
            managemen.setLastName(data[2]);
            //managemen.setEmail(data[3]);
            managemen.setPhone(data[3]);
            managemen.setLocation(data[4]);
            managemen.setBirthDate(LocalDate.parse(data[5]));

            if (dbo.update(managemen)) {
                response = "Encargado actualizado correctamente!";
            }
        } else {
            response = "Encargado no encontrado!";
        }
        return response;
    }

    @Override
    public String delete(String id) {
        String response = "Error al eliminar al encargado!!!";

        Managemen managemen = dbo.getById(Integer.parseInt(id));

        if (managemen != null) {
            if (dbo.delete(Integer.parseInt(id))) {
                response = "Encargado eliminado correctamente!";
            }
        } else {
            response = "Encargado no encontrado!";
        }

        return response;
    }

    @Override
    public String[][] list() {
        List<Managemen> managemens = dbo.getAll();

        if (managemens == null || managemens.isEmpty()) {
            return new String[0][];
        }

        String[][] data = new String[managemens.size()][6];

        for (int i = 0; i < managemens.size(); i++) {
            Managemen managemen = managemens.get(i);
            data[i][0] = String.valueOf(managemen.getId());
            data[i][1] = managemen.getName();
            data[i][2] = managemen.getLastName();
            data[i][3] = managemen.getPhone();
            data[i][4] = String.valueOf(managemen.getBirthDate());
            data[i][5] = managemen.getLocation();

        }

        return data;
    }

    @Override
    public String[] find(String id) {
        Managemen managemen = dbo.getById(Integer.parseInt(id));
        if (managemen != null) {
            String[] data = new String[6];
            data[0] = String.valueOf(managemen.getId());
            data[1] = managemen.getName();
            data[2] = managemen.getLastName();
            data[3] = managemen.getPhone();
            data[4] = String.valueOf(managemen.getBirthDate());
            data[5] = managemen.getLocation();
            return data;
        }
        return null;
    }
}
