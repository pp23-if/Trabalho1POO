package Model;

import java.time.LocalDateTime;

public class PessoaDAO {

    private Pessoa vetorPessoa[] = new Pessoa[50];

    public PessoaDAO() {
        LocalDateTime agora = LocalDateTime.now();

        Pessoa pessoa = new Pessoa("Pedro Augusto Rodrigues", "123", "1", "1",
                "1", "1", "Paciente", agora);
        adicionaPessoa(pessoa);

        Pessoa pessoa2 = new Pessoa("Lucas Rocha Pereira", "7272", "rua 32", "9999",
                "lu123", "2", "Paciente", agora);
        adicionaPessoa(pessoa2);

        Pessoa pessoa3 = new Pessoa("Lucas Rocha Pereira", "7272", "rua 32", "9999",
                "lm23", "456", "Medico", agora);
        adicionaPessoa(pessoa3);

        Pessoa pessoa4 = new Pessoa("Juliana Carla De Souza", "789101010", "rua da batata", "3333",
                "ju", "10", "Paciente", agora);
        adicionaPessoa(pessoa4);

        Pessoa pessoa5 = new Pessoa("Juliana Carla De Souza", "789101010", "rua da batata", "3333",
                "ju25", "123", "Medico", agora);
        adicionaPessoa(pessoa5);

        Pessoa pessoa6 = new Pessoa("Eduardo Silvestre", "456666", "Rua dos Limoes", "33112020",
                "dudu10", "12", "Paciente", agora);
        adicionaPessoa(pessoa6);

        Pessoa pessoa7 = new Pessoa("Eduardo Silvestre", "456666", "Rua dos Limoes", "33112020",
                "Edu28", "24", "DonodeFranquia", agora);
        adicionaPessoa(pessoa7);
        
        Pessoa pessoa8 = new Pessoa("Roberto Gomes", "332288", "Rua das uvas - 17", "32985427",
                "gb35", "50", "Paciente", agora);
        adicionaPessoa(pessoa8);
        
        Pessoa pessoa9 = new Pessoa("Roberto Gomes", "332288", "Rua das uvas - 17", "32985427",
                "rgd", "30", "DonoDeUnidadeDeFranquia", agora);
        adicionaPessoa(pessoa9);
        
         Pessoa pessoa10 = new Pessoa("Marcos Pereira Faria", "3315152626", "Rua das Bananas - 600", "999612854",
                "mp22", "36", "Paciente", agora);
        adicionaPessoa(pessoa10);
        
        Pessoa pessoa11 = new Pessoa("Marcos Pereira Faria", "3315152626", "Rua das Bananas - 600", "999612854",
                "mpm", "100", "Medico", agora);
        adicionaPessoa(pessoa11);
        
         Pessoa pessoa12 = new Pessoa("Roberta Miranda De Sousa", "77882424", "Rua dos Abacates - 557", "99330044",
                "ro25", "99", "Paciente", agora);
        adicionaPessoa(pessoa12);
        
        Pessoa pessoa13 = new Pessoa("Roberta Miranda De Sousa", "77882424", "Rua dos Abacates - 557", "99330044",
                "roadm", "20", "Admnistrador", agora);
        adicionaPessoa(pessoa13);

    }

