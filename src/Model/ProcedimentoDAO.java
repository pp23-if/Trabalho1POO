package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            LocalTime novaHoraProcedimento, Procedimento procedimento, CalendarioSistema calendarioSistema)
    {
        if(procedimento != null && procedimento.getEstadoProcedimento().equals("Agendado"))
        {
            procedimento.setDiaProcedimento(novoDiaProcedimento);
            procedimento.setHoraProcedimento(novaHoraProcedimento);
            procedimento.setDataModificacao(calendarioSistema.getDataHoraSistema());
            return true;
        }
        return false;
        
    }

    public Procedimento buscaProcedimentosQueTemMedicoSolicitanteEPacienteEscolhido(Pessoa pessoa, Medico medico)
    {
        for (Procedimento procedimento : vetorProcedimento) {
            
            if(procedimento != null
               && procedimento.getConsulta().getMedico().equals(medico)
               && procedimento.getConsulta().getPessoa().equals(pessoa))
            {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }
    
    public Procedimento buscaProcedimentoNaoRealizado(Medico medico)
    {
        for (Procedimento procedimento : vetorProcedimento) {
            
            if(procedimento != null
               && procedimento.getConsulta().getMedico().equals(medico)
               && procedimento.getEstadoProcedimento().equals("Agendado"))
            {
                return procedimento;
            }
               
        }
        return null;
    }
    
    public boolean realizarProcedimento(Procedimento procedimento, String laudo, CalendarioSistema calendarioSistema)
    {
        if(procedimento != null)
        {
            procedimento.setEstadoProcedimento("Realizado");
            procedimento.setLaudo(laudo);
            procedimento.setDataModificacao(calendarioSistema.getDataHoraSistema());
            return true;
        }
        return false;
    }
}
