package View;

import java.util.Scanner;

public class MenuTitulosUnidadeFranquia {

    Scanner scanner = new Scanner(System.in);

    public int menuUnidadeFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============= MENU UNIDADE DE FRANQUIA ==============");
        builder.append("\n 0 - Para Sair.....................................: ");
        builder.append("\n 1 - Ver Cadastro Unidade De Franquia..............: ");
        builder.append("\n 2 - Ver Cadastro Dono Unidade De Franquia.........: ");
        builder.append("\n 3 - Atualizar Dados Unidade De Franquia E Dono....: ");
        builder.append("\n 4 - Exibir Todas As Unidades De Franquia..........: ");
        builder.append("\n 5 - Cadastrar Medico..............................: ");
        builder.append("\n 6 - Exibir Todos Os Medicos.......................: ");
        builder.append("\n 7 - Excluir??.....................................: ");
        builder.append("\n\n Informe Opcao...................................: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAtualizacaoDeDadosUnidadeFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU ATUALIZACAO DE DADOS UNIDADES FRANQUIA =====");
        builder.append("\n 0 - Para Sair..............................................: ");
        builder.append("\n 1 - Atualizar Cidade da Unidade De Franquia................: ");
        builder.append("\n 2 - Atualizar Endereco Da Unidade De Franquia..............: ");
        builder.append("\n 3 - Atualizar Login Dono Unidade Franquia..................: ");
        builder.append("\n 4 - Atualizar Senha Dono Unidade Franquia..................: ");
        builder.append("\n 5 - Atualizar Telefone Dono Unidade De Franquia............: ");
        builder.append("\n\n Informe Opcao............................................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
}
