package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import View.MenuTitulosFranquia;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FranquiaControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosFranquia telaFranquia = new MenuTitulosFranquia();

    public FranquiaControladora(Franquia franquia, FranquiaDAO franquiaDAO, PessoaDAO pessoaDAO) {

        menuOpcoesFranquia(franquia, franquiaDAO, pessoaDAO);
    }

    private void menuOpcoesFranquia(Franquia franquia, FranquiaDAO franquiaDAO, PessoaDAO pessoaDAO) {

        int opcao;

        do {
            opcao = telaFranquia.menuFranquia();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + franquiaDAO.buscaFranquia(franquia));
                    break;
                }
                case 2: {
                    cadastraNovaFranquia(franquiaDAO, pessoaDAO);
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    System.out.println("======== VETOR DE FRANQUIAS ===========\n");
                    franquiaDAO.mostraTodasFranquias();
                }
            }

        } while (opcao != 0);
    }

    private void cadastraNovaFranquia(FranquiaDAO franquiaDAO, PessoaDAO pessoaDAO) {

        pessoaDAO.filtraPessoasQueNaoSaoDonosDeFranquia();

        System.out.println("Informe o Id da pessoa que Sera a Dona da Franquia: ");
        int idPessoa = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o Login de Dono de Franquia: ");
        String loginDonoFranquia = scanner.nextLine();

        System.out.println("Informe a Senha de Dono de Franquia: ");
        String senhaDonoFranquia = scanner.nextLine();

        Pessoa pessoa = pessoaDAO.buscaPessoaPorId(idPessoa);

        if (pessoa == null) {
            System.out.println("\nPessoa Nao Encontrada");
        } else {
            if (franquiaDAO.verificaDonosDeFranquia(pessoa) == true) {
                System.out.println("\nPessoa ja Cadastrada Como Dono de Franquia\n");

            } else {
                Pessoa pessoaDonoFranquia = new Pessoa(pessoa.getNomePessoa(), pessoa.getCpf(), pessoa.getEnderecoPessoa(),
                        pessoa.getTelefonePessoa(), loginDonoFranquia, senhaDonoFranquia, "DonodeFranquia", LocalDateTime.now());

                pessoaDAO.adicionaPessoa(pessoaDonoFranquia);

                System.out.println("Informe o Nome da Franquia: ");
                String nomeFranquia = scanner.nextLine();

                System.out.println("Informe o Cnpj da Franquia: ");
                String cnpjFranquia = scanner.nextLine();

                System.out.println("Informe a Cidade da Franquia: ");
                String cidadeFranquia = scanner.nextLine();

                System.out.println("Informe o Endereco da Franquia: ");
                String enderecoFranquia = scanner.nextLine();

                if (franquiaDAO.verificaSeFranquiaExiste(nomeFranquia, cnpjFranquia) == true) {
                    System.out.println("\nA Franquia Ja Existe");
                } else {
                    Franquia franquia = new Franquia(nomeFranquia, cnpjFranquia,
                            cidadeFranquia, enderecoFranquia, pessoaDonoFranquia, LocalDateTime.now());

                    boolean franquiaAdicionada = franquiaDAO.adicionaFranquia(franquia);

                    if (franquiaAdicionada == true) {
                        System.out.println("Franquia Cadastrada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Cadastrar a Franquia.");
                    }

                }
            }

        }

    }
}




