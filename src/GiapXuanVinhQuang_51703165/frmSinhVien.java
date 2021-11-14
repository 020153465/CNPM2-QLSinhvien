/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiapXuanVinhQuang_51703165;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Saito8546
 */
public class frmSinhVien extends javax.swing.JFrame {

    private static StudentDAO dao;
    /**
     * Creates new form MainFrame
     */
    public frmSinhVien() {
        initComponents();
        initConnection();
        initData();
    }

    private void initConnection(){
        String errMsg = "";
        Connection con = null;
        try {
            // Register Driver //
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Create new connection //
            String connectionURL
                = "jdbc:sqlserver://localhost;"
                + "databaseName=QLSinhvien;"
                + "username=admin;"
                + "password=123;"
                //+ "encrypt=false;"
                + "loginTimeout=5";
            con = (Connection) DriverManager.getConnection(connectionURL);
            dao = new StudentDAO(con);
            // Check connection //
            errMsg += "Kết nối đến cơ sở dữ liệu thành công !\n" + con;
        } // Driver excpetion //
        catch (ClassNotFoundException e1) {
            errMsg += "Không thể load Driver JDBC !\n" + e1;
        } catch (SQLException e2) {
            errMsg +=  "Lỗi kết nối đến cơ sở dữ liệu !\n" + e2;
        }
        messageDialog("Thông báo", errMsg);
        if (con == null){
            System.exit(-1);
        }
    }
    
