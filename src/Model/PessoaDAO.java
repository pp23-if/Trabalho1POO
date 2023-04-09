package Model;

import java.time.LocalDateTime;
import java.util.Locale;

public class PessoaDAO {

    private Pessoa vetorPessoa[] = new Pessoa[20];

    public PessoaDAO() {
        LocalDateTime agora = LocalDateTime.now();

        Pessoa pessoa = new Pessoa("pedro", "123", "1", "1",
                "1", "1", "Paciente", agora);
        adicionaPessoa(pessoa);

        Pessoa pessoa2 = new Pessoa("Lucas", "7272", "rua 32", "9999",
                "lu123", "2", "Paciente", agora);
        adicionaPessoa(pessoa2);

        Pessoa pessoa3 = new Pessoa("Lucas", "7272", "rua 32", "9999",
                "lm23", "456", "Medico", agora);
        adicionaPessoa(pessoa3);

        Pessoa pessoa4 = new Pessoa("Juliana", "789101010", "rua da batata", "3333",
                "ju", "10", "Paciente", agora);
        adicionaPessoa(pessoa4);

        Pessoa pessoa5 = new Pessoa("Juliana", "789101010", "rua da batata", "3333",
                "ju25", "123", "Medico", agora);
        adicionaPessoa(pessoa5);

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
                System.out.println(pessoa);
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

    public boolean verificaSePessoaExiste(String login, String tipoUsuario, String nome, String cpf) {
        for (Pessoa pessoa : vetorPessoa) {
            if (pessoa != null && pessoa.getLoginPessoa().equals(login.toUpperCase())
                    || pessoa != null && pessoa.getLoginPessoa().equals(login.toLowerCase())
                    || pessoa != null && pessoa.getTipoUsuario().equals(tipoUsuario)
                    && pessoa.getNomePessoa().equals(nome.toUpperCase())
                    || pessoa != null && pessoa.getNomePessoa().equals(nome.toLowerCase())
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

                if (pessoa != null && pessoa.getNomePessoa().equals(nomePessoa) && 
                        pessoa.getCpf().equals(cpf)) {
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
