package View;

import java.util.Scanner;

public class MenuTitulosPaciente {

    Scanner scanner = new Scanner(System.in);

    public int menuPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Paciente ===========");
        builder.append("\n0 - Para Sair.....................:");
        builder.append("\n1 - Ver Meu Cadastro..............:");
        builder.append("\n2 - Atualizar Meus Dados..........: ");
        builder.append("\n3 - Consulta......................: ");
        builder.append("\n4 - : ");
        builder.append("\n5 - : ");
        builder.append("\n\nInforme Opcao.....................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraDadosPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Atualizacao De Dados Paciente ===========");
        builder.append("\n0 - Para sair...........................: ");
        builder.append("\n1 - Atualizar Nome......................: ");
        builder.append("\n2 - Atualizar Cpf.......................: ");
        builder.append("\n3 - Atualizar Endereco..................: ");
        builder.append("\n4 - Atualizar Telefone..................: ");
        builder.append("\n5 - Atualizar Login.....................: ");
        builder.append("\n6 - Atualizar Senha.....................: ");
        builder.append("\n\nInforme Opcao...........................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
     public int menuConsultaPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Consulta Paciente ===========");
        builder.append("\n0 - Para sair.....................: ");
        builder.append("\n1 - Marcar Consulta...............: ");
        builder.append("\n2 - Ver Consultas Marcadas........: ");
        builder.append("\n3 - Cancelar Consulta.............: ");
        builder.append("\n4 - Remarcar Consulta.............: ");
        builder.append("\n\nInforme Opcao.....................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
}
