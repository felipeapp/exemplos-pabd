package acesso.modelo.dao;

import java.sql.SQLException;

import acesso.modelo.entidade.Usuario;
import acesso.modelo.util.AbstratoDao;

public class UsuarioDao extends AbstratoDao {

    public boolean adicionar(Usuario u) {
        boolean resultado;
        String sql = "insert into usuario (nome, cpf, tag) values (?, ?, ?)";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setInt(3, u.getTag());

            resultado = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    public Usuario buscarPorCpf(String cpf) {
        Usuario usuario = null;
        String sql = "select * from usuario where cpf = ?";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setTag(rs.getInt("tag"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

}
