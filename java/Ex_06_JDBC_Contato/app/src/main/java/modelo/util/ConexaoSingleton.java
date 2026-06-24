package modelo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {

    private static Connection conexao;

    private static final String URL = "jdbc:mysql://10.225.0.4/1812384_agenda";
    private static final String USUARIO = "1812384";
    private static final String SENHA = "alves@123";

    private ConexaoSingleton() {
    }

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed())
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no servidor de banco de dados!", e);
        }
    }

}
