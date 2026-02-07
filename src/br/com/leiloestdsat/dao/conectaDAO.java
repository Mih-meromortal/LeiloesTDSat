package br.com.leiloestdsat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe responsável por conectar ao banco de dados leiloes
 */
public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;

        try {
            // Tenta conectar ao banco "leiloes" com usuário "root" e sem senha
            // Se o teu MySQL tiver senha, coloque entre as aspas vazias no final: "senha"
          conn = DriverManager.getConnection("jdbc:mysql://localhost/leiloes?useSSL=false", "root", "12345");
            
        } catch (SQLException erro) {
            // Se der erro, mostra uma mensagem na tela
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }
}