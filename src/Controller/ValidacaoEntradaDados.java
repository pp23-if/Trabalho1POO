
package Controller;

import java.util.Scanner;


public class ValidacaoEntradaDados {
     Scanner scanner = new Scanner(System.in);
    
   /*Todos os metodos dessa classe serao Publicos.*/
    
    public String validaNome(String nome)
    {
        while(nome.equals("") || nome.equals(" "))
        {
            System.out.println("nome incorreto!");
            System.out.println("Informe o Nome da Pessoa: ");
            nome = scanner.nextLine();

        }
         return nome;
    }
    
    
}
