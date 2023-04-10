
package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import View.MenuTitulosFranquia;
import java.util.Scanner;


public class FranquiaControladora {
    
    Scanner scanner = new Scanner(System.in);
    MenuTitulosFranquia telaFranquia = new MenuTitulosFranquia();

    public FranquiaControladora(Franquia franquia, FranquiaDAO franquiaDAO) {
        
        menuOpcoesFranquia(franquia, franquiaDAO);
    }
    
     private void menuOpcoesFranquia(Franquia franquia, FranquiaDAO franquiaDAO) {

        int opcao;

        do {
            opcao = telaFranquia.menuFranquia();

            switch (opcao) {
                case 1: {
                    System.out.println("\n" + franquiaDAO.buscaFranquia(franquia));
                    break;
                }
                case 2: {
                   
                    break;
                }
            }

        } while (opcao != 0);
    }
    
}
