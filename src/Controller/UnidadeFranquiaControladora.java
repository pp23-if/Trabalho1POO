
package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import Model.MedicoDAO;
import Model.PessoaDAO;
import Model.UnidadeFranquia;
import Model.UnidadeFranquiaDAO;
import View.MenuTitulosUnidadeFranquia;
import java.util.Scanner;


public class UnidadeFranquiaControladora {

    Scanner scanner = new Scanner(System.in);
    MenuTitulosUnidadeFranquia menuTitulosUnidadeFranquia = new MenuTitulosUnidadeFranquia();
    
    
    public UnidadeFranquiaControladora(UnidadeFranquia unidadeFranquia, UnidadeFranquiaDAO 
            unidadeFranquiaDAO) 
    {
        menuOpcoesUnidadeFranquia(unidadeFranquia, unidadeFranquiaDAO);
    }
    
    
    private void menuOpcoesUnidadeFranquia(UnidadeFranquia unidadeFranquia, UnidadeFranquiaDAO unidadeFranquiaDAO) {

        int opcao;

        do {
            opcao = menuTitulosUnidadeFranquia.menuUnidadeFranquia();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + unidadeFranquiaDAO.buscaUnidadeDeFranquia(unidadeFranquia));
                    break;
                }
                case 2: {
                    
                    break;
                }
                case 3: {
                      unidadeFranquiaDAO.buscaUnidadeFranquiaAtravesDaFranquiaVinculada(unidadeFranquia.getFranquia());
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    System.out.println("\n======== VETOR DE MEDICOS ===========\n");
                    
                    break;
                }
                case 6: {
                   
                    break;
                }
                case 7: {
                    
                    break;
                }
                case 8: {
                    
                    break;
                }
                case 9: {
                    
                    break;
                }
            }

        } while (opcao != 0);
    }
    
}
