package controllers.Category;

import models.Category.Block.Block;
import models.Category.Category;
import models.Category.DBOCategory;

import java.util.List;

public class CategoryController implements CategoryInterface {

    @Override
    public String add(String[] data) {

        if (data.length < 4) {
            return "Datos incompletos";
        }

        Category category = new Category();
        category.setCode(Integer.parseInt(data[0]));
        category.setDescription(data[1]);

        Block blo = new Block();
        blo.setId(Integer.parseInt(data[2]));
        blo.setName(data[3]);
        blo.setState(data.length > 4 ? data[4] : "1");
        category.setBlock(blo);

        if (new DBOCategory().store(category)) {
            return "La categoría se ha guardado correctamente";
        }

        return "Error al guardar la categoría";
    }

    @Override
    public String[] find(String codigo) {
        String[] data = null;
        try {
            DBOCategory dbo = new DBOCategory();
            Category category = dbo.getById(Integer.parseInt(codigo.trim()));

            if (category != null) {
                Block block = category.getBlock();
                if (block != null) {
                    data = new String[4];
                    data[0] = String.valueOf(category.getCode());
                    data[1] = category.getDescription();
                    data[2] = String.valueOf(block.getId());
                    data[3] = block.getState();
                } else {
                    return new String[]{"Error: la categoría no tiene un bloque asociado."};
                }
            } else {
                return new String[]{"Error: categoría no encontrada."};
            }
        } catch (NumberFormatException e) {
            return new String[]{"Error: el código debe ser un número."};
        } catch (Exception e) {
        }
        return data;
    }

    @Override
    public String update(String[] data) {
        String response = "Error al actualizar datos";
        if (data.length < 4) {
            return "Datos incompletos";
        }

        try {
            Category category = new Category();
            category.setCode(Integer.parseInt(data[0].trim()));
            category.setDescription(data[1].trim());

            Block blo = new Block();
            blo.setId(Integer.parseInt(data[2].trim()));
            blo.setName(data[3].trim());
            blo.setState(data.length > 4 ? data[4].trim() : "1");
            category.setBlock(blo);

            if (new DBOCategory().update(category)) {
                response = "La categoría se ha actualizado correctamente";
            }
        } catch (NumberFormatException e) {
            return "Error: el código y el ID del bloque deben ser números.";
        } catch (Exception e) {
        }

        return response;
    }

    @Override
    public String delete(String id) {
        String response = "Error al eliminar la categoría";
        try {
            if (new DBOCategory().delete(Integer.parseInt(id.trim()))) {
                response = "Categoría eliminada correctamente";
            }
        } catch (NumberFormatException e) {
            return "Error: el ID debe ser un número.";
        } catch (Exception e) {
            return response;
        }
        return response;
    }

    @Override
    public String[][] list() {
        List<Category> categories = new DBOCategory().getAll();
        String[][] data = new String[categories.size()][5];
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            data[i][0] = String.valueOf(category.getCode());
            data[i][1] = category.getDescription();
            data[i][2] = String.valueOf(category.getBlock().getId());
            data[i][3] = category.getBlock().getName();

            String blockState = category.getBlock().getState().equals("1") ? "Activo" : "Inactivo";
            data[i][4] = blockState;
        }
        return data;
    }

}
