/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author jenif
 */
public class CustomInternalJFrame extends JInternalFrame {

    private int xOffset, yOffset;

    public CustomInternalJFrame() {
    }

    // Método para configurar la opacidad del JInternalFrame
    public void setOpacity(JInternalFrame internalFrame, int opacity) {
        internalFrame.setOpaque(false);
        internalFrame.getContentPane().setBackground(new Color(255, 255, 255, opacity));

    }

    public void setEliminatedBorder(JInternalFrame internalFrame) {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) internalFrame.getUI();
        ui.setNorthPane(null);
    }

    // Método para habilitar el movimiento manual del JInternalFrame
    public void enableDrag(JInternalFrame internalFrame) {
        internalFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOffset = e.getX();
                yOffset = e.getY();
            }
        });

        internalFrame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                internalFrame.setLocation(e.getXOnScreen() - xOffset, e.getYOnScreen() - yOffset);
            }
        });
    }

}
