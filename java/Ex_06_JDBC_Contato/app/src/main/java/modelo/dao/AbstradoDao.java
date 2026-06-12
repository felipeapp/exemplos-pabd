package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstradoDao implements AutoCloseable {

    protected Connection conexao;

    public AbstradoDao() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://10.230.0.44/1812384_agenda", "root", "123456");
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
