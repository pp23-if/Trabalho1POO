package Controller;

import Model.Medico;
import Model.MedicoDAO;
import View.MenuTitulosMedico;
import java.util.Scanner;

public class MedicoControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosMedico telaMedico = new MenuTitulosMedico();
    
    /*Instanciando a Classe de Validacao de dados.*/
    ValidacaoEntradaDados vd = new ValidacaoEntradaDados();

    public MedicoControladora(Medico medico, MedicoDAO medicoDAO, ValidacaoEntradaDados vd) {

        menuOpcoesMedico(medico, medicoDAO, vd);

    }

    private void menuOpcoesMedico(Medico medico, MedicoDAO medicoDAO, ValidacaoEntradaDados vd) {

        int opcao;

        do {
            opcao = telaMedico.menuMedico();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + medicoDAO.buscaMedico(medico));
                    break;
                }
                case 2: {
                    menuOpcoesAtualizarDadosMedico(medico, medicoDAO, vd);
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizarDadosMedico(Medico medico, MedicoDAO medicoDAO, ValidacaoEntradaDados vd) {
        int opcao;

        do {
            opcao = telaMedico.menuAlteraDadosMedico();

            switch (opcao) {
                case 1: {

                    System.out.println("Informe o Novo login De Medico: ");
                    String novologinMedico = scanner.nextLine();
                    novologinMedico = vd.validaString(novologinMedico);

                    if (medicoDAO.atualizaLoginMedico(medico, novologinMedico) == true) {
                        System.out.println("O Login De Medico Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("O Login De Medico Informado, Ja Se Encontra Cadastrado.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Informe a Nova Senha De Medico: ");
                    String novaSenhaMedico = scanner.nextLine();
                    novaSenhaMedico = vd.validaString(novaSenhaMedico);

                    if (medicoDAO.atualizaSenhaMedico(medico, novaSenhaMedico) == true) {
                        System.out.println("A Senha De Medico Foi Atualizada Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar a Senha de Medico.");
                    }
                    break;
                }
                
                case 3: {
                    System.out.println("Informe o Novo Telefone De Medico: ");
                    String novoTelefoneMedico = scanner.nextLine();
                    novoTelefoneMedico = vd.validaString(novoTelefoneMedico);

                    if (medicoDAO.atualizaTelefoneMedico(medico, novoTelefoneMedico) == true) {
                        System.out.println("O Telefone De Medico Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar o Telefone de Medico.");
                    }
                    break;
                }
            }

        } while (opcao != 0);

    }
}
