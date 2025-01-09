package views.category;

import javax.swing.*;
import java.awt.*;

public class MainMenuCategoria extends JInternalFrame {

    public MainMenuCategoria() {
        setTitle("Main Menu");
        setSize(500, 400);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Crear el título "Categorías y Bloques" centrado en la parte superior
        JLabel lblTitle = new JLabel("Categorías y Bloques");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.NORTH;
        add(lblTitle, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 1;

        gbc.anchor = GridBagConstraints.CENTER;

        JButton btnCategory = new JButton("Categorías");
        JButton btnBlock = new JButton("Bloques");

        btnCategory.addActionListener(e -> new frmCategory().setVisible(true));
        btnBlock.addActionListener(e -> new frmBlock().setVisible(true));

        JLabel lblSubTitle1 = new JLabel("Administración de Categorias");
        lblSubTitle1.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        add(lblSubTitle1, gbc);

        gbc.gridy = 2;
        add(btnCategory, gbc);

        JLabel lblSubTitle2 = new JLabel("Administración de Bloques");
        lblSubTitle2.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        add(lblSubTitle2, gbc);

        gbc.gridy = 4;
        add(btnBlock, gbc);

        // Color para los botones
        Color buttonColor = new Color(129, 83, 255);
        Color textColor = Color.WHITE;

        btnCategory.setBackground(buttonColor);
        btnCategory.setForeground(textColor);
        btnBlock.setBackground(buttonColor);
        btnBlock.setForeground(textColor);

        // Crear un botón de salir con una 'X'
        JButton btnExit = new JButton("X");
        btnExit.setPreferredSize(new Dimension(30, 27));
        btnExit.setBackground(new Color(255, 102, 102));
        btnExit.setForeground(Color.WHITE);
        btnExit.setBorder(BorderFactory.createEmptyBorder());
        btnExit.setFocusable(false);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(e -> setVisible(false));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(btnExit, gbc);

    }
}
