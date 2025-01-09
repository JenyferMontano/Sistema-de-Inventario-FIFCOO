package views.category;

import controllers.Block.BlockController;

import javax.swing.*;
import java.awt.*;

public class frmBlock extends JFrame {

    private JTextField txtBlockId, txtBlockName;
    private JComboBox<String> cmbBlockState;
    private JButton btnAdd, btnUpdate, btnFind;

    public frmBlock() {
        setTitle("Manejo de bloques");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Id bloque:"), gbc);
        txtBlockId = new JTextField(15);
        gbc.gridx = 1;
        add(txtBlockId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nombre bloque:"), gbc);
        txtBlockName = new JTextField(15);
        gbc.gridx = 1;
        add(txtBlockName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Estado bloque:"), gbc);
        cmbBlockState = new JComboBox<>(new String[]{"1 - Activo", "0 - Inactivo"});
        gbc.gridx = 1;
        add(cmbBlockState, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnAdd = new JButton("Agregar");
        btnUpdate = new JButton("Modificar");
        btnFind = new JButton("Buscar");

        Color buttonColor = new Color(129, 83, 255);
        Color textColor = Color.WHITE;

        btnAdd.setBackground(buttonColor);
        btnAdd.setForeground(textColor);
        btnUpdate.setBackground(buttonColor);
        btnUpdate.setForeground(textColor);
        btnFind.setBackground(buttonColor);
        btnFind.setForeground(textColor);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnFind);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);

        btnAdd.addActionListener(e -> addBlock());

        btnUpdate.addActionListener(e -> updateBlock());

        btnFind.addActionListener(e -> findBlock());

    }

    private void addBlock() {
        String[] data = new String[3];
        data[0] = txtBlockId.getText();
        data[1] = txtBlockName.getText();
        data[2] = cmbBlockState.getSelectedItem().toString().split(" ")[0];

        String response = new BlockController().add(data);
        JOptionPane.showMessageDialog(this, response);
    }

    private void updateBlock() {
        String[] data = new String[3];
        data[0] = txtBlockId.getText();
        data[1] = txtBlockName.getText();
        data[2] = cmbBlockState.getSelectedItem().toString().split(" ")[0];

        String response = new BlockController().update(data);
        JOptionPane.showMessageDialog(this, response);
    }

    private void findBlock() {
        String id = txtBlockId.getText().trim();
        String[] data = new BlockController().find(id);

        if (data != null && data.length == 3) {
            txtBlockId.setText(data[0]);
            txtBlockName.setText(data[1]);
            cmbBlockState.setSelectedItem(data[2] + " - " + (data[2].equals("1") ? "Activo" : "Inactivo"));
        } else {

            JOptionPane.showMessageDialog(this, "No se encontró el bloque");
        }
    }

}
