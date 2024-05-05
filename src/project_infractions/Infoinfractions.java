package project_infractions;

import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Infoinfractions extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement stmt = null;
     public String[] columnNames = {"Id","type d'infraction","Date","heure","lieu","montant", "statut de paiement"};
    
    DefaultTableModel model = new DefaultTableModel();
    public int id_veh;
    public int id_inf;
    
    public Infoinfractions(int id) {
        initComponents();
        this.id_veh = id;
        payerbtn.setVisible(false);
        showTableData(id);
    }
    
    
    public void showTableData(int idd) {
        
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            model.setColumnIdentifiers(columnNames);
            infrtable.setModel(model);
            
            
            String sql2 = "SELECT infraction.id,typeinfraction.nom ,date_infraction,heure_infraction,lieu,montant,statut_paiement FROM infraction inner join typeinfraction on typeinfraction.id = infraction.type_infraction_id where vehicule_id='"+idd+"'";
            stmt = conn.prepareStatement(sql2);
            ResultSet rs2 = stmt.executeQuery();
              
            
            String type_infr="" ;
            Date date ;
            Time heure ;
            String lieu = "";
            double montant; 
            String statut = "";
            int id_in = 0;
           
            while(rs2.next()){
                type_infr = rs2.getString("nom");
                id_in = rs2.getInt("id");
                date = rs2.getDate("date_infraction");
                heure = rs2.getTime("heure_infraction");
                lieu = rs2.getString("lieu");
                montant = rs2.getDouble("montant");
                statut = rs2.getString("statut_paiement");
                System.out.println(lieu);
                model.addRow(new Object[]{id_in,type_infr, date, heure, lieu, montant, statut});

            }
            
            
            /////////////////
            
            
            String sql = "SELECT plaque_immatriculation,nom,marque FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id where vehicule.id='"+idd+"' ";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            String nom_conducteur = "";
            String matricule = "";
            String marque = "";
            
            while(rs.next()){
                matricule = rs.getString("plaque_immatriculation");
                nom_conducteur = rs.getString("nom");
                marque = rs.getString("marque");
            }
            nomconlbl.setText(nom_conducteur);
            matrlbl.setText(matricule);
            marquelbl.setText(marque);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        homebtn = new javax.swing.JButton();
        loginbtn2 = new javax.swing.JButton();
        matrlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomconlbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        marquelbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infrtable = new javax.swing.JTable();
        payerbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(785, 455));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SécuriRoute");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 231, 42));

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
        jPanel2.add(homebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 118, 44));

        loginbtn2.setBackground(new java.awt.Color(0, 153, 153));
        loginbtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginbtn2.setForeground(new java.awt.Color(255, 255, 255));
        loginbtn2.setText("Login");
        loginbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtn2ActionPerformed(evt);
            }
        });
        jPanel2.add(loginbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 118, 44));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 785, 80));

        matrlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matrlbl.setText("32122|A|22");
        jPanel1.add(matrlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 110, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Monsieur :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Matricule :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 30));

        nomconlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomconlbl.setText("YASSINE");
        jPanel1.add(nomconlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Marque de voiture :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 150, 30));

        marquelbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marquelbl.setText("AUDI");
        jPanel1.add(marquelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 150, 30));

        infrtable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        infrtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "type d'infraction", "Date", "heure", "lieu", "montant", "statut de paiement"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        infrtable.setRowHeight(32);
        infrtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infrtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(infrtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 750, 250));

        payerbtn.setBackground(new java.awt.Color(0, 153, 0));
        payerbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        payerbtn.setForeground(new java.awt.Color(255, 255, 255));
        payerbtn.setText("Payer");
        payerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payerbtnActionPerformed(evt);
            }
        });
        jPanel1.add(payerbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 100, 40));

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

    private void infrtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infrtableMouseClicked
       
        if(evt.getButton() == MouseEvent.BUTTON1){
            payerbtn.setVisible(true);
        }else if(evt.getButton() == MouseEvent.BUTTON3){
            payerbtn.setVisible(false);
            infrtable.clearSelection();

        }
    }//GEN-LAST:event_infrtableMouseClicked

    private void payerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payerbtnActionPerformed
        // TODO add your handling code here:
        System.out.println("hello payer");
        int indice = infrtable.getSelectedRow();
        
        int id = Integer.parseInt(infrtable.getValueAt(indice, 0).toString());
       
        new Paiement(id,this.id_veh, Double.parseDouble(infrtable.getValueAt(indice,5).toString())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_payerbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        new Recherchervoiture().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homebtnActionPerformed

    private void loginbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtn2ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginbtn2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Infoinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Infoinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Infoinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Infoinfractions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Infoinfractions(3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homebtn;
    private javax.swing.JTable infrtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginbtn2;
    private javax.swing.JLabel marquelbl;
    private javax.swing.JLabel matrlbl;
    private javax.swing.JLabel nomconlbl;
    private javax.swing.JButton payerbtn;
    // End of variables declaration//GEN-END:variables
}
