package Model;

public class FinanceiroAdmDAO {

    private FinanceiroAdm[] vetotFinanceiroAdm = new FinanceiroAdm[50];

    public FinanceiroAdmDAO() {
    }

    private int proximaPosilivreFinanceiroAdm() {
        for (int i = 0; i < vetotFinanceiroAdm.length; i++) {
            if (vetotFinanceiroAdm[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean adicionaFinanceiroAdm(FinanceiroAdm financeiroAdm) {
        int proxima = proximaPosilivreFinanceiroAdm();
        if (proxima != -1) {
            vetotFinanceiroAdm[proxima] = financeiroAdm;
            return true;
        } else {
            return false;
        }

    }
    
    public FinanceiroAdm mostraTodosMovimentosFinanceiros()
    {
        for (FinanceiroAdm financeiroAdm : vetotFinanceiroAdm) {
            
            if(financeiroAdm != null)
            {
                System.out.println(financeiroAdm + "\n");
            }
        }
        return null;
    }
    
    public void geraMovimentacaoFinanceira(Franquia franquia, UnidadeFranquia unidadeFranquia,
            ConsultaDAO consultaDAO, ProcedimentoDAO procedimentoDAO)
    {
        
    }
}
