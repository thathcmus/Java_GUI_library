/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @pub thath
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        Book_Load();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public class CategoryItem
    {
        int id;
        String name;
        
        public CategoryItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        public String toString()
        {
            return name;
        }
    }
    public void Category()
    {
        try {
            pst = con.prepareStatement("select * from category");
            rs = pst.executeQuery();
            txtbookCat.removeAllItems();
            
            while(rs.next())
            {
                txtbookCat.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public class AuthorItem
    {
        int id;
        String name;
        
        public AuthorItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        public String toString()
        {
            return name;
        }
    }
    public class PublisherItem
    {
        int id;
        String name;
        
        public PublisherItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        public String toString()
        {
            return name;
        }
    }
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/slibrary", "root", "");
        }catch (SQLException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    public void Author()
    {
        try {
            pst = con.prepareStatement("select * from author");
            rs = pst.executeQuery();
            txtbookAuthor.removeAllItems();
            
            while(rs.next())
            {
                txtbookAuthor.addItem(new AuthorItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Publisher()
    {
        try {
            pst = con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();
            txtbookPublisher.removeAllItems();
            
            while(rs.next())
            {
                txtbookPublisher.addItem(new PublisherItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Book_Load()
    {
        int c;
        try {
            pst = con.prepareStatement("select b.bookID, b.bookName, c.catName, a.authorName, p.pubName, b.bookContents, b.bookNoPages, b.bookEdition, b.bookStock, b.bookPrice "
                    + "from book b "
                    + "JOIN category c  ON b.bookCat        = c.catID "
                    + "JOIN author a    ON b.bookAuthor     = a.authorID "
                    + "JOIN publisher p ON b.bookPublisher  = p.pubID");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)bookTable.getModel();
            
            
            d.setRowCount(0);
            
            while (rs.next()) 
            {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("b.bookID"));
                    v2.add(rs.getString("b.bookName"));
                    v2.add(rs.getString("c.catName"));
                    v2.add(rs.getString("a.authorName"));
                    v2.add(rs.getString("p.pubName"));
                    v2.add(rs.getString("b.bookContents"));
                    v2.add(rs.getString("b.bookNoPages"));
                    v2.add(rs.getString("b.bookEdition"));
                    v2.add(rs.getString("b.bookStock"));
                    v2.add(rs.getString("b.bookPrice"));
                    
                }
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        bookTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtbookNoPages = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtbookEdition = new javax.swing.JTextField();
        txtbookPublisher = new javax.swing.JComboBox();
        txtbookCat = new javax.swing.JComboBox();
        txtbookAuthor = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtbookName = new javax.swing.JTextField();
        txtbookContents = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtbookPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtbookStock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtbookPages.setBackground(new java.awt.Color(51, 0, 51));
        txtbookPages.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sách", "Danh mục", "Tác giả", "Nhà xuất bản", "Nội dung", "Số trang", "Phiên bản", "Còn lại", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookTable);

        txtbookPages.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 20, 630, 492));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 0));
        jLabel1.setText("KHO SÁCH");
        txtbookPages.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 0));
        jLabel2.setText("Danh mục");
        txtbookPages.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 160, -1));

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        txtbookPages.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 120, 60));

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        txtbookPages.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 120, 60));

        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        txtbookPages.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 120, 60));

        btnExit.setText("Quay lại");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        txtbookPages.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 120, 60));

        txtbookNoPages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookNoPagesActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookNoPages, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 0));
        jLabel4.setText("Số trang");
        txtbookPages.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 160, -1));

        txtbookEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookEditionActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 170, -1));

        txtbookPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookPublisherActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 170, -1));

        txtbookPages.add(txtbookCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 170, -1));

        txtbookPages.add(txtbookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 170, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtbookPages.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        txtbookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookNameActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 170, -1));

        txtbookContents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookContentsActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookContents, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 0));
        jLabel5.setText("Tác giả");
        txtbookPages.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 0));
        jLabel6.setText("Nhà xuẩt bản");
        txtbookPages.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 160, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 0));
        jLabel7.setText("Nội dung");
        txtbookPages.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 0));
        jLabel8.setText("Tên sách");
        txtbookPages.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 160, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 0));
        jLabel9.setText("Giá mượn/ngày");
        txtbookPages.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 160, -1));

        txtbookPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookPriceActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 0));
        jLabel10.setText("Phiên bản");
        txtbookPages.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 160, -1));

        txtbookStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookStockActionPerformed(evt);
            }
        });
        txtbookPages.add(txtbookStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 255, 0));
        jLabel11.setText("Còn lại");
        txtbookPages.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 160, -1));

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

    private void txtbookNoPagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookNoPagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookNoPagesActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        
        String bname = txtbookName.getText();
        CategoryItem citem = (CategoryItem)txtbookCat.getSelectedItem();
        AuthorItem aitem = (AuthorItem)txtbookAuthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem)txtbookPublisher.getSelectedItem();
        
        String contents = txtbookContents.getText();
        String pages = txtbookNoPages.getText();
        String edition = txtbookEdition.getText();
        String stock = txtbookStock.getText();
        String price = txtbookPrice.getText();
        
        
        try {
            pst = con.prepareStatement("insert into book(bookName, bookCat, bookAuthor, bookPublisher, bookContents, bookNoPages, bookEdition, bookStock, bookPrice)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, bname);
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, contents);
            pst.setString(6, pages);
            pst.setString(7, edition);
            pst.setString(8, stock);
            pst.setString(9, price);
            
            int k = pst.executeUpdate();
            if (k == 1)
            {
                JOptionPane.showMessageDialog(this, "Đã thêm sách mới thành công");
                txtbookName.setText("");
                txtbookCat.setSelectedItem(-1);
                txtbookAuthor.setSelectedItem(-1);
                txtbookPublisher.setSelectedItem(-1);
                txtbookContents.setText("");
                txtbookNoPages.setText("");
                txtbookEdition.setText("");
                txtbookStock.setText("");
                Book_Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        String bname = txtbookName.getText();
        CategoryItem citem = (CategoryItem)txtbookCat.getSelectedItem();
        AuthorItem aitem = (AuthorItem)txtbookAuthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem)txtbookPublisher.getSelectedItem();
        
        String contents = txtbookContents.getText();
        String pages = txtbookNoPages.getText();
        String edition = txtbookEdition.getText();
        String stock = txtbookStock.getText();
        String price = txtbookPrice.getText();
        
        try {
            pst = con.prepareStatement("update book set bookName = ?, bookCat = ?, bookAuthor = ?, bookPublisher = ? , bookContents = ?, bookNoPages = ?, bookEdition = ?, bookStock = ?, bookPrice = ? where bookID = ?");
            pst.setString(1, bname);
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, contents);
            pst.setString(6, pages);
            pst.setString(7, edition);
            pst.setString(8, stock);
            pst.setString(9, price);
            pst.setInt(10, id);
            int k = pst.executeUpdate();
            if (k == 1)
            {
                JOptionPane.showMessageDialog(this, "Đã cập nhật sách thành công");
                txtbookName.setText("");
                txtbookCat.setSelectedItem(-1);
                txtbookAuthor.setSelectedItem(-1);
                txtbookPublisher.setSelectedItem(-1);
                txtbookContents.setText("");
                txtbookNoPages.setText("");
                txtbookEdition.setText("");
                txtbookStock.setText("");                
                txtbookPrice.setText("");
                Book_Load();
                btnAdd.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        txtbookName.setText(d1.getValueAt(selectIndex, 1).toString());
        txtbookCat.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        txtbookAuthor.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
        txtbookPublisher.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
        txtbookContents.setText(d1.getValueAt(selectIndex, 5).toString());
        txtbookNoPages.setText(d1.getValueAt(selectIndex, 6).toString());
        txtbookEdition.setText(d1.getValueAt(selectIndex, 7).toString());
        txtbookStock.setText(d1.getValueAt(selectIndex, 8).toString());
        txtbookPrice.setText(d1.getValueAt(selectIndex, 9).toString());
        btnAdd.setEnabled(false);
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        try {
            pst = con.prepareStatement("delete from book where bookID = ?");
            pst.setInt(1, id);
            int k = pst.executeUpdate();
            if (k == 1)
            {
                JOptionPane.showMessageDialog(this, "Đã xoá sách thành công");
                txtbookName.setText("");
                txtbookCat.setSelectedItem(-1);
                txtbookAuthor.setSelectedItem(-1);
                txtbookPublisher.setSelectedItem(-1);
                txtbookContents.setText("");
                txtbookNoPages.setText("");
                txtbookEdition.setText("");
                txtbookStock.setText("");
                txtbookPrice.setText("");
                Book_Load();
                btnAdd.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main m = new Main();
        m.setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtbookEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookEditionActionPerformed

    private void txtbookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookNameActionPerformed

    private void txtbookContentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookContentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookContentsActionPerformed

    private void txtbookPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookPriceActionPerformed

    private void txtbookStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookStockActionPerformed

    private void txtbookPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookPublisherActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox txtbookAuthor;
    private javax.swing.JComboBox txtbookCat;
    private javax.swing.JTextField txtbookContents;
    private javax.swing.JTextField txtbookEdition;
    private javax.swing.JTextField txtbookName;
    private javax.swing.JTextField txtbookNoPages;
    private javax.swing.JPanel txtbookPages;
    private javax.swing.JTextField txtbookPrice;
    private javax.swing.JComboBox txtbookPublisher;
    private javax.swing.JTextField txtbookStock;
    // End of variables declaration//GEN-END:variables
}
