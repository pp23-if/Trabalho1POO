package Controller;

import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import View.MenuTitulos;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ControladoraPrincipal {

    Scanner scanner = new Scanner(System.in);

    MenuTitulos Tela = new MenuTitulos();

    /*Instanciando os DAO.*/
    PessoaDAO pessoaDAO = new PessoaDAO();
    MedicoDAO medicoDAO = new MedicoDAO(pessoaDAO);

    /*Instanciando as Controladoras.*/
    public ControladoraPrincipal() {

        int opcao;

        do {

            opcao = Tela.menuInicial();

            switch (opcao) {
                case 1: {
                    fazLogin();
                    break;
                }

                case 2: {
                    cadastrarPessoa();
                    break;
                }

                case 3: {
                    System.out.println("\nMostrando Todas as Pessoas Cadastradas: " + "\n");
                    pessoaDAO.mostraTodasPessoas();
                    System.out.println("\nMostrando Todas os Medicos Cadastrados: " + "\n");
                    medicoDAO.mostraTodosMedicos();
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void cadastrarPessoa() {
        LocalDateTime agora = LocalDateTime.now();

        System.out.println("Informe o Nome da Pessoa: ");
        String nomePessoa = scanner.nextLine();

        System.out.println("Informe o Cpf da Pessoa: ");
        String cpf = scanner.nextLine();

        System.out.println("Informe o Endereco da Pessoa: ");
        String enderecoPessoa = scanner.nextLine();

        System.out.println("Informe o login da Pessoa: ");
        String loginPessoa = scanner.nextLine();

        System.out.println("Informe a Senha da Pessoa: ");
        String senhaPessoa = scanner.nextLine();

        System.out.println("Informe o Telefone da Pessoa: ");
        String telefonePessoa = scanner.nextLine();

        String tipoUsuario = "Paciente";

        boolean existePessoa;
        boolean adicionado;

        existePessoa = pessoaDAO.verificaSePessoaExiste(loginPessoa, tipoUsuario, nomePessoa, cpf);

        if (existePessoa == true) {
            System.out.println("\nPessoa ja Cadastrada");

        } else {
            Pessoa pessoa = new Pessoa(nomePessoa, cpf, enderecoPessoa, telefonePessoa,
                    loginPessoa, senhaPessoa, tipoUsuario, agora);

            adicionado = pessoaDAO.adicionaPessoa(pessoa);

            if (adicionado == true) {
                System.out.println("\nPessoa Cadastrada Com Sucesso!!!");
            } else {
                System.out.println("\nNao Foi Possivel Cadastrar a Pessoa.");
            }
        }

    }

    private void fazLogin() {
        System.out.println("\nLogin: ");
        String login = scanner.nextLine();
        System.out.println("\n");

        System.out.println("\nSenha: ");
        String senha = scanner.nextLine();
        System.out.println("\n");

        Pessoa pessoaLogada = pessoaDAO.buscaPessoaQuerendoLogar(login, senha);

        gerenciaControladoras(pessoaLogada);

    }

    private void gerenciaControladoras(Pessoa pessoaLogada) {
        if (pessoaLogada != null) {
            System.out.println("Login efetuado Com Sucesso!");
            System.out.println("Logado Como: " + pessoaLogada.getTipoUsuario());

            if (pessoaLogada.getTipoUsuario().equals("Paciente")) {

                menuOpcoesPaciente(pessoaLogada);
            } else if (pessoaLogada.getTipoUsuario().equals("Medico")) {
                Medico medico = medicoDAO.mostraDadosMedicoLogado(pessoaLogada.getLoginPessoa(),
                        pessoaLogada.getSenhaPessoa());

                MedicoControladora medicoControladora = new MedicoControladora(medico, medicoDAO);
            }

        } else {
            System.out.println("Nao Foi Possivel Fazer Login: Usuario Nao Encontrado OU "
                    + "Nao Cadastrado.");
        }
    }

    private void menuOpcoesPaciente(Pessoa pessoa) {

        int opcao;

        do {
            opcao = Tela.menuPaciente();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + pessoaDAO.buscaPessoaCadastrada(pessoa.getLoginPessoa(),
                            pessoa.getSenhaPessoa()));
                    break;
                }
                case 2: {
                    menuOpcoesAtualizarDadosPaciente(pessoa);
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizarDadosPaciente(Pessoa pessoa) {

        int opcao;

        do {
            opcao = Tela.menuAlteraDadosPaciente();

            switch (opcao) {
                case 1: {
                    System.out.println("Informe o Novo Nome: ");
                    String novoNomePessoa = scanner.nextLine();

                    if (pessoaDAO.atualizaNomePessoa(pessoa.getNomePessoa(), novoNomePessoa,pessoa.getCpf()) == true) {
                        System.out.println("O Nome Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Nome Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Informe o Novo Cpf: ");
                    String novoCpf = scanner.nextLine();

                    if (pessoaDAO.atualizaCpfPessoa(pessoa.getCpf(), novoCpf) == true) {
                        System.out.println("O Cpf Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Cpf Informado Ja Se Encontra Cadastrado.");
                    }

                    break;
                }

                case 3: {
                    System.out.println("Informe o Novo Endereco: ");
                    String novoEndereco = scanner.nextLine();

                    if (pessoaDAO.atualizaEnderecoPessoa(pessoa.getEnderecoPessoa(), novoEndereco) == true) {
                        System.out.println("O Endereco Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar O Endereco");
                    }
                    break;
                }

                case 4: {
                    System.out.println("Informe o Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();

                    if (pessoaDAO.atualizaTelefonePessoa(pessoa.getTelefonePessoa(), novoTelefone, 
                            pessoa.getTipoUsuario()) == true) {
                        System.out.println("O Telefone Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Telefone Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }

                case 5: {
                    System.out.println("Informe o Novo Login: ");
                    String novoLogin = scanner.nextLine();

                    if (pessoaDAO.atualizaLoginPessoa(pessoa.getLoginPessoa(), novoLogin, pessoa.getTipoUsuario()) == true) {
                        System.out.println("O Login Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Login Informado Ja Se Encontra Cadastrado.");
                    }

                    break;
                }

                case 6: {
                    System.out.println("Informe a Nova Senha: ");
                    String novaSenha = scanner.nextLine();

                    if (pessoaDAO.atualizaSenhaPessoa(pessoa.getSenhaPessoa(), pessoa.getLoginPessoa(),
                            novaSenha, pessoa.getTipoUsuario()) == true) {
                        System.out.println("A Senha Foi Atualizada Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar A Senha");
                    }
                    break;
                }
            }

        } while (opcao != 0);
    }

}
