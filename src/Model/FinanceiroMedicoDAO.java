
package Model;


public class FinanceiroMedicoDAO {

    public FinanceiroMedicoDAO() {
    }
    
     public boolean adicionaFinanceiroMedico(FinanceiroMedico financeiroMedico) {
        int proxima = proximaPosilivreFinanceiroMedico();
        if (proxima != -1) {
            vetorFinanceiroMedico[proxima] = financeiroMedico;
            return true;
        } else {
            return false;
        }

    }
    
    private FinanceiroMedico[] vetorFinanceiroMedico = new FinanceiroMedico[50];
    
     private int proximaPosilivreFinanceiroMedico() {
        for (int i = 0; i < vetorFinanceiroMedico.length; i++) {
            if (vetorFinanceiroMedico[i] == null) {
                return i;
            }
        }
        return -1;
    }
     
     
     public FinanceiroMedico mostraTodosFinanceiroMedico()
     {
         for (FinanceiroMedico financeiroMedico : vetorFinanceiroMedico) {
             
             if(financeiroMedico != null)
             {
                 System.out.println(financeiroMedico + "\n");
             }
         }
        return null;
     }
      
     public boolean verificaCalculosValoresMedico(Medico medico, CalendarioSistema calendarioSistema) 
     {
          int mesSitemaComparavel = calendarioSistema.getDiaDoSistema().minusDays(1).getMonthValue();
         
         for (FinanceiroMedico financeiroMedico : vetorFinanceiroMedico) {
             
             if(financeiroMedico != null
                && financeiroMedico.getMedico().equals(medico)
                && financeiroMedico.getEstado().equals("Agendado")
                && financeiroMedico.getDataCriacao().isEqual(calendarioSistema.getDataHoraSistema()))
             {
                return true; 
             }
         }
        return false;
     }
}
