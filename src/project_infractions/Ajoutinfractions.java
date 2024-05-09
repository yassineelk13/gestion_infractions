package project_infractions;


import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Ajoutinfractions extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement stmt = null;
    DefaultTableModel model = new DefaultTableModel();
    public int id_v;
    public String mode;
    public int id_inf;
    
    
    public Ajoutinfractions(int id,int id_inf,String str) {
        initComponents();
        this.id_v = id;
        this.mode = str;
        this.id_inf = id_inf;
        System.out.println(id);
        getVehicule(id);
        remplirComboBox();
        
        
             if(str.equals("modif")){
                  
            modelbl.setText("Modifier infraction :");
            ajoutbtn.setText("Modifier");
               try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
               String query1 = "SELECT typeinfraction.nom ,lieu,montant FROM infraction inner join typeinfraction on typeinfraction.id = infraction.type_infraction_id where infraction.id='"+this.id_inf+"'";
         
            //String query1 = "SELECT plaque_immatriculation,CIN,annee,couleur,prenom,adresse,nom,marque,modele,note_permis FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id where vehicule.id='"+this.id_vehicule+"'  ";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            ResultSet rs = pstmt1.executeQuery();
            
            
            String type_inf = "";
            String lieu = "";
            double montant = 0;
            
            
            while (rs.next()) {
                
                type_inf = rs.getString("nom");
                lieu = rs.getString("lieu");
                montant = rs.getDouble("montant");
           
            }
            
           
            
           listinfrac.setSelectedItem(""+type_inf);
           lieufld.setText(lieu);
           montfld.setValue(montant);
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
             }
    
    public int getId(){
        return this.id_v;
    }
    
    public void remplirComboBox(){
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            Statement statement = conn.createStatement();
            String sql = "select * from typeinfraction";
            ResultSet result = statement.executeQuery(sql);
            listinfrac.addItem("");
            
            while(result.next()){
                listinfrac.addItem(result.getString("nom"));  
            }
      
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getVehicule(int id){
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            String sql = "SELECT plaque_immatriculation,nom FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id where vehicule.id='"+id+"' ";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            String nom_conducteur = "";
            String matricule = "";
            
            while(rs.next()){
                matricule = rs.getString("plaque_immatriculation");
                nom_conducteur = rs.getString("nom");
            }
            proprlbl.setText(nom_conducteur);
            matrlbl.setText(matricule);
              // System.out.println(lieu);
              
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        proprlbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ajoutbtn = new javax.swing.JButton();
        res = new javax.swing.JLabel();
        listinfrac = new javax.swing.JComboBox<>();
        modelbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        matrlbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lieufld = new javax.swing.JTextField();
        montfld = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(785, 455));
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SécuriRoute");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 231, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        proprlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        proprlbl.setText("bomy");
        jPanel2.add(proprlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("lieu :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 104, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("montant :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 40));

        ajoutbtn.setBackground(new java.awt.Color(0, 204, 0));
        ajoutbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ajoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        ajoutbtn.setText("Ajouter");
        ajoutbtn.setOpaque(true);
        ajoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutbtnActionPerformed(evt);
            }
        });
        jPanel2.add(ajoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 130, 40));

        res.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        res.setForeground(new java.awt.Color(0, 153, 51));
        jPanel2.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 376, 190, 34));

        listinfrac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(listinfrac, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 230, 40));

        modelbl.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        modelbl.setText("Ajouter infraction :");
        jPanel2.add(modelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 289, 42));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("type d'infraction :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Propriétaire :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 130, 30));

        matrlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matrlbl.setText("32908A23");
        jPanel2.add(matrlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 170, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Matricule :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 140, 30));

        lieufld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lieufld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lieufldActionPerformed(evt);
            }
        });
        jPanel2.add(lieufld, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 230, 40));

        montfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montfld.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        montfld.setToolTipText("");
        jPanel2.add(montfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 120, 40));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 620, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, 800, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void ajoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutbtnActionPerformed
        // TODO add your handling code here:
        
        if(this.mode.equals("ajout")){
            String type_inf = listinfrac.getSelectedItem().toString();
        String lieu = lieufld.getText();
        //Double montant = Double.parseDouble(montantfld.getText().toString());
        Double montant = Double.parseDouble(montfld.getValue().toString());
        LocalDate date = LocalDate.now(); // Create a date object
        Date sqlDate = Date.valueOf(date);
        LocalTime heure = LocalTime.now();
        Time sqlheure = Time.valueOf(heure);
        String statut = "en_attente";
        int id_inf = listinfrac.getSelectedIndex();
          if(type_inf.equals("") || lieu.equals("") || montant == 0){
                System.out.println(listinfrac.getSelectedIndex());
                JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
          }
          else{
               try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            
            String query = "INSERT INTO infraction(date_infraction, heure_infraction,lieu,montant,statut_paiement,vehicule_id,type_infraction_id)VALUES(?, ?,?,?, ?,?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDate(1,sqlDate);
            pstmt.setTime(2,sqlheure);
            pstmt.setString(3,lieu);
            pstmt.setDouble(4,montant);
            pstmt.setString(5,statut);
            pstmt.setInt(6,getId());
            pstmt.setInt(7,id_inf);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "l'infraction a été ajouté avec succes !", "success", JOptionPane.CLOSED_OPTION);

            new Infractions(getId()).setVisible(true);
            this.dispose();
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
        }else{
            
            
            String type_inf = listinfrac.getSelectedItem().toString();
            String lieu = lieufld.getText();
            //Double montant = Double.parseDouble(montantfld.getText().toString());
            Double montant = Double.parseDouble(montfld.getValue().toString());

            int id_type_inf = listinfrac.getSelectedIndex();
            if(type_inf.equals("") || lieu.equals("") || montant == 0){
                    System.out.println(listinfrac.getSelectedIndex());
                    JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
            }
              
            else{
               try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            
            String query = "UPDATE infraction SET type_infraction_id = ?,montant = ?,lieu = ? WHERE id ='"+this.id_inf+"'  ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id_type_inf);
            pstmt.setDouble(2,montant);
            pstmt.setString(3,lieu);
           
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "l'infraction a été modifié avec succes !", "success", JOptionPane.CLOSED_OPTION);

            new Infractions(getId()).setVisible(true);
            this.dispose();
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
            
            
            
        }
        
       
    
    }//GEN-LAST:event_ajoutbtnActionPerformed

    private void lieufldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lieufldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lieufldActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        new InterAutorite().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_homebtnActionPerformed

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
            java.util.logging.Logger.getLogger(Ajoutinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajoutinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajoutinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajoutinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Ajoutinfractions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutbtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lieufld;
    private javax.swing.JComboBox<String> listinfrac;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JLabel matrlbl;
    private javax.swing.JLabel modelbl;
    private javax.swing.JSpinner montfld;
    private javax.swing.JLabel proprlbl;
    private javax.swing.JLabel res;
    // End of variables declaration//GEN-END:variables
}
