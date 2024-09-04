public class Proximo {
  
    public static void main(String[] args) {
        // Sequência (a)
        int[] seqA = {1, 3, 5, 7};
        System.out.println("Sequência (a): Próximo elemento é " + (seqA[seqA.length - 1] + 2));

        // Sequência (b)
        int[] seqB = {2, 4, 8, 16, 32, 64};
        System.out.println("Sequência (b): Próximo elemento é " + (seqB[seqB.length - 1] * 2));

        // Sequência (c)
        int[] seqC = {0, 1, 4, 9, 16, 25, 36};
        System.out.println("Sequência (c): Próximo elemento é " + ((int)Math.pow(Math.sqrt(seqC[seqC.length - 1]) + 1, 2)));

        // Sequência (d)
        int[] seqD = {4, 16, 36, 64};
        System.out.println("Sequência (d): Próximo elemento é " + (int)Math.pow(Math.sqrt(seqD[seqD.length - 1]) + 2, 2));

        // Sequência (e)
        int a = 1, b = 1;
        System.out.println("Sequência (e): Próximo elemento é " + (a + b));

        // Sequência (f)
        int[] seqF = {2, 10, 12, 16, 17, 18, 19};
        System.out.println("Sequência (f): Próximo elemento é 20");
    }
}
