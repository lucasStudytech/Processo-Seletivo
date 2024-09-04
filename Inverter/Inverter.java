import java.util.Scanner;

public class Inverter {
    public static void main(String[] args) {
        String entrada;
        // Solicita a entrada do usuário
        try ( // Cria um Scanner para ler a entrada do usuário
                Scanner scanner = new Scanner(System.in)) {
            // Solicita a entrada do usuário
            System.out.print("Digite a string que deseja inverter: ");
            entrada = scanner.nextLine();
            // Fecha o scanner
        }
        
        // Chama o método para inverter a string
        String invertida = inverterString(entrada);
        
        // Exibe o resultado
        System.out.println("String invertida: " + invertida);
    }

    private static String inverterString(String str) {
        // Converte a string em um array de caracteres
        char[] caracteres = str.toCharArray();
        int comprimento = caracteres.length;
        
        // Cria um novo array para armazenar a string invertida
        char[] invertida = new char[comprimento];
        
        // Loop para preencher o array invertido
        for (int i = 0; i < comprimento; i++) {
            invertida[i] = caracteres[comprimento - 1 - i];
        }
        
        // Converte o array de caracteres invertido de volta para uma string
        return new String(invertida);
    }
}




 /*
 5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
 */