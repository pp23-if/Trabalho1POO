
package Controller;

import java.util.Scanner;


public class ValidacaoEntradaDados {
     Scanner scanner = new Scanner(System.in);
    
   /*Todos os metodos dessa classe serao Publicos.*/
    
    public String validaString(String nome)
    {
        while(nome.equals("") || nome.equals(" "))
        {
            System.out.println("entrada incorreta!");
            System.out.println("Informe o Nome da Pessoa: ");
            nome = scanner.nextLine();

        }
         return nome;
    }
    
    
}
