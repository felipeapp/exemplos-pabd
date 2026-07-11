package acesso.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import acesso.modelo.entidade.Sala;
import acesso.modelo.util.AbstratoDao;

public class SalaDao extends AbstratoDao {

    public static Sala criarSala(ResultSet rs, boolean prefixo) throws SQLException {
        if (prefixo) {
            return new Sala(rs.getInt("s.id"), rs.getInt("s.numero"), rs.getString("s.nome"));
        } else {
            return new Sala(rs.getInt("id"), rs.getInt("numero"), rs.getString("nome"));
        }
    }

    public boolean adicionar(Sala s) {
        boolean sucesso;
        String sql = "insert into sala (numero, nome) values (?, ?)";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, s.getNumero());
            stmt.setString(2, s.getNome());

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;
    }

    public Sala buscarPorNumero(int numero) {
        Sala s = null;
        String sql = "select * from sala where numero = ?";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numero);

            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    s = criarSala(rs, false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    public List<Sala> buscarPorUsuario(String cpf) {
        List<Sala> salas = new ArrayList<>();
        String sql = """
                    select s.* from
                    sala s inner join permissao p on s.id = p.id_sala
                    inner join usuario u on u.id = p.id_usuario
                    where u.cpf = ?
                """;

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            try (var rs = stmt.executeQuery()) {
                while (rs.next()) {
                    salas.add(criarSala(rs, false));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salas;
    }

    public List<Sala> listar() {
        List<Sala> salas = new ArrayList<>();
        String sql = "select * from sala";

        try (var stmt = conexao.prepareStatement(sql); var rs = stmt.executeQuery()) {
            while (rs.next()) {
                salas.add(criarSala(rs, false));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salas;
    }

}
