
package View;

import java.util.Scanner;


public class MenuTitulosFranquia {
    
    Scanner scanner = new Scanner(System.in);
    
     public int menuFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU DONO DE FRANQUIA ===========");
        builder.append("\n0 - Para Sair.............................:");
        builder.append("\n1 - Ver Cadastro da Franquia.............: ");
        builder.append("\n2 - Ver Cadastro Dono De Franquia........: ");
        builder.append("\n3 - Cadastrar Nova Franquia..............: ");
        builder.append("\n4 - Atualizar Dados da Franquia E Dono...: ");
        builder.append("\n5 - Excluir Dados da Franquia............: ");
        builder.append("\n6 - Exibir Todas As Franquias............: ");
        builder.append("\n7 - Cadastrar Medico.....................: ");
        builder.append("\n8 - Exibir Todos Os Medicos..............: ");
        builder.append("\n9 - Cadastar Unidade De Franquia.........: ");
        builder.append("\n10 - Exibir Unidades Franquia............: ");
        builder.append("\n\nInforme Opcao..........................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
     
     public int menuAtualizacaoDeDadosFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU ATUALIZACAO DE DADOS FRANQUIA ===========");
        builder.append("\n0 - Para Sair...................................:");
        builder.append("\n1 - Atualizar Nome Da Franquia..................: ");
        builder.append("\n2 - Atualizar Cidade da Franquia................: ");
        builder.append("\n3 - Atualizar Endereco Da Franquia..............: ");
        builder.append("\n4 - Atualizar Login Dono De Franquia............: ");
        builder.append("\n5 - Atualizar Senha Dono De Franquia............: ");
        builder.append("\n6 - Atualizar Telefone Dono De Franquia.........: ");
        builder.append("\n\nInforme Opcao...................................: ");
       
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
     
     
}
