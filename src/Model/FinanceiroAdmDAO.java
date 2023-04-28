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

    public FinanceiroAdm mostraTodosMovimentosFinanceiros() {
        for (FinanceiroAdm financeiroAdm : vetotFinanceiroAdm) {

            if (financeiroAdm != null) {
                System.out.println(financeiroAdm + "\n");
            }
        }
        return null;
    }

    public FinanceiroAdm buscaMovimentacoesFinanceirasPorFranquia(Franquia franquia) {
        for (FinanceiroAdm financeiroAdm : vetotFinanceiroAdm) {

            if (financeiroAdm != null && financeiroAdm.getUnidadeFranquia().getFranquia().equals(franquia)) {
                System.out.println(financeiroAdm + "\n");
            }
        }
        return null;
    }

    public void geraMovimentacaoFinanceiraConsulta(Consulta consulta, CalendarioSistema calendarioSistema) {
        FinanceiroAdm entradaConsultas = new FinanceiroAdm("Entrada", consulta.getValor(),
                consulta.getUnidadeFranquia(), "Consulta", calendarioSistema.getDataHoraSistema());
        adicionaFinanceiroAdm(entradaConsultas);
    }

    public void geraMovimentacaoFinanceiraProcedimento(Procedimento procedimento, CalendarioSistema calendarioSistema) {
        FinanceiroAdm entradaProcedimentos = new FinanceiroAdm("Entrada", procedimento.getValorProcedimento(),
                procedimento.getConsulta().getUnidadeFranquia(), "Procedimento", calendarioSistema.getDataHoraSistema());
        adicionaFinanceiroAdm(entradaProcedimentos);
    }
    
    public void geraMovimentacaoFinanceiraPagamentosFranquia(UnidadeFranquia unidadeFranquia, 
            double valorPagamento, CalendarioSistema calendarioSistema)
    {
        FinanceiroAdm saidaPagamentoFranquia = new FinanceiroAdm("Saida", valorPagamento, unidadeFranquia, 
                "PagamentoFranquia", calendarioSistema.getDataHoraSistema());
        adicionaFinanceiroAdm(saidaPagamentoFranquia);
    }
    
    public void comparaUnidades(CalendarioSistema calendarioSistema, UnidadeFranquiaDAO unidadeFranquiaDAO)
    {
        int mesSitemaComparavel = calendarioSistema.getDiaDoSistema().minusDays(1).getMonthValue();
        
        for (FinanceiroAdm financeiroAdm : vetotFinanceiroAdm) {
            
            if(financeiroAdm != null
               && !financeiroAdm.getDescritivoMovimento().equals("PagamentoFranquia")
               && financeiroAdm.getDataCriacao().getMonthValue() == mesSitemaComparavel)
            {
                System.out.println(financeiroAdm.getUnidadeFranquia() +  "\n"); 
            }
        }
    }
    
  

    public double calculaRendaBruta(CalendarioSistema calendarioSistema, UnidadeFranquia unidadeFranquia) {
        
        double valorTotalConsultas = 0;
        double valorTotalprocedimentos = 0;
        double valorTotalEntradas;
      
        int mesSitemaComparavel = calendarioSistema.getDiaDoSistema().minusDays(1).getMonthValue();
        
        for (FinanceiroAdm financeiroAdm : vetotFinanceiroAdm) {
             
             
            if (financeiroAdm != null
                    && financeiroAdm.getDescritivoMovimento().equals("Consulta")
                    && financeiroAdm.getUnidadeFranquia().equals(unidadeFranquia)
                    && financeiroAdm.getDataCriacao().getMonthValue() == mesSitemaComparavel) {
                valorTotalConsultas += financeiroAdm.getValor();
            } 
            else if (financeiroAdm != null
                    && financeiroAdm.getDescritivoMovimento().equals("Procedimento")
                    && financeiroAdm.getUnidadeFranquia().equals(unidadeFranquia)
                    && financeiroAdm.getDataCriacao().getMonthValue() == mesSitemaComparavel) {
                valorTotalprocedimentos += financeiroAdm.getValor();
            }

        }
        valorTotalEntradas = valorTotalConsultas + valorTotalprocedimentos;
      
        return valorTotalEntradas;

    }
    
    public double calculaParteValorAdmnistradora(double rendaBruta)
    {
        double valorAdministradora = 0;
        
        valorAdministradora = (rendaBruta * 0.05) + 1000;
        
        return valorAdministradora;
    }
    
    public double calculaRendaLiquida(double rendaBruta, double parteAdministradora)
    {
        double rendaLiquida = rendaBruta - parteAdministradora;
        
        return rendaLiquida;
    }
    
}
