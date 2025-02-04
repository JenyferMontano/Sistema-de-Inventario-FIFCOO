/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views.user;

import controllers.user.UserController;
import controllers.user.UserInterface;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import utils.Clean;
import utils.CustomInternalJFrame;
import utils.Validator;

/**
 *
 * @author jenif
 */
public class FrmUsers extends javax.swing.JInternalFrame {

    private UserInterface service;
    CustomInternalJFrame customizer;

    public FrmUsers() throws SQLException {
        initComponents();
        service = new UserController();
        customizer = new CustomInternalJFrame();
        customizer.setOpacity(this, 180);
        customizer.setEliminatedBorder(this);
        customizer.enableDrag(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnClean = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Direccion:");

        txtEmail.setToolTipText("Direccion");

        txtUsername.setToolTipText("Digite el Usuario");

        jLabel4.setText("Identificacion:");

        txtLocation.setToolTipText("Especialidad del Doctor/Profesion");

        btnDelete.setBackground(new java.awt.Color(51, 51, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre:");

        btnClean.setBackground(new java.awt.Color(204, 0, 255));
        btnClean.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClean.setForeground(new java.awt.Color(255, 255, 255));
        btnClean.setText("Vaciar");
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnFind.setBackground(new java.awt.Color(255, 0, 102));
        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setText("Buscar");
        btnFind.setToolTipText("Buscar");
        btnFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnModify.setBackground(new java.awt.Color(204, 0, 51));
        btnModify.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModify.setForeground(new java.awt.Color(255, 255, 255));
        btnModify.setText("Modificar");
        btnModify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        txtId.setToolTipText("Apellidos");

        jLabel6.setText("Apellidos:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestion de  Usuarios");

        btnClose.setBackground(new java.awt.Color(205, 23, 25));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("X");
        btnClose.setToolTipText("Cerrar/Salir");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtName.setToolTipText("Télefono");

        jLabel7.setText("Correo:");

        jLabel2.setText("Username:");

        txtPhone.setToolTipText("Fecha con el siguiente formato dd-MM-yyyy");

        txtLastName.setToolTipText("Correo");

        jLabel8.setText("Telefono:");

        jLabel3.setText("Contraseña:");

        txtBirthDate.setToolTipText("Especialidad del Doctor/Profesion");

        jLabel10.setText("Fecha de Nacimiento:");

        txtPassword.setToolTipText("La contraseña debe tener como minimo 8 caracteres dentro de ellos minuculas, mayusculas, numeros, caracteres especiales (¿?+*!¡#$%&/)\n");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(btnDelete))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone)
                                    .addComponent(txtEmail)
                                    .addComponent(txtLastName)
                                    .addComponent(txtId)
                                    .addComponent(txtName)
                                    .addComponent(txtLocation)
                                    .addComponent(txtBirthDate)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModify)
                                .addGap(95, 95, 95)
                                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFind)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnModify)
                    .addComponent(btnClean))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            if (!txtId.getText().isEmpty()) {
                String id = txtId.getText();
                String elimanted = service.delete(id);
                JOptionPane.showMessageDialog(this, elimanted);
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar el ID para eliminar!!!", "Error", 2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage(), "Error", 2);
        }
        Clean.clearSpaces(txtUsername, txtPassword, txtId, txtName, txtLastName,
                txtPhone, txtEmail, txtLocation, txtBirthDate);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        // TODO add your handling code here:
        Clean.clearSpaces(txtUsername, txtPassword, txtId, txtName, txtLastName,
                txtPhone, txtEmail, txtLocation, txtBirthDate);

    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        try {
            if (!txtUsername.getText().isEmpty()) {
                String username = txtUsername.getText();
                String[] data = service.findByUsername(username);
                if (data != null && data.length > 0) {
                    setData(data);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró registro", "Error", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar  un nombre de usuario para buscar", "Error", 2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage(), "Error", 2);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        try {
            if (verify()) {
                try {
                    if (!Validator.getInstance().isEmailValid(txtEmail.getText())) {
                        showEmailError();
                        return;
                    }

                    if (!Validator.getInstance().isPasswordValid(txtPassword.getText())) {
                        showPasswordError();
                        return;
                    }
                    // Convierte la fecha de nacimiento a LocalDate
                    LocalDate birthDate = LocalDate.parse(txtBirthDate.getText());
                    String[] updatedData = {
                        txtUsername.getText(),
                        txtPassword.getText(),
                        txtId.getText(),
                        txtName.getText(),
                        txtLastName.getText(),
                        txtEmail.getText(),
                        txtPhone.getText(),
                        txtLocation.getText(),
                        birthDate.toString(),};

                    String updateResponse = service.update(updatedData);

                    JOptionPane.showMessageDialog(this, updateResponse);

                    if (updateResponse.equals("Actualizado exitosamente!!!")) {
                        Clean.clearSpaces(txtUsername, txtPassword, txtId, txtName, txtLastName,
                                txtPhone, txtEmail, txtLocation, txtBirthDate);
                    }
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use el formato yyyy-MM-dd, por favor!!!.", "Error", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos!!!", "Error", 2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar!!!: " + e.getMessage(), "Error", 2);
        }

    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void setData(String[] data) {
        this.txtUsername.setText(data[0]);
        this.txtPassword.setText(data[1]);
        this.txtId.setText(data[2]);
        this.txtName.setText(data[3]);
        this.txtLastName.setText(data[4]);
        this.txtEmail.setText(data[5]);
        this.txtPhone.setText(data[6]);
        this.txtLocation.setText(data[7]);
        LocalDate birthdate = LocalDate.parse(data[8]);
        this.txtBirthDate.setText(birthdate.toString());

    }

    private boolean verify() {
        if (!txtUsername.getText().equals("") && !txtPassword.getText().equals("")
                && !txtId.getText().equals("") && !txtName.getText().equals("")
                && !txtLastName.getText().equals("") && !txtPhone.getText().equals("")
                && !txtEmail.getText().equals("") && !txtBirthDate.getText().equals("")) {
            return true;
        }
        return false;
    }

    private void showEmailError() {
        JOptionPane.showMessageDialog(this, "El correo electrónico no es válido."
                + "Debe de seguir el siguiente formato: "
                + "nombredeusuario@example.com", "Error de validación", 1);
    }

    private void showPasswordError() {
        JOptionPane.showMessageDialog(this, "La contraseña no es válida. Debe contener mayúsculas,"
                + " minúsculas, números y caracteres especiales. "
                + "Minimo 8 caracteres y Maximo 32", "Error de validación", 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
