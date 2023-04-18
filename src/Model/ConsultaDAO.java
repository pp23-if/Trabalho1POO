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

    public boolean buscaConsultaParaCancelar(Consulta consulta) {
        if (consulta != null) {
            consulta.setEstadoConsulta("Cancelada");
            return true;
        }
        return false;
    }

    public boolean buscaConsultaParaRemarcar(LocalDate novoDiaConsulta,
            LocalTime novaHoraConsulta) {

        for (Consulta consulta : vetorConsulta) {

            if (consulta != null && consulta.getDiaConsulta().equals(novoDiaConsulta)
                    && consulta.getHoraConsulta().equals(novaHoraConsulta)) {
                return true;
            }

        }
        return false;
    }

    public boolean atualizaDiaEHoraConsulta(LocalDate novoDiaConsulta,
            LocalTime novaHoraConsulta, Consulta consulta) {
        if (consulta != null) {
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

}
