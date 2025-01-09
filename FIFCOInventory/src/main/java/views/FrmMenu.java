/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Image;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import views.category.MainMenuCategoria;
import views.department.FrmDepartment;
import views.managemen.FrmManagemen;
import views.product.FrmProduct;
import views.report.FrmReport;
import views.user.FrmAddUser;
import views.user.FrmAllUsers;
import views.user.FrmUsers;

/**
 *
 * @author jenif
 */
public class FrmMenu extends javax.swing.JFrame {

    FrmUsers users;
    FrmAllUsers newAllUsers;
    FrmAddUser newAddUser;
    FrmAbout newAbout;
    FrmProduct newProduct;
    FrmReport newReport;
    MainMenuCategoria newCategory;
    FrmDepartment newDepa;
    FrmManagemen newManage;
    

    public FrmMenu() throws SQLException {
        initComponents();
        users = new FrmUsers();
        this.desktopPane.add(users);
        newAllUsers = new FrmAllUsers();
        this.desktopPane.add(newAllUsers);
        newAddUser = new FrmAddUser();
        this.desktopPane.add(newAddUser);
        newAbout = new FrmAbout();
        this.desktopPane.add(newAbout);
        newProduct = new FrmProduct();
        this.desktopPane.add(newProduct);
        newReport = new FrmReport();
        this.desktopPane.add(newReport);
        newCategory = new MainMenuCategoria();
        this.desktopPane.add(newCategory);
        newDepa = new FrmDepartment();
        this.desktopPane.add(newDepa);
        newManage = new FrmManagemen();
        this.desktopPane.add(newManage);

        //Esto se anade porque si
        //Se agrega porque ocupamos que mientras se a grande o minimice la pantalla vaya cambianndo la imagen
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                resizeImage(lbIse); //Redimensiona la imagen como tal
            }
        });
        resizeImage(lbIse);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lbIse = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmUserMenu = new javax.swing.JMenu();
        itemUser = new javax.swing.JMenuItem();
        itemListUser = new javax.swing.JMenuItem();
        itemAddUser = new javax.swing.JMenuItem();
        jmProducts = new javax.swing.JMenu();
        itemProduct = new javax.swing.JMenuItem();
        itemReport = new javax.swing.JMenuItem();
        jmCategory = new javax.swing.JMenu();
        itemCategory = new javax.swing.JMenuItem();
        jmDeparment = new javax.swing.JMenu();
        itemManagement = new javax.swing.JMenuItem();
        itemDeparment = new javax.swing.JMenuItem();
        jmAboutUs = new javax.swing.JMenu();
        itemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setLayer(lbIse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIse, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIse, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        jmUserMenu.setText("Usuarios");
        jmUserMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        itemUser.setText("Administracion de Usuarios");
        itemUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUserActionPerformed(evt);
            }
        });
        jmUserMenu.add(itemUser);

        itemListUser.setText("Listado de Usuarios");
        itemListUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemListUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListUserActionPerformed(evt);
            }
        });
        jmUserMenu.add(itemListUser);

        itemAddUser.setText("Agregar Usuarios");
        itemAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddUserActionPerformed(evt);
            }
        });
        jmUserMenu.add(itemAddUser);

        jMenuBar1.add(jmUserMenu);

        jmProducts.setText("Productos");
        jmProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        itemProduct.setText("Administracion de Productos");
        itemProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductActionPerformed(evt);
            }
        });
        jmProducts.add(itemProduct);

        itemReport.setText("Reportes");
        itemReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReportActionPerformed(evt);
            }
        });
        jmProducts.add(itemReport);

        jMenuBar1.add(jmProducts);

        jmCategory.setText("Categoria");
        jmCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        itemCategory.setText("Administracion de Categorias");
        itemCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoryActionPerformed(evt);
            }
        });
        jmCategory.add(itemCategory);

        jMenuBar1.add(jmCategory);

        jmDeparment.setText("Departamento");
        jmDeparment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        itemManagement.setText("Administrador de Encargados");
        itemManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManagementActionPerformed(evt);
            }
        });
        jmDeparment.add(itemManagement);

        itemDeparment.setText("Administrador de Departamentos");
        itemDeparment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemDeparment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeparmentActionPerformed(evt);
            }
        });
        jmDeparment.add(itemDeparment);

        jMenuBar1.add(jmDeparment);

        jmAboutUs.setText("Acerca de");
        jmAboutUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        itemAbout.setText("Sobre Nosotros");
        itemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAboutActionPerformed(evt);
            }
        });
        jmAboutUs.add(itemAbout);

        jMenuBar1.add(jmAboutUs);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUserActionPerformed
        // TODO add your handling code here:
        users.setVisible(true);
    }//GEN-LAST:event_itemUserActionPerformed

    private void itemListUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListUserActionPerformed
        // TODO add your handling code here:
        newAllUsers.setVisible(true);
    }//GEN-LAST:event_itemListUserActionPerformed

    private void itemAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddUserActionPerformed
        // TODO add your handling code here:
        newAddUser.setVisible(true);
    }//GEN-LAST:event_itemAddUserActionPerformed

    private void itemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAboutActionPerformed
        // TODO add your handling code here:
        newAbout.setVisible(true);
    }//GEN-LAST:event_itemAboutActionPerformed

    private void itemCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoryActionPerformed
        // TODO add your handling code here:
        newCategory.setVisible(true);
    }//GEN-LAST:event_itemCategoryActionPerformed

    private void itemProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductActionPerformed
        // TODO add your handling code here:
        newProduct.setVisible(true);
    }//GEN-LAST:event_itemProductActionPerformed

    private void itemDeparmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeparmentActionPerformed
        // TODO add your handling code here:
        newDepa.setVisible(true);
    }//GEN-LAST:event_itemDeparmentActionPerformed

    private void itemManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManagementActionPerformed
        // TODO add your handling code here:
        newManage.setVisible(true);
    }//GEN-LAST:event_itemManagementActionPerformed

    private void itemReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReportActionPerformed
        // TODO add your handling code here:
        newReport.setVisible(true);
    }//GEN-LAST:event_itemReportActionPerformed

    private void resizeImage(JLabel labelName) {
        // Cargar la imagen original
        ImageIcon image = new ImageIcon(getClass().getResource("/fill-bg-login-desktop-Lanza.jpg"));
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemAbout;
    private javax.swing.JMenuItem itemAddUser;
    private javax.swing.JMenuItem itemCategory;
    private javax.swing.JMenuItem itemDeparment;
    private javax.swing.JMenuItem itemListUser;
    private javax.swing.JMenuItem itemManagement;
    private javax.swing.JMenuItem itemProduct;
    private javax.swing.JMenuItem itemReport;
    private javax.swing.JMenuItem itemUser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmAboutUs;
    private javax.swing.JMenu jmCategory;
    private javax.swing.JMenu jmDeparment;
    private javax.swing.JMenu jmProducts;
    private javax.swing.JMenu jmUserMenu;
    private javax.swing.JLabel lbIse;
    // End of variables declaration//GEN-END:variables
}
