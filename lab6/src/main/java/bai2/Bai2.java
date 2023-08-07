/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bai2;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Kien Luu
 */
public final class Bai2 extends javax.swing.JFrame {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=student_management;user=sa;password=Kientung789;encrypt=true;trustServerCertificate=true;";
    ArrayList<Student> list = new ArrayList<>();
    int currentIndex = -1;
    /**
     * Creates new form Bai2
     */
    public Bai2() {
        initComponents();
        FillInfomation();
        LoadToList();
        setLocationRelativeTo(null);
    }
     
    public void FillInfomation() {
        String[] data = {"Name", "Standard"};
        DefaultTableModel tbl = new DefaultTableModel(data, ABORT);
        tbl.setRowCount(0);
        tblThongTin.setModel(tbl);
        
        
        String[] fee = {"Fee 1", "Fee 2", "Fee 3"};
        DefaultComboBoxModel cb1 = new DefaultComboBoxModel(fee);
        cbbFee.setModel(cb1);
        
        String[] standard = {"Standard 1", "Standard 2", "Standard 3"};
        DefaultComboBoxModel cb = new DefaultComboBoxModel(standard);
        cbbStan.setModel(cb);  
        
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
    }
    
//Chức năng 
    //Clear nhập
    public void Clear() {
        txtContact.setText("");
        txtName.setText("");
        txtParentName.setText("");
        txtAddress.setText("");
        cbbFee.setSelectedIndex(0);
        cbbStan.setSelectedIndex(0);
        btnInsert.setEnabled(true);
        btnDelete.setEnabled(false);
    }
    public int ranNum() {
        int ranNum = 0;
        for (int i=0; i<5; i++) {
            Random rand = new Random();
            ranNum = rand.nextInt(100)+1;
        }
        return ranNum;
    }
    
    // Tự tạo ID
    public int getId() {
        LoadToList();
        boolean checkE = false;
        int ranNum = ranNum();
        for (Student sv : list) {
            if (sv.id == ranNum) {
                ranNum = ranNum();
                checkE = true;
            }
        }
        if (checkE == false) {
            return ranNum;
        } else {
            return getId();
        }
    }
    
    //Tự tạo ngày
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }
    
    //Tải danh sách lên bảng
    public void LoadToList() {
        // get date from database
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String sql = "select * from student";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                String parentName = rs.getString(4);
                String contact = rs.getString(5);
                String standard = rs.getString(6);
                String fee = rs.getString(7);
                String date = rs.getString(8);
                Student sv = new Student(id, name, address, parentName, contact, standard, fee, date);
                list.add(sv);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        try {
            if (!list.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) tblThongTin.getModel();
                model.setRowCount(0);
                for (Student sv : list) {
                    Object[] row = new Object[] {sv.name, sv.standard};
                    model.addRow(row);
                }
            } 
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    //Void hiện thông tin
    public void Display(int index) {
        Student sv = list.get(index);
        txtContact.setText(sv.phone);
        txtName.setText(sv.name);
        txtParentName.setText(sv.parentName);
        txtAddress.setText(sv.address);
        cbbFee.setSelectedItem(sv.fee);
        cbbStan.setSelectedItem(sv.standard);
    }
    
    //Lấy thông tin từ tbl khi click 
    public void showDetail() {
        int index = tblThongTin.getSelectedRow();
        currentIndex = index;
        Display(currentIndex);
        btnInsert.setEnabled(false);
        btnDelete.setEnabled(true);
        btnEdit.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtParentName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        cbbStan = new javax.swing.JComboBox<>();
        cbbFee = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTin);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Address:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("ParentName:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("ContactNo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Standard:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Fees:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        cbbStan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbFee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setLayout(new java.awt.GridLayout(2, 4));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext);

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2)
                            .addComponent(txtParentName)
                            .addComponent(cbbStan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbFee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtParentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbStan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbbFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        Clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String name;
        if (!txtName.getText().trim().equals("")) {
            name = txtName.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            txtName.requestFocus();
            return;
        }
        String address = txtAddress.getText();
        String parentName = txtParentName.getText();
        String contact = txtContact.getText();
        String fee = cbbFee.getSelectedItem().toString();
        String standard = cbbStan.getSelectedItem().toString();
        int id = getId();
        System.out.println(id);
        String date = getDate();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url)) {
                String sql = "insert into student values (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, address);
                ps.setString(4, parentName);
                ps.setString(5, contact);
                ps.setString(6, standard);
                ps.setString(7, fee);
                ps.setString(8, date);
                ps.execute();
                JOptionPane.showMessageDialog(this, "Thêm Thành công!");
            }
            LoadToList();
            btnInsert.setEnabled(false);
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinMouseClicked
        showDetail();
    }//GEN-LAST:event_tblThongTinMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String name = txtName.getText();
        String address = txtAddress.getText();
        String parentName = txtParentName.getText();
        String contact = txtContact.getText();
        String fee = cbbFee.getSelectedItem().toString();
        String standard = cbbStan.getSelectedItem().toString();
        int id = currentIndex + 1;
        System.out.println(id);
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String sql = "Update Student set name = ?, address = ?, parentName = ?, phone = ?, standard = ?, fee = ? where regid = ?" ;
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, parentName);
            ps.setString(4, contact);
            ps.setString(5, standard);
            ps.setString(6, fee);
            ps.setInt(7, id);
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        LoadToList();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (currentIndex < list.size()-1) {
            btnInsert.setEnabled(false);
            btnDelete.setEnabled(true);
            btnEdit.setEnabled(true);
            currentIndex ++;
            Display(currentIndex);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (currentIndex == 0) {
            btnInsert.setEnabled(false);
            btnDelete.setEnabled(true);
            btnEdit.setEnabled(true);
            Display(currentIndex);
        } else if (currentIndex > 0) {
            btnInsert.setEnabled(false);
            btnDelete.setEnabled(true);
            btnEdit.setEnabled(true);
            currentIndex--;
            Display(currentIndex);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblThongTin.getSelectedRow();
        if (index != -1) {
            currentIndex = index;
        } 
        Student sv = list.get(currentIndex);
        int id = sv.id;
        System.out.println(id);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String sql = "Delete from student where regid = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            currentIndex = -1;
            System.out.println(id);
            LoadToList();
            Clear();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Thoát?", "Cảnh báo",JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbFee;
    private javax.swing.JComboBox<String> cbbStan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtParentName;
    // End of variables declaration//GEN-END:variables
}
