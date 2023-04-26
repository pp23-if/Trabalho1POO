
package View;

import java.util.Scanner;


public class MenuTitulosMedico {
    
    Scanner scanner = new Scanner(System.in);
    
    public int menuMedico() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=============== MENU MEDICO  ====================");
        builder.append("\n 0 - Para Sair................................: ");
        builder.append("\n 1 - Ver Cadastro de Medico...................: ");
        builder.append("\n 2 - Atualizar Dados de Medico................: ");
        builder.append("\n 3 - Admnistrar Consultas.....................: ");
        builder.append("\n 4 - Admnistrar Procedimentos.................: ");
        builder.append("\n 5 - Gerar Relatorio Consultas/Procedimentos..: ");
        builder.append("\n 6 - .........................................: ");
        builder.append("\n\n Informe Opcao................................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
      public int menuAlteraDadosMedico() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n======== MENU ATUALIZACAO DE DADOS MEDICO ========");
        builder.append("\n 0 - Para sair..................................: ");
        builder.append("\n 1 - Atualizar Login Medico.....................: ");
        builder.append("\n 2 - Atualizar Senha Medico.....................: ");
        builder.append("\n 3 - Atualizar Telefone Medico..................: ");
        builder.append("\n\n Informe Opcao..................................: ");

        System.out.print(builder.toString());
        
        return Integer.parseInt(scanner.nextLine());
    }
      
      public int menuGerenciamentoConsultas() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============== MENU GERENCIA CONSULTA ===============");
        builder.append("\n 0 - Para sair....................................: ");
        builder.append("\n 1 - Atender Consultas............................: ");
        builder.append("\n 2 - Ver consultas................................: ");
        builder.append("\n 3 - Ver Informacoes De Consultas.................: ");
        builder.append("\n 4 - Atualizar Descricao De Info De Consulta......: ");
        builder.append("\n\n Informe Opcao....................................: ");

        System.out.print(builder.toString());
        
        return Integer.parseInt(scanner.nextLine());
    }
      
    public int menuGerenciaProcedimentos() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n======== MENU GERENCIA PROCEDIMENTOS ===========");
        builder.append("\n 0 - Para sair do programa....................: ");
        builder.append("\n 1 - Marcar Procedimento......................: ");
        builder.append("\n 2 - Realizar Procedimento....................: ");
        builder.append("\n 3 - Ver Procedimentos........................: ");
        builder.append("\n 4 - Cancelar Procedimento....................: ");
        builder.append("\n 5 - Remarcar Procedimento....................: ");
        builder.append("\n\n Informe Opcao................................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }  
}
