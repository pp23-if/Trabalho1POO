package Controller;

import Model.Consulta;
import Model.ConsultaDAO;
import Model.Franquia;
import Model.FranquiaDAO;
import Model.Medico;
import Model.MedicoDAO;
import Model.Pessoa;
import Model.PessoaDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosPaciente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PacienteControladora {

    Scanner scanner = new Scanner(System.in);

    MenuTitulosPaciente telaPaciente = new MenuTitulosPaciente();
    
    /*Instanciando a Classe de Validacao de dados.*/
    ValidacaoEntradaDados vd = new ValidacaoEntradaDados();

    public PacienteControladora(Pessoa pessoa, PessoaDAO pessoaDAO,
            ValidacaoEntradaDados vd, MedicoDAO medicoDAO, FranquiaDAO franquiaDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO, ConsultaDAO consultaDAO) {

        menuOpcoesPaciente(pessoa, pessoaDAO, vd, medicoDAO, franquiaDAO, unidadeFranquiaDAO, consultaDAO);
    }

    private void menuOpcoesPaciente(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd,
            MedicoDAO medicoDAO, FranquiaDAO franquiaDAO, UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO) {

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
                    menuOpcoesAtualizarDadosPaciente(pessoa, pessoaDAO, vd);
                    break;
                }
                case 3: {
                    menuOpcoesConsulta(pessoa, vd, medicoDAO, franquiaDAO, unidadeFranquiaDAO, consultaDAO);
                    break;
                }
                case 4: {

                    break;
                }
                case 5: {
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesAtualizarDadosPaciente(Pessoa pessoa, PessoaDAO pessoaDAO, ValidacaoEntradaDados vd) {

        int opcao;

        do {
            opcao = telaPaciente.menuAlteraDadosPaciente();

            switch (opcao) {
                case 1: {
                    System.out.println("Informe o Novo Nome: ");
                    String novoNomePessoa = scanner.nextLine();
                    novoNomePessoa = vd.validaString(novoNomePessoa);

                    if (pessoaDAO.atualizaNomePessoa(pessoa.getNomePessoa(), novoNomePessoa, pessoa.getCpf()) == true) {
                        System.out.println("O Nome Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Nome Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Informe o Novo Cpf: ");
                    String novoCpf = scanner.nextLine();
                    novoCpf = vd.validaString(novoCpf);

                    if (pessoaDAO.atualizaCpfPessoa(pessoa.getCpf(), novoCpf) == true) {
                        System.out.println("O Cpf Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Cpf Informado Ja Se Encontra Cadastrado.");
                    }

                    break;
                }

                case 3: {
                    System.out.println("Informe o Novo Endereco: ");
                    String novoEndereco = scanner.nextLine();
                    novoEndereco = vd.validaString(novoEndereco);

                    if (pessoaDAO.atualizaEnderecoPessoa(pessoa.getEnderecoPessoa(), novoEndereco) == true) {
                        System.out.println("O Endereco Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar O Endereco");
                    }
                    break;
                }

                case 4: {
                    System.out.println("Informe o Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    novoTelefone = vd.validaString(novoTelefone);
                    
                    if (pessoaDAO.atualizaTelefonePessoa(pessoa.getTelefonePessoa(), novoTelefone,
                            pessoa.getTipoUsuario()) == true) {
                        System.out.println("O Telefone Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Telefone Informado Ja Se Encontra Cadastrado.");
                    }
                    break;
                }

                case 5: {
                    System.out.println("Informe o Novo Login: ");
                    String novoLogin = scanner.nextLine();
                    novoLogin = vd.validaString(novoLogin);

                    if (pessoaDAO.atualizaLoginPessoa(pessoa.getLoginPessoa(), novoLogin, pessoa.getTipoUsuario()) == true) {
                        System.out.println("O Login Foi Atualizado Com Sucesso!");
                    } else {
                        System.out.println("Login Informado Ja Se Encontra Cadastrado.");
                    }

                    break;
                }

                case 6: {
                    System.out.println("Informe a Nova Senha: ");
                    String novaSenha = scanner.nextLine();
                    novaSenha = vd.validaString(novaSenha);

                    if (pessoaDAO.atualizaSenhaPessoa(pessoa.getSenhaPessoa(), pessoa.getLoginPessoa(),
                            novaSenha, pessoa.getTipoUsuario()) == true) {
                        System.out.println("A Senha Foi Atualizada Com Sucesso!");
                    } else {
                        System.out.println("Nao Foi Possivel Atualizar A Senha");
                    }
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void menuOpcoesConsulta(Pessoa pessoa, ValidacaoEntradaDados vd,
            MedicoDAO medicoDAO, FranquiaDAO franquiaDAO, UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO) {
        int opcao;

        do {
            opcao = telaPaciente.menuConsultaPaciente();

            switch (opcao) {
                case 1: {
                    marcarConsulta(pessoa, vd, medicoDAO, franquiaDAO, unidadeFranquiaDAO, consultaDAO);
                    break;
                }
                case 2: {
                    consultaDAO.buscaConsultaAtravesDaPessoaVinculada(pessoa);
                    break;
                }
                case 3: {
                    cancelarConsulta(pessoa, consultaDAO, vd);
                    break;
                }
                case 4: {
                    remarcarConsulta(consultaDAO, pessoa, vd);
                    break;
                }
                case 5: {
                    break;
                }
            }

        } while (opcao != 0);
    }

    private void marcarConsulta(Pessoa pessoa, ValidacaoEntradaDados vd,
            MedicoDAO medicoDAO, FranquiaDAO franquiaDAO, UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO) {
        franquiaDAO.mostraTodasFranquias();

        System.out.println("\nEscolha Uma Franquia Informando o ID - Franquia: ");
        int idFranquia = Integer.parseInt(scanner.nextLine());
        idFranquia = vd.validarINT(idFranquia);
        
        System.out.println("\n");
        Franquia franquiaSelecionada = franquiaDAO.buscaFranquiaPorId(idFranquia);

        if (franquiaSelecionada == null) {
            System.out.println("\nFranquia Nao Encontrada!");
        } else {
            System.out.println("\n");
            unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(franquiaSelecionada);

            System.out.println("\nEscolha Uma Unidade DE Franquia Informando o ID - Unidade De Franquia: ");
            int idUnidadeFranquia = Integer.parseInt(scanner.nextLine());
            idUnidadeFranquia = vd.validarINT(idUnidadeFranquia);

            UnidadeFranquia unidadeFranquiaSelecionada = unidadeFranquiaDAO.buscaUnidadeFranquiaPorId(idUnidadeFranquia);

            if (unidadeFranquiaSelecionada == null) {
                System.out.println("\nUnidade De Franquia Nao Encontrada!");
            } else {
                System.out.println("\n");
                medicoDAO.mostraTodosMedicos();

                System.out.println("Informe O ID - MEDICO Do Qual Deseja Se Consultar: ");
                int idMedico = Integer.parseInt(scanner.nextLine());
                idMedico = vd.validarINT(idMedico);
                
                Medico medicoSelecionado = medicoDAO.buscaMedicoPorId(idMedico);

                if (medicoSelecionado == null) {
                    System.out.println("\nMedico Nao Encontrado!");
                } else {
                    if (pessoa.getCpf().equals(medicoSelecionado.getPessoa().getCpf())) {
                        System.out.println("\nO Paciente E O Medico Sao A Mesma Pessoa, "
                                + "Consulta Nao Pode Ser Marcada." + "\n");
                    } else {
                        double valorConsulta = medicoDAO.verificaValorConsulta(medicoSelecionado);

                        DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        System.out.println("Informe a Data Da Consulta No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
                        String dia = scanner.nextLine();
                        LocalDate diaConsulta = LocalDate.parse(dia, fdia);
                        //vou arrumar validação  ainda deu errado

                        System.out.println("Informe a Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
                        String Hora = scanner.nextLine();
                        LocalTime horaConsulta = LocalTime.parse(Hora);
                        //vou arrumar validação  ainda deu errado

                        Consulta consulta = new Consulta(diaConsulta, horaConsulta, medicoSelecionado,
                                pessoa, unidadeFranquiaSelecionada, valorConsulta, "Agendada", LocalDateTime.now());

                        if (consultaDAO.adicionaConsulta(consulta) == true) {
                            System.out.println("\nConsulta Marcada Com Sucesso!");
                        } else {
                            System.out.println("\nNao Foi Possivel Marcar A Consulta.");
                        }

                    }

                }
            }
        }
    }

    private void cancelarConsulta(Pessoa pessoa, ConsultaDAO consultaDAO,  ValidacaoEntradaDados vd) {
        
        consultaDAO.buscaConsultaAtravesDaPessoaVinculada(pessoa);

        System.out.println("\nInforme O ID Consulta Que Deseja Cancelar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        idConsulta = vd.validarINT(idConsulta);

        Consulta consultaEncontrada = consultaDAO.buscaConsultaPorId(idConsulta);

        if (consultaEncontrada == null) {
            System.out.println("\nConsulta Nao Encontrada.");
        } else {
            if (consultaDAO.buscaConsultaParaCancelar(consultaEncontrada) == true) {
                System.out.println("\nConsulta Cancelada Com Sucesso!");
            } else {
                System.out.println("\nNao Foi Possivel Cancelar A Consulta.");
            }
        }
    }

    private void remarcarConsulta(ConsultaDAO consultaDAO, Pessoa pessoa,  ValidacaoEntradaDados vd) {

        consultaDAO.buscaConsultaAtravesDaPessoaVinculada(pessoa);

        System.out.println("\nInforme O ID Consulta Que Deseja Remarcar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        idConsulta = vd.validarINT(idConsulta);

        Consulta consultaEncontrada = consultaDAO.buscaConsultaPorId(idConsulta);

        if (consultaEncontrada == null) {
            System.out.println("\nConsulta Nao Encontrada.");
        } else {

            DateTimeFormatter fdia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("Informe a Nova Data Da Consulta No Seguinte Formato, Dia/Mes/Ano (00/00/0000)..: ");
            String dia = scanner.nextLine();
            LocalDate novoDiaConsulta = LocalDate.parse(dia, fdia);
            //vou arrumar validação ainda deu errado
            
            System.out.println("Informe a Nova Hora Da Consulta No Seguinte Formato, Hora:Minutos (00:00)..: ");
            String Hora = scanner.nextLine();
            LocalTime novaHoraConsulta = LocalTime.parse(Hora);
             //vou arrumar validação ainda deu errado

            
            if (consultaDAO.buscaConsultaParaRemarcar(novoDiaConsulta, novaHoraConsulta) == true) {
                System.out.println("\nVoce Ja Possui Uma Consulta Marcada Para Esta Data E Hora");
            } else {
                if (consultaDAO.atualizaDiaEHoraConsulta(novoDiaConsulta, novaHoraConsulta, consultaEncontrada) == true) {
                    System.out.println("\nConsulta Remarcada Com Sucesso!");
                } else {
                    System.out.println("\nNao Foi Possivel Remarcar A Consulta.");
                }
            }
        }

    }
}
