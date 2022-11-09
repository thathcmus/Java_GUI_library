/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Library;

import com.sun.javafx.css.SizeUnits;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @pub thath
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public ReturnBook() {
        initComponents();
        Connect();
        Returnbook_Load();
    }
    public class LendItem
    {
        int id;
        String name;
        
        public LendItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        public String toString()
        {
            return name;
        }
    }
    public void Lend(String mid)
    {
        try {
            pst = con.prepareStatement("select l.lendbookID, b.bookName "
                        + "FROM lendbook l "                  
                        + "JOIN book b      ON b.bookID    = l.lendbookID "
                        + "where l.lendmemID = ?");
            pst.setString(1, mid);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                txtreBook.addItem(new LendItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/slibrary", "root", "");
        }catch (SQLException ex) {
                Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void Returnbook_Load()
    {
        int c;
        try {
            pst = con.prepareStatement("select * from returnbook");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)returnTable.getModel();
            
            
            d.setRowCount(0);
            
            while (rs.next()) 
            {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("memID"));
                    v2.add(rs.getString("MemName"));
                    v2.add(rs.getString("BookName"));
                    v2.add(rs.getString("ReturnDate"));    
                    v2.add(rs.getString("Elaps"));    
                    v2.add(rs.getString("Fine"));                    
                }
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
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

        txtbookPages = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        returnTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFine = new javax.swing.JLabel();
        txtrememName = new javax.swing.JLabel();
        txtrememID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtreBook = new javax.swing.JComboBox();
        btnCheck = new javax.swing.JButton();
        txtreDate = new javax.swing.JLabel();
        txtelapsDay = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtFine2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtbookPages.setBackground(new java.awt.Color(51, 0, 51));
        txtbookPages.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        returnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID thành viên", "Tên thành viên", "Sách", "Ngày trả sách", "Ngày quá hạn", "Phí"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(returnTable);

        txtbookPages.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 20, 630, 492));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 0));
        jLabel1.setText("THÔNG TIN TRẢ");
        txtbookPages.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 250, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 0));
        jLabel2.setText("Tên người mượn");
        txtbookPages.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 160, -1));

        btnExit.setText("Quay lại");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        txtbookPages.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 120, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 0));
        jLabel5.setText("Sách");
        txtbookPages.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 130, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 0));
        jLabel6.setText("Ngày trả");
        txtbookPages.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 0));
        jLabel7.setText("Ngày quá hạn");
        txtbookPages.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 0));
        jLabel8.setText("ID người mượn");
        txtbookPages.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, -1));

        txtFine.setForeground(new java.awt.Color(255, 255, 0));
        txtbookPages.add(txtFine, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 160, 20));

        txtrememName.setForeground(new java.awt.Color(102, 255, 0));
        txtbookPages.add(txtrememName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 160, 20));

        txtrememID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrememIDKeyPressed(evt);
            }
        });
        txtbookPages.add(txtrememID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 0));
        jLabel9.setText("Nhập phí quá hạn / ngày");
        txtbookPages.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 190, -1));

        txtreBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        txtbookPages.add(txtreBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 170, 30));

        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        txtbookPages.add(btnCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 30, 20));

        txtreDate.setForeground(new java.awt.Color(255, 255, 0));
        txtbookPages.add(txtreDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 160, 20));

        txtelapsDay.setForeground(new java.awt.Color(255, 255, 0));
        txtbookPages.add(txtelapsDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 160, 20));

        btnAdd.setText("Xác nhận trả");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        txtbookPages.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 120, 60));
        txtbookPages.add(txtFine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 130, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 0));
        jLabel10.setText("Phí");
        txtbookPages.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtbookPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtbookPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main m = new Main();
        m.setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtrememIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrememIDKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            {
                String memid = txtrememID.getText();
                try {
                pst = con.prepareStatement("select  m.memName, l.lendmemID "
                        + "FROM lendbook l "        
                        + "JOIN member m    ON m.memID = l.lendmemID "
                        + "JOIN book b      ON b.bookID    = l.lendbookID "
                        + "where l.lendmemID = ?");
                pst.setString(1, memid);
                txtreBook.removeAllItems();
                rs = pst.executeQuery();
                
                
                if(rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy ID mượn sách");
                }       
                else
                {
                    txtrememName.setText(rs.getString("m.memName"));
                    Lend(memid);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
  
        }
    }//GEN-LAST:event_txtrememIDKeyPressed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
        
    }//GEN-LAST:event_none

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        String mid = txtrememID.getText();
        txtFine2.setEditable(true);
        String fine2_ = txtFine2.getText();
        LendItem lItem = (LendItem) txtreBook.getSelectedItem();
        txtFine.setText("");
        try {
            pst = con.prepareStatement("select l.lendReturn, DATEDIFF(now(), l.lendReturn) as elap, DATEDIFF(l.lendReturn, l.lendDate) as day, b.bookPrice "
                    + "from lendbook l "
                    + "JOIN book b ON l.lendbookID = b.bookID "
                    + "where l.lendmemID = ? and l.lendbookID = ?");
            
            pst.setString(1, mid);
            pst.setInt(2, lItem.id);
            
            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            int c = rsd.getColumnCount();
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                for (int i = 1; i <= c; i++)
                {
                    txtreDate.setText(rs.getString("lendReturn"));
                    
                    int day = Integer.parseInt(rs.getString("day"));
                    int elap = Integer.parseInt(rs.getString("elap"));
                    
                    int fine2;
                    if(elap <= 0 )
                    {
                        elap = 0;
                        txtFine2.setText("0");
                        txtFine2.setEditable(false);
                        fine2 = 0;
                    }
                    else
                    {
                        fine2 = Integer.parseInt(String.valueOf(fine2_));
                    }
                    
                    txtelapsDay.setText(String.valueOf(elap));
                    int fine1 = Integer.parseInt(rs.getString("b.bookPrice"));
                    
                    fine1 = fine1*day + fine2*elap;
                    txtFine.setText(String.valueOf(fine1));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String mid = txtrememID.getText();
        String membername = txtrememName.getText();
        LendItem rItem = (LendItem)txtreBook.getSelectedItem();
        String returndate = txtreDate.getText();
        String elpdays = txtelapsDay.getText();
        String fine = txtFine.getText();
        try {
            pst = con.prepareStatement("insert into returnbook(memID, MemName, BookName, ReturnDate, Elaps, Fine)values(?,?,?,?,?,?)");
            pst.setString(1, mid);
            pst.setString(2, membername);
            pst.setInt(3, rItem.id);
            pst.setString(4, returndate);
            pst.setString(5, elpdays);
            pst.setString(6, fine);
              
            int k = pst.executeUpdate();
            
            pst = con.prepareStatement("delete from lendbook where lendmemID = ? and lendbookID = ?");
            
            pst.setString(1, mid);
            pst.setInt(2, rItem.id);
            pst.executeUpdate();
            
            if (k == 1)
            {
                pst = con.prepareStatement("update book set bookStock = bookStock + 1 where bookID = ?");
                pst.setInt(1, rItem.id);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Trả sách thành công");
                txtrememID.setText("");
                txtrememName.setText("");
                txtreBook.setSelectedItem(-1);
                txtFine.setText("");
                txtelapsDay.setText("");
                txtFine.setText("");
                Returnbook_Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable returnTable;
    private javax.swing.JLabel txtFine;
    private javax.swing.JTextField txtFine2;
    private javax.swing.JPanel txtbookPages;
    private javax.swing.JLabel txtelapsDay;
    private javax.swing.JComboBox txtreBook;
    private javax.swing.JLabel txtreDate;
    private javax.swing.JTextField txtrememID;
    private javax.swing.JLabel txtrememName;
    // End of variables declaration//GEN-END:variables
}
