package Controller;

import Model.Admnistrador;
import Model.AdmnistradorDAO;
import Model.Consulta;
import Model.ConsultaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.ProcedimentoDAO;
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

    public AdmnistradorControladora(PessoaDAO pessoaDAO, AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador, MedicoDAO medicoDAO, ProcedimentoDAO procedimentoDAO) {

        menuOpcoesAdmnistrador(pessoaDAO, admnistradorDAO,
                unidadeFranquiaDAO, consultaDAO, vd, admnistrador, medicoDAO, procedimentoDAO);

    }

    private void menuOpcoesAdmnistrador(PessoaDAO pessoaDAO,
            AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador, MedicoDAO medicoDAO, ProcedimentoDAO procedimentoDAO) {

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
                    menuOpcoesProcedimento(consultaDAO, admnistrador, unidadeFranquiaDAO,
                            vd, pessoaDAO, medicoDAO, procedimentoDAO);
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
                    System.out.println("\n");
                    consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());
                    break;
                }
                case 3: {
                    cancelarConsulta(consultaDAO, admnistrador, vd);
                    break;
                }
                case 4: {
                    remarcarConsulta(admnistrador, unidadeFranquiaDAO, vd,
                            pessoaDAO, medicoDAO, consultaDAO);
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void marcarConsulta(Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd,
            PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO) {

        System.out.println("\n");
        unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(admnistrador.getFranquia());

        System.out.println("\nInforme o ID da Unidade da Franquia que deseja realizar a consulta: ");
        int idUnidadeFranquia = Integer.parseInt(scanner.nextLine());
        idUnidadeFranquia = vd.validarINT(idUnidadeFranquia);

        UnidadeFranquia unidadeEncontrada = unidadeFranquiaDAO.
                buscaUnidadeFranquiaPorId(idUnidadeFranquia);

        if (unidadeEncontrada == null) {
            System.out.println("\nUnidade de franquia nao encontrada.");
        } else {

            System.out.println("\n");
            pessoaDAO.filtraPacientes();

            System.out.println("\nInforme o ID Da pessoa que deseja marcar para consulta: ");
            int idPessoaConsulta = Integer.parseInt(scanner.nextLine());
            idPessoaConsulta = vd.validarINT(idPessoaConsulta);

            System.out.println("\n");
            Pessoa pessoaEncontrada = pessoaDAO.buscaPessoaPorId(idPessoaConsulta);

            if (pessoaEncontrada == null) {
                System.out.println("\nPessoa nao encontrada");
            } else {

                medicoDAO.mostraTodosMedicos();

                System.out.println("\nInforme o ID Do Medico que deseja se consultar: ");
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

                        System.out.println("\nInforme a Data Da Consulta No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
                        String dia = scanner.nextLine();
                        LocalDate diaConsulta = LocalDate.parse(dia, fdia);

                        System.out.println("\nInforme a Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
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

        }

    }

    private void cancelarConsulta(ConsultaDAO consultaDAO,
            Admnistrador admnistrador, ValidacaoEntradaDados vd) {

        System.out.println("\n");
        consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());

        System.out.println("\nInforme o ID da Consulta que deseja cancelar: ");
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

    private void remarcarConsulta(Admnistrador admnistrador, UnidadeFranquiaDAO unidadeFranquiaDAO,
            ValidacaoEntradaDados vd, PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO) {

        System.out.println("\n");
        consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());

        System.out.println("\nInforme o ID da consulta que desaja remarcar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        idConsulta = vd.validarINT(idConsulta);

        Consulta consultaEncontrada = consultaDAO.buscaConsultaPorId(idConsulta);

        if (consultaEncontrada == null) {
            System.out.println("\nConsulta Nao Encontrada");
        } else {
            DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("\nInforme a Nova Data Da Consulta No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
            String dia = scanner.nextLine();
            LocalDate diaConsulta = LocalDate.parse(dia, fdia);

            System.out.println("\nInforme a Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
            String Hora = scanner.nextLine();
            LocalTime horaConsulta = LocalTime.parse(Hora);

            if (consultaDAO.buscaConsultaParaRemarcar(diaConsulta, horaConsulta) == true) {
                System.out.println("\nDia e Hora Informados Indisponiveis.");
            } else {

                if (consultaDAO.atualizaDiaEHoraConsulta(diaConsulta, horaConsulta,
                        consultaEncontrada) == true) {

                    System.out.println("\nConsulta Remarcada Com Sucesso.");
                } else {
                    System.out.println("\nNao Foi Possivel Remarcar a Consulta, Conulta Realizada Ou Cancelada.");
                }
            }

        }
    }

    private void menuOpcoesProcedimento(ConsultaDAO consultaDAO, Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd, PessoaDAO pessoaDAO,
            MedicoDAO medicoDAO, ProcedimentoDAO procedimentoDAO) {

        int opcao;

        do {
            opcao = telaAdmistrador.menuProcedimentos();

            switch (opcao) {
                case 1: {

                    marcarProcedimento(pessoaDAO, medicoDAO, admnistrador, unidadeFranquiaDAO,
                            procedimentoDAO, vd);
                    break;
                }
                case 2: {

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

    private void marcarProcedimento(PessoaDAO pessoaDAO, MedicoDAO medicoDAO, Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ProcedimentoDAO procedimentoDAO, ValidacaoEntradaDados vd) {

        System.out.println("\n");
        pessoaDAO.filtraPacientes();

        System.out.println("\nInforme o ID - paciente que Ira Passar pelo Procedimento: ");
        int idPessoa = Integer.parseInt(scanner.nextLine());

        Pessoa pessoaEncontrada = pessoaDAO.buscaPessoaPorId(idPessoa);

        if (pessoaEncontrada == null) {
            System.out.println("\nPaciente Nao Encontrado.");
        } else {
            System.out.println("\n");
            medicoDAO.mostraTodosMedicos();

            System.out.println("\nInforme o ID - Medico que Ira Fazer O Procedimento: ");
            int idMedico = Integer.parseInt(scanner.nextLine());

            Medico medicoEncontrado = medicoDAO.buscaMedicoPorId(idMedico);

            if (medicoEncontrado == null) {
                System.out.println("\nMedico Nao Encontrado.");
            } else {
                System.out.println("\n");
                unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(admnistrador.getFranquia());

                System.out.println("\nInforme o ID - UnidadeFranquia Onde Ocorrera O Procedimento: ");
                int idUnidadeFranquia = Integer.parseInt(scanner.nextLine());

                UnidadeFranquia unidadeFranquiaEncontrada
                        = unidadeFranquiaDAO.buscaUnidadeFranquiaPorId(idUnidadeFranquia);

                if (unidadeFranquiaEncontrada == null) {
                    System.out.println("\nUnidade De Franquia Nao Encontrada.");
                } else 
                {
                    Consulta consulta = new Consulta(null, null, medicoEncontrado,
                            pessoaEncontrada, unidadeFranquiaEncontrada, 0, "", null);
                }

            }

        }
    }

}
