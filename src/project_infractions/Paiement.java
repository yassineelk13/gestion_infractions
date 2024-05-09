package project_infractions;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paiement extends javax.swing.JFrame {

    public int id_inf;
    public int id_veh;
   
    public Paiement(int id,int id_v,Double m) {
        initComponents();
        this.id_inf = id;
        this.id_veh = id_v;
        montantlbl.setText(m.toString());
        printxt.setVisible(false);
        printbtn.setVisible(false);

    }

    
    private boolean validateCreditCardNumber(String cardNumber) {
    // Vérifiez que le numéro de carte comporte 16 chiffres et passe le test de Luhn
    // Retourne vrai si le numéro de carte est valide, sinon faux
    // Exemple simplifié de validation :
    return cardNumber.matches("\\d{16}");
}

private boolean validateExpirationDate(String expirationDate) {
    // Vérifiez que la date d'expiration est au format MM/AAAA et ultérieure à la date actuelle
    // Retourne vrai si la date d'expiration est valide, sinon faux
    // Exemple simplifié de validation :
    return expirationDate.matches("(0[1-9]|1[0-2])/20\\d{2}");
}

private boolean validateSecurityCode(String securityCode) {
    // Vérifiez que le code de sécurité comporte 3 ou 4 chiffres
    // Retourne vrai si le code de sécurité est valide, sinon faux
    // Exemple simplifié de validation :
    return securityCode.matches("\\d{3,4}");
}

private boolean validatePaymentDetails() {
    String cardNumber = numcartefld.getText();
    String expirationDate = dateexpfld.getText();
    String securityCode = codesecfld.getText();

    boolean isValid = true;

    // Valider le numéro de carte de crédit
    if (!validateCreditCardNumber(cardNumber)) {
        isValid = false;
        JOptionPane.showMessageDialog(this, "Numéro de carte invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    // Valider la date d'expiration
    if (!validateExpirationDate(expirationDate)) {
        isValid = false;
        JOptionPane.showMessageDialog(this, "Date d'expiration invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    // Valider le code de sécurité
    if (!validateSecurityCode(securityCode)) {
        isValid = false;
        JOptionPane.showMessageDialog(this, "Code de sécurité invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    return isValid;

}
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginbtn2 = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        montantlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        printbtn = new javax.swing.JButton();
        dateexpfld = new javax.swing.JTextField();
        codesecfld = new javax.swing.JTextField();
        numcartefld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        printxt = new javax.swing.JTextArea();
        payerbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(785, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SécuriRoute");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 231, 42));

        loginbtn2.setBackground(new java.awt.Color(0, 153, 153));
        loginbtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginbtn2.setForeground(new java.awt.Color(255, 255, 255));
        loginbtn2.setText("Login");
        loginbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtn2ActionPerformed(evt);
            }
        });
        jPanel2.add(loginbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 118, 44));

        homebtn.setBackground(new java.awt.Color(0, 204, 102));
        homebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homebtn.setForeground(new java.awt.Color(255, 255, 255));
        homebtn.setText("Retour");
        homebtn.setBorder(null);
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });
        jPanel2.add(homebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 118, 44));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 785, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Montant à payer :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));

        montantlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montantlbl.setText("100.00");
        jPanel1.add(montantlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Code de sécurité :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Numéro de carte :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date d'expiration :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 160, 30));

        printbtn.setBackground(new java.awt.Color(0, 153, 51));
        printbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printbtn.setForeground(new java.awt.Color(255, 255, 255));
        printbtn.setText("Print");
        printbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printbtnMouseClicked(evt);
            }
        });
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });
        jPanel1.add(printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 140, 40));

        dateexpfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateexpfld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateexpfldActionPerformed(evt);
            }
        });
        jPanel1.add(dateexpfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 220, -1));

        codesecfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(codesecfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 220, -1));
        jPanel1.add(numcartefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 220, -1));

        printxt.setColumns(20);
        printxt.setRows(5);
        printxt.setText("montant : 300");
        jScrollPane1.setViewportView(printxt);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, 270));

        payerbtn.setBackground(new java.awt.Color(0, 153, 51));
        payerbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        payerbtn.setForeground(new java.awt.Color(255, 255, 255));
        payerbtn.setText("Payer");
        payerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payerbtnActionPerformed(evt);
            }
        });
        jPanel1.add(payerbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 140, 40));

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

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_printbtnActionPerformed

    private void dateexpfldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateexpfldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateexpfldActionPerformed

    private void payerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payerbtnActionPerformed
        // TODO add your handling code here:
    String cardNumber = numcartefld.getText();
    String expirationDate = dateexpfld.getText();
    String securityCode = codesecfld.getText();
    double amount = Double.parseDouble(montantlbl.getText());//1111111111111111 
     LocalDate date = LocalDate.now(); 
     LocalTime heure = LocalTime.now();
     
    String type_infr="" ;
     
    if (validatePaymentDetails()) {
        
        ////////////////////
        
          try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            String sql = "UPDATE infraction SET statut_paiement = ? WHERE id ='"+this.id_inf+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"payée");
            stmt.executeUpdate();
            
            
            String sql2 = "SELECT typeinfraction.nom  FROM infraction inner join typeinfraction on typeinfraction.id = infraction.type_infraction_id where infraction.id='"+this.id_inf+"'";
            stmt = conn.prepareStatement(sql2);
            ResultSet rs2 = stmt.executeQuery();
              
            
            

           
            while(rs2.next()){
                type_infr = rs2.getString("nom");
               

            }
            
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        // Si les informations de paiement sont valides, procédez au traitement du paiement
       
        printxt.setText("********Facture de paiement********\n\n\n\n\n\n"+"type d'nfraction : "+type_infr+"\n"+"Date : "+date+"\nHeure : "+heure+"\n\nMontant payée : "+amount);
         JOptionPane.showMessageDialog(this, "Paiement de " + amount + " € effectué avec succès.", "Confirmation de paiement", JOptionPane.INFORMATION_MESSAGE);
         numcartefld.setText("");
         dateexpfld.setText("");
         codesecfld.setText("");
         printxt.setVisible(true);
         printbtn.setVisible(true);
         
    }
    }//GEN-LAST:event_payerbtnActionPerformed

    private void printbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbtnMouseClicked
        // TODO add your handling code here:
        try {
            printxt.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Paiement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printbtnMouseClicked

    private void loginbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtn2ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginbtn2ActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        new Infoinfractions(this.id_veh).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homebtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(Paiement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paiement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paiement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paiement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new Paiement(100.00).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codesecfld;
    private javax.swing.JTextField dateexpfld;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JButton loginbtn1;
    private javax.swing.JButton loginbtn2;
    private javax.swing.JLabel montantlbl;
    private javax.swing.JTextField numcartefld;
    private javax.swing.JButton payerbtn;
    private javax.swing.JButton printbtn;
    private javax.swing.JTextArea printxt;
    // End of variables declaration//GEN-END:variables
}
