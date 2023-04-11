
package View;

import java.util.Scanner;


public class MenuTitulosFranquia {
    
    Scanner scanner = new Scanner(System.in);
    
     public int menuFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Franquia ===========");
        builder.append("\n0 - Para Sair");
        builder.append("\n1 - Ver Cadastro da Franquia");
        builder.append("\n2 - Cadastrar Nova Franquia ");
        builder.append("\n3 - Atualizar Dados da Franquia: ");
        builder.append("\n4 - Excluir Dados da Franquia: ");
        builder.append("\n5 - Exibir Todas As Franquias: ");
        builder.append("\n6 - : ");
        builder.append("\n\nOpcao: ");
       
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
}
