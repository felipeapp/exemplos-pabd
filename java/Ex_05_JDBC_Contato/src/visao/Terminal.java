package visao;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;
import visao.util.DateUtil;

public class Terminal {

    public static void main(String[] args) {

        var leitor = new Scanner(System.in);

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
            }

            if (opcao == 1) {
                var c = new Contato();

                System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
                var nascimento = DateUtil.stringToDate(leitor.nextLine(), LocalDate.class);

                if (nascimento == null) {
                    System.out.println("Data de nascimento inválida!");
                } else {
                    c.setNascimento(nascimento);

                    System.out.print("Digite o nome: ");
                    c.setNome(leitor.nextLine());

                    System.out.print("Digite o email: ");
                    c.setEmail(leitor.nextLine());

                    System.out.print("Digite o celular: ");
                    c.setCelular(leitor.nextInt());

                    try (var dao = new ContatoDAO()) {
                        if (dao.salvar(c))
                            System.out.println("Contato salvo com sucesso!");
                        else
                            System.out.println("Erro ao salvar o contato!");

                    }
                }
            } else if (opcao == 2) {
                try (var dao = new ContatoDAO()) {
                    var contatos = dao.listar();

                    if (contatos.isEmpty())
                        System.out.println("Nenhum contato encontrado!");
                    else
                        contatos.forEach(System.out::println);
                }
            } else if (opcao == 3) {
                System.out.print("Digite o e-mail do contato a atualizar: ");
                var email = leitor.nextLine();

                try (var dao = new ContatoDAO()) {
                    var contato = dao.buscarPorEmail(email);

                    if (contato == null) {
                        System.out.println("Contato não encontrado!");
                    } else {
                        System.out.println("Contato: " + contato);

                        System.out.print("Digite o novo nome do contato: ");
                        var novo_nome = leitor.nextLine();

                        System.out.print("Digite o novo número do contato: ");
                        var novo_numero = leitor.nextInt();

                        if (dao.atualizarNomeNumeroPorEmail(email, novo_nome, novo_numero))
                            System.out.println("Contato atualizado com sucesso!");
                        else
                            System.out.println("Erro ao atualizar o contato!");
                    }
                }
            } else if (opcao == 4) {
                System.out.print("Digite o e-mail do contato a remover: ");
                var email = leitor.nextLine();

                try (var dao = new ContatoDAO()) {
                    if (dao.removerPorEmail(email))
                        System.out.println("Contato removido com sucesso!");
                    else
                        System.out.println("Contato não encontrado!");
                }
            } else if (opcao == 5) {
                System.out.print("Digite o e-mail do contato a buscar: ");
                var email = leitor.nextLine();

                try (var dao = new ContatoDAO()) {
                    var contato = dao.buscarPorEmail(email);

                    if (contato == null)
                        System.out.println("Contato não encontrado!");
                    else
                        System.out.println(contato);
                }
            } else if (opcao == 6) {
                System.out.print("Digite o nome ou parte do nome a buscar: ");
                var nome = leitor.nextLine();

                try (var dao = new ContatoDAO()) {
                    var contatos = dao.buscarPorSimilaridadeNome(nome);

                    if (contatos.isEmpty())
                        System.out.println("Nenhum contato encontrado!");
                    else
                        contatos.forEach(System.out::println);
                }
            } else {
                System.out.println("Opção inválida, tente novamente!");
            }

        }

        leitor.close();

    }

}
