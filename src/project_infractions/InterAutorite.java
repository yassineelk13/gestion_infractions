package project_infractions;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;



public class InterAutorite extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement stmt = null;
    public String[] columnNames = {"Matricule","CIN","Propriétaire","type de voiture","Modèle", "Note de permis"};
    int id_v ;
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<TableModel> rowSorter;
    
    public InterAutorite() {
        initComponents();
        showTableData();
        infoinfractbtn.setVisible(false);
        initializeSearch();
    }
    
    
    
     private void initializeSearch() {
        // Création d'un rowSorter pour le modèle de tableau
        rowSorter = new TableRowSorter<>(proprtable.getModel());
        proprtable.setRowSorter(rowSorter);
        
        // Ajout d'un DocumentListener au champ de recherche
        rechefld.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = rechefld.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = rechefld.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Ne sera pas utilisé pour les champs de texte non éditables
            }
        });
    }

    public void showTableData() {
        
         try {
            
            model.setColumnIdentifiers(columnNames);
            proprtable.setModel(model);
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            String sql = "SELECT vehicule.id,plaque_immatriculation,CIN,nom,marque,modele,note_permis,conducteur_id FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            String Matricule = "";
            String CIN = "";
            String nom = "";
            String marque = "";
            String modele = "";
            int note_permis ;
            int id_con ;
            int i = 0;
            while (rs.next()) {
                id_v = rs.getInt("id");
                Matricule = rs.getString("plaque_immatriculation");
                CIN = rs.getString("CIN");
                nom = rs.getString("nom");
                marque = rs.getString("marque");
                modele = rs.getString("modele");
                note_permis = rs.getInt("note_permis");
                id_con = rs.getInt("conducteur_id");
                model.addRow(new Object[]{Matricule, CIN, nom, marque, modele, note_permis});
           
            }
         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        proprtable = new javax.swing.JTable();
        rechefld = new javax.swing.JTextField();
        loginuser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rechebtn = new javax.swing.JButton();
        infoinfractbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(787, 477));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        proprtable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        proprtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Matricule", "CIN", "Propriétaire", "type de voiture", "Modèle", "Note de permis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        proprtable.setRowHeight(32);
        proprtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proprtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(proprtable);
        if (proprtable.getColumnModel().getColumnCount() > 0) {
            proprtable.getColumnModel().getColumn(0).setResizable(false);
            proprtable.getColumnModel().getColumn(1).setResizable(false);
            proprtable.getColumnModel().getColumn(2).setResizable(false);
            proprtable.getColumnModel().getColumn(3).setResizable(false);
            proprtable.getColumnModel().getColumn(4).setResizable(false);
            proprtable.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 205, 740, 250));

        rechefld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rechefld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechefldActionPerformed(evt);
            }
        });
        getContentPane().add(rechefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 156, 170, 31));

        loginuser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginuser.setText("Bonjour Autorité");
        getContentPane().add(loginuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 88, 251, 32));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutbtn.setBackground(new java.awt.Color(255, 51, 51));
        logoutbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutbtn.setText("Deconnection");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });
        jPanel1.add(logoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, 44));

        homebtn.setBackground(new java.awt.Color(0, 204, 102));
        homebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homebtn.setForeground(new java.awt.Color(255, 255, 255));
        homebtn.setText("Home");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });
        jPanel1.add(homebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 118, 44));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SécuriRoute");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 231, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rechebtn.setBackground(new java.awt.Color(0, 204, 102));
        rechebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rechebtn.setForeground(new java.awt.Color(255, 255, 255));
        rechebtn.setText("Rechercher");
        rechebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechebtnActionPerformed(evt);
            }
        });
        jPanel3.add(rechebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 116, 120, 31));

        infoinfractbtn.setBackground(new java.awt.Color(0, 204, 102));
        infoinfractbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoinfractbtn.setForeground(new java.awt.Color(255, 255, 255));
        infoinfractbtn.setText("voir les infractions");
        infoinfractbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoinfractbtnActionPerformed(evt);
            }
        });
        jPanel3.add(infoinfractbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 107, 201, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        new InterAutorite().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homebtnActionPerformed

    private void rechebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechebtnActionPerformed
        // TODO add your handling code here:
        /*String recherche = rechefld.getText();
        
        for(int i=0;i<proprtable.getRowCount();i++){
            if(proprtable.getValueAt(i, 1).toString().contains(recherche)){
                proprtable.setRowSelectionInterval(i, i);
            }
        }*/
    }//GEN-LAST:event_rechebtnActionPerformed

    private void infoinfractbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoinfractbtnActionPerformed
        // TODO add your handling code here:
        System.out.println("clicked" );
        int index = proprtable.getSelectedRow();
        String mat =model.getValueAt(index, 0).toString();
        System.out.println( mat );

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            String sql = "SELECT id,conducteur_id FROM vehicule where plaque_immatriculation='"+mat+"'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int idd = 0;
            int con_id = 0;
            while(rs.next()){
                idd =rs.getInt("id");
                con_id =rs.getInt("conducteur_id");
            }

            new Infractions(idd).setVisible(true);
            this.dispose();

            // System.out.println(lieu);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_infoinfractbtnActionPerformed

    private void proprtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proprtableMouseClicked
        // TODO add your handling code here:
        if(evt.getButton() == MouseEvent.BUTTON1){
            infoinfractbtn.setVisible(true);

        }else if(evt.getButton() == MouseEvent.BUTTON3){
            infoinfractbtn.setVisible(false);
            proprtable.clearSelection();
        }

    }//GEN-LAST:event_proprtableMouseClicked

    private void rechefldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechefldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechefldActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new InterAutorite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homebtn;
    private javax.swing.JButton infoinfractbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loginuser;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTable proprtable;
    private javax.swing.JButton rechebtn;
    private javax.swing.JTextField rechefld;
    // End of variables declaration//GEN-END:variables
}
