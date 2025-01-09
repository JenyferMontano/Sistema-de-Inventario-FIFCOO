package views.product;

import controllers.product.ProductController;
import controllers.product.ProductInterface;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FrmProduct extends JInternalFrame {

    private JButton btnFind, btnAdd, btnUpdate, btnDelete, btnUpload, btnClear, btnExit;
    private JLabel lblCode, lblCategory, lblDescription, lblCurrentExist, lblMin, lblMax, lblImage, lblImageDisplay;
    private JTextField txtCode, txtCategory, txtDescription, txtCurrentExist, txtMin, txtMax, txtImage;
    private ProductInterface service;

    public FrmProduct() {
        init();
        service = new ProductController();

    }

    private void init() {
        setTitle("Gestión de Productos");
        setSize(900, 600);  // Aumentamos el ancho de la ventana

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Crear un gradiente celeste a blanco
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(213, 213, 246, 200), 0, getHeight(), new Color(255, 255, 255, 20));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblCode = new JLabel("Código:");
        txtCode = new JTextField(15);

        lblCategory = new JLabel("Descripción:");
        txtCategory = new JTextField(15);

        lblDescription = new JLabel("ID Categoría:");
        txtDescription = new JTextField(15);

        lblCurrentExist = new JLabel("Existencia Actual:");
        txtCurrentExist = new JTextField(15);

        lblMin = new JLabel("Stock Mínimo:");
        txtMin = new JTextField(15);

        lblMax = new JLabel("Stock Máximo:");
        txtMax = new JTextField(15);

        lblImage = new JLabel("Imagen:");
        txtImage = new JTextField(15);

        //Tamanio de la imagen
        lblImageDisplay = new JLabel();
        lblImageDisplay.setPreferredSize(new Dimension(300, 300));

        // Crear botones y establecer el color
        btnUpload = new JButton("Cargar Imagen");
        btnUpload.setPreferredSize(new Dimension(120, 30));
        btnFind = new JButton("Buscar");
        btnFind.setPreferredSize(new Dimension(120, 30));
        btnAdd = new JButton("Guardar");
        btnAdd.setPreferredSize(new Dimension(120, 30));
        btnUpdate = new JButton("Actualizar");
        btnUpdate.setPreferredSize(new Dimension(120, 30));
        btnClear = new JButton("Vaciar");
        btnClear.setPreferredSize(new Dimension(120, 30));
        btnDelete = new JButton("Eliminar");
        btnDelete.setPreferredSize(new Dimension(120, 30));
        btnExit = new JButton("Regresar"); 
        btnExit.setPreferredSize(new Dimension(120, 3));
        btnExit.setBorder(BorderFactory.createEmptyBorder());
        btnExit.setFocusable(false);

        // Establecer color celeste
        Color moradoChillon = new Color(134, 21, 255);
        btnUpload.setBackground(moradoChillon);
        btnFind.setBackground(moradoChillon);
        btnAdd.setBackground(moradoChillon);
        btnUpdate.setBackground(moradoChillon);
        btnClear.setBackground(moradoChillon);
        btnDelete.setBackground(moradoChillon);
        btnExit.setBackground(moradoChillon);

        btnUpload.setForeground(Color.WHITE);
        btnFind.setForeground(Color.WHITE);
        btnAdd.setForeground(Color.WHITE);
        btnUpdate.setForeground(Color.WHITE);
        btnClear.setForeground(Color.WHITE);
        btnDelete.setForeground(Color.WHITE);
        btnExit.setForeground(Color.WHITE);

        btnUpload.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFind.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblCode, gbc);
        gbc.gridx = 1;
        panel.add(txtCode, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblCategory, gbc);
        gbc.gridx = 1;
        panel.add(txtCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblDescription, gbc);
        gbc.gridx = 1;
        panel.add(txtDescription, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblCurrentExist, gbc);
        gbc.gridx = 1;
        panel.add(txtCurrentExist, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblMin, gbc);
        gbc.gridx = 1;
        panel.add(txtMin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblMax, gbc);
        gbc.gridx = 1;
        panel.add(txtMax, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(lblImage, gbc);
        gbc.gridx = 1;
        panel.add(txtImage, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(btnUpload, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(lblImageDisplay, gbc);

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Usar FlowLayout para botones en línea
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnFind);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        // Añadir el panel de botones al panel principal
        gbc.gridx = 0;
        gbc.gridy = 8; // La fila de los botones
        gbc.gridwidth = 3; // Hacer que el panel de botones ocupe varias columnas
        panel.add(buttonPanel, gbc);

        // Añadir el botón "Regresar" en la parte superior derecha
        gbc.gridx = 10; // Coloca en la columna derecha
        gbc.gridy = -10; // Fila superior
        gbc.gridwidth = 0; // Ocupa una columna
        panel.add(btnExit, gbc);
        add(panel);

        // Action Listeners
        btnUpload.addActionListener(this::uploadAction);
        btnFind.addActionListener(evt -> findAction());
        btnAdd.addActionListener(evt -> addAction());
        btnUpdate.addActionListener(evt -> updateAction());
        btnDelete.addActionListener(evt -> deleteAction());
        btnClear.addActionListener(evt -> clearFields());
        btnExit.addActionListener(evt -> setVisible(false));
    }

    private void uploadAction(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            this.txtImage.setText(file.getAbsolutePath());
            Image image = Toolkit.getDefaultToolkit().getImage(this.txtImage.getText());
            image = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // Aumentar el tamaño de la imagen
            lblImageDisplay.setIcon(new ImageIcon(image));
            try (InputStream data = new FileInputStream(file)) {
                service.upload(data.readAllBytes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void findAction() {
        String code = txtCode.getText();
        String[] data = service.find(code);

        if (data != null) {
            txtCategory.setText(data[1]);
            txtDescription.setText(data[2]);
            txtCurrentExist.setText(data[3]);
            txtMin.setText(data[4]);
            txtMax.setText(data[5]);
            txtImage.setText(data[6]);

            String fullPath = data[6];

            System.out.println("Ruta de la imagen: " + fullPath);  // Verifica la ruta completa.

            File imgFile = new File(fullPath);
            if (imgFile.exists()) {
                try {
                    BufferedImage image = ImageIO.read(imgFile);
                    if (image != null) {
                        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                        lblImageDisplay.setIcon(new ImageIcon(scaledImage));
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen.");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "El archivo de imagen no existe en la ruta proporcionada.");
            }

        }
    }

    private void addAction() {
        String[] data = {txtCode.getText(),
            txtCategory.getText(), txtDescription.getText(),
            txtCurrentExist.getText(), txtMin.getText(),
            txtMax.getText(), txtImage.getText()};
        String response = service.add(data);
        JOptionPane.showMessageDialog(this, response);
        clearFields();

    }

    private void updateAction() {
        String[] data = {
            txtCode.getText(),
            txtCategory.getText(),
            txtDescription.getText(),
            txtCurrentExist.getText(),
            txtMin.getText(),
            txtMax.getText(),
            txtImage.getText()
        };
        String response = service.update(data);
        JOptionPane.showMessageDialog(this, response);
        clearFields();
    }

    private void deleteAction() {
        String code = txtCode.getText();
        String[] data = service.find(code); // Busca el producto

        if (data != null) {
            // Muestra la información del producto
            String productInfo = String.format("Código: %s\nDescripción: %s\nID Categoría: %s\nExistencia Actual: %s\nStock Mínimo: %s\nStock Máximo: %s\nImagen: %s",
                    data[0], data[1], data[2], data[3], data[4], data[5], data[6]);

            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar el siguiente producto?\n\n" + productInfo, "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String response = service.delete(code);
                JOptionPane.showMessageDialog(this, response);
                clearFields(); // Limpia los campos después de eliminar
            }
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
        }
    }


    private void clearFields() {
        txtCode.setText("");
        txtCategory.setText("");
        txtDescription.setText("");
        txtCurrentExist.setText("");
        txtMin.setText("");
        txtMax.setText("");
        txtImage.setText("");
        lblImageDisplay.setIcon(null);
        txtCode.setEnabled(true);
    }

}
