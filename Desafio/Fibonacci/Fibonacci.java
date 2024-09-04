import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe um número: ");
            int numero = scanner.nextInt();
            
            if (pertenceFibonacci(numero)) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + numero + " NÃO pertence à sequência de Fibonacci.");
            }
        }
    }

    public static boolean pertenceFibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }

        int a = 0;
        int b = 1;
        int soma = a + b;

        while (soma <= numero) {
            if (soma == numero) {
                return true;
            }
            a = b;
            b = soma;
            soma = a + b;
        }

        return false;
    }
}


/*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores
 anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde,
  informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado
   pertence ou não a sequência.

IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente
 definido no código;*/