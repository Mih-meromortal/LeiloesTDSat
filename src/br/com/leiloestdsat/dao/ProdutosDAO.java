package br.com.leiloestdsat.dao;

import br.com.leiloestdsat.dto.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    
    // Método para cadastrar o produto no banco
    public void cadastrarProduto(ProdutosDTO produto) {
        
        // Abre a conexão
        conn = new conectaDAO().connectDB();
        
        // O comando SQL para inserir
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?,?,?)";
        
        try {
            prep = conn.prepareStatement(sql);
            
            // Pega os dados do DTO e coloca no SQL
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            // Executa
            prep.execute();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + erro.getMessage());
        }
    }
}