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


public class Infoagents extends javax.swing.JFrame {
    
    
    
    public Infoagents() {
        initComponents();
        showTableData();
    }

    public void showTableData() {
        
         try {
            String[] columnNames = {"Nom","Prenom","nom d'utilisateur","mot de passe"};
            PreparedStatement stmt = null;
            Connection conn= null;
            //int id_v ;
            DefaultTableModel model = new DefaultTableModel();
            
            model.setColumnIdentifiers(columnNames);
            listagents.setModel(model);
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            String sql = "select * FROM utilisateur where role='Agent'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            String prenom = "";
            String nom = "";
            String pass = "";
            String username = "";
           
            while (rs.next()) {
                
                prenom = rs.getString("prenom");
                nom = rs.getString("nom");
                pass = rs.getString("mot_de_passe");
                username = rs.getString("nom_utilisateur");
                
                model.addRow(new Object[]{nom,prenom, username ,pass});          
            }
         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void clear(){
        nomfld.setText("");
         prenomfld.setText("");
         nomutifld.setText("");
         passfld.setText("");
         passconfld.setText("");
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listagents = new javax.swing.JTable();
        clrbtn = new javax.swing.JTextField();
        ajoubtn = new javax.swing.JTextField();
        supbtn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passconfld = new javax.swing.JTextField();
        nomfld = new javax.swing.JTextField();
        prenomfld = new javax.swing.JTextField();
        nomutifld = new javax.swing.JTextField();
        passfld = new javax.swing.JTextField();
        modbtn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        logoutbtn.setBackground(new java.awt.Color(255, 51, 51));
        logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutbtn.setText("Deconnection");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        homebtn.setBackground(new java.awt.Color(0, 204, 102));
        homebtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        homebtn.setForeground(new java.awt.Color(255, 255, 255));
        homebtn.setText("Home");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 527, Short.MAX_VALUE)
                .addComponent(homebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutbtn))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(homebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("liste d'Agents :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 206, 47));

        listagents.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listagents.setModel(new javax.swing.table.DefaultTableModel(
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
        listagents.setRowHeight(32);
        listagents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listagentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listagents);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 470, 290));

        clrbtn.setEditable(false);
        clrbtn.setBackground(new java.awt.Color(51, 153, 0));
        clrbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clrbtn.setForeground(new java.awt.Color(255, 255, 255));
        clrbtn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        clrbtn.setText("Vider");
        clrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clrbtnMouseClicked(evt);
            }
        });
        clrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrbtnActionPerformed(evt);
            }
        });
        jPanel2.add(clrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 110, 30));

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
        jPanel2.add(ajoubtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 110, 30));

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
        jPanel2.add(supbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Confirmer mot de passe :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 200, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Nom :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Prenom :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Nom d'utilisateur :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Mot de passe :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 20));

        passconfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(passconfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 140, 30));

        nomfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(nomfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, 30));

        prenomfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(prenomfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 30));

        nomutifld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(nomutifld, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, 30));

        passfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(passfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, 30));

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
        jPanel2.add(modbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 110, 30));

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

    private void supbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supbtnActionPerformed

    private void listagentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listagentsMouseClicked
        // TODO add your handling code here:
        int indice = listagents.getSelectedRow();
        if(evt.getButton() == MouseEvent.BUTTON1){
            String nom = listagents.getModel().getValueAt(indice, 0).toString();
            String prenom = listagents.getModel().getValueAt(indice, 1).toString();
            String username = listagents.getModel().getValueAt(indice, 2).toString();
            String pass = listagents.getModel().getValueAt(indice, 3).toString();
            
            nomfld.setText(nom);
            prenomfld.setText(prenom);
            nomutifld.setText(username);
            passfld.setText(pass);
            passconfld.setText(pass);
            
            System.out.println("nom : "+nom+"/prenom : "+prenom+"/username : "+username+"/pass : "+pass);

        }else if(evt.getButton() == MouseEvent.BUTTON3){
            
            listagents.clearSelection();
        }
    }//GEN-LAST:event_listagentsMouseClicked

    private void clrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrbtnActionPerformed
        // TODO add your handling code here:
         nomfld.setText("");
         prenomfld.setText("");
         nomutifld.setText("");
         passfld.setText("");
         passconfld.setText("");
    }//GEN-LAST:event_clrbtnActionPerformed

    
    private void clrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrbtnMouseClicked
        // TODO add your handling code here:
         clear();
    }//GEN-LAST:event_clrbtnMouseClicked

    private void supbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supbtnMouseClicked
        // TODO add your handling code here:
         if(listagents.getSelectedRow() != -1){
           
        int indice = listagents.getSelectedRow(); 
        String user_name = listagents.getModel().getValueAt(indice, 2).toString();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query1 = "DELETE FROM `utilisateur` WHERE nom_utilisateur='"+user_name+"'  ";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.execute();
            clear();
            
            JOptionPane.showMessageDialog(this, "l'agent a été supprimé avec succes !", "success", JOptionPane.CLOSED_OPTION);
            showTableData();
        
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        } 
    }//GEN-LAST:event_supbtnMouseClicked

    private void ajoubtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoubtnActionPerformed
        // TODO add your handling code here:
        String nom = nomfld.getText();
        String prenom = prenomfld.getText();
        String username = nomutifld.getText();
        String pass = passfld.getText();
        String con_pass = passconfld.getText();
        
        if(nom.equals("") || prenom.equals("") || username.equals("") || pass.equals("") || con_pass.equals("")  ){
                //System.out.println(listagents.getSelectedRow());
                JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
          }
        else if(!pass.equals(con_pass)){
               JOptionPane.showMessageDialog(this, "Les mots de passe ne sont pas identiques !", "mot de passe", JOptionPane.ERROR_MESSAGE);

        }else{
               try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            
            String query = "INSERT INTO utilisateur(nom, prenom,nom_utilisateur,mot_de_passe)VALUES(?, ?,?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nom);
            pstmt.setString(2,prenom);
            pstmt.setString(3,username);
            pstmt.setString(4,pass);
           
            pstmt.executeUpdate();
            clear();
            JOptionPane.showMessageDialog(this, "success", "l'agent est ajouté avec succes !", JOptionPane.CLOSED_OPTION);

            
            System.out.println("selected row : " +listagents.getSelectedRow());
            
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
    }//GEN-LAST:event_ajoubtnActionPerformed

    private void ajoubtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoubtnMouseClicked
        // TODO add your handling code here:
        String nom = nomfld.getText();
        String prenom = prenomfld.getText();
        String username = nomutifld.getText();
        String pass = passfld.getText();
        String con_pass = passconfld.getText();
        
        if(nom.equals("") || prenom.equals("") || username.equals("") || pass.equals("") || con_pass.equals("")  ){
                //System.out.println(listagents.getSelectedRow());
                JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
          }
        else if(!pass.equals(con_pass)){
               JOptionPane.showMessageDialog(this, "Les mots de passe ne sont pas identiques !", "mot de passe", JOptionPane.ERROR_MESSAGE);

        }else{
               try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            
            String query = "INSERT INTO utilisateur(nom, prenom,nom_utilisateur,mot_de_passe,role)VALUES(?, ?,?, ?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nom);
            pstmt.setString(2,prenom);
            pstmt.setString(3,username);
            pstmt.setString(4,pass);
            pstmt.setString(5,"Agent");
            
            pstmt.executeUpdate();
            clear();
            
            JOptionPane.showMessageDialog(this, "l'agent a été ajouté avec succes !", "success", JOptionPane.CLOSED_OPTION);
            showTableData();
            
            System.out.println("selected row : " +listagents.getSelectedRow());
            
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
    }//GEN-LAST:event_ajoubtnMouseClicked

    private void modbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modbtnMouseClicked
        // TODO add your handling code here:
        
        if(listagents.getSelectedRow() != -1){
           
        int indice = listagents.getSelectedRow();    
        String user_name = listagents.getModel().getValueAt(indice, 2).toString();
        
        String nom = nomfld.getText();
        String prenom = prenomfld.getText();
        String username = nomutifld.getText();
        String pass = passfld.getText();
        String con_pass = passconfld.getText();
        
        if(nom.equals("") || prenom.equals("") || username.equals("") || pass.equals("") || con_pass.equals("")  ){
                //System.out.println(listagents.getSelectedRow());
                JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
          }
        else if(!pass.equals(con_pass)){
               JOptionPane.showMessageDialog(this, "Les mots de passe ne sont pas identiques !", "mot de passe", JOptionPane.ERROR_MESSAGE);

        }else{
               try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query1 = "select id from utilisateur where nom_utilisateur='"+user_name+"'  ";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            ResultSet rs = pstmt1.executeQuery();
            
            int id = 0;
            
           
            while (rs.next()) {
                
                id = rs.getInt("id");
                
                
            }
            
            
            String query = "UPDATE utilisateur SET nom = ?,prenom = ?,nom_utilisateur = ?,mot_de_passe = ? WHERE id ='"+id+"'  ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nom);
            pstmt.setString(2,prenom);
            pstmt.setString(3,username);
            pstmt.setString(4,pass);
            
            pstmt.executeUpdate();
            clear();
            
            JOptionPane.showMessageDialog(this, "l'agent a été modifié avec succes !", "success", JOptionPane.CLOSED_OPTION);
            showTableData();
            
            System.out.println("selected row : " +listagents.getSelectedRow());
            
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
        }
        
    }//GEN-LAST:event_modbtnMouseClicked

    
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
            java.util.logging.Logger.getLogger(Infoagents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Infoagents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Infoagents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Infoagents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Infoagents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ajoubtn;
    private javax.swing.JTextField clrbtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listagents;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextField modbtn;
    private javax.swing.JTextField nomfld;
    private javax.swing.JTextField nomutifld;
    private javax.swing.JTextField passconfld;
    private javax.swing.JTextField passfld;
    private javax.swing.JTextField prenomfld;
    private javax.swing.JTextField supbtn;
    // End of variables declaration//GEN-END:variables
}
