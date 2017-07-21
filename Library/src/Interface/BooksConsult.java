/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.*;
import java.util.Date;
import java.text.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dto.BookDto;
import modelo.facade.BooService;
import modelo.dao.ConexionMySQL;
import net.sourceforge.jcalendarbutton.JCalendarPopup;

/**
 *
 * @author XxYoshiBlackxX
 */
public class BooksConsult extends javax.swing.JInternalFrame {

    /*Se instancean las clases dto y facade las cuales
    tienen las operaciones que se requieren en MySQL*/
    BookDto booksDTO;
    BooService bookData;
    ConexionMySQL cmsql = new ConexionMySQL();
    Connection cn = cmsql.conectBdd();
    
    public BooksConsult() {
        initComponents();
        showTitles();
        showAuthors();
        showCategories();
        showEditorials();
    }
    
    /*Se consultan los titulos y se insertan en el combo box*/
    public void showTitles() {
        title.removeAllItems();
        title.addItem("Selecciona un título: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT title FROM books");
            while (rst.next()) {
                title.addItem(rst.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /*Se consultan los autores y se insertan en el combo box*/
    public void showAuthors() {
        author.removeAllItems();
        author.addItem("Selecciona un autor: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT name FROM authors");
            
            while (rst.next()) {
                author.addItem(rst.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /*Se consultan las editoriales y se insertan en el combo box*/
    public void showEditorials() {
        editorial.removeAllItems();
        editorial.addItem("Selecciona una editorial: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT editorial FROM editorial");
            
            while (rst.next()) {
                editorial.addItem(rst.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /*Se consultan las categorias y se insertan en el combo box*/
    public void showCategories() {
        category.removeAllItems();
        category.addItem("Selecciona una categoría: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT category FROM categories");
            
            while (rst.next()) {
                category.addItem(rst.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /*Se consultan los libros y se insertan en la tabla*/
    public void showBooks(String row, String info) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Título");
        dtm.addColumn("Autor");
        dtm.addColumn("Edición");
        dtm.addColumn("Editorial");
        dtm.addColumn("Fecha de impresión");
        dtm.addColumn("Categoría");
        dtm.addColumn("Ubicación");
        dtm.addColumn("Disponibilidad");
        try {
            String[] data = new String[9];
            PreparedStatement ps = null;
            ResultSet rst = null;
            ps = cn.prepareStatement("SELECT * FROM tbl_book WHERE " + row + " = ?");
            ps.setString(1, info);
            rst = ps.executeQuery();
            while (rst.next()) {
                data[0] = rst.getString(1);
                data[1] = rst.getString(2);
                data[2] = rst.getString(3);
                data[3] = rst.getString(4);
                data[4] = rst.getString(5);
                data[5] = rst.getString(6);
                data[6] = rst.getString(7);
                data[7] = rst.getString(8);
                data[8] = rst.getString(9);
                dtm.addRow(data);
            }
            bookTable.setModel(dtm);
        } catch (Exception ex) {
            System.out.println("Mensaje: \n" + ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        author = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        editorial = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox();
        title = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setTitle("Consulta de libros");
        setMaximumSize(new java.awt.Dimension(687, 459));
        setMinimumSize(new java.awt.Dimension(687, 459));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Consulta de libros");
        jLabel1.setToolTipText("");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(bookTable);

        jLabel4.setText("Autor:");

        author.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                authorItemStateChanged(evt);
            }
        });

        jLabel5.setText("Editorial:");

        editorial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editorialItemStateChanged(evt);
            }
        });

        jLabel6.setText("Categoría:");

        category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryItemStateChanged(evt);
            }
        });

        title.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                titleItemStateChanged(evt);
            }
        });

        jLabel7.setText("Títulos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(author, 0, 203, Short.MAX_VALUE)
                                .addComponent(title, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addGap(215, 215, 215)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        //cuando se detecte que se cerro la ventana se activa
        //el menu principal para poder seleccionarse de nuevo
        MenuStart.consultSubMenu.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosed

    private void categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryItemStateChanged
        /*Con esto detectamos el cambio en los combobox
        para encontrar datos validos, se condiciona sea diferente al valor 
        inicial*/
        String Category = (String) category.getSelectedItem();
        if (!Category.equals("Selecciona una categoría: ")) {
            showBooks("category", Category);
        }
    }//GEN-LAST:event_categoryItemStateChanged

    private void editorialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editorialItemStateChanged
        /*Con esto detectamos el cambio en los combobox
        para encontrar datos validos, se condiciona sea diferente al valor 
        inicial*/
        String Editorial = (String) editorial.getSelectedItem();
        if (!Editorial.equals("Selecciona una editorial: ")) {
            showBooks("editorial", Editorial);
        }
    }//GEN-LAST:event_editorialItemStateChanged

    private void authorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_authorItemStateChanged
        /*Con esto detectamos el cambio en los combobox
        para encontrar datos validos, se condiciona sea diferente al valor 
        inicial*/
        String Author = (String) author.getSelectedItem();
        if (!Author.equals("Selecciona un autor: ")) {
            showBooks("name", Author);
        }
    }//GEN-LAST:event_authorItemStateChanged

    private void titleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_titleItemStateChanged
        /*Con esto detectamos el cambio en los combobox
        para encontrar datos validos, se condiciona sea diferente al valor 
        inicial*/
        String Title = (String) title.getSelectedItem();
        if (!Title.equals("Selecciona un título: ")) {
            showBooks("title", Title);
        }
    }//GEN-LAST:event_titleItemStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox author;
    private javax.swing.JTable bookTable;
    private javax.swing.JComboBox category;
    private javax.swing.JComboBox editorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox title;
    // End of variables declaration//GEN-END:variables

    public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
}