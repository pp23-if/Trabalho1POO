package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.PessoaDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosUnidadeFranquia;
import java.util.Scanner;

public class UnidadeFranquiaControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosUnidadeFranquia menuTitulosUnidadeFranquia = new MenuTitulosUnidadeFranquia();

    public UnidadeFranquiaControladora(UnidadeFranquia unidadeFranquia, UnidadeFranquiaDAO unidadeFranquiaDAO, 
            MedicoDAO medicoDAO, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd) {
        
        menuOpcoesUnidadeFranquia(unidadeFranquia, unidadeFranquiaDAO, vd, medicoDAO, pessoaDAO);
    }

    private void menuOpcoesUnidadeFranquia(UnidadeFranquia unidadeFranquia, 
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd, 
            MedicoDAO medicoDAO, PessoaDAO pessoaDAO) {

        int opcao;

        do {
            opcao = menuTitulosUnidadeFranquia.menuUnidadeFranquia();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + unidadeFranquiaDAO.buscaUnidadeDeFranquia(unidadeFranquia));
                    break;
                }
                case 2: {
                    menuOpcoesAtualizaDadosUnidadeFranquia(unidadeFranquia, unidadeFranquiaDAO, vd);
                    break;
                }
                case 3: {
                    unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(unidadeFranquia.getFranquia());
                    break;
                }
                case 4: {
                    cadastraMedicos(medicoDAO, pessoaDAO);
                    break;
                }
                case 5: {
                    System.out.println("\n======== VETOR DE MEDICOS ===========\n");
                    medicoDAO.mostraTodosMedicos();
                    break;
                }
                case 6: {

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
                    System.out.println("Informe o Nova Cidade da Unidade De Franquia: ");
                    String novaCidadeUnidadeFranquia = scanner.nextLine();

                    if (unidadeFranquiaDAO.atualizaCidadeUnidadeFranquia(unidadeFranquia,
                            novaCidadeUnidadeFranquia) == true) {
                        System.out.println("Cidade Da Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar A Cidade Da Unidade De Franquia.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Informe o Novo Endereco da Unidade De Franquia: ");
                    String novoEnderecoUnidadeFranquia = scanner.nextLine();

                    if (unidadeFranquiaDAO.atualizaEnderecoUnidadeDeFranquia(unidadeFranquia,
                            novoEnderecoUnidadeFranquia) == true) {
                        System.out.println("Endereco Da Unidade De Franquia Atualizada Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar O Endereco Da Unidade De Franquia.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Informe o Novo Login Dono De Unidade De Franquia: ");
                    String novoLoginDonoUnidadeFranquia = scanner.nextLine();
                    
                    if(unidadeFranquiaDAO.atualizaLoginDonoDeUnidadeDeFranquia(unidadeFranquia, 
                            novoLoginDonoUnidadeFranquia) == true)
                    {
                      System.out.println("Login Dono Unidade De Franquia Atualizada Com Sucesso!");  
                    }
                    else
                    {
                      System.out.println("Nao Foi Possivel Atualizar O Login Dono Da Unidade De Franquia.");  
                    }
                    break;
                }
                case 4: {
                    System.out.println("Informe o Nova Senha Dono De Unidade De Franquia: ");
                    String novaSenhaDonoUnidadeFranquia = scanner.nextLine();
                    
                    if(unidadeFranquiaDAO.atualizaSenhaDonoDeUnidadeDeFranquia(unidadeFranquia,
                            novaSenhaDonoUnidadeFranquia) == true)
                    {
                       System.out.println("Senha Dono Unidade De Franquia Atualizada Com Sucesso!");    
                    }
                    else
                    {
                      System.out.println("Nao Foi Possivel Atualizar A Senha Dono Da Unidade De Franquia.");    
                    }
                    break;
                }
                case 5: {
                    System.out.println("Informe o Novo Telefone Dono De Unidade De Franquia: ");
                    String novoTelefoneDonoUnidadeFranquia = scanner.nextLine();
                    
                    if(unidadeFranquiaDAO.atualizaTelefoneDonoDeUnidadeDeFranquia(unidadeFranquia, 
                            novoTelefoneDonoUnidadeFranquia) == true)
                    {
                      System.out.println("Telefone Dono Unidade De Franquia Atualizada Com Sucesso!");     
                    }
                    else
                    {
                       System.out.println("Nao Foi Possivel Atualizar O Telefone Dono Da Unidade De Franquia.");       
                    }
                    break;

                }

            }
        } while (opcao != 0);

    }
    
    private void cadastraMedicos(MedicoDAO medicoDAO, PessoaDAO pessoaDAO)
    {
        
    }

}
