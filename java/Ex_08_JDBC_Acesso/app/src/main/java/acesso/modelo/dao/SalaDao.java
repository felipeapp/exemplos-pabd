package acesso.modelo.dao;

import java.sql.SQLException;

import acesso.modelo.entidade.Sala;
import acesso.modelo.util.AbstratoDao;

public class SalaDao extends AbstratoDao {

    public boolean adicionar(Sala s) {
        boolean resultado;
        String sql = "insert into sala (nome, numero) values (?, ?)";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, s.getNome());
            stmt.setInt(2, s.getNumero());

            resultado = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    public Sala buscarPorNumero(int numero) {
        Sala sala = null;
        String sql = "select * from sala where numero = ?";

        try (var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numero);

            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    sala = new Sala();
                    sala.setId(rs.getInt("id"));
                    sala.setNome(rs.getString("nome"));
                    sala.setNumero(rs.getInt("numero"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sala;
    }

}