    private void initData(){
        resetRow();
        try{
            List<Student> stdList = dao.getAll();
            stdList.forEach(std -> {
                String id = std.getId();
                String name = std.getName();
                int bYear = std.getBirthYear();
                addRow(id, name, bYear);
            });
            
        }catch(SQLException e){
            messageDialog("Thông báo", "Lỗi truy cập dữ liệu getAll() !\n" + e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextYear = new javax.swing.JTextField();
        jBtnAdd = new javax.swing.JButton();
        jBtnDel = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnSave = new javax.swing.JButton();
        jBtnNoSave = new javax.swing.JButton();
        jBtnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sinh viên");
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH SINH VIÊN");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Mã SV:");

        jTextId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextId.setToolTipText("Nhập mã sinh viên");
        jTextId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextIdFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        jTextName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextName.setToolTipText("Nhập họ và tên của sinh viên");
        jTextName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextNameFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Năm sinh:");

        jTextYear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextYear.setToolTipText("Nhập số năm sinh");
        jTextYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextYearFocusLost(evt);
            }
        });

        jBtnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnAdd.setText("Thêm");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnDel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnDel.setText("Xóa");
        jBtnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDelActionPerformed(evt);
            }
        });

        jBtnEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnEdit.setText("Sửa");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnSave.setText("Lưu");
        jBtnSave.setToolTipText("");

        jBtnNoSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnNoSave.setText("K. Lưu");
        jBtnNoSave.setToolTipText("");

        jBtnExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnExit.setText("Thoát");
        jBtnExit.setToolTipText("");
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("<html> \nĐược làm bởi: <br/>\nGiáp Xuân Vinh Quang <br/>\n51703165\n</html>");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jTextName)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnDel)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSave)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnNoSave)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExit)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnDel)
                    .addComponent(jBtnEdit)
                    .addComponent(jBtnSave)
                    .addComponent(jBtnNoSave)
                    .addComponent(jBtnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SV", "Họ và tên", "Năm sinh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setGridColor(new java.awt.Color(102, 102, 102));
        jTable.setRowHeight(30);
        jTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable.setShowGrid(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void messageDialog(String title, String msg){
        java.awt.Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);           
    }
    
    private void jTextIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextIdFocusLost
        if (jTextId.getText().length() != 6 && jTextId.getText().length() != 0){
            messageDialog("Lưu ý", "Mã sinh viên phải có đủ 6 ký tự !");       
        }
    }//GEN-LAST:event_jTextIdFocusLost

    private void jTextYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextYearFocusLost
        String text = jTextYear.getText();
        if (text.length() == 0)
            return;
        try {
            int year = Integer.parseInt(text);
            if (year >= 0)
                return;
        }catch(NumberFormatException e){                   
        }
        messageDialog("Lưu ý", "Năm sinh của sinh viên phải là một số nguyên dương, không vượt quá " + Integer.MAX_VALUE);    
    }//GEN-LAST:event_jTextYearFocusLost

    private void jTextNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextNameFocusLost
        String text = jTextName.getText();        
        if (text.length() > 40)
        {
            messageDialog("Lưu ý", "Họ và tên không được vượt quá 40 ký tự !");     
        }
    }//GEN-LAST:event_jTextNameFocusLost

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        if (validateNewData()){
            try{
                String id = jTextId.getText();
                String name = jTextName.getText();
                int bYear = Integer.parseInt(jTextYear.getText());
                Student std = new Student(id, name, bYear);
                
                dao.add(std);
                addRow(id, name, bYear);
            }catch(SQLException e){
                messageDialog("Thông báo lỗi", "Không thể add sinh viên mới !\n" + e);
            }
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDelActionPerformed
        String id = jTextId.getText();
        String errMsg = "Không thể xóa sinh viên " + id + " !\n";
        if (id.length() == 6){
            try{                
                dao.delete(id);
                int index = findRow(id);
                removeRow(index);
                return;
            }catch(SQLException e){
                errMsg += e;
            }
        }
        messageDialog("Thông báo lỗi", errMsg);
    }//GEN-LAST:event_jBtnDelActionPerformed

    private void jBtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExitActionPerformed
        try {
            dao.con.close();
            dao.rs.close();
            dao.stmt.close();
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);           
        }
    }//GEN-LAST:event_jBtnExitActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        String id = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
        String name = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
        String bYear = jTable.getValueAt(jTable.getSelectedRow(), 2).toString();
        
        jTextId.setText(id);
        jTextName.setText(name);
        jTextYear.setText(bYear);
    }//GEN-LAST:event_jTableMouseClicked

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        if (validateNewData()){
            String id = jTextId.getText();
            String name = jTextName.getText();
            int bYear = Integer.parseInt(jTextYear.getText());
            try{
                Student std = dao.get(id);
                if (std == null){
                    throw new SQLException("Không thể tìm sinh vien có ID " + id);
                }
                dao.update(std);
                editRow(id, name, bYear);
            }catch(SQLException e){
                messageDialog("Thông báo lỗi", "Không thể cập nhật sinh viên " + id + " !\n" + e);
            }
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void addRow(String str1, String str2, int str3){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.addRow(new Object[]{str1, str2, str3});
    }
    
    private void removeRow(int index){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.removeRow(index);
    }
    
    private int findRow(String id){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++){           
            if (id.equals(model.getValueAt(i, 0))){
                return i;
            }
        }
        return -1;
    }
    
    private void editRow(String id, String name, int bYear){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int index = findRow(id);
        model.setValueAt(name, index, 1);
        model.setValueAt(bYear, index, 2);
    }
    
    private void resetRow(){
        int nRow = jTable.getRowCount();
        for (int i = 0; i < nRow; i++){
            try{
                removeRow(0);
            }catch(java.lang.IndexOutOfBoundsException e){
                break;
            }
        }
    }
    
    private boolean validateNewData(){
        String errMsg = "";
        String id = jTextId.getText();
        String name = jTextName.getText();
        String bYear = jTextYear.getText();
        
        if (id.length() != 6)
            errMsg += "Mã sinh viên phải đủ 6 ký tự !\n";
        if (name.length() == 0 || name.length() > 40)
            errMsg += "Họ và tên sinh viên bị trống hoặc quá 40 ký tự !\n";
        if (bYear.length() == 0)
            errMsg += "Năm sinh của sinh viên bị trống !\n";
        try{
            if (Integer.parseInt(bYear) < 0)
                throw new Exception("Năm sinh đang là số âm !");
        }catch(Exception e){
            errMsg += "Năm sinh của sinh viên không phải là một số nguyên dương !\n" + e;
        }
        
        if (errMsg.length() != 0){
            messageDialog("Thông báo lỗi", errMsg);
            return false;
        }
        return true;
    }
    
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
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDel;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnNoSave;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextYear;
    // End of variables declaration//GEN-END:variables
}