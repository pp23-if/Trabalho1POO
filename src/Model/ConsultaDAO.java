package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConsultaDAO {

    private Consulta vetorConsulta[] = new Consulta[50];

    public ConsultaDAO() {
    }

    private int proximaPosilivreConsulta() {
        for (int i = 0; i < vetorConsulta.length; i++) {
            if (vetorConsulta[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean adicionaConsulta(Consulta consulta) {
        int proxima = proximaPosilivreConsulta();
        if (proxima != -1) {
            vetorConsulta[proxima] = consulta;
            return true;
        } else {
            return false;
        }

    }

    public Consulta mostraTodasConsultas() {

        for (Consulta consulta : vetorConsulta) {

            if (consulta != null) {
                System.out.println(consulta + "\n");
            }
        }
        return null;
    }

    public Consulta buscaConsultaAtravesDaPessoaVinculada(Pessoa p) {
        for (Consulta consulta : vetorConsulta) {

            if (consulta != null && consulta.getPessoa().equals(p)) {
                System.out.println(consulta + "\n");
            }
        }
        return null;
    }

    public Consulta buscaConsultaPorId(int idConsulta) {
        for (Consulta consulta : vetorConsulta) {

            if (consulta != null && consulta.getIdConsulta() == idConsulta) {
                return consulta;
            }
        }
        return null;
    }

    
     public Consulta buscaConsultaRealizadaPorId(int idConsulta) {
        for (Consulta consulta : vetorConsulta) {

            if (consulta != null && consulta.getIdConsulta() == idConsulta 
                    && consulta.getEstadoConsulta().equals("Realizada")) {
                return consulta;
            }
        }
        return null;
    }
    
    
    public boolean receConsultaECancela(Consulta consulta) {
        if (consulta != null && consulta.getEstadoConsulta().equals("Agendada")) {
            consulta.setEstadoConsulta("Cancelada");
            consulta.setDataModificacao(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public boolean verificaDisponibilidadeDiaEHora(LocalDate novoDiaConsulta,
            LocalTime novaHoraConsulta) {

        for (Consulta consulta : vetorConsulta) {

            if (consulta != null && consulta.getDiaConsulta().equals(novoDiaConsulta)
                    && consulta.getHoraConsulta().equals(novaHoraConsulta)) {
                return true;
            }

        }
        return false;
    }

    public boolean recebeConsultaERemarca(LocalDate novoDiaConsulta,
            LocalTime novaHoraConsulta, Consulta consulta) {
        if (consulta != null && consulta.getEstadoConsulta().equals("Agendada")) {
            consulta.setDiaConsulta(novoDiaConsulta);
            consulta.setHoraConsulta(novaHoraConsulta);
            consulta.setDataModificacao(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public Consulta buscaConsultaPorFranquia(Franquia franquia) {
        for (Consulta consulta : vetorConsulta) {
            if (consulta != null
                    && consulta.getUnidadeFranquia().getFranquia().equals(franquia)) {

                System.out.println(consulta + "\n");
            }
        }
        return null;

    }

    public Consulta buscaConsultaPorMedico(Medico medico) {
        for (Consulta consulta : vetorConsulta) {
            if (consulta != null && consulta.getMedico().equals(medico)) {
                System.out.println(consulta + "\n");

            }
        }
        return null;
    }

    public boolean atenderConsulta(Medico medico, InfoConsultaDAO infoConsultaDAO) {
        for (Consulta consulta : vetorConsulta) {
            if (consulta != null
                    && consulta.getMedico().equals(medico)
                    && consulta.getEstadoConsulta().equals("Agendada")) {

                consulta.setEstadoConsulta("Realizada");
                consulta.setDataModificacao(LocalDateTime.now());

                InfoConsulta infoConsulta = new InfoConsulta(consulta, "", LocalDateTime.now());

                infoConsultaDAO.adicionaInfoConsulta(infoConsulta);

                return true;
            }
        }
        return false;
    }
    
    public Consulta buscaConsultasQueTemMedicoSolicitanteEPacienteEscolhido(Pessoa pessoa, Medico medico)
    {
        for (Consulta consulta : vetorConsulta) {
            
            if(consulta != null
               && consulta.getMedico().equals(medico)
               && consulta.getPessoa().equals(pessoa))
            {
                System.out.println(consulta + "\n");
            }
        }
        return null;
        
    }

}
