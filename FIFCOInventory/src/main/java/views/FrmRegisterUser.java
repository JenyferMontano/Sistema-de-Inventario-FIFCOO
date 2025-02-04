package views;

import controllers.user.UserController;
import controllers.user.UserInterface;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.*;

import utils.Validator;

/**
 *
 * @author jenif
 */
public class FrmRegisterUser extends javax.swing.JFrame {

    private UserInterface service;
    FrmUserLogin loginForm;

    public FrmRegisterUser() throws SQLException {
        service = new UserController();
        loginForm = new FrmUserLogin();
        initComponents();
        // Validación de email
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Validator.getInstance().isEmailValid(txtEmail.getText())) {
                    txtEmail.setBorder(txtName.getBorder());
                } else {
                    txtEmail.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });

        // Validación de contraseña
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Validator.getInstance().isPasswordValid(new String(txtPassword.getPassword()))) {
                    txtPassword.setBorder(txtLastName.getBorder());
                } else {
                    txtPassword.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPhone = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnReturn = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        lbLastName = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lbBirthdate = new javax.swing.JLabel();
        lbLocation = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtLocation = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(213, 213, 246));

        txtPhone.setToolTipText("Ingresar numero de telefono");

        txtPassword.setToolTipText("Ingresar Contraseña(Ejemplo: Mm12#$%&, ademas caracteres especiales aceptados: ¿?+*!¡#$%&/)");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(52, 11, 128));
        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setText("Regresar");
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        txtId.setToolTipText("Ingresar Cedula ");

        lbId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbId.setForeground(new java.awt.Color(30, 30, 30));
        lbId.setText("Identificacion :");

        lbLastName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbLastName.setForeground(new java.awt.Color(30, 30, 30));
        lbLastName.setText("Apellidos:");

        txtBirthDate.setToolTipText("Fecha de nacimiento(yyyy-MM-dd)");

        txtEmail.setToolTipText("Ingresar correo(Ejemplo: example@example.com)");

        lbBirthdate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbBirthdate.setForeground(new java.awt.Color(30, 30, 30));
        lbBirthdate.setText("Fecha de Nacimiento:");

        lbLocation.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbLocation.setForeground(new java.awt.Color(30, 30, 30));
        lbLocation.setText("Direccion:");

        lbEmail.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(30, 30, 30));
        lbEmail.setText("Correo:");

        lbPassword.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(30, 30, 30));
        lbPassword.setText("Contraseña:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Registro de Usuario");

        lbUsername.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(30, 30, 30));
        lbUsername.setText("Nombre de Usuario:");

        btnAdd.setBackground(new java.awt.Color(52, 11, 128));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Guardar");
        btnAdd.setToolTipText("Guardar usuario");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(52, 11, 128));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("X");
        btnClose.setToolTipText("Cerrar");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtLocation.setToolTipText("Ingresar cuidad o barrio de residencia");

        txtLastName.setToolTipText("Ingresar apellidos");

        txtName.setToolTipText("Ingresar nombre");

        txtUsername.setToolTipText("Ingresar nombre de Usuario");

        lbPhone.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbPhone.setForeground(new java.awt.Color(30, 30, 30));
        lbPhone.setText("Telefono:");

        lbName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(30, 30, 30));
        lbName.setText("Nombre:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fill p (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnReturn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151)
                        .addComponent(btnClose)))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(lbUsername))
                        .addComponent(lbPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbBirthdate)
                            .addComponent(lbName)
                            .addComponent(lbId)
                            .addComponent(lbLastName)
                            .addComponent(lbEmail)
                            .addComponent(lbPhone)
                            .addComponent(lbLocation))))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPassword)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPassword))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLastName))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBirthdate))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReturn)
                            .addComponent(btnAdd))
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here: 
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

                String data[] = new String[9];
                data[0] = txtUsername.getText();
                data[1] = txtPassword.getText();
                data[2] = txtId.getText();
                data[3] = txtName.getText();
                data[4] = txtLastName.getText();
                data[5] = txtEmail.getText();
                data[6] = txtPhone.getText();
                data[7] = txtLocation.getText();
                LocalDate birthdate = LocalDate.parse(txtBirthDate.getText());
                data[8] = birthdate.toString();

                String msj = service.add(data);
                JOptionPane.showMessageDialog(this, msj);

                //Si el registro fue exitoso, redirigir al login
                if (msj.equals("Usuario guardado correctamente!")) {
                    loginForm.setVisible(true);
                    this.dispose();
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Por favor, use yyyy-MM-dd.", "Error", 2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al agregar el usuario: " + e.getMessage(), "Error", 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos!!!", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

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
                + " minúsculas, números y caracteres especiales(¿?+*!¡#$%&/). "
                + "Minimo 8 caracteres y Maximo 32", "Error de validación", 1);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBirthdate;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbLastName;
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbUsername;
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
