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
        builder.append("\n3 - Exibir Todas As Unidades De Franquia : ");
        builder.append("\n4 - Cadastrar Medico: ");
        builder.append("\n5 - Exibir Todos Os Medicos: ");
        builder.append("\n6 - Excluir?? : ");
        builder.append("\n7 - : ");
        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAtualizacaoDeDadosUnidadeFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Atualizacao De Dados Unidade Franquia ===========");
        builder.append("\n0 - Para Sair");
        builder.append("\n1 - Atualizar Cidade da Unidade De Franquia: ");
        builder.append("\n2 - Atualizar Endereco Da Unidade De Franquia: ");
        builder.append("\n3 - Atualizar Login Dono Unidade Franquia: ");
        builder.append("\n4 - Atualizar Senha Dono Unidade Franquia: ");
        builder.append("\n5 - Atualizar Telefone Dono Unidade De Franquia: ");

        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
}
