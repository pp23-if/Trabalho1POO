package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import View.MenuTitulos;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GerenciaControladoras {

    Scanner scanner = new Scanner(System.in);

    MenuTitulos Tela = new MenuTitulos();

    /*Instanciando os DAO.*/
    PessoaDAO pessoaDAO = new PessoaDAO();
    MedicoDAO medicoDAO = new MedicoDAO(pessoaDAO);
    FranquiaDAO franquiaDAO = new FranquiaDAO(pessoaDAO);

    public GerenciaControladoras() {

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
                    System.out.println("\nMostrando Todas as Franquias Cadastradas: " + "\n");
                    franquiaDAO.mostraTodasFranquias();
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

        existePessoa = pessoaDAO.verificaSePessoaExiste(loginPessoa, cpf);

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

                PacienteControladora pacienteControladora = new PacienteControladora(pessoaLogada, pessoaDAO);

            } else if (pessoaLogada.getTipoUsuario().equals("Medico")) {

                Medico medico = medicoDAO.buscaMedicoAtravesdaPessoaVinculada(pessoaLogada);

                MedicoControladora medicoControladora = new MedicoControladora(medico, medicoDAO);

            } else if (pessoaLogada.getTipoUsuario().equals("Dono de Franquia")) {

                Franquia franquia = franquiaDAO.buscaFranquiaAtravesDaPessoaVinculada(pessoaLogada);

                FranquiaControladora franquiaControladora = new FranquiaControladora(franquia, franquiaDAO);
            }

        } else {
            System.out.println("Nao Foi Possivel Fazer Login: Usuario Nao Encontrado OU "
                    + "Nao Cadastrado.");
        }
    }

}