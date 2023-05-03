
package View;

import java.util.Scanner;


public class MenuTitulosFranquia {
    
    Scanner scanner = new Scanner(System.in);
    
     public int menuFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU DONO DE FRANQUIA ==========");
        builder.append("\n 0 - Para Sair.............................:");
        builder.append("\n 1 - Ver Cadastro da Franquia..............: ");
        builder.append("\n 2 - Ver Cadastro Dono De Franquia.........: ");
        builder.append("\n 3 - Cadastrar Nova Franquia...............: ");
        builder.append("\n 4 - Atualizar Dados da Franquia E Dono....: ");
        builder.append("\n 5 - Excluir Dados da Franquia.............: ");
        builder.append("\n 6 - Exibir Todas As Franquias.............: ");
        builder.append("\n 7 - Cadastrar Medico......................: ");
        builder.append("\n 8 - Exibir Todos Os Medicos...............: ");
        builder.append("\n 9 - Cadastar Unidade De Franquia..........: ");
        builder.append("\n 10 - Exibir Unidades Franquia.............: ");
        builder.append("\n\n Informe Opcao...........................: ");
        
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
     
     public int menuAtualizacaoDeDadosFranquia() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n============ MENU ATUALIZACAO DE DADOS FRANQUIA ==========");
        builder.append("\n 0 - Para Sair..........................................:");
        builder.append("\n 1 - Atualizar Nome Da Franquia.........................: ");
        builder.append("\n 2 - Atualizar Cidade da Franquia.......................: ");
        builder.append("\n 3 - Atualizar Endereco Da Franquia.....................: ");
        builder.append("\n 4 - Atualizar Login Dono De Franquia...................: ");
        builder.append("\n 5 - Atualizar Senha Dono De Franquia...................: ");
        builder.append("\n 6 - Atualizar Telefone Dono De Franquia................: ");
        builder.append("\n\n Informe Opcao........................................: ");
       
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
     
     
}
