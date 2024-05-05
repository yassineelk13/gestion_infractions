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


public class Infovoitures extends javax.swing.JFrame {

    public int id_v;
    public Infovoitures() {
        initComponents();
        showTableData();
        supbtn.setVisible(false);
        modbtn.setVisible(false);
    }

        public void showTableData() {
        
         try {
                String[] columnNames = {"Matricule","Marque","Modèle","année","Conducteur"};
                PreparedStatement stmt = null;
                Connection conn= null;
                //int id_v ;
                DefaultTableModel model = new DefaultTableModel();
    
            
            model.setColumnIdentifiers(columnNames);
            listvoiture.setModel(model);
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            String sql = "select plaque_immatriculation,marque,modele,annee,conducteur.nom as nom FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            String Matricule = "";
            String nom = "";
            String marque = "";
            String modele = "";
            int annee ;
           
            while (rs.next()) {
                
                Matricule = rs.getString("plaque_immatriculation");
                nom = rs.getString("nom");
                marque = rs.getString("marque");
                modele = rs.getString("modele");
                annee = rs.getInt("annee");
                model.addRow(new Object[]{Matricule,marque, modele ,annee,nom});          
            }
         
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listvoiture = new javax.swing.JTable();
        ajoubtn = new javax.swing.JTextField();
        modbtn = new javax.swing.JTextField();
        supbtn = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("liste d'Agents :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "nom d'utilisateur", "mot de passe"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField2.setBackground(new java.awt.Color(51, 153, 0));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Ajouter");

        jTextField3.setBackground(new java.awt.Color(51, 153, 0));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Modifier");

        jTextField4.setBackground(new java.awt.Color(51, 153, 0));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Supprimer");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(787, 477));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutbtn.setBackground(new java.awt.Color(255, 51, 51));
        logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutbtn.setText("Deconnection");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });
        jPanel1.add(logoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, 44));

        homebtn.setBackground(new java.awt.Color(0, 204, 102));
        homebtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        homebtn.setForeground(new java.awt.Color(255, 255, 255));
        homebtn.setText("Home");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });
        jPanel1.add(homebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 118, 44));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SécuriRoute");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 231, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("liste de voitures:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 206, 47));

        listvoiture.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listvoiture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matricule", "Marque", "Modèle", "année", "Conducteur"
            }
        ));
        listvoiture.setRowHeight(32);
        listvoiture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listvoitureMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listvoiture);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 670, 290));

        ajoubtn.setEditable(false);
        ajoubtn.setBackground(new java.awt.Color(51, 153, 0));
        ajoubtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ajoubtn.setForeground(new java.awt.Color(255, 255, 255));
        ajoubtn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ajoubtn.setText("Ajouter");
        ajoubtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoubtnMouseClicked(evt);
            }
        });
        ajoubtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoubtnActionPerformed(evt);
            }
        });
        jPanel2.add(ajoubtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 110, 40));

        modbtn.setEditable(false);
        modbtn.setBackground(new java.awt.Color(51, 153, 0));
        modbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modbtn.setForeground(new java.awt.Color(255, 255, 255));
        modbtn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modbtn.setText("Modifier");
        modbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modbtnMouseClicked(evt);
            }
        });
        modbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnActionPerformed(evt);
            }
        });
        jPanel2.add(modbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 110, 40));

        supbtn.setEditable(false);
        supbtn.setBackground(new java.awt.Color(51, 153, 0));
        supbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supbtn.setForeground(new java.awt.Color(255, 255, 255));
        supbtn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        supbtn.setText("Supprimer");
        supbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supbtnMouseClicked(evt);
            }
        });
        supbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supbtnActionPerformed(evt);
            }
        });
        jPanel2.add(supbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 120, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        new InterAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homebtnActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void supbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supbtnActionPerformed

    private void modbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnActionPerformed
        // TODO add your handling code here:
         int indice = listvoiture.getSelectedRow(); 
        String matricule = listvoiture.getModel().getValueAt(indice, 0).toString();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query = "select id FROM vehicule WHERE plaque_immatriculation='"+matricule+"'  ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            int id = 0;
        
            while (rs.next()) {
                
                id = rs.getInt("id");        
                
            }
            
            
            new Ajoutvoitures(id,"modif").setVisible(true);
            this.dispose();
            
             } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_modbtnActionPerformed

    private void supbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supbtnMouseClicked
        // TODO add your handling code here:
         if(listvoiture.getSelectedRow() != -1){
           
       int option = JOptionPane.showConfirmDialog(this, "Vous êtes sûr de vouloir supprimer ?", "Supprimer", JOptionPane.YES_NO_OPTION);
       
       if (option == JOptionPane.YES_OPTION) {
     int indice = listvoiture.getSelectedRow(); 
        String matricule = listvoiture.getModel().getValueAt(indice, 0).toString();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query = "select id FROM vehicule WHERE plaque_immatriculation='"+matricule+"'  ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            int id = 0;
            
           
            while (rs.next()) {
                
                id = rs.getInt("id");
                
                
            }
            
            String query2 = "DELETE FROM infraction WHERE vehicule_id ='"+id+"'  ";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.execute();
            
            String query1 = "DELETE FROM vehicule WHERE plaque_immatriculation='"+matricule+"'  ";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.execute();
            
            
            JOptionPane.showMessageDialog(this, "l'agent a été supprimé avec succes !", "success", JOptionPane.CLOSED_OPTION);
            showTableData();
        
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       } 
     
       
        } 
    }//GEN-LAST:event_supbtnMouseClicked

    private void listvoitureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listvoitureMouseClicked
        // TODO add your handling code here:
         if(evt.getButton() == MouseEvent.BUTTON1){
            supbtn.setVisible(true);
            modbtn.setVisible(true);

        }else if(evt.getButton() == MouseEvent.BUTTON3){
            supbtn.setVisible(false);
            modbtn.setVisible(false);
            listvoiture.clearSelection();
        }
    }//GEN-LAST:event_listvoitureMouseClicked

    private void modbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modbtnMouseClicked
        // TODO add your handling code here:
          int indice = listvoiture.getSelectedRow(); 
        String matricule = listvoiture.getModel().getValueAt(indice, 0).toString();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query = "select id FROM vehicule WHERE plaque_immatriculation='"+matricule+"'  ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            int id = 0;
        
            while (rs.next()) {
                
                id = rs.getInt("id");        
                
            }
            
            
            new Ajoutvoitures(id,"modif").setVisible(true);
            this.dispose();
            
             } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_modbtnMouseClicked

    private void ajoubtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoubtnMouseClicked
        // TODO add your handling code here:
          new Ajoutvoitures(1,"ajout").setVisible(true);
          this.dispose();
    }//GEN-LAST:event_ajoubtnMouseClicked

    private void ajoubtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoubtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajoubtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(Infovoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Infovoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Infovoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Infovoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Infovoitures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ajoubtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable listvoiture;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextField modbtn;
    private javax.swing.JTextField supbtn;
    // End of variables declaration//GEN-END:variables
}
