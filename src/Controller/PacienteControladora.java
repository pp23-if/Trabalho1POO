package Controller;

import Model.CalendarioSistema;
import Model.ConsultaDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.ProcedimentoDAO;
import View.MenuTitulosPaciente;
import java.util.Scanner;

public class PacienteControladora {

    Scanner scanner = new Scanner(System.in);

    MenuTitulosPaciente telaPaciente = new MenuTitulosPaciente();

    public PacienteControladora(Pessoa pessoa, PessoaDAO pessoaDAO,
            ValidacaoEntradaDados vd, ConsultaDAO consultaDAO, ProcedimentoDAO procedimentoDAO, 
            CalendarioSistema calendarioSistema) {

        menuOpcoesPaciente(pessoa, pessoaDAO, vd, consultaDAO, procedimentoDAO, calendarioSistema);
    }

    private void menuOpcoesPaciente(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd,
            ConsultaDAO consultaDAO, ProcedimentoDAO procedimentoDAO, CalendarioSistema calendarioSistema) {

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
                    menuOpcoesAtualizarDadosPaciente(pessoa, pessoaDAO, vd, calendarioSistema);
                    break;
                }
                case 3: {
                    System.out.println("\n");
                    consultaDAO.buscaConsultaAtravesDaPessoaVinculada(pessoa);
                    break;
                }
                case 4: {
                     System.out.println("\n");
                     procedimentoDAO.buscaProcedimentoPorPaciente(pessoa);
                    break;
                }
                case 5: {
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizarDadosPaciente(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd, 
            CalendarioSistema calendarioSistema) {

        int opcao;

        do {
            opcao = telaPaciente.menuAlteraDadosPaciente();

            switch (opcao) {
                case 1: {
                    System.out.println("\nInforme o Novo Nome: ");
                    String novoNomePessoa = scanner.nextLine();
                    novoNomePessoa = vd.validaString(novoNomePessoa);

                    if (pessoaDAO.atualizaNomePessoa(pessoa.getNomePessoa(), novoNomePessoa, pessoa.getCpf(), 
                            calendarioSistema) == true) {
                        
                        System.out.println("\nO Nome Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nNome Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nInforme o Novo Cpf: ");
                    String novoCpf = scanner.nextLine();
                    novoCpf = vd.validaString(novoCpf);

                    if (pessoaDAO.atualizaCpfPessoa(pessoa.getCpf(), novoCpf, calendarioSistema) == true) {
                        System.out.println("\nO Cpf Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nCpf Informado Ja Se Encontra Cadastrado.");
                    }

                    break;
                }

                case 3: {
                    System.out.println("\nInforme o Novo Endereco: ");
                    String novoEndereco = scanner.nextLine();
                    novoEndereco = vd.validaString(novoEndereco);

                    if (pessoaDAO.atualizaEnderecoPessoa(pessoa.getEnderecoPessoa(), novoEndereco, calendarioSistema) == true) {
                        System.out.println("\nO Endereco Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar O Endereco");
                    }
                    break;
                }

                case 4: {
                    System.out.println("\nInforme o Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    novoTelefone = vd.validaString(novoTelefone);

                    if (pessoaDAO.atualizaTelefonePessoa(pessoa.getTelefonePessoa(), novoTelefone,
                            pessoa.getTipoUsuario(), calendarioSistema) == true) {
                        System.out.println("\nO Telefone Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nTelefone Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }

                case 5: {
                    System.out.println("\nInforme o Novo Login: ");
                    String novoLogin = scanner.nextLine();
                    novoLogin = vd.validaString(novoLogin);

                    if (pessoaDAO.atualizaLoginPessoa(pessoa.getLoginPessoa(), novoLogin, 
                            pessoa.getTipoUsuario(), calendarioSistema) == true) {
                        System.out.println("\nO Login Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nLogin Informado Ja Se Encontra Cadastrado.");
                    }

                    break;
                }

                case 6: {
                    System.out.println("\nInforme a Nova Senha: ");
                    String novaSenha = scanner.nextLine();
                    novaSenha = vd.validaString(novaSenha);

                    if (pessoaDAO.atualizaSenhaPessoa(pessoa.getSenhaPessoa(), pessoa.getLoginPessoa(),
                            novaSenha, pessoa.getTipoUsuario(), calendarioSistema) == true) {
                        System.out.println("\nA Senha Foi Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar A Senha");
                    }
                    break;
                }
            }

        } while (opcao != 0);
    }

}
