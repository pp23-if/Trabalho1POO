
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
      
     public boolean verificaCalculosValoresMedico(Medico medico, CalendarioSistema calendarioSistema, Franquia franquia) 
     {
         
         for (FinanceiroMedico financeiroMedico : vetorFinanceiroMedico) {
             
             if(financeiroMedico != null
                && financeiroMedico.getMedico().equals(medico)
                && financeiroMedico.getEstado().equals("Agendado")
                && financeiroMedico.getFranquia().equals(franquia)
                && financeiroMedico.getDataCriacao().isEqual(calendarioSistema.getDataHoraSistema()))
             {
                return true; 
             }
         }
        return false;
     }
     
     public FinanceiroMedico buscaPagamentosMedicosPorFranquia(Franquia franquia)
     {
         for (FinanceiroMedico financeiroMedico : vetorFinanceiroMedico) {
             
             if(financeiroMedico != null && financeiroMedico.getFranquia().equals(franquia))
             {
                 System.out.println(financeiroMedico + "\n");
             }
         }
        return null;
     }
     
     public boolean buscaPagamentosMedicosPorFranquiaEhMes(Franquia franquia, CalendarioSistema calendarioSistema)
     {
         for (FinanceiroMedico financeiroMedico : vetorFinanceiroMedico) {
             
             if(financeiroMedico != null && financeiroMedico.getFranquia().equals(franquia)
                && financeiroMedico.getEstado().equals("Agendado")
                && financeiroMedico.getDataCriacao().isEqual(calendarioSistema.getDataHoraSistema()))
             {
                 System.out.println(financeiroMedico + "\n");
                 return true;
             }
         }
        return false;
        
     }
     
     public FinanceiroMedico buscaPagamentosMedicosPorID(int idFinanceiroMedico)
     {
         for (FinanceiroMedico financeiroMedico : vetorFinanceiroMedico) {
             
             if(financeiroMedico != null && financeiroMedico.getIdFinanceiroMedico() == idFinanceiroMedico)
             {
                 return financeiroMedico;
             }
         }
        return null;
     }
     
     public double calculaValorLiquidoAReceberMedico(double valorTotalConsultas, double valorTotalProcedimentos,
             double parteUnidadeFranquiaConsulta, double parteUnidadeFranquiaProcedimento)
     {
         
       double valorLiquidoMedico = valorTotalConsultas + valorTotalProcedimentos;
       
       valorLiquidoMedico = valorLiquidoMedico - (parteUnidadeFranquiaConsulta + parteUnidadeFranquiaProcedimento);
       
       return valorLiquidoMedico;
     }
}