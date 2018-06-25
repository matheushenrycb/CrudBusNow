package View;

import controller.CarroMapeamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CarroModelo;

public class ListaVeiculo extends javax.swing.JFrame {
    List<CarroMapeamento> listaCarro;
    CarroModelo cModel;
    DefaultTableModel modelo;

    public ListaVeiculo() {
        initComponents();
        listaCarro = new ArrayList<>();
        this.cModel = new CarroModelo();
        setTabelaVeiculo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tab_veiculo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab_veiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Modelo", "Ano", "Cor", "chassi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab_veiculo);

        jLabel1.setText("Lista de Veiculos");

        jToggleButton1.setText("Cancelar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText(" Editar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Excluir");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jToggleButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        try{    
            new CarroModelo().remover(listaCarro.get(tab_veiculo.getSelectedRow())); 
            modelo = (DefaultTableModel) tab_veiculo.getModel();
            modelo.removeRow(tab_veiculo.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Sucesso ao remover carro");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao remover carro\n" + e);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        VeiculoView editarVeiculo = new VeiculoView();
        editarVeiculo.editar(listaCarro.get(tab_veiculo.getSelectedRow()));
        editarVeiculo.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed
  
    private void setTabelaVeiculo(){
        modelo = (DefaultTableModel) tab_veiculo.getModel();
        listaCarro = cModel.buscarTodos();
        modelo.setRowCount(0);
        for (int i = 0; i < listaCarro.size(); i++) {
            modelo.addRow(new Object[]{ 
                listaCarro.get(i).getMarca(), 
                listaCarro.get(i).getModelo(), 
                listaCarro.get(i).getAno(), 
                listaCarro.get(i).getCor(), 
                listaCarro.get(i).getChassi()
                });
        }
        
        tab_veiculo.setModel(modelo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTable tab_veiculo;
    // End of variables declaration//GEN-END:variables

}
