package View;

import java.util.Scanner;

public class MenuTitulos {

    Scanner scanner = new Scanner(System.in);

    public int menuInicial() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Inicial ===========");
        builder.append("\n0 - Para sair do programa");
        builder.append("\n1 - Login");
        builder.append("\n2 - cadastrar Pessoa: ");
        builder.append("\n3 - Listar Todos os Vetores: ");
        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Paciente ===========");
        builder.append("\n0 - Para Sair");
        builder.append("\n1 - Ver Meu Cadastro");
        builder.append("\n2 - Atualizar Meus Dados: ");
        builder.append("\n3 - Excluir Meus Dados: ");
        builder.append("\n4 - : ");
        builder.append("\n5 - : ");
        builder.append("\n6 - : ");
        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraDadosPaciente() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ Menu Atualizacao De Dados Paciente ===========");
        builder.append("\n0 - Para sair");
        builder.append("\n1 - Atualizar Nome: ");
        builder.append("\n2 - Atualizar Cpf: ");
        builder.append("\n3 - Atualizar Endereco: ");
        builder.append("\n4 - Atualizar Telefone: ");
        builder.append("\n5 - Atualizar Login: ");
        builder.append("\n6 - Atualizar Senha: ");
        builder.append("\n\nOpcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
}
