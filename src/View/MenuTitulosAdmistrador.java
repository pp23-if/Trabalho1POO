
package View;

import java.util.Scanner;

public class MenuTitulosAdmistrador {
    Scanner scanner = new Scanner(System.in);

    public int menuAdmnistrador() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU ADMNISTRADOR ===========");
        builder.append("\n 0 - Para sair do programa.............: ");
        builder.append("\n 1 - Ver Cadastro Admnistrador.........: ");
        builder.append("\n 2 - Consultas.........................: ");
        builder.append("\n 3 - Procedimentos.....................: ");
        builder.append("\n 4 - Financeiro........................: ");
        builder.append("\n 5 - ..................................: ");
        builder.append("\n\n Informe Opcao.........................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuConsultas() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU CONSULTAS ============");
        builder.append("\n 0 - Para sair do programa...........: ");
        builder.append("\n 1 - Marcar Consulta.................: ");
        builder.append("\n 2 - Ver Consultas...................: ");
        builder.append("\n 3 - Cancelar Consulta...............: ");
        builder.append("\n 4 - Remarcar Consulta...............: ");
        builder.append("\n\n Informe Opcao.......................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
      public int menuProcedimentos() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU PROCEDIMENTOS ===========");
        builder.append("\n 0 - Para sair do programa..............: ");
        builder.append("\n 1 - Marcar Procedimento................: ");
        builder.append("\n 2 - Ver Procedimentos..................: ");
        builder.append("\n 3 - Cancelar Procedimento..............: ");
        builder.append("\n 4 - Remarcar Procedimento..............: ");
        builder.append("\n\n Informe Opcao..........................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
      
      public int menuFinanceiroAdm() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU FINANCEIRO ==============");
        builder.append("\n 0 - Para sair do programa..............: ");
        builder.append("\n 1 - Encerrar Dia.......................: ");
        builder.append("\n 2 - Pagar Despesas.....................: ");
        builder.append("\n 3 - Ver Movimentos Financeiros.........: ");
        builder.append("\n 4 - ..........: ");
        builder.append("\n\n Informe Opcao........................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
}
