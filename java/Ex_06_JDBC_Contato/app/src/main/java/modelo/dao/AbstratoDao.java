package modelo.dao;

import java.sql.Connection;

import modelo.util.ConexaoSingleton;

public abstract class AbstratoDao implements AutoCloseable {

    protected Connection conexao;

    public AbstratoDao() {
        conexao = ConexaoSingleton.getConexao();
    }

    @Override
    public void close() {
        // Sem fechar a conexão, se desejável, mantemos uma conexão para a aplicação
    }

}
