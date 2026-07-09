package acesso.visao.terminal;

import java.util.Scanner;

import acesso.modelo.dao.UsuarioDao;
import acesso.modelo.entidade.Usuario;

public class UsuarioTerminal {

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

}
