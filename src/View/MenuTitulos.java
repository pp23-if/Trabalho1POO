package View;

import java.util.Scanner;

public class MenuTitulos {

    Scanner scanner = new Scanner(System.in);

    public int menuInicial() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU INICIAL ============");
        builder.append("\n 0 - Para sair do programa..........: ");
        builder.append("\n 1 - Login..........................: ");
        builder.append("\n 2 - Cadastrar Pessoa...............: ");
        builder.append("\n 3 - Listar Todos os Vetores........: ");
        builder.append("\n\n Informe Opcao....................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
    
}
