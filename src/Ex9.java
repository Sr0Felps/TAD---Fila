/*
9. Implemente um procedimento que mescle duas filas
de inteiros já ordenadas (não decrescente) em uma terceira
fila, também ordenada. Em cada passo, compare primeiro()
de A e B e desenfileire o menor para C. Se uma fila esgotar,
despeje a outra. Não use arrays.
 */

public class Ex9 {

    public static void main(String[] args) {

        Fila<Integer> fila1 = new Fila<>();
        fila1.enfileirar(1);
        fila1.enfileirar(3);
        fila1.enfileirar(5);
        fila1.enfileirar(7);

        Fila<Integer> fila2 = new Fila<>();
        fila2.enfileirar(2);
        fila2.enfileirar(4);
        fila2.enfileirar(6);
        fila2.enfileirar(8);
        fila2.enfileirar(8);

        Fila<Integer> fila3 = new Fila<>();

        mesclarFilas(fila1, fila2, fila3);

        System.out.println("Fila mesclada e ordenada:");
        System.out.println("---------------------------------------------");
        while (!fila3.vazia()) {
            System.out.println(fila3.desenfileirar());
        }
        System.out.println("---------------------------------------------");
    }

    public static void mesclarFilas(Fila<Integer> a, Fila<Integer> b, Fila<Integer> c) {

        while (!a.vazia() && !b.vazia()) {
            Integer primeiroA = a.primeiro();
            Integer primeiroB = b.primeiro();

            if (primeiroA <= primeiroB) {
                c.enfileirar(a.desenfileirar());
            } else {
                c.enfileirar(b.desenfileirar());
            }
        }

        while (!a.vazia()) {
            c.enfileirar(a.desenfileirar());
        }

        while (!b.vazia()) {
            c.enfileirar(b.desenfileirar());
        }
    }
}
