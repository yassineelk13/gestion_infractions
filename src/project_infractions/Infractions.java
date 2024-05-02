
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




public class Infractions extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement stmt = null;
    public String[] columnNames = {"type d'infraction","Date","heure","lieu","montant", "statut de paiement"};
    public int id_v ;
    DefaultTableModel model = new DefaultTableModel();
    
    //public int id;
    public Infractions(int id) {
        initComponents();
        showTableData(id);
        //payerbtn.setVisible(false);
        this.id_v = id;
    }
    
  /*  public void getId(int id){
        this.id = id;
    }*/

      public void showTableData(int idd) {
        
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            model.setColumnIdentifiers(columnNames);
            infrtable.setModel(model);
            
            
            String sql2 = "SELECT typeinfraction.nom ,date_infraction,heure_infraction,lieu,montant,statut_paiement FROM infraction inner join typeinfraction on typeinfraction.id = infraction.type_infraction_id where vehicule_id='"+idd+"'";
            stmt = conn.prepareStatement(sql2);
            ResultSet rs2 = stmt.executeQuery();
              
            
            String type_infr="" ;
            Date date ;
            Time heure ;
            String lieu = "";
            double montant; 
            String statut = "";
           
            while(rs2.next()){
                type_infr = rs2.getString("nom");
                date = rs2.getDate("date_infraction");
                heure = rs2.getTime("heure_infraction");
                lieu = rs2.getString("lieu");
                montant = rs2.getDouble("montant");
                statut = rs2.getString("statut_paiement");
                System.out.println(lieu);
                model.addRow(new Object[]{type_infr, date, heure, lieu, montant, statut});

            }
            
            
            /////////////////
            
            
            String sql = "SELECT plaque_immatriculation,nom FROM vehicule INNER JOIN conducteur ON vehicule.conducteur_id = conducteur.id where vehicule.id='"+idd+"' ";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            String nom_conducteur = "";
            String matricule = "";
            
            while(rs.next()){
                matricule = rs.getString("plaque_immatriculation");
                nom_conducteur = rs.getString("nom");
            }
            proprlbl.setText(nom_conducteur);
            matrilbl.setText(matricule);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        matrilbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infrtable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        proprlbl = new javax.swing.JLabel();
        ajoutinfrbtn1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Bonjour Autorité");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(787, 477));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Bonjour Autorité");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 88, 251, 32));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Matricule :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 70, 30));

        matrilbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        matrilbl.setText("239032|A|22");
        getContentPane().add(matrilbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 150, 30));

        infrtable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        infrtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "type d'infraction", "Date", "heure", "lieu", "montant", "statut de paiement"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 710, 250));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Propriétaire d'infraction :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, 30));

        proprlbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        proprlbl.setText("yassine");
        getContentPane().add(proprlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 150, 30));

        ajoutinfrbtn1.setBackground(new java.awt.Color(0, 204, 102));
        ajoutinfrbtn1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ajoutinfrbtn1.setText("+Ajouter nouvelle infraction");
        ajoutinfrbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutinfrbtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(ajoutinfrbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, 40));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        logoutbtn.setBackground(new java.awt.Color(255, 51, 51));
        logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutbtn.setText("Deconnection");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        homebtn.setBackground(new java.awt.Color(0, 204, 102));
        homebtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infrtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infrtableMouseClicked
        // TODO add your handling code here:
        if(evt.getButton() == MouseEvent.BUTTON1){
           // payerbtn.setVisible(true);
        }else if(evt.getButton() == MouseEvent.BUTTON3){
            //payerbtn.setVisible(false);
            infrtable.clearSelection();
            
        }
                
    }//GEN-LAST:event_infrtableMouseClicked

    private void ajoutinfrbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutinfrbtn1ActionPerformed
        // TODO add your handling code here:
             new Ajoutinfractions(id_v).setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ajoutinfrbtn1ActionPerformed

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

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Infractions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutinfrbtn1;
    private javax.swing.JButton homebtn;
    private javax.swing.JTable infrtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JLabel matrilbl;
    private javax.swing.JLabel proprlbl;
    // End of variables declaration//GEN-END:variables
}
