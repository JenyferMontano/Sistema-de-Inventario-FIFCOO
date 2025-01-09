package controllers.Block;

import models.Category.Block.Block;
import models.Category.Block.DBOBlock;

import java.util.ArrayList;
import java.util.List;

public class BlockController implements BlockInterface {

    @Override
    public String add(String[] data) {
        String response = "Error al guardar datos";
        if (data.length < 3) {
            return "Datos incompletos. Se requieren ID, nombre y estado.";
        }
        try {
            Block block = new Block();
            block.setId(Integer.parseInt(data[0]));
            block.setName(data[1]);
            block.setState(data[2]);

            if (new DBOBlock().store(block)) {
                response = "El bloque se ha guardado correctamente";
            }
        } catch (NumberFormatException e) {
            response = "ID debe ser un número";
        } catch (Exception e) {

        }
        return response;
    }

    @Override
    public String[] find(String id) {
        String[] data = null;
        try {
            DBOBlock dbo = new DBOBlock();
            Block block = dbo.getById(Integer.parseInt(id));
            if (block != null) {
                data = new String[3];
                data[0] = String.valueOf(block.getId());
                data[1] = block.getName();
                data[2] = block.getState();
            }
        } catch (NumberFormatException e) {
            System.err.println("ID debe ser un número");
        } catch (Exception e) {
        }
        return data;
    }

    @Override
    public String update(String[] data) {
        String response = "Error al actualizar los datos";
        if (data.length < 3) {
            return "Datos incompletos. Se requieren ID, nombre y estado.";
        }
        try {
            Block block = new Block();
            block.setId(Integer.parseInt(data[0]));
            block.setName(data[1]);
            block.setState(data[2]);

            if (new DBOBlock().update(block)) {
                response = "Bloque actualizado correctamente";
            }
        } catch (NumberFormatException e) {
            response = "ID debe ser un número";
        } catch (Exception e) {
        }
        return response;
    }

    @Override
    public String delete(String id) {
        String response = "Error al eliminar el bloque";
        try {
            if (new DBOBlock().delete(Integer.parseInt(id))) {
                response = "Bloque eliminado correctamente";
            }
        } catch (NumberFormatException e) {
            response = "ID debe ser un número";
        } catch (Exception e) {
        }
        return response;
    }

    @Override
    public String[][] list() {
        List<Block> blocks = new DBOBlock().getAll();
        String[][] data = new String[blocks.size()][3];
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            data[i][0] = String.valueOf(block.getId());
            data[i][1] = block.getName();
            data[i][2] = block.getState();
        }
        return data;
    }

    @Override
    public List<String> getAllBlock() {
        List<String> blockId = new ArrayList<>();
        DBOBlock dbo = new DBOBlock();
        List<Block> blocks = dbo.getAll();
        for (Block block : blocks) {
            blockId.add(String.valueOf(block.getId()));
        }
        return blockId;
    }
}