    private int proximaPosilivrePessoa() {
        for (int i = 0; i < vetorPessoa.length; i++) {
            if (vetorPessoa[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean adicionaPessoa(Pessoa pessoa) {
        int proxima = proximaPosilivrePessoa();
        if (proxima != -1) {
            vetorPessoa[proxima] = pessoa;
            return true;
        } else {
            return false;
        }

    }

    public void mostraTodasPessoas() {
        for (Pessoa pessoa : vetorPessoa) {

            if (pessoa != null) {
                System.out.println(pessoa + "\n");
            }
        }
    }

    public Pessoa buscaPessoaCadastrada(String login, String senha) {
        for (Pessoa pessoa : vetorPessoa) {

            if (pessoa != null && pessoa.getLoginPessoa().equals(login)
                    && pessoa.getSenhaPessoa().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean verificaSePessoaExiste(String login, String cpf) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getLoginPessoa().equals(login)
                    || pessoa != null && pessoa.getCpf().equals(cpf)) {
                return true;
            }

        }
        return false;
    }

    public Pessoa buscaPessoaQuerendoLogar(String login, String senha) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getLoginPessoa().equals(login)
                    && pessoa.getSenhaPessoa().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean atualizaNomePessoa(String nomePessoa, String novoNomePessoa, String cpf) {

        boolean atualizado = false;

        if (!verificaSeNomeEstaSendoUsado(novoNomePessoa) == true) {

            for (Pessoa pessoa : vetorPessoa) {

                if (pessoa != null && pessoa.getNomePessoa().equals(nomePessoa)
                        && pessoa.getCpf().equals(cpf)) {
                    pessoa.setNomePessoa(novoNomePessoa);
                    pessoa.setDataModificacao(LocalDateTime.now());
                    atualizado = true;

                }

            }
        }
        return atualizado;

    }

    public boolean atualizaCpfPessoa(String cpf, String novoCpf) {

        boolean atualizado = false;

        if (!verificaSeCpfEstaSendoUsado(novoCpf) == true) {
            for (Pessoa pessoa : vetorPessoa) {
                if (pessoa != null && pessoa.getCpf().equals(cpf)) {
                    pessoa.setCpf(novoCpf);
                    pessoa.setDataModificacao(LocalDateTime.now());
                    atualizado = true;
                }

            }
        }

        return atualizado;
    }

    public boolean atualizaEnderecoPessoa(String endereco, String novoEndereco) {

        boolean atualizado = false;

        for (Pessoa pessoa : vetorPessoa) {

            if (pessoa != null && pessoa.getEnderecoPessoa().equals(endereco)) {
                pessoa.setEnderecoPessoa(novoEndereco);
                pessoa.setDataModificacao(LocalDateTime.now());
                atualizado = true;
            }

        }
        return atualizado;
    }

    public boolean atualizaTelefonePessoa(String telefone, String novoTelefone, String tipoUsuario) {

        if (!verificaSeTelefoneEstaSendoUsado(novoTelefone) == true) {
            for (Pessoa pessoa : vetorPessoa) {

                if (pessoa != null && pessoa.getTelefonePessoa().equals(telefone)
                        && pessoa.getTipoUsuario().equals(tipoUsuario)) {
                    pessoa.setTelefonePessoa(novoTelefone);
                    pessoa.setDataModificacao(LocalDateTime.now());
                    return true;
                }
            }
        }

        return false;
    }

    public boolean atualizaLoginPessoa(String login, String novoLogin, String tipoUsuario) {
        if (!verificaSeloginEstaSendoUsado(novoLogin) == true) {
            for (Pessoa pessoa : vetorPessoa) {

                if (pessoa != null && pessoa.getLoginPessoa().equals(login) && pessoa.getTipoUsuario().equals(tipoUsuario)) {
                    pessoa.setLoginPessoa(novoLogin);
                    pessoa.setDataModificacao(LocalDateTime.now());
                    return true;
                }

            }
        }

        return false;
    }

    public boolean atualizaSenhaPessoa(String senha, String login, String novaSenha, String tipoUsuario) {
        for (Pessoa pessoa : vetorPessoa) {

            if (pessoa != null && pessoa.getLoginPessoa().equals(login) && pessoa.getSenhaPessoa().equals(senha)
                    && pessoa.getTipoUsuario().equals(tipoUsuario)) {
                pessoa.setSenhaPessoa(novaSenha);
                pessoa.setDataModificacao(LocalDateTime.now());
                return true;
            }

        }
        return false;
    }

    private boolean verificaSeNomeEstaSendoUsado(String nome) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getNomePessoa().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificaSeCpfEstaSendoUsado(String cpf) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificaSeTelefoneEstaSendoUsado(String telefone) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getTelefonePessoa().equals(telefone)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificaSeloginEstaSendoUsado(String login) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getLoginPessoa().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public Pessoa filtraPessoasCandidatasADonoDeFranquia() {

        String cpfDono = null;

        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getTipoUsuario().equals("DonodeFranquia")) {
                cpfDono = pessoa.getCpf();
            }
            if (pessoa != null && !pessoa.getTipoUsuario().equals("DonoDeUnidadeDeFranquia") 
                    && !pessoa.getTipoUsuario().equals("Medico")
                    && !pessoa.getCpf().equals(cpfDono)) {
                System.out.println(pessoa + "\n");
            }

        }

        return null;
    }

    public Pessoa buscaPessoaPorId(int idPessoa) {
        for (Pessoa pessoa : vetorPessoa) {

            if (pessoa != null && pessoa.getId() == idPessoa) {
                return pessoa;
            }
        }
        return null;

    }
    
      public Pessoa filtraPessoasCandidatasAMedico() {

        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && !pessoa.getTipoUsuario().equals("Medico") 
                    && !pessoa.getTipoUsuario().equals("DonodeFranquia") 
                    && !pessoa.getTipoUsuario().equals("DonoDeUnidadeDeFranquia"))
            {
                System.out.println(pessoa + "\n");
            }
        }

        return null;
    }
      
    public Pessoa filtraPessoaCandidatasADonoUnidadeFranquia()
    {
        for (Pessoa pessoa : vetorPessoa) {
            
            if(pessoa != null && !pessoa.getTipoUsuario().equals("Medico") &&
               !pessoa.getTipoUsuario().equals("DonodeFranquia")  && 
               !pessoa.getTipoUsuario().equals("DonoDeUnidadeDeFranquia"))
            {
                System.out.println(pessoa + "\n");
            }
        }
        return null;
    }
    
    public Pessoa filtraPacientes(){
        for (Pessoa pessoa : vetorPessoa) {
            if(pessoa != null && pessoa.getTipoUsuario().equals("Paciente")){
                System.out.println(pessoa + "\n");
            }
        }
        return null;
    }
    
   
     
    /*private boolean verificaSeNomeEstaSendoUsado(String nome) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getNomePessoa().equals(nome.toUpperCase(Locale.US)) || 
                pessoa != null && pessoa.getNomePessoa().equals(nome.toLowerCase(Locale.US))) {
                return true;
            }
        }
        return false;
    }*/
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
