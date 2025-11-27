package visao;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;
import visao.util.DateUtil;

public class Terminal {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

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
                Contato c = new Contato();

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

                    try (ContatoDAO dao = new ContatoDAO()) {
                        if (dao.salvar(c)) {
                            System.out.println("Contato salvo com sucesso!");
                        } else {
                            System.out.println("Erro ao salvar o contato!");
                        }
                    }
                }
            } else if (opcao == 2) {
            } else if (opcao == 3) {
            } else {
                System.out.println("Opção inválida, tente novamente!");
            }

        }

        leitor.close();

    }

}
