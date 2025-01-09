package controllers.Block;

import java.util.List;

public interface BlockInterface {
        public String add(String[] data);
        public String[] find(String id);
        public String update(String[] data);
        public String delete(String id);
        public String[][] list();
        public List<String> getAllBlock();
}
