package Controller;

import Model.Admnistrador;
import Model.AdmnistradorDAO;
import Model.CalendarioSistema;
import Model.Consulta;
import Model.ConsultaDAO;
import Model.FinanceiroAdmDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.Procedimento;
import Model.ProcedimentoDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosAdmistrador;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AdmnistradorControladora {

    MenuTitulosAdmistrador telaAdmistrador = new MenuTitulosAdmistrador();

    Scanner scanner = new Scanner(System.in);

    public AdmnistradorControladora(PessoaDAO pessoaDAO, AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador, MedicoDAO medicoDAO, ProcedimentoDAO procedimentoDAO,
            CalendarioSistema calendarioSistema, FinanceiroAdmDAO financeiroAdmDAO) {

        menuOpcoesAdmnistrador(pessoaDAO, admnistradorDAO,
                unidadeFranquiaDAO, consultaDAO, vd, admnistrador, medicoDAO, procedimentoDAO, calendarioSistema,
                financeiroAdmDAO);

    }

    private void menuOpcoesAdmnistrador(PessoaDAO pessoaDAO,
            AdmnistradorDAO admnistradorDAO, UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO, ValidacaoEntradaDados vd, Admnistrador admnistrador,
            MedicoDAO medicoDAO, ProcedimentoDAO procedimentoDAO, CalendarioSistema calendarioSistema,
            FinanceiroAdmDAO financeiroAdmDAO) {

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
                            unidadeFranquiaDAO, vd, pessoaDAO, medicoDAO, calendarioSistema);
                    break;
                }
                case 3: {
                    menuOpcoesProcedimento(consultaDAO, admnistrador, unidadeFranquiaDAO,
                            vd, pessoaDAO, medicoDAO, procedimentoDAO, calendarioSistema);
                    break;
                }
                case 4: {
                    menuOpcoesFinanceiro(financeiroAdmDAO, calendarioSistema,
                            consultaDAO, procedimentoDAO, admnistrador);
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void menuOpcoesConsulta(ConsultaDAO consultaDAO,
            Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd,
            PessoaDAO pessoaDAO, MedicoDAO medicoDAO, CalendarioSistema calendarioSistema) {

        int opcao;

        do {
            opcao = telaAdmistrador.menuConsultas();

            switch (opcao) {
                case 1: {
                    marcarConsulta(admnistrador, unidadeFranquiaDAO, vd,
                            pessoaDAO, medicoDAO, consultaDAO, calendarioSistema);

                    break;
                }
                case 2: {
                    System.out.println("\n");
                    consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());
                    break;
                }
                case 3: {
                    cancelarConsulta(consultaDAO, admnistrador, vd, calendarioSistema);
                    break;
                }
                case 4: {
                    remarcarConsulta(admnistrador, unidadeFranquiaDAO, vd,
                            pessoaDAO, medicoDAO, consultaDAO, calendarioSistema);
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void marcarConsulta(Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd,
            PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO, CalendarioSistema calendarioSistema) {

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
                                valorConsulta, "Agendada", calendarioSistema.getDataHoraSistema());

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
            Admnistrador admnistrador, ValidacaoEntradaDados vd, CalendarioSistema calendarioSistema) {

        System.out.println("\n");
        consultaDAO.buscaConsultaPorFranquia(admnistrador.getFranquia());

        System.out.println("\nInforme o ID da Consulta que deseja cancelar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        idConsulta = vd.validarINT(idConsulta);

        Consulta consultaEncontra = consultaDAO.buscaConsultaPorId(idConsulta);

        if (consultaEncontra == null) {
            System.out.println("\nConsulta nao Encontrada");
        } else {
            if (consultaDAO.receConsultaECancela(consultaEncontra, calendarioSistema) == true) {
                System.out.println("\nConsulta cancelada com sucesso.");

            } else {
                System.out.println("\nNao foi Possivel cancelar Consulta..");
            }

        }
    }

    private void remarcarConsulta(Admnistrador admnistrador, UnidadeFranquiaDAO unidadeFranquiaDAO,
            ValidacaoEntradaDados vd, PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO,
            CalendarioSistema calendarioSistema) {

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

            System.out.println("\nInforme a Nova Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
            String Hora = scanner.nextLine();
            LocalTime horaConsulta = LocalTime.parse(Hora);

            if (consultaDAO.verificaDisponibilidadeDiaEHora(diaConsulta, horaConsulta) == true) {
                System.out.println("\nDia e Hora Informados Indisponiveis.");
            } else {

                if (consultaDAO.recebeConsultaERemarca(diaConsulta, horaConsulta,
                        consultaEncontrada, calendarioSistema) == true) {

                    System.out.println("\nConsulta Remarcada Com Sucesso.");
                } else {
                    System.out.println("\nNao Foi Possivel Remarcar a Consulta, Conulta Realizada Ou Cancelada.");
                }
            }

        }
    }

    private void menuOpcoesProcedimento(ConsultaDAO consultaDAO, Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ValidacaoEntradaDados vd, PessoaDAO pessoaDAO,
            MedicoDAO medicoDAO, ProcedimentoDAO procedimentoDAO, CalendarioSistema calendarioSistema) {

        int opcao;

        do {
            opcao = telaAdmistrador.menuProcedimentos();

            switch (opcao) {
                case 1: {

                    marcarProcedimento(pessoaDAO, medicoDAO, admnistrador, unidadeFranquiaDAO,
                            procedimentoDAO, vd, calendarioSistema);
                    break;
                }
                case 2: {
                    System.out.println("\n");
                    procedimentoDAO.buscaProcedimentoPorFranquia(admnistrador.getFranquia());
                    break;
                }
                case 3: {
                    cancelarProcedimento(procedimentoDAO, admnistrador, vd, calendarioSistema);
                    break;
                }
                case 4: {
                    remarcarProcedimento(procedimentoDAO, admnistrador, vd, calendarioSistema);
                    break;
                }

            }

        } while (opcao != 0);

    }

    private void marcarProcedimento(PessoaDAO pessoaDAO, MedicoDAO medicoDAO, Admnistrador admnistrador,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ProcedimentoDAO procedimentoDAO, ValidacaoEntradaDados vd,
            CalendarioSistema calendarioSistema) {

        System.out.println("\n");
        pessoaDAO.filtraPacientes();

        System.out.println("\nInforme o ID - paciente que Ira Passar pelo Procedimento: ");
        int idPessoa = Integer.parseInt(scanner.nextLine());
        idPessoa = vd.validarINT(idPessoa);

        Pessoa pessoaEncontrada = pessoaDAO.buscaPessoaPorId(idPessoa);

        if (pessoaEncontrada == null) {
            System.out.println("\nPaciente Nao Encontrado.");
        } else {
            System.out.println("\n");
            medicoDAO.mostraTodosMedicos();

            System.out.println("\nInforme o ID - Medico que Ira Fazer O Procedimento: ");
            int idMedico = Integer.parseInt(scanner.nextLine());
            idMedico = vd.validarINT(idMedico);

            Medico medicoEncontrado = medicoDAO.buscaMedicoPorId(idMedico);

            if (medicoEncontrado == null) {
                System.out.println("\nMedico Nao Encontrado.");
            } else {
                System.out.println("\n");
                unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(admnistrador.getFranquia());

                System.out.println("\nInforme o ID - UnidadeFranquia Onde Ocorrera O Procedimento: ");
                int idUnidadeFranquia = Integer.parseInt(scanner.nextLine());
                idUnidadeFranquia = vd.validarINT(idUnidadeFranquia);

                UnidadeFranquia unidadeFranquiaEncontrada
                        = unidadeFranquiaDAO.buscaUnidadeFranquiaPorId(idUnidadeFranquia);

                if (unidadeFranquiaEncontrada == null) {
                    System.out.println("\nUnidade De Franquia Nao Encontrada.");
                } else {

                    DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    System.out.println("\nQual procedimento Sera Feito: ");
                    String nomeProcedimento = scanner.nextLine();
                    nomeProcedimento = vd.validaString(nomeProcedimento);

                    System.out.println("\nInforme a Data Do Procedimento No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
                    String dia = scanner.nextLine();
                    LocalDate diaProcediemnto = LocalDate.parse(dia, fdia);

                    System.out.println("\nInforme a Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
                    String Hora = scanner.nextLine();
                    LocalTime horaProcedimento = LocalTime.parse(Hora);

                    Consulta consulta = new Consulta(diaProcediemnto, horaProcedimento, medicoEncontrado,
                            pessoaEncontrada, unidadeFranquiaEncontrada, 0, "Realizada",
                            calendarioSistema.getDataHoraSistema());

                    Procedimento procedimento = new Procedimento(nomeProcedimento, consulta,
                            diaProcediemnto, horaProcedimento, "Agendado", 1500, "",
                            calendarioSistema.getDataHoraSistema());

                    if (procedimentoDAO.adicionaProcedimento(procedimento) == true) {
                        System.out.println("\nProcedimento Marcado Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Marcar O Procediemnto.");
                    }

                }

            }

        }
    }

    private void cancelarProcedimento(ProcedimentoDAO procedimentoDAO, Admnistrador admnistrador,
            ValidacaoEntradaDados vd, CalendarioSistema calendarioSistema) {
        System.out.println("\n");
        procedimentoDAO.buscaProcedimentoPorFranquia(admnistrador.getFranquia());

        System.out.println("\nInforme o ID - Procedimento Que Deseja Cancelar: ");
        int idProcedimento = Integer.parseInt(scanner.nextLine());
        idProcedimento = vd.validarINT(idProcedimento);

        Procedimento procedimentoEncontrado = procedimentoDAO.buscaProcedimentoPorId(idProcedimento);

        if (procedimentoEncontrado == null) {
            System.out.println("\nProcedimento Nao Encontrado.");
        } else {
            if (procedimentoDAO.recebeProcedimentoECancela(procedimentoEncontrado, calendarioSistema) == true) {
                System.out.println("\nProcedimento Cancelado Com Sucesso!");
            } else {
                System.out.println("\nNao Foi Possivel Cancelar O Procedimento.");
            }
        }
    }

    private void remarcarProcedimento(ProcedimentoDAO procedimentoDAO, Admnistrador admnistrador,
            ValidacaoEntradaDados vd, CalendarioSistema calendarioSistema) {

        System.out.println("\n");
        procedimentoDAO.buscaProcedimentoPorFranquia(admnistrador.getFranquia());

        System.out.println("\nInforme o ID - Procedimento Que Deseja Remarcar: ");
        int idProcedimento = Integer.parseInt(scanner.nextLine());
        idProcedimento = vd.validarINT(idProcedimento);

        Procedimento procedimentoEncontrado = procedimentoDAO.buscaProcedimentoPorId(idProcedimento);

        if (procedimentoEncontrado == null) {
            System.out.println("\nProcedimento Nao Encontrado.");
        } else {
            DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("\nInforme a Nova Data Do Procedimento No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
            String dia = scanner.nextLine();
            LocalDate diaProcedimento = LocalDate.parse(dia, fdia);

            System.out.println("\nInforme a Nova Hora Do Procedimento No Seguinte Formato, Hora:Minutos (00:00)..: ");
            String Hora = scanner.nextLine();
            LocalTime horaProcedimento = LocalTime.parse(Hora);

            if (procedimentoDAO.verificaDisponibilidadeDataEHoraProcedimento(diaProcedimento, horaProcedimento) == true) {
                System.out.println("\nDia e hora Informados, Indisponiveis.");
            } else {
                if (procedimentoDAO.recebeProcedimentoERemarca(diaProcedimento,
                        horaProcedimento, procedimentoEncontrado, calendarioSistema) == true) {
                    System.out.println("\nProcedimento Remarcado Com Sucesso!");
                } else {
                    System.out.println("\nNao Foi Possivel Remarcar O Procedimento.");
                }
            }

        }

    }

    private void menuOpcoesFinanceiro(FinanceiroAdmDAO financeiroAdmDAO,
            CalendarioSistema calendarioSistema, ConsultaDAO consultaDAO,
            ProcedimentoDAO procedimentoDAO, Admnistrador admnistrador) {

        int opcao;

        do {
            System.out.println("\nData e Hora do Sistema: " + calendarioSistema.getDataHoraSistema().format(DateTimeFormatter.
                    ofPattern("dd/MM/yyyy HH:mm:ss")));
            opcao = telaAdmistrador.menuFinanceiroAdm();

            int dias = 0;
            switch (opcao) {
                case 1: {
                    dias++;
                    if (calendarioSistema.passaDias(dias) == true) {
                        System.out.println("\nDia Encerrado com sucesso.");
                        cancelaConsultasNaoAtendidasNoDia(consultaDAO, calendarioSistema);
                        cancelaProcedimentosNaoAtendidosNoDia(procedimentoDAO, calendarioSistema);
                        verificaSeEhPrimeiroDiaDoMes(calendarioSistema);
                    } else {
                        System.out.println("\nNao foi possivel Encerrar o dia");
                    }

                    break;
                }
                case 2: {
                    System.out.println("\nO valor Somado Da CONSULTA E PROCEDIMENTO SAO: " + 
                            financeiroAdmDAO.calculaRendaBruta(calendarioSistema));
                    
                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    System.out.println("\n");
                    financeiroAdmDAO.buscaMovimentacoesFinanceirasPorFranquia(admnistrador.getFranquia());
                    break;
                }

            }

        } while (opcao != 0);
    }

    private void cancelaConsultasNaoAtendidasNoDia(ConsultaDAO consultaDAO,
            CalendarioSistema calendarioSistema) {

        if (consultaDAO.cancelaConsultasNaoRealizadasNoDia(calendarioSistema) == true) {
            System.out.println("\nTodas Consultas Nao realizadas No Dia Anterior Foram Canceladas.");
        }
    }

    private void cancelaProcedimentosNaoAtendidosNoDia(ProcedimentoDAO procedimentoDAO,
            CalendarioSistema calendarioSistema) {
        if (procedimentoDAO.cancelaProcedimentosNaoRealizadosNoDia(calendarioSistema) == true) {
            System.out.println("\nTodos Procedimentos Nao Realizados No Dia Anterior Foram Cancelados.");
        }
    }
    
    private void verificaSeEhPrimeiroDiaDoMes(CalendarioSistema calendarioSistema)
    {
        
    }

}
