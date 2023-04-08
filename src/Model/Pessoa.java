package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pessoa {

    private static int sequence = 1;
    private int idPessoa;
    private String nomePessoa;
    private String cpf;
    private String enderecoPessoa;
    private String telefonePessoa;
    private String loginPessoa;
    private String senhaPessoa;
    private String tipoUsuario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public int getId() {
        return idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getLoginPessoa() {
        return loginPessoa;
    }

    public void setLoginPessoa(String loginPessoa) {
        this.loginPessoa = loginPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
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

    public Pessoa(String nomePessoa, String cpf, String enderecoPessoa, String telefonePessoa,
            String loginPessoa, String senhaPessoa, String tipoUsuario, LocalDateTime dataCriacao) {
        this.idPessoa = sequence++;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.enderecoPessoa = enderecoPessoa;
        this.telefonePessoa = telefonePessoa;
        this.loginPessoa = loginPessoa;
        this.senhaPessoa = senhaPessoa;
        this.tipoUsuario = tipoUsuario;
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idPessoa;
        hash = 29 * hash + Objects.hashCode(this.nomePessoa);
        hash = 29 * hash + Objects.hashCode(this.cpf);
        hash = 29 * hash + Objects.hashCode(this.enderecoPessoa);
        hash = 29 * hash + Objects.hashCode(this.telefonePessoa);
        hash = 29 * hash + Objects.hashCode(this.loginPessoa);
        hash = 29 * hash + Objects.hashCode(this.senhaPessoa);
        hash = 29 * hash + Objects.hashCode(this.tipoUsuario);
        hash = 29 * hash + Objects.hashCode(this.dataCriacao);
        hash = 29 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return true;
    }

    @Override
    public String toString() {

        DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        if (this.dataModificacao == null) {
            return "ID: " + this.idPessoa + "\n"
                    + "Nome: " + this.nomePessoa + "\n"
                    + "Cpf: " + this.cpf + "\n"
                    + "Endereco: " + this.enderecoPessoa + "\n"
                    + "Login: " + this.loginPessoa + "\n"
                    + "Senha: " + this.senhaPessoa + "\n"
                    + "Telefone: " + this.telefonePessoa + "\n"
                    + "Tipo de Usuario: " + this.tipoUsuario + "\n"
                    + "Data e Hora da Criacao: " + fd.format(this.dataCriacao) + "\n";
        } else {
            return "ID: " + this.idPessoa + "\n"
                    + "Nome: " + this.nomePessoa + "\n"
                    + "Cpf: " + this.cpf + "\n"
                    + "Endereco: " + this.enderecoPessoa + "\n"
                    + "Login: " + this.loginPessoa + "\n"
                    + "Senha: " + this.senhaPessoa + "\n"
                    + "Telefone: " + this.telefonePessoa + "\n"
                    + "Tipo de Usuario: " + this.tipoUsuario + "\n"
                    + "Data e Hora da Criacao: " + fd.format(this.dataCriacao) + "\n"
                    + "Data e Hora da Modificacao: " + fd.format(this.dataModificacao) + "\n";
        }

    }
}
