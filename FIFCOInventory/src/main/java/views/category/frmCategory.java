package views.category;

import controllers.Block.BlockController;
import controllers.Category.CategoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

import java.util.List;

public class frmCategory extends JFrame {

    private JTextField txtCode;
    private JTextField txtDescription;
    private JComboBox<String> cmbBlockId;
    private JTextField txtBlockName;
    private JComboBox<String> cmbBlockState;
    private JButton btnAdd, btnUpdate, btnDelete, btnFind, btnShowAll;

    public frmCategory() {
        setTitle("Manejo de Categoria");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Codigo:"), gbc);
        txtCode = new JTextField(15);
        gbc.gridx = 1;
        add(txtCode, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Descripcion:"), gbc);
        txtDescription = new JTextField(15);
        gbc.gridx = 1;
        add(txtDescription, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Id bloque:"), gbc);
        cmbBlockId = new JComboBox<>();
        loadBlockIds();
        gbc.gridx = 1;
        add(cmbBlockId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Nombre bloque:"), gbc);
        txtBlockName = new JTextField(15);
        txtBlockName.setEditable(false);
        gbc.gridx = 1;
        add(txtBlockName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Estado Bloque:"), gbc);
        cmbBlockState = new JComboBox<>(new String[]{"Activo", "Inactivo"});
        cmbBlockState.setEnabled(false);
        gbc.gridx = 1;
        add(cmbBlockState, gbc);

        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Agregar");
        btnUpdate = new JButton("Modificar");
        btnDelete = new JButton("Borrar");
        btnFind = new JButton("Buscar");
        btnShowAll = new JButton("Listar");
        JButton btnClearSpaces = new JButton("Limpiar Espacios");

        Color buttonColor = new Color(129, 83, 255);
        Color textColor = Color.WHITE;

        btnAdd.setBackground(buttonColor);
        btnAdd.setForeground(textColor);
        btnUpdate.setBackground(buttonColor);
        btnUpdate.setForeground(textColor);
        btnDelete.setBackground(buttonColor);
        btnDelete.setForeground(textColor);
        btnFind.setBackground(buttonColor);
        btnFind.setForeground(textColor);
        btnShowAll.setBackground(buttonColor);
        btnShowAll.setForeground(textColor);
        btnClearSpaces.setBackground(buttonColor);
        btnClearSpaces.setForeground(textColor);
        btnClearSpaces.setBackground(buttonColor);
        btnClearSpaces.setForeground(textColor);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnFind);
        buttonPanel.add(btnShowAll);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
        buttonPanel.add(btnClearSpaces);

        btnAdd.addActionListener(e -> addCategory());
        btnUpdate.addActionListener(e -> updateCategory());
        btnDelete.addActionListener(e -> deleteCategory());
        btnFind.addActionListener(e -> findCategory());
        btnShowAll.addActionListener(e -> showAllCategories());

        cmbBlockId.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                loadBlockData((String) e.getItem());
            }
        });

        btnClearSpaces.addActionListener(e -> clearSpaces());

        clearSpaces();
        setVisible(true);
    }

    private void loadBlockIds() {
        List<String> blockIds = new BlockController().getAllBlock();
        for (String id : blockIds) {
            cmbBlockId.addItem(id);
        }
    }

    private void loadBlockData(String blockId) {
        String[] blockData = new BlockController().find(blockId);
        if (blockData != null) {
            txtBlockName.setText(blockData[1]);
            cmbBlockState.setSelectedItem(blockData[2].equals("1") ? "Activo" : "Inactivo");
        } else {
            txtBlockName.setText("");
            cmbBlockState.setSelectedItem(null);
        }
    }

    private void addCategory() {
        String[] data = new String[4];
        data[0] = txtCode.getText();
        data[1] = txtDescription.getText();
        data[2] = (String) cmbBlockId.getSelectedItem();
        data[3] = (String) cmbBlockState.getSelectedItem();

        if (data[3].equals("Inactivo")) {
            JOptionPane.showMessageDialog(this, "No se puede agregar la categoría porque el bloque está inactivo.");
            return;
        }

        String response = new CategoryController().add(data);
        JOptionPane.showMessageDialog(this, response);
        clearSpaces();
    }

    private void updateCategory() {
        String[] data = new String[4];
        data[0] = txtCode.getText();
        data[1] = txtDescription.getText();
        data[2] = (String) cmbBlockId.getSelectedItem();
        data[3] = (String) cmbBlockState.getSelectedItem();

        if ("Inactivo".equals(data[3])) {
            JOptionPane.showMessageDialog(this, "No se puede modificar debido a que el bloque está inactivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String response = new CategoryController().update(data);
        JOptionPane.showMessageDialog(this, response);
        clearSpaces();
    }

    private void deleteCategory() {
        String id = txtCode.getText();
        String response = new CategoryController().delete(id);
        JOptionPane.showMessageDialog(this, response);
        clearSpaces();
    }

    private void findCategory() {
        String id = txtCode.getText();
        String[] data = new CategoryController().find(id);

        if (data != null) {
            if (data.length == 4) {
                txtDescription.setText(data[1]);
                cmbBlockId.setSelectedItem(data[2]);
                cmbBlockState.setSelectedItem(data[3].equals("1") ? "Activo" : "Inactivo");
            } else {
                JOptionPane.showMessageDialog(this, data[0]);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la categoría");
        }
    }

    private void showAllCategories() {
        String[][] data = new CategoryController().list();
        String[] columnNames = {"Codigo", "Descripcion", "Id bloque", "Nombre bloque", "Estado bloque"};

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JFrame frame = new JFrame("Todas las Categorías");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(scrollPane);
        frame.setVisible(true);
        clearSpaces();
    }

    private void clearSpaces() {
        txtCode.setText(null);
        txtDescription.setText(null);
        txtBlockName.setText(null);
        cmbBlockId.setSelectedItem(null);

    }
}
