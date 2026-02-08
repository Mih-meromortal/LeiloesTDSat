package br.com.leiloestdsat.view;

import br.com.leiloestdsat.dao.ProdutosDAO;
import br.com.leiloestdsat.dto.ProdutosDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Tela de Listagem Moderna: Venda por Seleção na Tabela
 */
public class listagemVIEW extends javax.swing.JFrame {

    public listagemVIEW() {
        initComponents();
        listarProdutos();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JTable();
        btnVender = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); 
        jLabel1.setText("Lista de Produtos");

        // Configura a Tabela
        listaProdutos.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Nome", "Valor", "Status" }
        ));
        jScrollPane1.setViewportView(listaProdutos);

        btnVender.setText("Vender Item Selecionado");
        btnVoltar.setText("Voltar");
        
        jLabel2.setText("Clique em um item da tabela para vender:");

        // --- LÓGICA DE VENDA POR SELEÇÃO (UPGRADE) ---
        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                // Pega o número da linha que está azul (selecionada)
                int linhaSelecionada = listaProdutos.getSelectedRow();
                
                // Se for -1, significa que não tem nada selecionado
                if (linhaSelecionada >= 0) {
                    
                    // Pega o valor da Coluna 0 (que é o ID) daquela linha
                    // getValueAt(linha, coluna)
                    String idTexto = listaProdutos.getValueAt(linhaSelecionada, 0).toString();
                    int id = Integer.parseInt(idTexto);
                    
                    ProdutosDAO produtosdao = new ProdutosDAO();
                    produtosdao.venderProduto(id);
                    
                    listarProdutos(); // Atualiza a tabela
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, clique em um produto da tabela primeiro.");
                }
            }
        });

        // Botão Voltar
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVender))
                     .addComponent(jLabel2))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2) // Texto explicativo
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVender)
                    .addComponent(btnVoltar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void listarProdutos(){
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            DefaultTableModel model = (DefaultTableModel) listaProdutos.getModel();
            model.setNumRows(0);
            
            ArrayList<ProdutosDTO> listagem = produtosdao.listarProdutos();
            
            for(int i = 0; i < listagem.size(); i++){
                model.addRow(new Object[]{
                    listagem.get(i).getId(),
                    listagem.get(i).getNome(),
                    listagem.get(i).getValor(),
                    listagem.get(i).getStatus()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
    }

    // Variáveis
    private javax.swing.JButton btnVender;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2; // Novo Label explicativo
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listaProdutos;
}