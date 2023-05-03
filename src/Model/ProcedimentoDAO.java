package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProcedimentoDAO {

    private Procedimento vetorProcedimento[] = new Procedimento[50];

    public ProcedimentoDAO() {
    }

    public boolean adicionaProcedimento(Procedimento procedimento) {
        int proxima = proximaPosilivreProcedimento();
        if (proxima != -1) {
            vetorProcedimento[proxima] = procedimento;
            return true;
        } else {
            return false;
        }

    }

    private int proximaPosilivreProcedimento() {
        for (int i = 0; i < vetorProcedimento.length; i++) {
            if (vetorProcedimento[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public Procedimento buscaProcedimentoPorPaciente(Pessoa pessoa) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null && procedimento.getConsulta().getPessoa().equals(pessoa)) {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }

    public Procedimento buscaProcedimentoPorMedico(Medico medico) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null && procedimento.getConsulta().getMedico().equals(medico)) {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }

    public Procedimento buscaProcedimentoPorFranquia(Franquia franquia) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null && procedimento.getConsulta()
                    .getUnidadeFranquia().getFranquia().equals(franquia)) {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }

    public Procedimento buscaProcedimentoPorId(int idProcediemnto) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null && procedimento.getIdProcedimento() == idProcediemnto) {
                return procedimento;
            }
        }
        return null;
    }

    public boolean recebeProcedimentoECancela(Procedimento procedimento, CalendarioSistema calendarioSistema) {
        if (procedimento != null && procedimento.getEstadoProcedimento().equals("Agendado")) {
            procedimento.setEstadoProcedimento("Cancelado");
            procedimento.setDataModificacao(calendarioSistema.getDataHoraSistema());
            return true;
        }
        return false;
    }

    public boolean verificaDisponibilidadeDataEHoraProcedimento(LocalDate diaProcedimento, LocalTime horaProcedimento) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null && procedimento.getDiaProcedimento().equals(diaProcedimento)
                    && procedimento.getHoraProcedimento().equals(horaProcedimento)) {

                return true;
            }
        }
        return false;
    }

    public boolean recebeProcedimentoERemarca(LocalDate novoDiaProcedimento,
            LocalTime novaHoraProcedimento, Procedimento procedimento, CalendarioSistema calendarioSistema) {
        if (procedimento != null && procedimento.getEstadoProcedimento().equals("Agendado")) {
            procedimento.setDiaProcedimento(novoDiaProcedimento);
            procedimento.setHoraProcedimento(novaHoraProcedimento);
            procedimento.setDataModificacao(calendarioSistema.getDataHoraSistema());
            return true;
        }
        return false;

    }

    public Procedimento buscaProcedimentosQueTemMedicoSolicitanteEPacienteEscolhido(Pessoa pessoa, Medico medico) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null
                    && procedimento.getConsulta().getMedico().equals(medico)
                    && procedimento.getConsulta().getPessoa().equals(pessoa)) {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }

    public Procedimento buscaProcedimentoNaoRealizado(Medico medico, CalendarioSistema calendarioSistema) {
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null
                    && procedimento.getConsulta().getMedico().equals(medico)
                    && procedimento.getEstadoProcedimento().equals("Agendado")
                    && procedimento.getDiaProcedimento().isEqual(calendarioSistema.getDiaDoSistema())) {
                return procedimento;
            }

        }
        return null;
    }

    public boolean realizarProcedimento(Procedimento procedimento, String laudo,
            CalendarioSistema calendarioSistema, FinanceiroAdmDAO financeiroAdmDAO) {
        if (procedimento != null) {
            procedimento.setEstadoProcedimento("Realizado");
            procedimento.setLaudo(laudo);
            procedimento.setDataModificacao(calendarioSistema.getDataHoraSistema());

            financeiroAdmDAO.geraMovimentacaoFinanceiraProcedimento(procedimento, calendarioSistema);
            return true;
        }
        return false;
    }

    public boolean cancelaProcedimentosNaoRealizadosNoDia(CalendarioSistema calendarioSistema) {

        boolean canceladas = false;
        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null && procedimento.getEstadoProcedimento().equals("Agendado")
                    && calendarioSistema.getDiaDoSistema().isAfter(procedimento.getDiaProcedimento())) {
                procedimento.setEstadoProcedimento("Cancelado");
                procedimento.setDataModificacao(calendarioSistema.getDataHoraSistema());
                canceladas = true;
            }
            if (canceladas == true) {
                return true;
            }
        }
        return false;

    }

    public double calculaValorProcedimentosDoMes(Medico medico, CalendarioSistema calendarioSistema, Franquia franquia) {
        
        double totalProcedimentos = 0;

        int mesSitemaComparavel = calendarioSistema.getDiaDoSistema().minusDays(1).getMonthValue();

        for (Procedimento procedimento : vetorProcedimento) {

            if (procedimento != null
                    && procedimento.getConsulta().getMedico().equals(medico)
                    && procedimento.getEstadoProcedimento().equals("Realizado")
                    && procedimento.getConsulta().getUnidadeFranquia().getFranquia().equals(franquia)
                    && procedimento.getDiaProcedimento().getMonthValue() == mesSitemaComparavel) {
                
                totalProcedimentos += procedimento.getValorProcedimento();
            }

        }
        
        return totalProcedimentos;
    }
    
    public double calculaParteDaUnidadeSobreProcedimentos(double valorProcedimentos)
    {
        double valorParteProcedimento;
        
        valorParteProcedimento = valorProcedimentos * 0.50;
        
        return valorParteProcedimento;
    }
}
