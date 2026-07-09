package acesso.modelo.util;

import java.sql.Connection;

public abstract class AbstratoDao {

    protected Connection conexao;

    public AbstratoDao() {
        conexao = ConexaoSingleton.getConexao();
    }

}
