/*
5. Implemente um procedimento que remova elementos
duplicados de uma fila de inteiros, preservando a
primeira ocorrência e a ordem relativa. Utilize uma
estrutura auxiliar de marcação (ex.: HashSet<Integer>)
e apenas a própria fila para remontar o resultado.
 */

import java.util.HashSet;
import java.util.Set;

public class Ex5 {
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();

        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(2);
        fila.enfileirar(4);
        fila.enfileirar(1);

        if (removerDuplicados(fila)) {
            System.out.println("Repetições encontradas!");
            System.out.print("Fila sem repetições: ");
            while (!fila.vazia()) {
                System.out.print(fila.desenfileirar() + " ");
            }
        } else {
            System.out.println("Repetições não encontradas!");
        }
    }

    public static boolean removerDuplicados(Fila<Integer> fila) {
        int tamanhoOriginal = fila.tamanho();

        Set<Integer> vistos = new HashSet<>();

        for (int i = 0; i < tamanhoOriginal; i++) {
            Integer elemento = fila.desenfileirar();

            if (vistos.add(elemento)) {
                fila.enfileirar(elemento);
            }
        }

        return fila.tamanho() < tamanhoOriginal;
    }
}
