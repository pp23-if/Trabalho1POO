package Model;

import java.time.LocalDateTime;

public class AdmnistradorDAO {

    private Admnistrador[] vetorAdm = new Admnistrador[50];

    public AdmnistradorDAO(PessoaDAO pessoaDAO, FranquiaDAO franquiaDAO) {
        Pessoa pessoaAdm = pessoaDAO.buscaPessoaCadastrada("roadm", "20");
        if (pessoaAdm != null) {
            Franquia franquiaSelecionada = franquiaDAO.buscaFranquiaPorCnpj("123456789-30");

            if (franquiaSelecionada != null) {
                Admnistrador adm = new Admnistrador(pessoaAdm, franquiaSelecionada, LocalDateTime.now());

                adicionaAdmnistrador(adm);
            }

        }

    }

    private int proximaPosilivreAdm() {
        for (int i = 0; i < vetorAdm.length; i++) {
            if (vetorAdm[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean adicionaAdmnistrador(Admnistrador adm) {
        int proxima = proximaPosilivreAdm();
        if (proxima != -1) {
            vetorAdm[proxima] = adm;
            return true;
        } else {
            return false;
        }

    }

    public Admnistrador buscaTodosAdmnistradores() {
        for (Admnistrador admnistrador : vetorAdm) {
            if (admnistrador != null) {
                System.out.println(admnistrador + "\n");
            }
        }
        return null;
    }

    public Admnistrador buscaAdmnistradorAtravesPessoaVinculada(Pessoa pessoa) {
        for (Admnistrador admnistrador : vetorAdm) {
            if (admnistrador != null && admnistrador.getPessoa().equals(pessoa)) {
                return admnistrador;
            }
        }
        return null;
    }
}
