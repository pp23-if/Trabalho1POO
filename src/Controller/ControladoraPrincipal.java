package Controller;

import Model.Pessoa;
import Model.PessoaDAO;
import View.MenuTitulos;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ControladoraPrincipal {

    Scanner scanner = new Scanner(System.in);
    MenuTitulos Tela = new MenuTitulos();
    PessoaDAO pessoaDAO = new PessoaDAO();

    public ControladoraPrincipal() {

        int opcao;

        do {

            opcao = Tela.menuInicial();

            switch (opcao) {
                case 1: {
                    System.out.println("\nLogin: ");
                    String login = scanner.nextLine();
                    System.out.println("\n");

                    System.out.println("Senha: ");
                    String senha = scanner.nextLine();
                    System.out.println("\n");

                    Pessoa pessoaLogada = pessoaDAO.fazLogin(login, senha);

                    if (pessoaLogada != null) {
                        System.out.println("Login efetuado Com Sucesso!");
                        System.out.println("Logado Como: " + pessoaLogada.getTipoUsuario());

                        if (pessoaLogada.getTipoUsuario().equals("Paciente")) {
                            
                            menuOpcoesPaciente(pessoaLogada);
                        }
                        
                    } else {
                        System.out.println("Nao Foi Possivel Fazer Login: Usuario Nao Encontrado OU "
                                + "Nao Cadastrado.");
                    }

                    break;
                }

                case 2: {

                    cadastrarPessoa();

                    break;
                }

                case 3: {
                    System.out.println("\nMostrando Todas as Pessoas Cadastradas: ");
                    pessoaDAO.mostraTodasPessoas();
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

        existePessoa = pessoaDAO.verificaSePessoaExiste(loginPessoa, tipoUsuario, nomePessoa);

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

    private void menuOpcoesPaciente(Pessoa pessoa) {
       
        int opcao;
        
         do
         {
             opcao = Tela.menuPaciente();
             
             switch(opcao)
             {
                 case 1:
                 {
                     System.out.println(pessoaDAO.mostraDadosPessoaLogada(pessoa.getLoginPessoa(), pessoa.getSenhaPessoa()));
                     break;
                 }
                 case 2:
                 {
                     menuOpcoesAtualizarDadosPaciente(pessoa);
                     break;
                 }
             }
             
         }while(opcao != 0);
    }
    
    
    private void menuOpcoesAtualizarDadosPaciente(Pessoa pessoa) {
       
        int opcao;
        
         do
         {
             opcao = Tela.menuAlteraDadosPaciente();
             
             switch(opcao)
             {
                 case 1:
                 {
                     System.out.println("Informe o Novo Nome: ");
                     String novoNomePessoa = scanner.nextLine();
                     
                     if(pessoaDAO.atualizaNomePessoa(pessoa, novoNomePessoa) == true)
                     {
                         System.out.println("O Nome Foi Alterado Com Sucesso!");
                     }
                     else
                     {
                       System.out.println("Nao Foi Possivel Alterar O Nonme");  
                     }
                     break;
                 }
                 case 2:
                 {
                     
                     break;
                 }
                 
                 case 3:
                 {
                     
                     break;
                 }
                 
                 case 4:
                 {
                     
                     break;
                 }
                 
                 case 5:
                 {
                     
                     break;
                 }
                 
                 case 6:
                 {
                     
                     break;
                 }
             }
             
         }while(opcao != 0);
    }

}
