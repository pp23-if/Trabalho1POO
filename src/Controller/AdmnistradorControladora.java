package Controller;

import Model.Admnistrador;
import Model.AdmnistradorDAO;
import Model.ConsultaDAO;
import Model.PessoaDAO;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosAdmistrador;

public class AdmnistradorControladora {

    MenuTitulosAdmistrador telaAdmistrador = new MenuTitulosAdmistrador();

    public AdmnistradorControladora(PessoaDAO pessoaDAO,
            AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador) {

        menuOpcoesAdmnistrador(pessoaDAO, admnistradorDAO,
                unidadeFranquiaDAO, consultaDAO, vd, admnistrador);

    }

    private void menuOpcoesAdmnistrador(PessoaDAO pessoaDAO,
            AdmnistradorDAO admnistradorDAO,
            UnidadeFranquiaDAO unidadeFranquiaDAO,
            ConsultaDAO consultaDAO, ValidacaoEntradaDados vd,
            Admnistrador admnistrador) {

        int opcao;

        do {
            opcao = telaAdmistrador.menuAdmnistrador();

            switch (opcao) {
                case 1: {
                    System.out.println(admnistradorDAO.
                            buscaAdmnistradorAtravesPessoaVinculada
                                (admnistrador.getPessoa()));

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    break;
                }

            }

        } while (opcao != 0);

    }

}
