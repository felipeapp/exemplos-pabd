package visao.terminal;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.dao.ContatoDao;
import modelo.entidade.Contato;
import visao.util.DateUtil;

public class App {

    public static void main(String[] args) {
        var leitor = new Scanner(System.in);

        System.out.println("** EXEMPLO AINDA NÃO FINALIZADO! **");

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("0. Sair");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Atualizar contato");
            System.out.println("4. Remover por e-mail");
            System.out.println("5. Buscar por e-mail");
            System.out.println("6. Buscar por similaridade de nome");
            System.out.print("Escolha sua opção: ");
            var opcao = leitor.nextInt();
            leitor.nextLine();

            if (opcao == 0) {
                System.out.println("Encerrando o programa...");
                break;
            } else if (opcao == 1) {
                Contato contato = new Contato();

                System.out.print("Digite sua data de nascimento (dd/mm/aaaa): ");
                contato.setNascimento(DateUtil.stringToDate(leitor.nextLine(), LocalDate.class));

                System.out.print("Digite seu nome: ");
                contato.setNome(leitor.nextLine());

                System.out.print("Digite seu e-mail: ");
                contato.setEmail(leitor.nextLine());

                System.out.print("Digite seu celular: ");
                contato.setCelular(leitor.nextInt());

                try (var dao = new ContatoDao()) {
                    if (dao.adicionar(contato)) {
                        System.out.println("Contato adicionado com sucesso!");
                    } else {
                        System.out.println("Ocorreu um erro ao adicionar o contato!");
                    }
                }
            }
        }

        leitor.close();
    }
}
