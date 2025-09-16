/*
1. Implemente um procedimento que receba uma fila de inteiros
e rotacione seus elementos k posições para a esquerda. Remova
da frente e enfileire no fim repetindo k vezes. Não use estruturas
extras além da própria fila e variáveis simples.
 */

public class Ex1 {
    public static void main(String[] args) {

        int contador = 30;

        Fila<Integer> fila = new Fila<>();
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.enfileirar(40);
        fila.enfileirar(50);

        rotacionar(contador, fila);

    }

    public static void rotacionar(int c, Fila f) {
        for (int i = c; i > 0; i--) {
            System.out.println("Valor: " + f.primeiro());
            f.enfileirar(f.desenfileirar());
        }
    }
}
