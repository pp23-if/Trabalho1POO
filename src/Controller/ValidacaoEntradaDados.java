package Controller;

import java.util.Scanner;

public class ValidacaoEntradaDados {

    Scanner scanner = new Scanner(System.in);

    /*Todos os metodos dessa classe serao Publicos.*/
    public String validaString(String nome) {
        while (nome.equals("") || nome.equals(" ")) {
            System.out.println("entrada incorreta!");
            System.out.println("Informe o Nome da Pessoa: ");
            nome = scanner.nextLine();

        }
        return nome;
    }

    public int validarINT(int numero) {

        while (numero <= 0) {
            System.out.println("numero invalido!");
            System.out.println("Informe outro numero Maior que 0 : ");
            numero = Integer.parseInt(scanner.nextLine());
        }
        return numero;
    }

    public double validarDoble(double numero) {

        while (numero <= 0) {
            System.out.println("numero invalido!");
            System.out.println("Informe outro numero Maior que 0 : ");
            numero = Integer.parseInt(scanner.nextLine());
        }
        return numero;
    }

}
