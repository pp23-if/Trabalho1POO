package Model;

import java.time.LocalDateTime;

public class MedicoDAO {

    private Medico[] vetorMedico = new Medico[20];

    public MedicoDAO(PessoaDAO pessoaDAO) {

        Pessoa pessoaMedico = pessoaDAO.buscaPessoaCadastrada("lm23", "456");

        if (pessoaMedico != null) {
            Medico medico = new Medico("ABC-123", pessoaMedico, "Ortopedista", LocalDateTime.now());
            adicionaMedico(medico);
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

    public Medico mostraDadosMedicoLogado(String login, String senha) {

        for (Medico medico : vetorMedico) {

            if (medico != null && medico.getPessoa().getLoginPessoa().equals(login)
                    && medico.getPessoa().getSenhaPessoa().equals(senha)) {
                return medico;
            }
        }
        return null;
    }

    public boolean atualizaLoginMedico(String login, String novoLogin) {

        for (Medico medico : vetorMedico) {

            if (medico != null && medico.getPessoa().getLoginPessoa().equals(login)) {
                medico.getPessoa().setLoginPessoa(novoLogin);
                medico.getPessoa().setDataModificacao(LocalDateTime.now());
                return true;
            }

        }

        return false;
    }

    public boolean atualizaSenhaMedico(String login, String senha, String novaSenha) {

        for (Medico medico : vetorMedico) {

            if (medico != null && medico.getPessoa().getLoginPessoa().equals(login)
                    && medico.getPessoa().getSenhaPessoa().equals(senha)) {
                medico.getPessoa().setSenhaPessoa(novaSenha);
                medico.getPessoa().setDataModificacao(LocalDateTime.now());
                return true;
            }
        }

        return false;
    }

}
