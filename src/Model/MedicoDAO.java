package Model;

import java.time.LocalDateTime;

public class MedicoDAO {

    private Medico[] vetorMedico = new Medico[50];

    public MedicoDAO(PessoaDAO pessoaDAO) {

        Pessoa pessoaMedico1 = pessoaDAO.buscaPessoaCadastrada("lm23", "456");

        if (pessoaMedico1 != null) {
            Medico medico1 = new Medico("ABC-123", pessoaMedico1, "Ortopedista", LocalDateTime.now());
            adicionaMedico(medico1);
        }

        Pessoa pessoaMedico2 = pessoaDAO.buscaPessoaCadastrada("ju25", "123");

        if (pessoaMedico2 != null) {
            Medico medico2 = new Medico("DEF-456", pessoaMedico2, "Nutricionista", LocalDateTime.now());
            adicionaMedico(medico2);
        }

    }

    private int proximaPosilivreMedico() {
        for (int i = 0; i < vetorMedico.length; i++) {
            if (vetorMedico[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean adicionaMedico(Medico medico) {
        int proxima = proximaPosilivreMedico();
        if (proxima != -1) {
            vetorMedico[proxima] = medico;
            return true;
        } else {
            return false;
        }

    }

    public void mostraTodosMedicos() {
        for (Medico medico : vetorMedico) {
            if (medico != null) {
                System.out.println(medico);
            }
        }
    }

    public Medico buscaMedico(Medico m) {

        for (Medico medico : vetorMedico) {

            if (medico != null && medico.equals(m)) {
                return medico;
            }
        }
        return null;
    }

    public Medico buscaMedicoAtravesdaPessoaVinculada(Pessoa pessoaLogada) {

        for (Medico medico : vetorMedico) {
            if (medico != null && medico.getPessoa().equals(pessoaLogada)) {
                return medico;
            }
        }

        return null;
    }

    public boolean atualizaLoginMedico(Medico m, String novoLogin) {

        if (!verificaSeloginEstaSendoUsado(novoLogin) == true) {
            for (Medico medico : vetorMedico) {

                if (medico != null && medico.equals(m)) {
                    medico.getPessoa().setLoginPessoa(novoLogin);
                    medico.getPessoa().setDataModificacao(LocalDateTime.now());
                    return true;
                }

            }
        }

        return false;
    }

    public boolean atualizaSenhaMedico(Medico m, String novaSenha) {

        for (Medico medico : vetorMedico) {

            if (medico != null && medico.equals(m)) {
                medico.getPessoa().setSenhaPessoa(novaSenha);
                medico.getPessoa().setDataModificacao(LocalDateTime.now());
                return true;
            }
        }

        return false;
    }

    public boolean atualizaTelefoneMedico(Medico m, String novoTelefone) {

        if (!verificaSeTelefoneEstaSendoUsado(novoTelefone) == true) {
            for (Medico medico : vetorMedico) {

                if (medico != null && medico.equals(m)) {
                    medico.getPessoa().setTelefonePessoa(novoTelefone);
                    medico.getPessoa().setDataModificacao(LocalDateTime.now());
                    return true;
                }
            }
        }

        return false;
    }

    private boolean verificaSeloginEstaSendoUsado(String login) {
        for (Medico medico : vetorMedico) {
            if (medico != null && medico.getPessoa().getLoginPessoa().equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificaSeTelefoneEstaSendoUsado(String telefone) {
        for (Medico medico : vetorMedico) {
            if (medico != null && medico.getPessoa().getTelefonePessoa().equals(telefone)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificaSeMedicoExiste(Pessoa p)
    {
        for (Medico medico : vetorMedico) {
            
            if(medico != null && medico.getPessoa().getCpf().equals(p.getCpf()))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificaCrm(String Crm)
    {
        for (Medico medico : vetorMedico) {
            
            if(medico != null && medico.getCrm().equals(Crm.toUpperCase()) ||
               medico != null && medico.getCrm().equals(Crm.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }

}
