package acesso.modelo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {

    private static Connection conexao;

    private static final String URL = "jdbc:mysql://127.0.0.1/acesso";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    private ConexaoSingleton() {
    }

    protected static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed())
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no servidor de banco de dados!", e);
        }
    }

}
