/*
3. Implemente um procedimento que intercale duas
filas de inteiros A e B em uma fila C, alternando um
elemento de cada, até que ambas esgotem. Se uma fila
terminar antes, enfileire o restante da outra. Não
modifique A e B ao final (reconstrua-as, se necessário).
 */

public class Ex3 {
    public static void main(String[] args) {

        //Construindo as filas
        Fila<Integer> filaA = new Fila<>();
        filaA.enfileirar(1);
        filaA.enfileirar(3);
        filaA.enfileirar(5);

        Fila<Integer> filaB = new Fila<>();
        filaB.enfileirar(2);
        filaB.enfileirar(4);
        filaB.enfileirar(6);

        Fila<Integer> filaC = new Fila<>();

        intercalandoAsFilas(filaA, filaB, filaC);

        System.out.print("Fila C: ");
        for (int i = filaC.tamanho(); i > 0; i--) {
            System.out.print(filaC.desenfileirar() + " ");
        }
    }

    public static void intercalandoAsFilas(Fila<Integer> filaA, Fila<Integer>  filaB, Fila<Integer>  filaC) {

        while (!filaA.vazia() && !filaB.vazia()) {
            filaC.enfileirar(filaA.desenfileirar());
            filaC.enfileirar(filaB.desenfileirar());
        }

        while (!filaA.vazia()) {
            filaC.enfileirar(filaA.desenfileirar());
        }

        while (!filaB.vazia()) {
            filaC.enfileirar(filaB.desenfileirar());
        }
    }
}
