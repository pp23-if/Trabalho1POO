
package View;

import java.util.Scanner;


public class MenuTitulosUnidadeFranquia {
      Scanner scanner = new Scanner(System.in);
      
     public int menuUnidadeFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Unidade De Franquia ===========");
        builder.append("\n0 - Para Sair");
        builder.append("\n1 - Ver Cadastro Unidade De Franquia");
        builder.append("\n2 - Atualizar Dados Unidade De Franquia: ");
        builder.append("\n3 - Excluir ??: ");
        builder.append("\n4 - Cadastrar Medico: ");
        builder.append("\n5 - Exibir Todos Os Medicos: ");
        builder.append("\n6 - : ");
        builder.append("\n7 - : ");
        builder.append("\n\nOpcao: ");
       
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
}
