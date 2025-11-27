package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstratoDAO implements AutoCloseable {

    private final String url = "jdbc:mysql://127.0.0.1/agenda";
    private final String usuario = "root";
    private final String senha = "123456";

    protected Connection conexao;

    public AbstratoDAO() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
