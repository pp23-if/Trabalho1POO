package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosPaciente;
import java.util.Scanner;

public class PacienteControladora {

    Scanner scanner = new Scanner(System.in);

    MenuTitulosPaciente telaPaciente = new MenuTitulosPaciente();

    public PacienteControladora(Pessoa pessoa, PessoaDAO pessoaDAO,
            ValidacaoEntradaDados vd, MedicoDAO medicoDAO, FranquiaDAO franquiaDAO, 
            UnidadeFranquiaDAO unidadeFranquiaDAO) 
    {
        menuOpcoesPaciente(pessoa, pessoaDAO, vd, medicoDAO, franquiaDAO, unidadeFranquiaDAO);
    }

    private void menuOpcoesPaciente(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd, 
            MedicoDAO medicoDAO, FranquiaDAO franquiaDAO, UnidadeFranquiaDAO unidadeFranquiaDAO) {

        int opcao;

        do {
            opcao = telaPaciente.menuPaciente();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + pessoaDAO.buscaPessoaCadastrada(pessoa.getLoginPessoa(),
                            pessoa.getSenhaPessoa()));
                    break;
                }
                case 2: {
                    menuOpcoesAtualizarDadosPaciente(pessoa, pessoaDAO, vd);
                    break;
                }
                case 3:
                {
                    marcarConsulta(pessoa, pessoaDAO, vd, medicoDAO, franquiaDAO, unidadeFranquiaDAO);
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
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizarDadosPaciente(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd) {

        int opcao;

        do {
            opcao = telaPaciente.menuAlteraDadosPaciente();

            switch (opcao) {
                case 1: {
                    System.out.println("Informe o Novo Nome: ");
                    String novoNomePessoa = scanner.nextLine();
                    
                    if (pessoaDAO.atualizaNomePessoa(pessoa.getNomePessoa(), novoNomePessoa, pessoa.getCpf()) == true) {
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
    
    private void marcarConsulta(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd, 
            MedicoDAO medicoDAO, FranquiaDAO franquiaDAO, UnidadeFranquiaDAO unidadeFranquiaDAO)
    {
       franquiaDAO.mostraTodasFranquias();
       
        System.out.println("\nEscolha Uma Franquia Informando o ID - Franquia: ");
        int idFranquia = Integer.parseInt(scanner.nextLine());
        
         System.out.println("\n");
         Franquia franquiaSelecionada = franquiaDAO.buscaFranquiaPorId(idFranquia);
         
       if(franquiaSelecionada == null)
       {
           System.out.println("\nFranquia Nao Encontrada!");
       }
       else
       {
           System.out.println("\n");
           unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(franquiaSelecionada);
           
            System.out.println("\nEscolha Uma Unidade DE Franquia Informando o ID - Unidade De Franquia: ");
            int idUnidadeFranquia = Integer.parseInt(scanner.nextLine());
            
            UnidadeFranquia unidadeFranquiaSelecionada = unidadeFranquiaDAO.buscaUnidadeFranquiaPorId(idUnidadeFranquia);
            
            if(unidadeFranquiaSelecionada == null)
            {
              System.out.println("\nUnidade De Franquia Nao Encontrada!");  
            }
            else
            {
                System.out.println("\n");
                medicoDAO.mostraTodosMedicos();
                
                System.out.println("Informe O ID - MEDICO Do Qual Deseja Se Consultar: ");
                int idMedico = Integer.parseInt(scanner.nextLine());
                
                Medico medicoSelecionado = medicoDAO.buscaMedicoPorId(idMedico);
                
                if(medicoSelecionado == null)
                {
                  System.out.println("\nMedico Nao Encontrado!");   
                }
                else
                {
                    double valorConsulta = medicoDAO.verificaValorConsulta(medicoSelecionado);
                    
                    System.out.println("\nO Valor da Consulta Sera: " + valorConsulta + "\n"); 
                    
                    System.out.println("1 - Continuar: ");
                    System.out.println("2 - Sair: ");
                    
                }
            }
       }
    }

}
