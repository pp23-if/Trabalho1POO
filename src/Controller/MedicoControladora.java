package Controller;

import Model.ConsultaDAO;
import Model.Medico;
import Model.MedicoDAO;
import View.MenuTitulosMedico;
import java.util.Scanner;

public class MedicoControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosMedico telaMedico = new MenuTitulosMedico();

    public MedicoControladora(Medico medico, MedicoDAO medicoDAO, ValidacaoEntradaDados vd, ConsultaDAO consultaDAO) {

        menuOpcoesMedico(medico, medicoDAO, vd, consultaDAO);

    }

    private void menuOpcoesMedico(Medico medico, MedicoDAO medicoDAO,
            ValidacaoEntradaDados vd, ConsultaDAO consultaDAO) {

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
                case 3: {

                    menuOpcoesConsultaMedico(medico, consultaDAO);
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

    private void menuOpcoesConsultaMedico(Medico medico, ConsultaDAO consultaDAO) {

        int opcao;

        do {
            opcao = telaMedico.menuGerenciamentoConsultas();

            switch (opcao) {
                case 1: {

                    if (consultaDAO.atenderConsulta(medico) == true) {
                        System.out.println("\nConsulta atendida com sucesso.");
                    }else{
                        System.out.println("\nNao existe mais consultas marcadas.");
                    }
                    break;
                }
                case 2: {
                    consultaDAO.buscaConsultaPorMedico(medico);
                    break;
                }
            }

        } while (opcao != 0);
    }

}
