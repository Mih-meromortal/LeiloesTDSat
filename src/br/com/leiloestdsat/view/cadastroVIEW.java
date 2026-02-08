package br.com.leiloestdsat.view;

import br.com.leiloestdsat.dao.ProdutosDAO;
import br.com.leiloestdsat.dto.ProdutosDTO;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

/**
 * Tela de Cadastro com o Botão Consultar funcionando
 */
public class cadastroVIEW extends javax.swing.JFrame {

    // Componentes da tela
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JTextField cadastroValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;

    public cadastroVIEW() {
        initComponents();
        // Centraliza a janela na tela ao abrir
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        // --- Inicialização dos Componentes ---
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cadastroNome = new javax.swing.JTextField();
        cadastroValor = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // --- Estilização (Fontes e Cores) ---
        
        // Fontes aumentadas
        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonteTitulo = new Font("Segoe UI", Font.PLAIN, 26);

        jLabel1.setFont(fonteTitulo);
        jLabel1.setText("Sistema de Leilões");

        jLabel2.setFont(fontePadrao);
        jLabel2.setText("Nome do Produto:");

        jLabel3.setFont(fontePadrao);
        jLabel3.setText("Valor do Produto:");
        
        jLabel4.setFont(fontePadrao);
        jLabel4.setText("Cadastre um novo produto");

        cadastroNome.setFont(fontePadrao);
        cadastroValor.setFont(fontePadrao);

        // Botão Cadastrar (Laranja)
        btnCadastrar.setBackground(new Color(255, 140, 0)); 
        btnCadastrar.setForeground(Color.BLACK); 
        btnCadastrar.setFont(fontePadrao);
        btnCadastrar.setText("Cadastrar");
        
        // Botão Consultar (Laranja)
        btnConsultar.setBackground(new Color(255, 140, 0)); 
        btnConsultar.setForeground(Color.BLACK);
        btnConsultar.setFont(fontePadrao);
        btnConsultar.setText("Consultar / Vender");

        // --- Ações dos Botões ---
        
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        // --- AQUI ESTÁ A MUDANÇA (ATIVIDADE 2) ---
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listagemVIEW listagem = new listagemVIEW(); 
                listagem.setVisible(true);
            }
        });

        // --- Layout ---
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cadastroValor, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastroValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }                           

    // --- Lógica de Cadastro ---
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        ProdutosDTO produto = new ProdutosDTO();
        String nome = cadastroNome.getText();
        String valor = cadastroValor.getText();
        String status = "A Venda";
        
        ProdutosDAO produtodao = new ProdutosDAO();
        
        if(!nome.isEmpty() && !valor.isEmpty()){
             try {
                 produto.setNome(nome);
                 produto.setValor(Integer.parseInt(valor));
                 produto.setStatus(status);
                 
                 produtodao.cadastrarProduto(produto);
                 
                 cadastroNome.setText("");
                 cadastroValor.setText("");
                 JOptionPane.showMessageDialog(null, "Sucesso! Produto cadastrado.");
                 
             } catch (NumberFormatException e) {
                 JOptionPane.showMessageDialog(null, "O campo 'Valor' deve conter apenas números.");
             }
        } else {
             JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }                                           

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroVIEW().setVisible(true);
            }
        });
    }                  
}