package model;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar");
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluir(scanner, repoFisica, repoJuridica);
                    break;
                case 2:
                    alterar(scanner, repoFisica, repoJuridica);
                    break;
                case 3:
                    excluir(scanner, repoFisica, repoJuridica);
                    break;
                case 4:
                    exibirPeloId(scanner, repoFisica, repoJuridica);
                    break;
                case 5:
                    exibirTodos(scanner, repoFisica, repoJuridica);
                    break;
                case 6:
                    salvarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 7:
                    recuperarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 0:
                    running = false;
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Incluir: (1 - Pessoa Física, 2 - Pessoa Jurídica)");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            PessoaFisica pessoa = new PessoaFisica(nome, cpf, idade);
            repoFisica.inserir(pessoa);
            System.out.println("Pessoa física incluída com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            PessoaJuridica pessoa = new PessoaJuridica(nome, cnpj);
            repoJuridica.inserir(pessoa);
            System.out.println("Pessoa jurídica incluída com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }
    
    private static void alterar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Alterar: (1 - Pessoa Física, 2 - Pessoa Jurídica)");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("ID da Pessoa Física: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            PessoaFisica pessoa = repoFisica.obter(id);
            if (pessoa != null) {
                System.out.println("Pessoa Física Atual:");
                pessoa.exibir();
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Nova idade: ");
                int idade = scanner.nextInt();
                pessoa.setNome(nome);
                pessoa.setCpf(cpf);
                pessoa.setIdade(idade);
                repoFisica.alterar(pessoa);
                System.out.println("Pessoa física alterada com sucesso!");
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID da Pessoa Jurídica: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            PessoaJuridica pessoa = repoJuridica.obter(id);
            if (pessoa != null) {
                System.out.println("Pessoa Jurídica Atual:");
                pessoa.exibir();
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CNPJ: ");
                String cnpj = scanner.nextLine();
                pessoa.setNome(nome);
                pessoa.setCnpj(cnpj);
                repoJuridica.alterar(pessoa);
                System.out.println("Pessoa jurídica alterada com sucesso!");
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }
    
    private static void excluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Excluir: (1 - Pessoa Física, 2 - Pessoa Jurídica)");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("ID da Pessoa Física: ");
            int id = scanner.nextInt();
            repoFisica.excluir(id);
            System.out.println("Pessoa física excluída com sucesso!");
        } else if (tipo == 2) {
            System.out.print("ID da Pessoa Jurídica: ");
            int id = scanner.nextInt();
            repoJuridica.excluir(id);
            System.out.println("Pessoa jurídica excluída com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void exibirPeloId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Exibir pelo ID: (1 - Pessoa Física, 2 - Pessoa Jurídica)");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("ID da Pessoa Física: ");
            int id = scanner.nextInt();
            PessoaFisica pessoa = repoFisica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID da Pessoa Jurídica: ");
            int id = scanner.nextInt();
            PessoaJuridica pessoa = repoJuridica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Exibir todos: (1 - Pessoas Físicas, 2 - Pessoas Jurídicas)");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Pessoas Físicas:");
            for (PessoaFisica pessoa : repoFisica.obterTodos()) {
                pessoa.exibir();
            }
        } else if (tipo == 2) {
            System.out.println("Pessoas Jurídicas:");
            for (PessoaJuridica pessoa : repoJuridica.obterTodos()) {
                pessoa.exibir();
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }
    
    private static void salvarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Digite o prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.persistir(prefixo + ".fisica.bin");
            repoJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Digite o prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.recuperar(prefixo + ".fisica.bin");
            repoJuridica.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }
    }
}
