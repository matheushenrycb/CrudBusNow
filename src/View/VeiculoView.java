package View;

import controller.CarroMapeamento;
import javax.swing.JOptionPane;
import model.CarroModelo;

public class VeiculoView extends javax.swing.JFrame {

   CarroMapeamento car;
    boolean editar = false;
    public VeiculoView() {
        this.car = new CarroMapeamento();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_chassi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        txt_ano = new javax.swing.JTextField();
        txt_cor = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btncadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Marca:");

        jLabel2.setText(" Ano:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Cor:");

        jLabel5.setText("Chassi:");

        jLabel6.setText("Cadastro deVeiculos");

        btncadastro.setText("Cadastrar");
        btncadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txt_chassi, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btncadastro)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_chassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btncadastro)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        car.setMarca(txt_marca.getText());
        car.setModelo(txt_modelo.getText());
        car.setAno(Integer.parseInt(txt_ano.getText()));
        car.setCor(txt_cor.getText());
        car.setChassi(txt_chassi.getText());
        try {
            if (editar) {
                new CarroModelo().editar(car);
                JOptionPane.showMessageDialog(null, "Registrado com Sucesso");
            }else if(!editar){
                new CarroModelo().inserir(car);
                    JOptionPane.showMessageDialog(null, "Fornecedor Editado"); 
                }
                txt_marca.setText("");
                txt_modelo.setText("");
                txt_ano.setText("");
                txt_cor.setText("");
                txt_chassi.setText("");

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar\n" + e);
       
        }

        

    }                                             
    void editar(CarroMapeamento car) {
        editar = true;
        this.car = car;
        btncadastro.setText("Salvar");
        txt_marca.setText(car.getMarca());
        txt_modelo.setText(car.getModelo());
        txt_ano.setText(car.getAno() + "");
        txt_cor.setText(car.getCor());
        txt_chassi.setText(car.getChassi());
    }//GEN-LAST:event_btncadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_ano;
    private javax.swing.JTextField txt_chassi;
    private javax.swing.JTextField txt_cor;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_modelo;
    // End of variables declaration//GEN-END:variables
}
