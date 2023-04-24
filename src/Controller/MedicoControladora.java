package Controller;

import Model.Consulta;
import Model.ConsultaDAO;
import Model.InfoConsulta;
import Model.InfoConsultaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.Procedimento;
import Model.ProcedimentoDAO;
import View.MenuTitulosMedico;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MedicoControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosMedico telaMedico = new MenuTitulosMedico();

    public MedicoControladora(Medico medico, MedicoDAO medicoDAO, ValidacaoEntradaDados vd,
            ConsultaDAO consultaDAO, InfoConsultaDAO infoConsultaDAO,
            ProcedimentoDAO procedimentoDAO, PessoaDAO pessoaDAO) {

        menuOpcoesMedico(medico, medicoDAO, vd, consultaDAO, infoConsultaDAO, procedimentoDAO, pessoaDAO);

    }

    private void menuOpcoesMedico(Medico medico, MedicoDAO medicoDAO,
            ValidacaoEntradaDados vd, ConsultaDAO consultaDAO, InfoConsultaDAO infoConsultaDAO,
            ProcedimentoDAO procedimentoDAO, PessoaDAO pessoaDAO) {

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
                    menuOpcoesConsultaMedico(medico, consultaDAO, infoConsultaDAO, vd);
                    break;
                }
                case 4: {
                    menuOpcoesProcedimentosMedico(consultaDAO, procedimentoDAO, medico, vd);
                    break;
                }
                case 5: {
                    gerarRelatorioDeConsultasEProcedimentosDeUmDadoPaciente(consultaDAO, procedimentoDAO,
                            pessoaDAO, medico, vd);
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

                    System.out.println("\nInforme o Novo login De Medico: ");
                    String novologinMedico = scanner.nextLine();
                    novologinMedico = vd.validaString(novologinMedico);

                    if (medicoDAO.atualizaLoginMedico(medico, novologinMedico) == true) {
                        System.out.println("\nO Login De Medico Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nO Login De Medico Informado, Ja Se Encontra Cadastrado.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nInforme a Nova Senha De Medico: ");
                    String novaSenhaMedico = scanner.nextLine();
                    novaSenhaMedico = vd.validaString(novaSenhaMedico);

                    if (medicoDAO.atualizaSenhaMedico(medico, novaSenhaMedico) == true) {
                        System.out.println("\nA Senha De Medico Foi Atualizada Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar a Senha de Medico.");
                    }
                    break;
                }

                case 3: {
                    System.out.println("\nInforme o Novo Telefone De Medico: ");
                    String novoTelefoneMedico = scanner.nextLine();
                    novoTelefoneMedico = vd.validaString(novoTelefoneMedico);

                    if (medicoDAO.atualizaTelefoneMedico(medico, novoTelefoneMedico) == true) {
                        System.out.println("\nO Telefone De Medico Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("\nNao Foi Possivel Atualizar o Telefone de Medico.");
                    }
                    break;
                }
            }

        } while (opcao != 0);

    }

    private void menuOpcoesConsultaMedico(Medico medico, ConsultaDAO consultaDAO,
            InfoConsultaDAO infoConsultaDAO, ValidacaoEntradaDados vd) {

        int opcao;

        do {
            opcao = telaMedico.menuGerenciamentoConsultas();

            switch (opcao) {
                case 1: {

                    if (consultaDAO.atenderConsulta(medico, infoConsultaDAO) == true) {
                        System.out.println("\nConsulta atendida com sucesso.");
                    } else {
                        System.out.println("\nNao existe mais consultas marcadas.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n");
                    consultaDAO.buscaConsultaPorMedico(medico);
                    break;
                }
                case 3: {
                    System.out.println("\n");
                    infoConsultaDAO.buscaInfoConsultasPorMedico(medico);
                    break;
                }
                case 4: {
                    atualizaInfoConsulta(medico, infoConsultaDAO, vd);
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void atualizaInfoConsulta(Medico medico, InfoConsultaDAO infoConsultaDAO, ValidacaoEntradaDados vd) {

        System.out.println("\n");
        infoConsultaDAO.buscaInfoConsultasPorMedico(medico);

        System.out.println("\nInforme o ID - InfoConsulta Que Deseja Atualizar: ");
        int idInfoConsulta = Integer.parseInt(scanner.nextLine());
        idInfoConsulta = vd.validarINT(idInfoConsulta);

        InfoConsulta infoConsulta = infoConsultaDAO.buscaInfoConsultaPorId(idInfoConsulta);

        if (infoConsulta == null) {
            System.out.println("\nInfo Consulta Nao Encontrada.");
        } else {
            System.out.println("\nInforme A Descricao Da Info Consulta: ");
            String descricao = scanner.nextLine();

            if (infoConsultaDAO.atualizaDescricaoInfoConsulta(infoConsulta, descricao) == true) {
                System.out.println("\nDescricao Da Info Consulta Atualizada Com Sucesso!");
            } else {
                System.out.println("\nNao Foi Possivel Atualizar A Descricao Da Info Consulta.");
            }
        }
    }

    private void menuOpcoesProcedimentosMedico(ConsultaDAO consultaDAO,
            ProcedimentoDAO procedimentoDAO, Medico medico, ValidacaoEntradaDados vd) {

        int opcao;

        do {
            opcao = telaMedico.menuGerenciaProcedimentos();

            switch (opcao) {
                case 1: {
                    marcarProcedimentoComoMedico(consultaDAO, procedimentoDAO, medico, vd);
                    break;
                }
                case 2: {

                    break;
                }
                case 3: {
                    System.out.println("\n");
                    procedimentoDAO.buscaProcedimentoPorMedico(medico);
                    break;
                }
                case 4: {
                    cancelarProcedimentoComoMedico(procedimentoDAO, medico, vd);
                    break;
                }
                case 5: {
                    remarcarProcedimentoComoMedico(procedimentoDAO, medico, vd);
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void marcarProcedimentoComoMedico(ConsultaDAO consultaDAO,
            ProcedimentoDAO procedimentoDAO, Medico medico, ValidacaoEntradaDados vd) {

        System.out.println("\n");
        consultaDAO.buscaConsultaPorMedico(medico);

        System.out.println("\nInforme O ID - Consulta Que deseja Usar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        idConsulta = vd.validarINT(idConsulta);

        Consulta consultaEncontrada = consultaDAO.buscaConsultaPorId(idConsulta);

        if (consultaEncontrada == null) {
            System.out.println("\nConsulta Nao Encontrada.");
        } else {
            DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("\nQual procedimento Sera Feito: ");
            String nomeProcedimento = scanner.nextLine();
            nomeProcedimento = vd.validaString(nomeProcedimento);

            System.out.println("\nInforme a Data Do Procedimento No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
            String dia = scanner.nextLine();
            LocalDate diaProcedimento = LocalDate.parse(dia, fdia);

            System.out.println("\nInforme a Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
            String Hora = scanner.nextLine();
            LocalTime horaProcedimento = LocalTime.parse(Hora);

            Procedimento procedimento = new Procedimento(nomeProcedimento, consultaEncontrada, diaProcedimento,
                    horaProcedimento, "Agendado", 1500, "", LocalDateTime.now());

            if (procedimentoDAO.adicionaProcedimento(procedimento) == true) {
                System.out.println("\nProcedimento Marcado Com Sucesso!");
            } else {
                System.out.println("\nNao Foi Possivel Marcar o Procedimento.");
            }
        }

    }

    private void cancelarProcedimentoComoMedico(ProcedimentoDAO procedimentoDAO, Medico medico,
            ValidacaoEntradaDados vd) {

        System.out.println("\n");
        procedimentoDAO.buscaProcedimentoPorMedico(medico);

        System.out.println("\nInforme O ID - Procedimento Que Deseja Cancelar: ");
        int idProcedimento = Integer.parseInt(scanner.nextLine());
        idProcedimento = vd.validarINT(idProcedimento);

        Procedimento procedimentoEncontrado = procedimentoDAO.buscaProcedimentoPorId(idProcedimento);

        if (procedimentoEncontrado == null) {
            System.out.println("\nProcedimento Nao Encontrado.");
        } else {
            if (procedimentoDAO.recebeProcedimentoECancela(procedimentoEncontrado) == true) {
                System.out.println("\nProcedimento Cancelado Com Sucesso!");
            } else {
                System.out.println("\nNao Foi Possivel Cancelar O Procedimento.");
            }
        }

    }

    private void remarcarProcedimentoComoMedico(ProcedimentoDAO procedimentoDAO, Medico medico,
            ValidacaoEntradaDados vd) {
        
        System.out.println("\n");
        procedimentoDAO.buscaProcedimentoPorMedico(medico);

        System.out.println("\nInforme O ID - Procedimento Que Deseja Remarcar: ");
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
                        horaProcedimento, procedimentoEncontrado) == true) {
                    System.out.println("\nProcedimento Remarcado Com Sucesso!");
                } else {
                    System.out.println("\nNao Foi Possivel Remarcar O Procedimento.");
                }
            }
        }
    }

    private void realizarProcedimento(ProcedimentoDAO procedimentoDAO, Medico medico,
            ValidacaoEntradaDados vd) {

    }

    private void gerarRelatorioDeConsultasEProcedimentosDeUmDadoPaciente(ConsultaDAO consultaDAO,
            ProcedimentoDAO procedimentoDAO, PessoaDAO pessoaDAO, Medico medico, ValidacaoEntradaDados vd) {
        System.out.println("\n");
        pessoaDAO.filtraPacientes();

        System.out.println("\nInforme o ID - Pessoa: ");
        int idPessoa = Integer.parseInt(scanner.nextLine());
        idPessoa = vd.validarINT(idPessoa);

        Pessoa pessoaEncontrada = pessoaDAO.buscaPessoaPorId(idPessoa);

        if (pessoaEncontrada == null) {
            System.out.println("\nPaciente Nao Encontrado.");
        } else {
            System.out.println("\n******* - Paciente: " + pessoaEncontrada.getNomePessoa());
            System.out.println("\n ....... Consultas ........:");
            System.out.println("\n");
            consultaDAO.buscaConsultasQueTemMedicoSolicitanteEPacienteEscolhido(pessoaEncontrada, medico);

            System.out.println("\n ....... Procedimentos ........:");
            System.out.println("\n");
            procedimentoDAO.buscaProcedimentosQueTemMedicoSolicitanteEPacienteEscolhido(pessoaEncontrada, medico);

        }

    }
}
