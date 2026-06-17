package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstratoDao implements AutoCloseable {

    private final String url = "jdbc:mysql://10.230.0.44/1812384_agenda";
    private final String usuario = "root";
    private final String senha = "123456";

    protected Connection conexao;

    public AbstratoDao() {
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
