package Controller;

import Model.Medico;
import Model.MedicoDAO;
import View.MenuTitulosMedico;
import java.util.Scanner;

public class MedicoControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosMedico telaMedico = new MenuTitulosMedico();

    public MedicoControladora(Medico medico, MedicoDAO medicoDAO) {

        menuOpcoesMedico(medico, medicoDAO);

    }

    private void menuOpcoesMedico(Medico medico, MedicoDAO medicoDAO) {

        int opcao;

        do {
            opcao = telaMedico.menuMedico();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + medicoDAO.mostraDadosMedicoLogado(medico.getPessoa().getLoginPessoa(),
                            medico.getPessoa().getSenhaPessoa()));
                    break;
                }
                case 2: {
                    menuOpcoesAtualizarDadosMedico(medico, medicoDAO);
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizarDadosMedico(Medico medico, MedicoDAO medicoDAO) {
        int opcao;

        do {
            opcao = telaMedico.menuAlteraDadosMedico();

            switch (opcao) {
                case 1: {

                    System.out.println("Informe o Novo login Do Medico: ");
                    String novologinMedico = scanner.nextLine();

                    if (medicoDAO.atualizaLoginMedico(medico.getPessoa().getLoginPessoa(), novologinMedico) == true) {
                        System.out.println("O Login De Medico Foi Alterado Com Sucesso!");
                    } else {
                        System.out.println("O Login De Medico Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }
                case 2: {

                    break;
                }
            }

        } while (opcao != 0);

    }
}
