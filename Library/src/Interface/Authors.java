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
import modelo.dto.AuthorDto;
import modelo.facade.AutService;
import modelo.dao.ConexionMySQL;
import net.sourceforge.jcalendarbutton.JCalendarPopup;

/**
 *
 * @author XxYoshiBlackxX
 */
public class Authors extends javax.swing.JInternalFrame {

    /*Se instancean las clases dto y facade las cuales
    tienen las operaciones que se requieren en MySQL*/
    AuthorDto authorDTO;
    AutService authorData;
    ConexionMySQL cmsql = new ConexionMySQL();
    Connection cn = cmsql.conectBdd();
    /*Este vector booleano realiza el chequeo de los 
    campos para asi aparecer el boton de guardar cuando
    se hayan insertado todos los valores, y ademas convierte
    una cadena en el formato que se especifica*/
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    boolean[] fields = new boolean[2];
    int id = 0;
    
    public Authors() {
        initComponents();
        showAuthors();
    }
    
    /*Consulta los autores y los muestra en la tabla*/
    public void showAuthors() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre del Autor");
        dtm.addColumn("Fecha de nacimiento");
        
        try {
            String[] data = new String[3];
            Statement set = cn.createStatement();
            ResultSet rst = set.executeQuery("SELECT * FROM authors");
            while (rst.next()) {
                data[0] = rst.getString(1);
                data[1] = rst.getString(2);
                data[2] = rst.getString(3);
                dtm.addRow(data);
            }
            autorTable.setModel(dtm);
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        autorTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCalendarButton1 = new net.sourceforge.jcalendarbutton.JCalendarButton();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setTitle("Autores");
        setMaximumSize(new java.awt.Dimension(421, 454));
        setMinimumSize(new java.awt.Dimension(421, 454));
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
        jLabel1.setText("Panel de Autores");
        jLabel1.setToolTipText("");

        jLabel2.setText("Autor:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
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

        autorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        autorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(autorTable);

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

        jLabel3.setText("Nacimiento:");

        jTextField2.setEnabled(false);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jCalendarButton1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarButton1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCalendarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
        MenuStart.authorSubMenu.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        /*En caso de que el campo de texto sea diferente de vacio este 
        hara que su respectiva posicion en el vector booleano sea un
        verdadero, en caso de que no regresa a falso*/
        if (!jTextField1.getText().equals("")) {
            fields[0] = true;
        } else {
            fields[0] = false;
        }
        checkFields();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*Este es el proceso para crear, llamando a los objetos instanciados
        arriba, llenando los valores que se establecieron en AutoresDto y
        AutoresDao*/
        authorData = new AutService();
        authorDTO = new AuthorDto();
        authorDTO.setName(jTextField1.getText());
        java.util.Date date = null;
        try {
            date = sdf.parse(jTextField2.getText());
        } catch (ParseException ex) {
            //Logger.getLogger(Authors.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        authorDTO.setBirthday(sqlDate);
        try {
            authorData.createAuthor(authorDTO);
            resetStatus();
            JOptionPane.showMessageDialog(null, "Registro exitoso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede registrar!!");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void autorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorTableMouseClicked
        /*Con  estas instrucciones se captura el
        id del campo que se requiere y se activan los botones
        de actualizar eliminar y cancelar operacion*/
        int row = autorTable.getSelectedRow();
        if (row >= 0) {
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            id = Integer.parseInt(autorTable.getValueAt(row, 0).toString());
            jTextField1.setText(autorTable.getValueAt(row, 1).toString());
            jTextField2.setText(autorTable.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_autorTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*Este es el proceso para actualizar, llamando a los objetos instanciados
        arriba, llenando los valores que se establecieron en AutoresDto y
        AutoresDao*/
        authorData = new AutService();
        authorDTO = new AuthorDto();
        authorDTO.setAuthorId(id);
        authorDTO.setName(jTextField1.getText());
        java.util.Date date = null;
        try {
            date = sdf.parse(jTextField2.getText());
        } catch (ParseException ex) {
            //Logger.getLogger(Authors.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        authorDTO.setBirthday(sqlDate);
        try {
            authorData.updateAuthor(authorDTO);
            resetStatus();
            JOptionPane.showMessageDialog(null, "Actualización exitosa!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar!!");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*Este es el proceso para eliminar, llamando a los objetos instanciados
        arriba, llenando los valores que se establecieron en AutoresDto y
        AutoresDao*/
        authorData = new AutService();
        authorDTO = new AuthorDto();
        authorDTO.setAuthorId(id);
        try {
            authorData.deleteAuthor(authorDTO);
            resetStatus();
            JOptionPane.showMessageDialog(null, "Eliminación exitosa!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar!!");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //se reestablecen los campos
        resetStatus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        /*Se pone como verdadero el vector booleano con el cual se podra 
        identificar si este tiene informacion o no*/
        if (!jTextField2.getText().equals("")) {
            fields[1] = true;
        } else {
            fields[1] = false;
        }
        checkFields();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jCalendarButton1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarButton1PropertyChange
        /*Se llama al evento de la fecha para capturar el dato que se selecciono*/
        if (evt.getNewValue() instanceof Date) {
            setDate((Date) evt.getNewValue());
        }
    }//GEN-LAST:event_jCalendarButton1PropertyChange
 
    /**Se reestablecen todos los campos, de autores, 
        y el vector llenando todos los campos a falso
       asi poder reiniciar el proceso**/
    public void resetStatus() {
       
        showAuthors();
        jTextField1.setText("");
        jTextField2.setText("");
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
        if (cnt == 2) {
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
        jTextField2.setText(dateString);
        jCalendarButton1.setTargetDate(date);
        fields[1] = true;

        checkFields();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable autorTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private net.sourceforge.jcalendarbutton.JCalendarButton jCalendarButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
}