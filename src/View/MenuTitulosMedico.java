
package View;

import java.util.Scanner;


public class MenuTitulosMedico {
    
    Scanner scanner = new Scanner(System.in);
    
    public int menuMedico() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU MEDICO  ===========");
        builder.append("\n0 - Para Sair.................: ");
        builder.append("\n1 - Ver Cadastro de Medico....: ");
        builder.append("\n2 - Atualizar Dados de Medico.: ");
        builder.append("\n3 - Admnistrar Consultas......: ");
        builder.append("\n4 - : ");
        builder.append("\n5 - : ");
        builder.append("\n6 - : ");
        builder.append("\n\nInforme Opcao.................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
      public int menuAlteraDadosMedico() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=== MENU ATUALIZACAO DE DADOS MEDICO ===");
        builder.append("\n0 - Para sair.........................: ");
        builder.append("\n1 - Atualizar Login Medico............: ");
        builder.append("\n2 - Atualizar Senha Medico............: ");
        builder.append("\n3 - Atualizar Telefone Medico.........: ");
        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());
        
        return Integer.parseInt(scanner.nextLine());
    }
      
      public int menuGerenciamentoConsultas() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU GERENCIA CONSULTA ===========");
        builder.append("\n0 - Para sair.........................: ");
        builder.append("\n1 - Atender Consultas.................: ");
        builder.append("\n2 - Ver consultas.....................: ");
        builder.append("\n3 - ...: ");
        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());
        
        return Integer.parseInt(scanner.nextLine());
    }
}
