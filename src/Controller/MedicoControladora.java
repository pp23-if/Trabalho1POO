
package Controller;

import Model.Medico;
import Model.MedicoDAO;
import View.MenuTitulosMedico;


public class MedicoControladora {
    
    MenuTitulosMedico telaMedico = new MenuTitulosMedico();

    public MedicoControladora(Medico medico, MedicoDAO medicoDAO) {
        
       menuOpcoesMedico(medico,medicoDAO);
        
    }
    
   private void menuOpcoesMedico(Medico medico, MedicoDAO medicoDAO) {

        int opcao;

        do {
             opcao = telaMedico.menuMedico();

            switch (opcao) {
                case 1: {
                      System.out.println("\n" + medicoDAO.mostraDadosmedicoLogado(medico.getPessoa().getLoginPessoa(),
                              medico.getPessoa().getSenhaPessoa()));
                    break;
                }
                case 2: {
                   
                    break;
                }
            }

        } while (opcao != 0);
    }
}
