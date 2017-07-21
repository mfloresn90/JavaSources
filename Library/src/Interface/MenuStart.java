package Interface;

import javax.swing.JDesktopPane;

public class MenuStart extends javax.swing.JFrame {
    
    public int userID = 0;
    public String userType = "";

    public MenuStart() {
        initComponents();
        getTypeUser();
    }
    
    public void getTypeUser () {
        String userInfo = Login.dataLogin;
        String[] userData = userInfo.split("-");
        userID = Integer.parseInt(userData[0]);
        if (userData[1].equals("1")) {
            userMenu.setVisible(false);
        } else {
            adminMenu.setVisible(false);
        }
        this.setTitle("Pc Health Library - " + userData[2]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        myDataMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        categorySubMenu = new javax.swing.JMenuItem();
        authorSubMenu = new javax.swing.JMenuItem();
        editorialSubMenu = new javax.swing.JMenuItem();
        bookSubMenu = new javax.swing.JMenuItem();
        userMenu = new javax.swing.JMenu();
        consultSubMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pc Health Library");
        setMinimumSize(new java.awt.Dimension(800, 640));

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        myDataMenuItem.setText("Mis Datos");
        myDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myDataMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(myDataMenuItem);

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Cerrar sesión");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(jSeparator1);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        adminMenu.setText("Administrador");

        categorySubMenu.setText("Categorías");
        categorySubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySubMenuActionPerformed(evt);
            }
        });
        adminMenu.add(categorySubMenu);

        authorSubMenu.setText("Autores");
        authorSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorSubMenuActionPerformed(evt);
            }
        });
        adminMenu.add(authorSubMenu);

        editorialSubMenu.setText("Editoriales");
        editorialSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialSubMenuActionPerformed(evt);
            }
        });
        adminMenu.add(editorialSubMenu);

        bookSubMenu.setText("Libros");
        bookSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSubMenuActionPerformed(evt);
            }
        });
        adminMenu.add(bookSubMenu);

        menuBar.add(adminMenu);

        userMenu.setText("Usuario");

        consultSubMenu.setText("Consultar");
        consultSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultSubMenuActionPerformed(evt);
            }
        });
        userMenu.add(consultSubMenu);

        menuBar.add(userMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void categorySubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySubMenuActionPerformed
        categorySubMenu.setEnabled(false);
        Categories cgs = new Categories();
        desktopPane.add(cgs);
        cgs.setVisible(true);
    }//GEN-LAST:event_categorySubMenuActionPerformed

    private void authorSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorSubMenuActionPerformed
        authorSubMenu.setEnabled(false);
        Authors ahs = new Authors();
        desktopPane.add(ahs);
        ahs.setVisible(true);
    }//GEN-LAST:event_authorSubMenuActionPerformed

    private void editorialSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialSubMenuActionPerformed
        editorialSubMenu.setEnabled(false);
        Editorials ers = new Editorials();
        desktopPane.add(ers);
        ers.setVisible(true);
    }//GEN-LAST:event_editorialSubMenuActionPerformed

    private void bookSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSubMenuActionPerformed
        bookSubMenu.setEnabled(false);
        Books bos = new Books();
        desktopPane.add(bos);
        bos.setVisible(true);
    }//GEN-LAST:event_bookSubMenuActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        Login lgn = new Login();
        lgn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void myDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myDataMenuItemActionPerformed
        myDataMenuItem.setEnabled(false);
        MyData mda = new MyData();
        desktopPane.add(mda);
        mda.setVisible(true);
    }//GEN-LAST:event_myDataMenuItemActionPerformed

    private void consultSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultSubMenuActionPerformed
        consultSubMenu.setEnabled(false);
        BooksConsult bct = new BooksConsult();
        desktopPane.add(bct);
        bct.setVisible(true);
    }//GEN-LAST:event_consultSubMenuActionPerformed

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
            java.util.logging.Logger.getLogger(MenuStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu adminMenu;
    public static javax.swing.JMenuItem authorSubMenu;
    public static javax.swing.JMenuItem bookSubMenu;
    public static javax.swing.JMenuItem categorySubMenu;
    public static javax.swing.JMenuItem consultSubMenu;
    private javax.swing.JDesktopPane desktopPane;
    public static javax.swing.JMenuItem editorialSubMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenuItem myDataMenuItem;
    public javax.swing.JMenuItem openMenuItem;
    public javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables

}
