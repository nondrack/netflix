package config;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Tentando conectar ao banco de dados da Hostinger...");

        // O 'try-with-resources' garante que a conexão será fechada automaticamente após o teste
        try (Connection conexao = Database.getConnection()) {

            if (conexao != null && !conexao.isClosed()) {
                System.out.println("----------------------------------------");
                System.out.println("🎉 CONEXÃO REALIZADA COM SUCESSO! 🎉");
                System.out.println("O Java conseguiu acessar o banco na Hostinger.");
                System.out.println("----------------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("\n❌ FALHA NA CONEXÃO!");
            System.err.println("Motivo do erro: " + e.getMessage());

            // Se o erro for de rede ou bloqueio de IP, isso ajudará a identificar:
            if (e.getMessage().contains("Communications link failure")) {
                System.err.println("\nDICA: Verifique se você liberou seu IP no painel da Hostinger (MySQL Remoto)!");
            }
        }
    }
}
