package acesso.visao.terminal;

import java.util.Scanner;

import acesso.modelo.dao.PermissaoDao;
import acesso.modelo.dao.SalaDao;
import acesso.modelo.dao.UsuarioDao;
import acesso.modelo.entidade.Permissao;

public class PermissaoTerminal {

    public static void lerDadosAdicionarSemVerificacao(Scanner leitor) {
        PermissaoDao dao = new PermissaoDao();

        System.out.print("Digite o CPF do usuário: ");
        var cpf = leitor.nextLine();

        System.out.print("Digite o número da sala: ");
        var numero = leitor.nextInt();

        if (dao.adicionarSemVerificacao(cpf, numero)) {
            System.out.println("Permissão adicionada com sucesso!");
        } else {
            System.out.println("Erro ao adicionar permissão!");
        }
    }

    public static void lerDadosAdicionarComVerificacao(Scanner leitor) {
        PermissaoDao permissaoDao = new PermissaoDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        SalaDao salaDao = new SalaDao();

        System.out.print("Digite o CPF do usuário: ");
        var cpf = leitor.nextLine();

        var usuario = usuarioDao.buscarPorCpf(cpf);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }
        System.out.println(usuario);

        System.out.print("Digite o número da sala: ");
        var numero = leitor.nextInt();

        var sala = salaDao.buscarPorNumero(numero);
        if (sala == null) {
            System.out.println("Sala não encontrada!");
            return;
        }
        System.out.println(sala);

        var permissao = new Permissao();
        permissao.setUsuario(usuario);
        permissao.setSala(sala);

        if (permissaoDao.adicionarComVerificacao(permissao)) {
            System.out.println("Permissão adicionada com sucesso!");
        } else {
            System.out.println("Erro ao adicionar permissão!");
        }
    }

    public static void lerDadosListarSalas(Scanner leitor) {
        PermissaoDao dao = new PermissaoDao();

        System.out.print("Digite o CPF do usuário: ");
        var cpf = leitor.nextLine();

        var salas = dao.listarSalas(cpf);
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala encontrada para o usuário!");
        } else {
            salas.forEach(System.out::println);
        }
    }

}
