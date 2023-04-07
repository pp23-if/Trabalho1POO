package Model;

import java.time.LocalDateTime;

public class PessoaDAO {
    
    private Pessoa vetorPessoa[] = new Pessoa[20];
    
    public PessoaDAO() {
        LocalDateTime agora = LocalDateTime.now();
        
        Pessoa pessoa = new Pessoa("pedro", "123", "1", "1",
                "1", "1", "Paciente", agora);
        
     
        adicionaPessoa(pessoa);
    }
    
    private int proximaPosilivrePessoa() {
        for (int i = 0; i < vetorPessoa.length; i++) {
            if (vetorPessoa[i] == null) {
                return i;
            }
            
        }
        return -1;
    }
    
    public boolean adicionaPessoa(Pessoa p) {
        int proxima = proximaPosilivrePessoa();
        if (proxima != -1) {
            vetorPessoa[proxima] = p;
            return true;
        } else {
            return false;
        }
        
    }
    
    public void mostraTodasPessoas() {
        for (Pessoa pessoa : vetorPessoa) {
            
            if (pessoa != null) {
                System.out.println(pessoa);
            }
        }
    }
    
     public Pessoa mostraDadosPessoaLogada(String login, String senha) {
        for (Pessoa pessoa : vetorPessoa) {
            
            if (pessoa != null && pessoa.getLoginPessoa().equals(login) && 
                    pessoa.getSenhaPessoa().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }
    
    public boolean verificaSePessoaExiste(String login, String tipoUsuario, String nome) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getLoginPessoa().equals(login)
                    || pessoa != null && pessoa.getTipoUsuario().equals(tipoUsuario) && 
                    pessoa.getLoginPessoa().equals(nome)) { 
                
                return true;
            }
            
        }
        return false;
    }
    
    public Pessoa fazLogin(String login, String senha)
    {
        for (Pessoa pessoa : vetorPessoa) {
            if(pessoa != null && pessoa.getLoginPessoa().equals(login) && 
                    pessoa.getSenhaPessoa().equals(senha))
            {
                return pessoa;
            }
        }
        return null;
    }
    
    
    public boolean atualizaNomePessoa(String nomePessoa, String novoNomePessoa)
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && pessoa.getNomePessoa().equals(nomePessoa))
            {
               pessoa.setNomePessoa(novoNomePessoa);
               pessoa.setDataModificacao(LocalDateTime.now());
               return true;
            }
            
        }
        return false;
    }
    
    public boolean atualizaCpfPessoa(String cpf, String novoCpf)
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && pessoa.getCpf().equals(cpf))
            {
               pessoa.setCpf(novoCpf);
               pessoa.setDataModificacao(LocalDateTime.now());
               return true;
            }
            
        }
        return false;
    }
    
    public boolean atualizaEnderecoPessoa(String endereco, String novoEndereco)
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && pessoa.getEnderecoPessoa().equals(endereco))
            {
               pessoa.setEnderecoPessoa(novoEndereco);
               pessoa.setDataModificacao(LocalDateTime.now());
               return true;
            }
            
        }
        return false;
    }
    
    
    public boolean atualizaTelefonePessoa(String telefone, String novoTelefone)
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && pessoa.getTelefonePessoa().equals(telefone))
            {
               pessoa.setTelefonePessoa(novoTelefone);
               pessoa.setDataModificacao(LocalDateTime.now());
               return true;
            }
            
        }
        return false;
    }
    
    
    public boolean atualizaLoginPessoa(String login, String novoLogin, String tipoUsuario)
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && pessoa.getLoginPessoa().equals(login) && pessoa.getTipoUsuario().equals(tipoUsuario))
            {
               pessoa.setLoginPessoa(novoLogin);
               pessoa.setDataModificacao(LocalDateTime.now());
               return true;
            }
            
        }
        return false;
    }
     
     
     public boolean atualizaSenhaPessoa(String senha, String login, String novaSenha, String tipoUsuario)
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && pessoa.getLoginPessoa().equals(login) && pessoa.getSenhaPessoa().equals(senha) 
                    && pessoa.getTipoUsuario().equals(tipoUsuario))
            {
               pessoa.setSenhaPessoa(novaSenha);
               pessoa.setDataModificacao(LocalDateTime.now());
               return true;
            }
            
        }
        return false;
    }
    /*public boolean verificaSePessoaExiste(String login, String nome, String cpf) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getLoginPessoa().equals(login)
                    || pessoa != null && pessoa.getNomePessoa().equals(nome)
                    || pessoa != null && pessoa.getCpf().equals(cpf)) {    
                return true;
            }
            
        }
        return false;
    }*/
}
