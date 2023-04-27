package Model;

import java.time.LocalDateTime;

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
    
    public FinanceiroAdm buscaMovimentacoesFinanceirasPorFranquia(Franquia franquia)
    {
        for (FinanceiroAdm financeiroAdm : vetotFinanceiroAdm) {
            
            if(financeiroAdm != null && financeiroAdm.getUnidadeFranquia().getFranquia().equals(franquia))
            {
                System.out.println(financeiroAdm + "\n");
            }
        }
        return null;
    }
    
    public void geraMovimentacaoFinanceiraConsulta(Consulta consulta, CalendarioSistema calendarioSistema)
    {
        FinanceiroAdm entradaConsultas = new FinanceiroAdm("Entrada", consulta.getValor(), 
                consulta.getUnidadeFranquia(), "Consulta", calendarioSistema.getDataHoraSistema());
        adicionaFinanceiroAdm(entradaConsultas);
    }
    
    public void geraMovimentacaoFinanceiraProcedimento(Procedimento procedimento, CalendarioSistema calendarioSistema)
    {
        FinanceiroAdm entradaProcedimentos = new  FinanceiroAdm("Entrada", procedimento.getValorProcedimento(), 
                procedimento.getConsulta().getUnidadeFranquia(),"Procedimento", calendarioSistema.getDataHoraSistema());
        adicionaFinanceiroAdm(entradaProcedimentos);
    }
}
