package Model;

import java.time.LocalDateTime;

public class FinanceiroAdm {

    private static int sequence = 1;
    private int idFinanceiroAdm;
    private String tipoMovimento;
    private double valor;
    private UnidadeFranquia unidadeFranquia;
    private String descritivoMovimento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public int getIdFinanceiroAdm() {
        return idFinanceiroAdm;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UnidadeFranquia getUnidadeFranquia() {
        return unidadeFranquia;
    }

    public void setUnidadeFranquia(UnidadeFranquia unidadeFranquia) {
        this.unidadeFranquia = unidadeFranquia;
    }

    public String getDescritivoMovimento() {
        return descritivoMovimento;
    }

    public void setDescritivoMovimento(String descritivoMovimento) {
        this.descritivoMovimento = descritivoMovimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    

}
