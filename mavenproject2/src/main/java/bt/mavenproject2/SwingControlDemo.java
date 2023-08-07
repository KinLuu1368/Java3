/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package bt.mavenproject2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Kien Luu
 */
public class SwingControlDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
       
    public SwingControlDemo(){
        prepareGUI();
    }    
    
    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showCheckBoxDemo();
    }
   
    private void prepareGUI(){
        mainFrame = new JFrame("Vi du Java Swing");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        
        statusLabel.setSize(350, 100);
        
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    
    private void showCheckBoxDemo() {
        headerLabel.setText("Control in action: CheckBox");
        final JCheckBox chkApple = new JCheckBox("Apple");
        final JCheckBox chkMango = new JCheckBox("Mango");
        final JCheckBox chkPeer = new JCheckBox("Peer");
        
        chkApple.setMnemonic(KeyEvent.VK_A);
        chkMango.setMnemonic(KeyEvent.VK_M);
        chkPeer.setMnemonic(KeyEvent.VK_P);
        
        chkApple.addItemListener((ItemEvent e) -> {
            statusLabel.setText("Apple CheckBox: "
                    + (e.getStateChange()== 1 ? "checked" : "unchecked"));
        });
        
        chkMango.addItemListener((ItemEvent e) -> {
            statusLabel.setText("Mango CheckBox: "
                    + (e.getStateChange() == 1 ? "checked" : "unchecked"));
        });
        
        chkPeer.addItemListener((ItemEvent e) -> {
           statusLabel.setText("Peer CheckBox: "
                    + (e.getStateChange() == 1 ? "checked" : "unchecked"));
        });
        
        controlPanel.add(chkApple);
        controlPanel.add(chkPeer);
        controlPanel.add(chkMango);
        
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }
}
