package acesso.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import acesso.modelo.entidade.Permissao;
import acesso.modelo.entidade.Sala;
import acesso.modelo.util.AbstratoDao;

public class PermissaoDao extends AbstratoDao {

    public boolean adicionarSemVerificacao(String cpf, int numero) {
        boolean resultado;
        String sql = "insert into permissao (id_usuario, id_sala) values" +
                "((select id from usuario where cpf = ?)," +
                "(select id from sala where numero = ?))";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setInt(2, numero);

            resultado = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    public boolean adicionarComVerificacao(Permissao p) {
        boolean resultado;
        String sql = "insert into permissao (id_usuario, id_sala) values (?, ?)";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, p.getUsuario().getId());
            stmt.setInt(2, p.getSala().getId());

            resultado = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    public List<Sala> listarSalas(String cpf) {
        List<Sala> salas = new ArrayList<Sala>();

        String sql = "select s.* from " +
                "usuario u inner join permissao p on u.id = p.id_usuario " +
                "inner join sala s on s.id = p.id_sala " +
                "where cpf = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sala s = new Sala();
                s.setId(rs.getInt("id"));
                s.setNumero(rs.getInt("numero"));
                s.setNome(rs.getString("nome"));
                salas.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salas;
    }

}
