
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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;




public class Infractions extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement stmt = null;
    public String[] columnNames = {"Id","type d'infraction","Date","heure","lieu","montant", "statut de paiement"};
    public int id_v ;
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<TableModel> rowSorter;
    
    public int id;
    public Infractions(int id) {
        this.id =id;
        initComponents();
        showTableData(id);
        modifierbtn.setVisible(false);
        suppbtn.setVisible(false);
        this.id_v = id;
        initializeSearch();
    }
    
    private void initializeSearch() {
        // Création d'un rowSorter pour le modèle de tableau
        rowSorter = new TableRowSorter<>(infrtable.getModel());
        infrtable.setRowSorter(rowSorter);
        
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

      public void showTableData(int idd) {
        
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
            model.setColumnIdentifiers(columnNames);
            infrtable.setModel(model);
            
            
            String sql2 = "SELECT infraction.id ,typeinfraction.nom ,date_infraction,heure_infraction,lieu,montant,statut_paiement FROM infraction inner join typeinfraction on typeinfraction.id = infraction.type_infraction_id where vehicule_id='"+idd+"'";
            stmt = conn.prepareStatement(sql2);
            ResultSet rs2 = stmt.executeQuery();
              
            
            String type_infr="" ;
            Date date ;
            Time heure ;
            String lieu = "";
            double montant; 
            String statut = "";
            int id_inf = 0;
           
            while(rs2.next()){
                type_infr = rs2.getString("nom");
                date = rs2.getDate("date_infraction");
                heure = rs2.getTime("heure_infraction");
                lieu = rs2.getString("lieu");
                id_inf = rs2.getInt("id");
                montant = rs2.getDouble("montant");
                statut = rs2.getString("statut_paiement");
                System.out.println(lieu);
                model.addRow(new Object[]{id_inf,type_infr, date, heure, lieu, montant, statut});
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
        jScrollPane1 = new javax.swing.JScrollPane();
        infrtable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        proprlbl = new javax.swing.JLabel();
        matrilbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ajoutinfrbtn1 = new javax.swing.JButton();
        rechefld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modifierbtn = new javax.swing.JButton();
        suppbtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Bonjour Autorité");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(787, 477));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Bonjour Autorité");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 88, 251, 32));

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
        if (infrtable.getColumnModel().getColumnCount() > 0) {
            infrtable.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 710, 240));

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SécuriRoute");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 231, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Propriétaire d'infraction :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 190, 30));

        proprlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        proprlbl.setText("yassine");
        jPanel2.add(proprlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 70, 30));

        matrilbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matrilbl.setText("239032|A|22");
        jPanel2.add(matrilbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Rechercher :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, 30));

        ajoutinfrbtn1.setBackground(new java.awt.Color(0, 204, 102));
        ajoutinfrbtn1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ajoutinfrbtn1.setForeground(new java.awt.Color(255, 255, 255));
        ajoutinfrbtn1.setText("+Ajouter ");
        ajoutinfrbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutinfrbtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(ajoutinfrbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, 40));

        rechefld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rechefld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechefldActionPerformed(evt);
            }
        });
        jPanel2.add(rechefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 170, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Matricule :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 100, 30));

        modifierbtn.setBackground(new java.awt.Color(0, 204, 102));
        modifierbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        modifierbtn.setForeground(new java.awt.Color(255, 255, 255));
        modifierbtn.setText("Modifier");
        modifierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierbtnActionPerformed(evt);
            }
        });
        jPanel2.add(modifierbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, 40));

        suppbtn.setBackground(new java.awt.Color(0, 204, 102));
        suppbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        suppbtn.setForeground(new java.awt.Color(255, 255, 255));
        suppbtn.setText("Supprimer");
        suppbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppbtnActionPerformed(evt);
            }
        });
        jPanel2.add(suppbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infrtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infrtableMouseClicked
        // TODO add your handling code here:
        if(evt.getButton() == MouseEvent.BUTTON1){
           modifierbtn.setVisible(true);
           suppbtn.setVisible(true);
        }else if(evt.getButton() == MouseEvent.BUTTON3){
           modifierbtn.setVisible(false);
           suppbtn.setVisible(false);
            infrtable.clearSelection();
            
        }
                
    }//GEN-LAST:event_infrtableMouseClicked

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

    private void rechefldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechefldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechefldActionPerformed

    private void ajoutinfrbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutinfrbtn1ActionPerformed
        // TODO add your handling code here:
        new Ajoutinfractions(id_v,0,"ajout").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ajoutinfrbtn1ActionPerformed

    private void modifierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierbtnActionPerformed
        // TODO add your handling code here:
         int indice = infrtable.getSelectedRow();
        
        int id = Integer.parseInt(infrtable.getValueAt(indice, 0).toString());
        new Ajoutinfractions(id_v,id,"modif").setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_modifierbtnActionPerformed

    private void suppbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppbtnActionPerformed
        // TODO add your handling code here:
           //if(listvoiture.getSelectedRow() != -1){
           
       int option = JOptionPane.showConfirmDialog(this, "Vous êtes sûr de vouloir supprimer ?", "Supprimer", JOptionPane.YES_NO_OPTION);
       
       if (option == JOptionPane.YES_OPTION) {
        int indice = infrtable.getSelectedRow(); 
        int id_inf = Integer.parseInt(infrtable.getModel().getValueAt(indice, 0).toString());
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project_infractions", "root", "");
            System.out.println("Connected!");
              
            String query2 = "DELETE FROM infraction WHERE id ='"+id_inf+"'  ";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.execute();
            
            
            JOptionPane.showMessageDialog(this, "l'infraction a été supprimé avec succes !", "success", JOptionPane.CLOSED_OPTION);
            new Infractions(this.id).setVisible(true);
            this.dispose();
        
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       } 
     
       
        
    }//GEN-LAST:event_suppbtnActionPerformed

 
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JLabel matrilbl;
    private javax.swing.JButton modifierbtn;
    private javax.swing.JLabel proprlbl;
    private javax.swing.JTextField rechefld;
    private javax.swing.JButton suppbtn;
    // End of variables declaration//GEN-END:variables
}
