package Controller;

import Model.CalendarioSistema;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosUnidadeFranquia;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UnidadeFranquiaControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosUnidadeFranquia menuTitulosUnidadeFranquia = new MenuTitulosUnidadeFranquia();
    


    public UnidadeFranquiaControladora(UnidadeFranquia unidadeFranquia, UnidadeFranquiaDAO unidadeFranquiaDAO,
            MedicoDAO medicoDAO, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd, CalendarioSistema calendarioSistema) {

        menuOpcoesUnidadeFranquia(unidadeFranquia, unidadeFranquiaDAO, vd, medicoDAO, pessoaDAO, calendarioSistema);
    }

    private void menuOpcoesUnidadeFranquia(UnidadeFranquia unidadeFranquia,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd,
            MedicoDAO medicoDAO, PessoaDAO pessoaDAO, CalendarioSistema calendarioSistema) {

        int opcao;

        do {
            opcao = menuTitulosUnidadeFranquia.menuUnidadeFranquia();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + unidadeFranquiaDAO.buscaUnidadeDeFranquia(unidadeFranquia));
                    break;
                }
                case 2: {
                    System.out.println("\n" + unidadeFranquia.getPessoa());
                    break;
                }
                case 3: {
                    menuOpcoesAtualizaDadosUnidadeFranquia(unidadeFranquia, unidadeFranquiaDAO, vd);
                    break;
                }
                case 4: {
                     System.out.println("\n");
                     unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(unidadeFranquia.getFranquia());
                    break;
                }
                case 5: {
                     cadastraMedicos(medicoDAO, pessoaDAO, vd);
                    break;
                }
                case 6: {
                    System.out.println("\n");
                    medicoDAO.mostraTodosMedicos();
                    break;
                }
                case 7: {

                    break;
                }
                case 8: {

                    break;
                }
                case 9: {

                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizaDadosUnidadeFranquia(UnidadeFranquia unidadeFranquia,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd) {

        int opcao;

        do {
            opcao = menuTitulosUnidadeFranquia.menuAtualizacaoDeDadosUnidadeFranquia();

            switch (opcao) {
                case 1: {
                    System.out.println("\nInforme o Nova Cidade da Unidade De Franquia: ");
                    String novaCidadeUnidadeFranquia = scanner.nextLine();
                    novaCidadeUnidadeFranquia = vd.validaString(novaCidadeUnidadeFranquia);

                    if (unidadeFranquiaDAO.atualizaCidadeUnidadeFranquia(unidadeFranquia,
                            novaCidadeUnidadeFranquia) == true) {
                        System.out.println("\nCidade Da Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar A Cidade Da Unidade De Franquia.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nInforme o Novo Endereco da Unidade De Franquia: ");
                    String novoEnderecoUnidadeFranquia = scanner.nextLine();
                    novoEnderecoUnidadeFranquia = vd.validaString(novoEnderecoUnidadeFranquia);

                    if (unidadeFranquiaDAO.atualizaEnderecoUnidadeDeFranquia(unidadeFranquia,
                            novoEnderecoUnidadeFranquia) == true) {
                        System.out.println("\nEndereco Da Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar O Endereco Da Unidade De Franquia.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("\nInforme o Novo Login Dono De Unidade De Franquia: ");
                    String novoLoginDonoUnidadeFranquia = scanner.nextLine();
                    novoLoginDonoUnidadeFranquia = vd.validaString(novoLoginDonoUnidadeFranquia);

                    if (unidadeFranquiaDAO.atualizaLoginDonoDeUnidadeDeFranquia(unidadeFranquia,
                            novoLoginDonoUnidadeFranquia) == true) {
                        System.out.println("\nLogin Dono Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar O Login Dono Da Unidade De Franquia.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nInforme o Nova Senha Dono De Unidade De Franquia: ");
                    String novaSenhaDonoUnidadeFranquia = scanner.nextLine();
                    novaSenhaDonoUnidadeFranquia = vd.validaString(novaSenhaDonoUnidadeFranquia);

                    if (unidadeFranquiaDAO.atualizaSenhaDonoDeUnidadeDeFranquia(unidadeFranquia,
                            novaSenhaDonoUnidadeFranquia) == true) {
                        System.out.println("\nSenha Dono Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar A Senha Dono Da Unidade De Franquia.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("\nInforme o Novo Telefone Dono De Unidade De Franquia: ");
                    String novoTelefoneDonoUnidadeFranquia = scanner.nextLine();
                    novoTelefoneDonoUnidadeFranquia = vd.validaString(novoTelefoneDonoUnidadeFranquia);

                    if (unidadeFranquiaDAO.atualizaTelefoneDonoDeUnidadeDeFranquia(unidadeFranquia,
                            novoTelefoneDonoUnidadeFranquia) == true) {
                        System.out.println("\nTelefone Dono Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar O Telefone Dono Da Unidade De Franquia.");
                    }
                    break;

                }

            }
        } while (opcao != 0);

    }

    private void cadastraMedicos(MedicoDAO medicoDAO, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd) 
    {
        System.out.println("\n");
        pessoaDAO.filtraPessoasCandidatasAMedico();

        System.out.println("\nInforme o Id da pessoa que Sera Medico: ");
        int idPessoa = Integer.parseInt(scanner.nextLine());
        idPessoa = vd.validarINT(idPessoa);

        Pessoa pessoaEncontrada = pessoaDAO.buscaPessoaPorId(idPessoa);

        if (pessoaEncontrada == null) {
            System.out.println("\nPessoa Nao Encontrada");
        } else {

            if (medicoDAO.verificaSeMedicoExiste(pessoaEncontrada) == true) {
                System.out.println("\nPessoa ja Cadastrada Como Medico.");
            } else {

                System.out.println("\nInforme O Crm do Medico: ");
                String crm = scanner.nextLine();
                crm = vd.validaString(crm);

                if (medicoDAO.verificaCrm(crm) == true) {
                    System.out.println("\nO Crm Informado Ja Esta Sendo Usado.");
                } else {
                    System.out.println("\nInforme A Especialidade do Medico: ");
                    String medicoEspecialidade = scanner.nextLine();
                    medicoEspecialidade = vd.validaString(medicoEspecialidade);

                    System.out.println("\nInforme O Login De Medico: ");
                    String LoginMedico = scanner.nextLine();
                    LoginMedico = vd.validaString(LoginMedico);

      
                    if (medicoDAO.verificaSeloginEstaSendoUsado(LoginMedico) == true) {
                        System.out.println("\nLogin De Medico Ja Esta Sendo Usado!");
                    } else {
                        System.out.println("\nInforme A Senha De Medico: ");
                        String senhaMedico = scanner.nextLine();
                        senhaMedico = vd.validaString(senhaMedico);

                        Pessoa pessoaMedico = new Pessoa(pessoaEncontrada.getNomePessoa(),
                                pessoaEncontrada.getCpf(), pessoaEncontrada.getEnderecoPessoa(),
                                pessoaEncontrada.getTelefonePessoa(), 
                                LoginMedico, senhaMedico, "Medico", LocalDateTime.now());

                        if (pessoaDAO.adicionaPessoa(pessoaMedico) == true) {

                            Medico medico = new Medico(crm, pessoaMedico, medicoEspecialidade, LocalDateTime.now());

                            if (medicoDAO.adicionaMedico(medico) == true) {
                                System.out.println("\nMedico Cadastrado Com Sucesso!");
                            } else {
                                System.out.println("\nNao Foi Possivel Cadastrar o Medico.");
                            }
                        } else {
                            System.out.println("\n Erro ao Cadastrar medico.");
                        }
                    }

                }

            }

        }

    }

}
