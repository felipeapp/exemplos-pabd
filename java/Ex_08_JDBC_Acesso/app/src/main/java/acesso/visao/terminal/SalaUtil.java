package acesso.visao.terminal;

import java.util.Scanner;

import acesso.modelo.dao.SalaDao;
import acesso.modelo.dao.UsuarioDao;
import acesso.modelo.entidade.Sala;
import acesso.modelo.entidade.Usuario;

public class SalaUtil {

    public static void lerDadosAdicionar(Scanner leitor) {
        Sala s = new Sala();
        SalaDao dao = new SalaDao();

        System.out.print("Digite o nome da sala: ");
        s.setNome(leitor.nextLine());

        System.out.print("Digite o número da sala: ");
        s.setNumero(leitor.nextInt());

        if (dao.adicionar(s)) {
            System.out.println("Sala adicionada com sucesso!");
        } else {
            System.out.println("Erro ao adicionar sala!");
        }
    }

    public static void lerDadosBuscarPorNumero(Scanner leitor) {
        System.out.print("Digite o número da sala: ");
        int numero = leitor.nextInt();

        SalaDao dao = new SalaDao();
        Sala sala = dao.buscarPorNumero(numero);

        if (sala == null) {
            System.out.println("Sala não encontrada!");
        } else {
            System.out.println(sala);
        }
    }

    public static void lerDadosBuscarPorUsuario(Scanner leitor) {
        UsuarioDao usuarioDao = new UsuarioDao();
        SalaDao salaDao = new SalaDao();

        System.out.print("Digite o CPF do usuário para buscar suas salas: ");
        String cpf = leitor.nextLine();

        Usuario u = usuarioDao.buscarPorCpf(cpf);
        if (u == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }
        System.out.println("Salas do usuário " + u + ":");

        var salas = salaDao.buscarPorUsuario(cpf);

        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala encontrada!");
        } else {
            salas.forEach(System.out::println);
        }

    }

    public static void gerarRelatorio() {
        SalaDao dao = new SalaDao();
        var salas = dao.listar();

        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada!");
        } else {
            salas.forEach(System.out::println);
        }
    }

}
