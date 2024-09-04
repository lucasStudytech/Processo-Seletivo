public class Contador{
    
    public static void main(String[] args) {
        // Defina a string que você deseja verificar
        String texto = "Aqui está um exemplo de texto para verificar a quantidade de letras A.";

        // Chama o método para contar a letra 'a' e exibe o resultado
        int quantidade = contarLetraA(texto);
        System.out.println("A letra 'a' aparece " + quantidade + " vez(es) no texto.");
    }

    public static int contarLetraA(String texto) {
        int contagem = 0;

        // Converte o texto para minúsculas para facilitar a contagem
        texto = texto.toLowerCase();

        // Itera sobre cada caractere da string
        for (int i = 0; i < texto.length(); i++) {
            // Verifica se o caractere atual é 'a'
            if (texto.charAt(i) == 'a') {
                contagem++;
            }
        }

        return contagem;
    }
}
