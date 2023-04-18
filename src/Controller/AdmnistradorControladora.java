package Controller;

import Model.Admnistrador;
import Model.AdmnistradorDAO;
import Model.Consulta;
import Model.ConsultaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosAdmistrador;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AdmnistradorControladora {

    MenuTitulosAdmistrador telaAdmistrador = new MenuTitulosAdmistrador();

    Scanner scanner = new Scanner(System.in);

    public AdmnistradorControladora(PessoaDAO pessoaDAO,
            AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador, MedicoDAO medicoDAO) {

        menuOpcoesAdmnistrador(pessoaDAO, admnistradorDAO,
                unidadeFranquiaDAO, consultaDAO, vd, admnistrador, medicoDAO);

    }

    private void menuOpcoesAdmnistrador(PessoaDAO pessoaDAO,
            AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador, MedicoDAO medicoDAO) {

        int opcao;

        do {
            opcao = telaAdmistrador.menuAdmnistrador();

            switch (opcao) {
                case 1: {
                    System.out.println(admnistradorDAO.
                            buscaAdmnistradorAtravesPessoaVinculada(admnistrador.getPessoa()));

                    break;
                }
                case 2: {
                    menuOpcoesConsulta(consultaDAO, admnistrador,
                            unidadeFranquiaDAO, vd, pessoaDAO, medicoDAO);
                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void menuOpcoesConsulta(ConsultaDAO consultaDAO,
            Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd,
            PessoaDAO pessoaDAO, MedicoDAO medicoDAO) {

        int opcao;

        do {
            opcao = telaAdmistrador.menuConsultas();

            switch (opcao) {
                case 1: {
                    marcarConsulta(admnistrador, unidadeFranquiaDAO, vd,
                            pessoaDAO, medicoDAO, consultaDAO);

                    break;
                }
                case 2: {
                    consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());
                    break;
                }
                case 3: {
                    cancelarConsulta(consultaDAO, admnistrador, vd);
                    break;
                }
                case 4: {
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void marcarConsulta(Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd,
            PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO) {

        unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(admnistrador.getFranquia());

        System.out.println("Informe o ID da Unidade da Franquia que deseja realizar a consulta: ");
        int idUnidadeFranquia = Integer.parseInt(scanner.nextLine());
        idUnidadeFranquia = vd.validarINT(idUnidadeFranquia);

        UnidadeFranquia unidadeEncontrada = unidadeFranquiaDAO.
                buscaUnidadeFranquiaPorId(idUnidadeFranquia);

        if (unidadeEncontrada == null) {
            System.out.println("\nUnidade de franquia nao encontrada.");
        } else {
            pessoaDAO.filtraPacientes();

            System.out.println("Informe o ID Da pessoa que deseja marcar para consulta: ");
            int idPessoaConsulta = Integer.parseInt(scanner.nextLine());
            idPessoaConsulta = vd.validarINT(idPessoaConsulta);

            Pessoa pessoaEncontrada = pessoaDAO.buscaPessoaPorId(idPessoaConsulta);

            if (pessoaEncontrada == null) {
                System.out.println("\nPessoa nao encontrada");
            } else {

                medicoDAO.mostraTodosMedicos();

                System.out.println("Informe o ID Do Medico que deseja se consultar: ");
                int idMedico = Integer.parseInt(scanner.nextLine());
                idMedico = vd.validarINT(idMedico);

                Medico medicoEncontrado = medicoDAO.buscaMedicoPorId(idMedico);

                if (medicoEncontrado == null) {
                    System.out.println("\nmedico nao encontrado");
                } else {
                    if (medicoDAO.vericaSeMedicoEPacienteSaoIguais(pessoaEncontrada,
                            medicoEncontrado) == true) {

                        System.out.println("\nMedico e Paciente sao as Mesmas Pessoas..");
                    } else {
                        double valorConsulta = medicoDAO.verificaValorConsulta(medicoEncontrado);

                        DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        System.out.println("Informe a Nova Data Da Consulta No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
                        String dia = scanner.nextLine();
                        LocalDate diaConsulta = LocalDate.parse(dia, fdia);

                        System.out.println("Informe a Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
                        String Hora = scanner.nextLine();
                        LocalTime horaConsulta = LocalTime.parse(Hora);

                        Consulta novaConsulta = new Consulta(diaConsulta, horaConsulta,
                                medicoEncontrado, pessoaEncontrada, unidadeEncontrada,
                                valorConsulta, "Agendada", LocalDateTime.now());

                        if (consultaDAO.adicionaConsulta(novaConsulta) == true) {
                            System.out.println("\nConsulta marcada com sucesso.");
                        } else {
                            System.out.println("\nNao foi possivel marcar Consulta");
                        }

                    }

                }
            }

//            
        }

    }

    private void cancelarConsulta(ConsultaDAO consultaDAO,
            Admnistrador admnistrador, ValidacaoEntradaDados vd) {

        consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());

        System.out.println("Informe o ID da Consulta que deseja cancelar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        idConsulta = vd.validarINT(idConsulta);

        Consulta consultaEncontra = consultaDAO.buscaConsultaPorId(idConsulta);

        if (consultaEncontra == null) {
            System.out.println("\nConsulta nao Encontrada");
        } else {
            if (consultaDAO.buscaConsultaParaCancelar(consultaEncontra) == true) {
                System.out.println("\nConsulta cancelada com sucesso.");

            } else {
                System.out.println("\nNao foi Possivel cancelar Consulta..");
            }

        }
    }

}
