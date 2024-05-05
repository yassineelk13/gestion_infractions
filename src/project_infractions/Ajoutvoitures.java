package project_infractions;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Ajoutvoitures extends javax.swing.JFrame {

   public int id_vehicule;
   public String type;
    
    public Ajoutvoitures(int id,String type) {
        initComponents();
        this.id_vehicule = id;
        this.type = type;
        
        if(this.type.equals("ajout")){
            System.out.println("yes");
        }else{
             System.out.println("non");
        }
        
        if(type.equals("modif")){
    
               try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query1 = "SELECT plaque_immatriculation,CIN,annee,couleur,prenom,adresse,nom,marque,modele,note_permis FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id where vehicule.id='"+this.id_vehicule+"'  ";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            ResultSet rs = pstmt1.executeQuery();
            
            String Matricule = "";
            String CIN = "";
            String nom = "";
            String prenom = "";
            String adresse = "";
            String marque = "";
            String modele = "";
            String couleur = "";
            int note_permis=0 ;
            int annee = 0;
            
            int[] years = new int[2024 - 1970 + 1];
            for (int i = 0; i < years.length; i++) {
                years[i] = 1970 + i;
            }
            
            String[] numbers = new String[40 - 32 + 1];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.toString(32 + i);
            }

            
            while (rs.next()) {
                annee = rs.getInt("annee");
                Matricule = rs.getString("plaque_immatriculation");
                CIN = rs.getString("CIN");
                nom = rs.getString("nom");
                marque = rs.getString("marque");
                modele = rs.getString("modele");
                note_permis = rs.getInt("note_permis");
                prenom = rs.getString("prenom");
                adresse = rs.getString("adresse");
                couleur = rs.getString("couleur");
           
            }
            listannee.addItem("");
            for (int year : years)
            {                
                listannee.addItem("" + year);
            } 
            listnoteperfld.addItem("");
            for (String num : numbers) {
                listnoteperfld.addItem("" + num);
            }
           
            
           listannee.setSelectedItem(""+annee);
           listnoteperfld.setSelectedItem(""+note_permis);
           marquefld.setText(marque);
           modelefld.setText(modele);
           cinfld.setText(CIN);
           adressefld.setText(adresse);
           clrfld.setText(couleur);
           precondfld.setText(prenom);
           matrfld.setText(Matricule);
           nomcondfld.setText(nom);
            
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }else{
            
            typesubmitlbl.setText("Ajouter voiture :");
            submitbtn.setText("Ajouter");
            
            int[] years = new int[2024 - 1970 + 1];
            for (int i = 0; i < years.length; i++) {
                years[i] = 1970 + i;
            }
            
            String[] numbers = new String[40 - 32 + 1];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.toString(32 + i);
            }
            
            listannee.addItem("");
            for (int year : years)
            {                
                listannee.addItem("" + year);
            } 
            
            listnoteperfld.addItem("");
            for (String num : numbers) {
                listnoteperfld.addItem("" + num);
            }

            
        }
        
        
        }
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        marquefld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        matrfld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        modelefld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nomcondfld = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        precondfld = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        clrfld = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cinfld = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        typesubmitlbl = new javax.swing.JLabel();
        submitbtn = new javax.swing.JButton();
        listnoteperfld = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        adressefld = new javax.swing.JTextArea();
        listannee = new javax.swing.JComboBox<>();

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("jLabel1");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(787, 460));
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SécuriRoute");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 231, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Marque :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 113, 28));

        marquefld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(marquefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Matricule :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 113, 28));

        matrfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(matrfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("note de permis :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, 28));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Modèle :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 113, 28));

        modelefld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(modelefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nom de conducteur :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 160, 28));

        nomcondfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(nomcondfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Adresse :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 113, 28));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Année :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 113, 28));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Prenom de conducteur :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 180, 28));

        precondfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(precondfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 150, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Couleur :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 113, 28));

        clrfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(clrfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 150, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("CIN de conducteur :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 160, 28));

        cinfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(cinfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 150, 30));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 740, 10));

        typesubmitlbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        typesubmitlbl.setText("Modifier voiture :");
        jPanel2.add(typesubmitlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 290, 40));

        submitbtn.setBackground(new java.awt.Color(0, 153, 0));
        submitbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        submitbtn.setText("modifier");
        submitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitbtnMouseClicked(evt);
            }
        });
        jPanel2.add(submitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 150, 40));

        listnoteperfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(listnoteperfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 150, 30));

        adressefld.setColumns(20);
        adressefld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adressefld.setRows(5);
        jScrollPane1.setViewportView(adressefld);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 270, 90));

        listannee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(listannee, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 150, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 420));

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

    private void submitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitbtnMouseClicked
        // TODO add your handling code here:
 
     
        if(this.type.equals("modif")){
            String Matricule = matrfld.getText();
        String CIN = cinfld.getText();
        String nom = nomcondfld.getText();    
        String prenom = precondfld.getText();
        String adresse = adressefld.getText();
        String marque = marquefld.getText();
        String modele = modelefld.getText();
        String couleur = clrfld.getText();
        
        
        
        if(nom.equals("") || prenom.equals("") || Matricule.equals("") || CIN.equals("") || adresse.equals("") || marque.equals("") || modele.equals("") || couleur.equals("") || listnoteperfld.getSelectedItem().toString().equals("") || listannee.getSelectedItem().toString().equals("") ){
                //System.out.println(listagents.getSelectedRow());
                JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
          }
       else{
            
           int annee= Integer.parseInt(listannee.getSelectedItem().toString()) ;
             int note_permis = Integer.parseInt(listnoteperfld.getSelectedItem().toString());
               try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
            String query1 = "select conducteur_id from vehicule where id='"+this.id_vehicule+"'  ";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            ResultSet rs = pstmt1.executeQuery();
            
            int id = 0;
            
           
            while (rs.next()) {
                
                id = rs.getInt("conducteur_id");
                
                
            }
            
            
            String query = "UPDATE conducteur SET nom = ?,prenom = ?,adresse = ?,CIN = ?,note_permis = ? WHERE id ='"+id+"'  ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nom);
            pstmt.setString(2,prenom);
            pstmt.setString(3,adresse);
            pstmt.setString(4,CIN);
            pstmt.setInt(5,note_permis);
            
            pstmt.executeUpdate();
            
            String query3 = "UPDATE vehicule SET plaque_immatriculation = ?,annee=?,couleur=?,marque=?,modele=? WHERE id ='"+this.id_vehicule+"'";
            PreparedStatement pstmt3 = conn.prepareStatement(query3);
            pstmt3.setString(1,Matricule);
            pstmt3.setInt(2,annee);
            pstmt3.setString(3,couleur);
            pstmt3.setString(4,marque);
            pstmt3.setString(5,modele);
            
            pstmt3.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "voiture a été modifié avec succes !", "success", JOptionPane.CLOSED_OPTION);
           
            new Infovoitures().setVisible(true);
            this.dispose();
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
        }else if(this.type.equals("ajout")){
            
       String Matricule = matrfld.getText();
        String CIN = cinfld.getText();
        String nom = nomcondfld.getText();    
        String prenom = precondfld.getText();
        String adresse = adressefld.getText();
        String marque = marquefld.getText();
        String modele = modelefld.getText();
        String couleur = clrfld.getText();
        Connection conn = null;
        
        
        System.out.println("wakha!");

        if(nom.equals("") || prenom.equals("") || Matricule.equals("") || CIN.equals("") || adresse.equals("") || marque.equals("") || modele.equals("") || couleur.equals("") || listnoteperfld.getSelectedItem().toString().equals("") || listannee.getSelectedItem().toString().equals("")  ){
                //System.out.println(listagents.getSelectedRow());
                JOptionPane.showMessageDialog(this, "veuillez replissez les champs !", "champs vides", JOptionPane.ERROR_MESSAGE);
          }
       else{
            int annee= Integer.parseInt(listannee.getSelectedItem().toString()) ;
            int note_permis = Integer.parseInt(listnoteperfld.getSelectedItem().toString());
            
            try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
      
          
          
            String query = "Insert into conducteur(nom,prenom,adresse,CIN,note_permis)values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nom);
            pstmt.setString(2,prenom);
            pstmt.setString(3,adresse);
            pstmt.setString(4,CIN);
            pstmt.setInt(5,note_permis);
            
            pstmt.executeUpdate();
            conn.close();
            
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            
            String query1 = "select id from conducteur where CIN='"+CIN+"'";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            ResultSet rs = pstmt1.executeQuery();
            
            int id_cond = 0;
            
           
            while (rs.next()) {
                
                 id_cond = rs.getInt("id");
                
                
            }
            
            
            String query3 = "insert into vehicule (plaque_immatriculation,annee,couleur,marque,modele,conducteur_id)values(?,?,?,?,?,?)";
            PreparedStatement pstmt3 = conn.prepareStatement(query3);
            pstmt3.setString(1,Matricule);
            pstmt3.setInt(2,annee);
            pstmt3.setString(3,couleur);
            pstmt3.setString(4,marque);
            pstmt3.setString(5,modele);
            pstmt3.setInt(6,id_cond);
            
            pstmt3.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "voiture a été ajouté avec succes !", "success", JOptionPane.CLOSED_OPTION);
           
            new Infovoitures().setVisible(true);
            this.dispose();
            
            
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
            
            
        }
                
    }//GEN-LAST:event_submitbtnMouseClicked

   
    
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
            java.util.logging.Logger.getLogger(Ajoutvoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajoutvoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajoutvoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajoutvoitures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Ajoutvoitures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea adressefld;
    private javax.swing.JTextField cinfld;
    private javax.swing.JTextField clrfld;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JComboBox<String> listannee;
    private javax.swing.JComboBox<String> listnoteperfld;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextField marquefld;
    private javax.swing.JTextField matrfld;
    private javax.swing.JTextField modelefld;
    private javax.swing.JTextField nomcondfld;
    private javax.swing.JTextField precondfld;
    private javax.swing.JButton submitbtn;
    private javax.swing.JLabel typesubmitlbl;
    // End of variables declaration//GEN-END:variables
}
