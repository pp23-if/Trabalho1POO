
package Controller;

import Model.Franquia;
import Model.FranquiaDAO;
import Model.Pessoa;
import View.MenuTitulosFranquia;
import java.time.LocalDateTime;
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
                    cadastraNovaFranquia(franquiaDAO);
                    break;
                }
                case 3:
                {
                    break;
                }
                case 4:
                {
                    break;
                }
                case 5:
                {
                    System.out.println("======== VETOR DE FRANQUIAS ===========\n");
                    franquiaDAO.mostraTodasFranquias();
                }
            }

        } while (opcao != 0);
    }
     
    private void cadastraNovaFranquia(FranquiaDAO franquiaDAO)
    {
        System.out.println("Informe o Nome da Franquia: ");
        String nomeFranquia = scanner.nextLine();
        
        System.out.println("Informe o Cnpj da Franquia: ");
        String cnpjFranquia = scanner.nextLine();
        
        System.out.println("Informe a Cidade da Franquia: ");
        String cidadeFranquia = scanner.nextLine();
        
        System.out.println("Informe o Endereco da Franquia: ");
        String enderecoFranquia = scanner.nextLine();
        
        if(franquiaDAO.verificaSeFranquiaExiste(nomeFranquia, cnpjFranquia) == true)
        {
            System.out.println("\nA Franquia Ja Existe");
        }
         else
        {
            Pessoa pessoa = new Pessoa("Carlos Alberto", "2020", "Rua 55", 
               "35358899", "A", "1", "Dono de Franquia", LocalDateTime.now());
            
            Franquia franquia = new Franquia(nomeFranquia, cnpjFranquia, 
                    cidadeFranquia, enderecoFranquia, pessoa, LocalDateTime.now());
            
            boolean franquiaAdicionada = franquiaDAO.adicionaFranquia(franquia);
            
            if(franquiaAdicionada == true)
            {
                System.out.println("\nFranquia Cadastrada Com Sucesso!");
            }
            else
            {
                System.out.println("\nNao Foi Possivel Cadastrar a Franquia.");
            }
        }
        
      
       
        
    }
    
}
