
package Model;


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
    
    public Procedimento buscaProcedimentoPorPaciente(Pessoa pessoa)
    {
        for (Procedimento procedimento : vetorProcedimento) {
            
            if(procedimento != null && procedimento.getConsulta().getPessoa().equals(pessoa))
            {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }
    
    public Procedimento buscaProcedimentoPorMedico(Medico medico)
    {
        for (Procedimento procedimento : vetorProcedimento) {
            
            if(procedimento != null && procedimento.getConsulta().getMedico().equals(medico))
            {
                System.out.println(procedimento + "\n");
            }
        }
        return null;
    }
    
}
