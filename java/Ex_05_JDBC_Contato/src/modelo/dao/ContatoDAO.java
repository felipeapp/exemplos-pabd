package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.entidade.Contato;

public class ContatoDAO extends AbstratoDAO {

    public boolean salvar(Contato c) {
        boolean sucesso;
        String sql = "insert into contato (nome, email, celular, nascimento) values (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setInt(3, c.getCelular());
            stmt.setObject(4, c.getNascimento());

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;
    }

}
