/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Tabelas.TabelaPaciente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import model.conexao.Conexao;
import model.bean.AgendaConsulta;
import model.dao.AgendaDao;
/**
 *
 * @author Vaio
 */
public class Agendamento extends javax.swing.JFrame {
       Conexao con = new Conexao();
       AgendaDao dao = new AgendaDao();
       AgendaConsulta agenda = new AgendaConsulta();
    /**
     * Creates new form Agendamento
     */
    public Agendamento() {
        initComponents();
        preencherMedicos();
       
    }
    public void HabilitarCampos(){
        comboturno.setEnabled(true);
        combomedicos.setEnabled(true);  
        Camdodata.setEnabled(true);
        txtmotivo.setEnabled(true);
    }
    public void LimparTabelas(){
        tabelabuscapaciente.clearSelection();
        
    }
    public void BloquearCampos(){
        comboturno.setEnabled(false);
        combomedicos.setEnabled(false);  
        Camdodata.setEnabled(false);
        txtmotivo.setEnabled(false);
    }
    public void HabilitarBotões(){
        btnFinalizar.setEnabled(true);
        btncancelar.setEnabled(true);
    }
    public void LimparCampos(){
       comboturno.setSelectedItem("");
       combomedicos.setSelectedItem("");
       txtpaciente.setText("");
       Camdodata.setDate(null);
       txtmotivo.setText(""); 
    }
    
    public void preencherMedicos(){
       Conexao.getConnection();
        con.executaSql("select * from medico order by nome");
        try {
            con.rs.first();
            combomedicos.removeAllItems();
            do {                
                combomedicos.addItem(con.rs.getString("nome"));
            } while (con.rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher medicos"+e);
        }
        con.desconecta();
    }
       
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtpaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelabuscapaciente = new javax.swing.JTable();
        btnbuscarpac = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboturno = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        combomedicos = new javax.swing.JComboBox<>();
        btncancelar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        Camdodata = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmotivo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Paciente:");

        jLabel3.setText("Médico:");

        jLabel4.setText("Motivo:");

        tabelabuscapaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelabuscapaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelabuscapacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelabuscapaciente);

        btnbuscarpac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/procurar.png"))); // NOI18N
        btnbuscarpac.setToolTipText("Buscar");
        btnbuscarpac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarpacActionPerformed(evt);
            }
        });

        jLabel5.setText("Turno:");

        comboturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno" }));
        comboturno.setEnabled(false);

        jLabel6.setText("Data:");

        combomedicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combomedicos.setEnabled(false);
        combomedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomedicosActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.setEnabled(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        Camdodata.setEnabled(false);

        txtmotivo.setColumns(20);
        txtmotivo.setRows(5);
        txtmotivo.setEnabled(false);
        jScrollPane2.setViewportView(txtmotivo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscarpac)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboturno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combomedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Camdodata, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarpac)
                    .addComponent(jLabel5)
                    .addComponent(comboturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Camdodata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combomedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnFinalizar))
                .addGap(32, 32, 32))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agendamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(835, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarpacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarpacActionPerformed
       preencherTabelaPaciente("select paciente.Id_paciente, paciente.nome, paciente.telefone, paciente.rg, bairro.nomebairro from paciente inner join bairro on paciente.Id_bairro = bairro.Id_bairro where nome like'%"+txtpaciente.getText()+"%'");
    }//GEN-LAST:event_btnbuscarpacActionPerformed

    private void tabelabuscapacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelabuscapacienteMouseClicked
      String nome = ""+tabelabuscapaciente.getValueAt(tabelabuscapaciente.getSelectedRow(), 1);
       Conexao.getConnection();
       con.executaSql("select * from paciente where nome='"+nome+"'");
        try {
            con.rs.first();           
            txtpaciente.setText(con.rs.getString("nome"));
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados"+ex);
        }
        con.desconecta();
        HabilitarCampos();
        HabilitarBotões();
        
    }//GEN-LAST:event_tabelabuscapacienteMouseClicked

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (txtmotivo.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Informe o motivo!");
         txtmotivo.requestFocus();
        }
        agenda.setNomePaciente(txtpaciente.getText());
        agenda.setNomeMedico((String)combomedicos.getSelectedItem());
        agenda.setTurno((String)comboturno.getSelectedItem());
        agenda.setMotivo(txtmotivo.getText());
        agenda.setData(Camdodata.getDate());
        agenda.setStatus("Aberto");
        dao.salvar(agenda);
        con.desconecta();
        dispose();
        LimparCampos();
        BloquearCampos();
        
        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        LimparCampos();
        BloquearCampos();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void combomedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combomedicosActionPerformed

     public void preencherTabelaPaciente(String Sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"ID","Nome","Telefone","RG","Bairro" };
        Conexao.getConnection();
        con.executaSql(Sql);
        try {
            con.rs.first();
            do{                    
                  dados.add(new Object[]{con.rs.getInt("paciente.Id_paciente"),con.rs.getString("paciente.nome"),con.rs.getString("paciente.telefone"),con.rs.getInt("paciente.rg"),con.rs.getString("bairro.nomebairro")});
                } while (con.rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Busque Novamente");
        }
         TabelaPaciente tabela = new TabelaPaciente(dados, colunas);
         tabelabuscapaciente.setModel(tabela);
         tabelabuscapaciente.getColumnModel().getColumn(0).setPreferredWidth(30);
         tabelabuscapaciente.getColumnModel().getColumn(0).setResizable(true);
         tabelabuscapaciente.getColumnModel().getColumn(1).setPreferredWidth(190);
         tabelabuscapaciente.getColumnModel().getColumn(1).setResizable(true);
         tabelabuscapaciente.getColumnModel().getColumn(2).setPreferredWidth(150);
         tabelabuscapaciente.getColumnModel().getColumn(2).setResizable(true);
         tabelabuscapaciente.getColumnModel().getColumn(3).setPreferredWidth(190);
         tabelabuscapaciente.getColumnModel().getColumn(3).setResizable(true);
         tabelabuscapaciente.getColumnModel().getColumn(4).setPreferredWidth(160);
         tabelabuscapaciente.getColumnModel().getColumn(4).setResizable(true);
         tabelabuscapaciente.getTableHeader().setReorderingAllowed(true);
         tabelabuscapaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         tabelabuscapaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         con.desconecta();
    }
    
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Agendamento().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Camdodata;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnbuscarpac;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox<String> combomedicos;
    private javax.swing.JComboBox<String> comboturno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelabuscapaciente;
    private javax.swing.JTextArea txtmotivo;
    private javax.swing.JTextField txtpaciente;
    // End of variables declaration//GEN-END:variables
}
