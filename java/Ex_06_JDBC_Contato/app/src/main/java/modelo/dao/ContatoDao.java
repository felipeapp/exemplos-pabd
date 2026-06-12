package modelo.dao;

import java.sql.SQLException;

import modelo.entidade.Contato;

public class ContatoDao extends AbstradoDao {

    public boolean adicionar(Contato contato) {
        boolean resultado;
        String sql = "insert into contato (nome, email, celular, nascimento) values (?, ?, ?, ?)";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setInt(3, contato.getCelular());
            stmt.setObject(4, contato.getNascimento());
            resultado = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            // e.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

}
