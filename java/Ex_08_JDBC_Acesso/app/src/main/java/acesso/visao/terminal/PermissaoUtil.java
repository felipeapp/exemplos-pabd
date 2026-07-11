package acesso.visao.terminal;

import java.util.Scanner;

import acesso.modelo.dao.PermissaoDao;
import acesso.modelo.dao.SalaDao;
import acesso.modelo.dao.UsuarioDao;
import acesso.modelo.entidade.Permissao;

public class PermissaoUtil {

    public static void lerDadosAdicionarSemVerificacao(Scanner leitor) {
        PermissaoDao dao = new PermissaoDao();

        System.out.print("Digite o CPF do usuário: ");
        var cpf = leitor.nextLine();

        System.out.print("Digite o número da sala: ");
        var numero = leitor.nextInt();

        if (dao.adicionar(cpf, numero)) {
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
        System.out.println("Usuário encontrado: " + usuario);

        System.out.print("Digite o número da sala: ");
        var numero = leitor.nextInt();

        var sala = salaDao.buscarPorNumero(numero);
        if (sala == null) {
            System.out.println("Sala não encontrada!");
            return;
        }
        System.out.println("Sala encontrada: " + sala);

        var permissao = new Permissao();
        permissao.setUsuario(usuario);
        permissao.setSala(sala);

        if (permissaoDao.adicionar(permissao)) {
            System.out.println("Permissão adicionada com sucesso!");
        } else {
            System.out.println("Erro ao adicionar permissão!");
        }
    }

    public static void lerDadosRemoverSemVerificacao(Scanner leitor) {
        PermissaoDao dao = new PermissaoDao();

        System.out.print("Digite o CPF do usuário: ");
        var cpf = leitor.nextLine();

        System.out.print("Digite o número da sala: ");
        var numero = leitor.nextInt();

        if (dao.remover(cpf, numero)) {
            System.out.println("Permissão removida com sucesso!");
        } else {
            System.out.println("Erro ao remover permissão!");
        }
    }

    public static void lerDadosRemoverComVerificacao(Scanner leitor) {
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
        System.out.println("Usuário encontrado: " + usuario);

        System.out.print("Digite o número da sala: ");
        var numero = leitor.nextInt();

        var sala = salaDao.buscarPorNumero(numero);
        if (sala == null) {
            System.out.println("Sala não encontrada!");
            return;
        }
        System.out.println("Sala encontrada: " + sala);

        var permissao = new Permissao();
        permissao.setUsuario(usuario);
        permissao.setSala(sala);

        if (permissaoDao.remover(permissao)) {
            System.out.println("Permissão removida com sucesso!");
        } else {
            System.out.println("Erro ao remover permissão!");
        }
    }

    public static void gerarRelatorio() {
        PermissaoDao dao = new PermissaoDao();
        var permissoes = dao.listar();

        if (permissoes.isEmpty()) {
            System.out.println("Nenhuma permissão cadastrada!");
        } else {
            permissoes.forEach(System.out::println);
        }
    }

}
