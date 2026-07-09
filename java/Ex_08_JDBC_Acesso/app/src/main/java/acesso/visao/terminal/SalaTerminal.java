package acesso.visao.terminal;

import java.util.Scanner;

import acesso.modelo.dao.SalaDao;
import acesso.modelo.entidade.Sala;

public class SalaTerminal {

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

}
