package acesso.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import acesso.modelo.entidade.Permissao;
import acesso.modelo.entidade.Sala;
import acesso.modelo.entidade.Usuario;
import acesso.modelo.util.AbstratoDao;

public class PermissaoDao extends AbstratoDao {

    public static Permissao criarPermissao(ResultSet rs) throws SQLException {
        Usuario u = UsuarioDao.criarUsuario(rs, true);
        Sala s = SalaDao.criarSala(rs, true);
        return new Permissao(u, s, rs.getObject("horario", LocalDateTime.class));
    }

    public boolean adicionar(String cpf, int numero) {
        boolean sucesso;
        String sql = """
                    insert into permissao (id_usuario, id_sala) values
                    (
                        (select id from usuario where cpf = ?),
                        (select id from sala where numero = ?)
                    )
                """;

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setInt(2, numero);

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;
    }

    public boolean adicionar(Permissao p) {
        boolean sucesso;
        String sql = "insert into permissao (id_usuario, id_sala) values (?, ?)";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, p.getUsuario().getId());
            stmt.setInt(2, p.getSala().getId());

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;
    }

    public boolean remover(String cpf, int numero) {
        boolean sucesso;
        String sql = """
                    delete from permissao
                    where
                        id_usuario = (select id from usuario where cpf = ?) and
                        id_sala = (select id from sala where numero = ?)
                """;

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setInt(2, numero);

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;
    }

    public boolean remover(Permissao p) {
        boolean sucesso;
        String sql = "delete from permissao where id_usuario = ? and id_sala = ?";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, p.getUsuario().getId());
            stmt.setInt(2, p.getSala().getId());

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;
    }

    public List<Permissao> listar() {
        List<Permissao> permissoes = new ArrayList<>();
        String sql = """
                    select
                        u.*, s.*, p.horario
                    from
                        usuario u inner join permissao p on u.id = p.id_usuario
                        inner join sala s on s.id = p.id_sala
                    order by u.nome, u.cpf
                """;

        try (var stmt = conexao.prepareStatement(sql); var rs = stmt.executeQuery()) {
            while (rs.next()) {
                permissoes.add(criarPermissao(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return permissoes;
    }

}
