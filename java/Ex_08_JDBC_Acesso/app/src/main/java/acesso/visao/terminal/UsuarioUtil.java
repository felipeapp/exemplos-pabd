package acesso.visao.terminal;

import java.util.Scanner;

import acesso.modelo.dao.SalaDao;
import acesso.modelo.dao.UsuarioDao;
import acesso.modelo.entidade.Sala;
import acesso.modelo.entidade.Usuario;

public class UsuarioUtil {

    public static void lerDadosAdicionar(Scanner leitor) {
        Usuario u = new Usuario();
        UsuarioDao dao = new UsuarioDao();

        System.out.print("Digite o nome do usuário: ");
        u.setNome(leitor.nextLine());

        System.out.print("Digite o CPF do usuário: ");
        u.setCpf(leitor.nextLine());

        System.out.print("Digite a tag do usuário: ");
        u.setTag(leitor.nextInt());

        if (dao.adicionar(u)) {
            System.out.println("Usuário adicionado com sucesso!");
        } else {
            System.out.println("Erro ao adicionar usuário!");
        }
    }

    public static void lerDadosBuscarPorCpf(Scanner leitor) {
        System.out.print("Digite o CPF do usuário: ");
        String cpf = leitor.nextLine();

        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = dao.buscarPorCpf(cpf);

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
        } else {
            System.out.println(usuario);
        }
    }

    public static void lerDadosBuscarPorSala(Scanner leitor) {
        UsuarioDao usuarioDao = new UsuarioDao();
        SalaDao salaDao = new SalaDao();

        System.out.print("Digite o número da sala para buscar seus usuários: ");
        var numero = leitor.nextInt();

        Sala s = salaDao.buscarPorNumero(numero);
        if (s == null) {
            System.out.println("Sala não encontrada!");
            return;
        }
        System.out.println("Usuários da sala " + s + ":");

        var usuarios = usuarioDao.buscarPorSala(numero);

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado!");
        } else {
            usuarios.forEach(System.out::println);
        }

    }

    public static void gerarRelatorio() {
        UsuarioDao dao = new UsuarioDao();
        var usuarios = dao.listar();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

}
