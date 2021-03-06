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
public class Books extends javax.swing.JInternalFrame {

    /*Se instancean las clases dto y facade las cuales
    tienen las operaciones que se requieren en MySQL*/
    BookDto booksDTO;
    BooService bookData;
    ConexionMySQL cmsql = new ConexionMySQL();
    Connection cn = cmsql.conectBdd();
    /*Este vector booleano realiza el chequeo de los 
    campos para asi aparecer el boton de guardar cuando
    se hayan insertado todos los valores, y ademas convierte
    una cadena en el formato que se especifica*/
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    boolean[] fields = new boolean[8];
    int id = 0;
    
    public Books() {
        //aqui se ejecuta todo lo qe debe
        //de cargar antes de mostrar la ventana
        initComponents();
        showAuthors();
        showCategories();
        showEditorials();
        showBooks();
    }
    
    /*Consulta los autores y los añade en el combobox*/
    public void showAuthors() {
        authorId.removeAllItems();
        authorId.addItem("0 - Selecciona un autor: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM authors");
            
            while (rst.next()) {
                authorId.addItem(rst.getString(1) + " - " + rst.getString(2));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }

    /*Consulta los editoriales y los añade en el combobox*/
    public void showEditorials() {
        editorialId.removeAllItems();
        editorialId.addItem("0 - Selecciona un editorial: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM editorial");
            
            while (rst.next()) {
                editorialId.addItem(rst.getString(1) + " - " + rst.getString(2));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /*Consulta las categorias y los añade en el combobox*/
    public void showCategories() {
        categoryId.removeAllItems();
        categoryId.addItem("0 - Selecciona una categoría: ");
        try {
            Statement stt = cn.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM categories");
            
            while (rst.next()) {
                categoryId.addItem(rst.getString(1) + " - " + rst.getString(2));
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /*Consulta los libros y los muestra en una tabla*/
    public void showBooks() {
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
            Statement set = cn.createStatement();
            ResultSet rst = set.executeQuery("SELECT * FROM tbl_book order by bookId");
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
        titleLabel = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        printing = new javax.swing.JTextField();
        jCalendarButton1 = new net.sourceforge.jcalendarbutton.JCalendarButton();
        jLabel4 = new javax.swing.JLabel();
        authorId = new javax.swing.JComboBox();
        title1 = new javax.swing.JLabel();
        edition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        editorialId = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        categoryId = new javax.swing.JComboBox();
        title2 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        title3 = new javax.swing.JLabel();
        availability = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setTitle("Libros");
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
        jLabel1.setText("Panel de Libros");
        jLabel1.setToolTipText("");

        titleLabel.setText("Título:");

        title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleKeyReleased(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        jButton3.setText("Eliminar");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de impresión:");

        printing.setEnabled(false);
        printing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                printingKeyReleased(evt);
            }
        });

        jCalendarButton1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarButton1PropertyChange(evt);
            }
        });

        jLabel4.setText("Autor:");

        authorId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                authorIdItemStateChanged(evt);
            }
        });

        title1.setText("Edición:");

        edition.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editionKeyReleased(evt);
            }
        });

        jLabel5.setText("Editorial:");

        editorialId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editorialIdItemStateChanged(evt);
            }
        });

        jLabel6.setText("Categoría:");

        categoryId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryIdItemStateChanged(evt);
            }
        });

        title2.setText("Ubicación:");

        location.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                locationKeyReleased(evt);
            }
        });

        title3.setText("Disponibilidad:");

        availability.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                availabilityKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(printing, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(titleLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(title)
                                        .addComponent(authorId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(title1))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(edition)
                                        .addComponent(editorialId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(title2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(title3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(availability)
                                    .addComponent(categoryId, 0, 203, Short.MAX_VALUE)
                                    .addComponent(location))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(authorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title1)
                    .addComponent(edition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(editorialId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendarButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(printing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title2)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title3)
                    .addComponent(availability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
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
        MenuStart.bookSubMenu.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosed

    private void titleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleKeyReleased
        /*En caso de que el campo de texto sea diferente de vacio este 
        hara que su respectiva posicion en el vector booleano sea un
        verdadero, en caso de que no regresa a falso*/
        if (!title.getText().equals("")) {
            fields[0] = true;
        } else {
            fields[0] = false;
        }
        checkFields();
    }//GEN-LAST:event_titleKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*Se capturan todos los datos ya validados
        para poder crear registros*/
        String idAuthor = (String) authorId.getSelectedItem();
        String[] author = idAuthor.split(" - ");
        String idCategory = (String) categoryId.getSelectedItem();
        String[] category = idCategory.split(" - ");
        String idEditorial = (String) editorialId.getSelectedItem();
        String[] editorial = idEditorial.split(" - ");
        bookData = new BooService();
        booksDTO = new BookDto();
        booksDTO.setTitle(title.getText());
        booksDTO.setAuthorId(Integer.parseInt(author[0]));
        booksDTO.setEdition(edition.getText());
        booksDTO.setEditorialId(Integer.parseInt(editorial[0]));
        java.util.Date date = null;
        try {
            date = sdf.parse(printing.getText());
        } catch (ParseException ex) {
            //Logger.getLogger(Authors.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        booksDTO.setPrinting(sqlDate);
        booksDTO.setCategoryId(Integer.parseInt(category[0]));
        booksDTO.setLocation(location.getText());
        booksDTO.setAvailability(Integer.parseInt(availability.getText()));
        try {
            bookData.createBook(booksDTO);
            resetStatus();
            JOptionPane.showMessageDialog(null, "Registro exitoso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede registrar!!");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
        /*Se captura el id al seleccionar un elemento de la tabla, con
        el cual podremos actualizar, eliminar y cancelar operacion*/
        int row = bookTable.getSelectedRow();
        if (row >= 0) {
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            id = Integer.parseInt(bookTable.getValueAt(row, 0).toString());
            title.setText(bookTable.getValueAt(row, 1).toString());
            edition.setText(bookTable.getValueAt(row, 3).toString());
            printing.setText(bookTable.getValueAt(row, 5).toString());
            location.setText(bookTable.getValueAt(row, 7).toString());
            availability.setText(bookTable.getValueAt(row, 8).toString());
        }
    }//GEN-LAST:event_bookTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*Se capturan todos los datos ya validados
        para poder actualizar registros*/
        String idAuthor = (String) authorId.getSelectedItem();
        String[] author = idAuthor.split(" - ");
        String idCategory = (String) categoryId.getSelectedItem();
        String[] category = idCategory.split(" - ");
        String idEditorial = (String) editorialId.getSelectedItem();
        String[] editorial = idEditorial.split(" - ");
        bookData = new BooService();
        booksDTO = new BookDto();
        booksDTO.setBookId(id);
        booksDTO.setTitle(title.getText());
        booksDTO.setAuthorId(Integer.parseInt(author[0]));
        booksDTO.setEdition(edition.getText());
        booksDTO.setEditorialId(Integer.parseInt(editorial[0]));
        java.util.Date date = null;
        try {
            date = sdf.parse(printing.getText());
        } catch (ParseException ex) {
            //Logger.getLogger(Authors.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        booksDTO.setPrinting(sqlDate);
        booksDTO.setCategoryId(Integer.parseInt(category[0]));
        booksDTO.setLocation(location.getText());
        booksDTO.setAvailability(Integer.parseInt(availability.getText()));
        try {
            bookData.updateBook(booksDTO);
            resetStatus();
            JOptionPane.showMessageDialog(null, "Actualización exitosa!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar!!");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*Por medio del id capturado anteriormente este elimina registros*/
        bookData = new BooService();
        booksDTO = new BookDto();
        booksDTO.setBookId(id);
        try {
            bookData.deleteBook(booksDTO);
            resetStatus();
            JOptionPane.showMessageDialog(null, "Eliminación exitosa!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar!!");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        /*llama al metodo para limpiar todos los campos*/
        resetStatus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void printingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_printingKeyReleased
        /*En caso de que el campo de texto sea diferente de vacio este 
        hara que su respectiva posicion en el vector booleano sea un
        verdadero, en caso de que no regresa a falso*/
        if (!printing.getText().equals("")) {
            fields[1] = true;
        } else {
            fields[1] = false;
        }
        checkFields();
    }//GEN-LAST:event_printingKeyReleased

    private void jCalendarButton1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarButton1PropertyChange
        //el evento del calendario, el cual hara que aparezca la fecha
        // en el campo de texto
        if (evt.getNewValue() instanceof Date) {
            setDate((Date) evt.getNewValue());
        }
    }//GEN-LAST:event_jCalendarButton1PropertyChange

    private void editionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editionKeyReleased
        /*En caso de que el campo de texto sea diferente de vacio este 
        hara que su respectiva posicion en el vector booleano sea un
        verdadero, en caso de que no regresa a falso*/
        if (!edition.getText().equals("")) {
            fields[2] = true;
        } else {
            fields[2] = false;
        }
        checkFields();
    }//GEN-LAST:event_editionKeyReleased

    private void locationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locationKeyReleased
        /*En caso de que el campo de texto sea diferente de vacio este 
        hara que su respectiva posicion en el vector booleano sea un
        verdadero, en caso de que no regresa a falso*/
        if (!location.getText().equals("")) {
            fields[6] = true;
        } else {
            fields[6] = false;
        }
        checkFields();
    }//GEN-LAST:event_locationKeyReleased

    private void availabilityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_availabilityKeyReleased
        /*En caso de que el campo de texto sea diferente de vacio este 
        hara que su respectiva posicion en el vector booleano sea un
        verdadero, en caso de que no regresa a falso*/
        if (!availability.getText().equals("")) {
            fields[7] = true;
        } else {
            fields[7] = false;
        }
        checkFields();
    }//GEN-LAST:event_availabilityKeyReleased

    private void authorIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_authorIdItemStateChanged
        /*Revisa el evento donde cambia la posicion actial del cursor
        del combo box campturando lo que se selecciono
        y validandolo si es mayor o igual a 1*/
        String idAuthor = (String) authorId.getSelectedItem();
        String[] parts = idAuthor.split(" - ");
        if (Integer.parseInt(parts[0]) >= 1) {
            fields[1] = true;
        } else {
            fields[1] = false;
        }
        checkFields();
    }//GEN-LAST:event_authorIdItemStateChanged

    private void editorialIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editorialIdItemStateChanged
        /*Revisa el evento donde cambia la posicion actial del cursor
        del combo box campturando lo que se selecciono
        y validandolo si es mayor o igual a 1*/
        String idEditorial = (String) editorialId.getSelectedItem();
        String[] parts = idEditorial.split(" - ");
        if (Integer.parseInt(parts[0]) >= 1) {
            fields[3] = true;
        } else {
            fields[3] = false;
        }
        checkFields();
    }//GEN-LAST:event_editorialIdItemStateChanged

    private void categoryIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryIdItemStateChanged
        /*Revisa el evento donde cambia la posicion actial del cursor
        del combo box campturando lo que se selecciono
        y validandolo si es mayor o igual a 1*/
        String idCategory = (String) categoryId.getSelectedItem();
        String[] parts = idCategory.split(" - ");
        if (Integer.parseInt(parts[0]) >= 1) {
            fields[5] = true;
        } else {
            fields[5] = false;
        }
        checkFields();
    }//GEN-LAST:event_categoryIdItemStateChanged

    public void resetStatus() {
        /*Se limpian todos los valores, de los campos, combo box
        que existan en la interface*/
        showBooks();
        title.setText("");
        authorId.setSelectedIndex(0);
        editorialId.setSelectedIndex(0);
        categoryId.setSelectedIndex(0);
        printing.setText("");
        edition.setText("");
        location.setText("");
        availability.setText("");
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        id = 0;
        Arrays.fill(fields, false);
    }
    
    public void checkFields() {
        /*Se revisan los campos de acuerdo al numero de 
        campos que se encuentran en la interface*/
        int cnt = 0;
        for (int x = 0; x < fields.length; x++) {
            if (fields[x] == true) {
                cnt++;
            }
        }
        if (cnt == 8) {
            if (id == 0) {
                jButton1.setEnabled(true);
            }
        } else {
            jButton1.setEnabled(false);
        }
    }
    
    public void setDate(String dateString) {
        /*Se instancea date para poder dar formato deseado,
        es necesario que se encuentre un valor */
        Date date = null;
        try {
            if ((dateString != null) && (dateString.length() > 0)) {
                date = dateFormat.parse(dateString);
            }
        } catch (Exception e) {
            date = null;
        }
        this.setDate(date);
    }

    public void setDate(Date date) {
        /*Aqui se obtiene el formato del metodo anterior y se convierte a tipo
        date mostrandolo en el campo de texto y activando su respectiva
        posicion del vector booleano en verdadero*/
        String dateString = "";
        if (date != null) {
            dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        printing.setText(dateString);
        jCalendarButton1.setTargetDate(date);
        fields[4] = true;

        checkFields();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox authorId;
    private javax.swing.JTextField availability;
    private javax.swing.JTable bookTable;
    private javax.swing.JComboBox categoryId;
    private javax.swing.JTextField edition;
    private javax.swing.JComboBox editorialId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private net.sourceforge.jcalendarbutton.JCalendarButton jCalendarButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField location;
    private javax.swing.JTextField printing;
    private javax.swing.JTextField title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
}