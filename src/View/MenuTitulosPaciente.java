package View;

import java.util.Scanner;

public class MenuTitulosPaciente {

    Scanner scanner = new Scanner(System.in);

    public int menuPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU PACIENTE ===========");
        builder.append("\n 0 - Para Sair.....................:");
        builder.append("\n 1 - Ver Meu Cadastro..............:");
        builder.append("\n 2 - Atualizar Meus Dados..........: ");
        builder.append("\n 3 - Ver Minhas Consultas..........: ");
        builder.append("\n 4 - Ver Meus Procedimentos........: ");
        builder.append("\n 5 - ..............................: ");
        builder.append("\n\n Informe Opcao.....................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraDadosPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU ATUALIZACAO DE DADOS PACIENTE ========");
        builder.append("\n 0 - Para sair......................................: ");
        builder.append("\n 1 - Atualizar Nome.................................: ");
        builder.append("\n 2 - Atualizar Cpf..................................: ");
        builder.append("\n 3 - Atualizar Endereco.............................: ");
        builder.append("\n 4 - Atualizar Telefone.............................: ");
        builder.append("\n 5 - Atualizar Login................................: ");
        builder.append("\n 6 - Atualizar Senha................................: ");
        builder.append("\n\n Informe Opcao......................................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

}
