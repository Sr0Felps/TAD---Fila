/*
10. Implemente um procedimento espelharFila
que replique a fila concatenando uma cópia de si
mesma ao final. Ex.: [A, B, C] -> [A, B, C, A, B, C].
Ao final, a fila original deve estar nesse novo formato.
Não use estruturas indexadas; use apenas a própria fila
e contagem (tamanho()).
*/

public class Ex10 {
    public static void main(String[] args) {
        Fila<String> minhaFila = new Fila<>();
        minhaFila.enfileirar("A");
        minhaFila.enfileirar("B");
        minhaFila.enfileirar("C");

        System.out.println("Fila original: [A, B, C]");
        espelharFila(minhaFila);

        System.out.print("Fila espelhada: [");
        while (!minhaFila.vazia()) {
            if (minhaFila.tamanho() == 1) {
                System.out.print(minhaFila.desenfileirar() + "]");
            } else {
                System.out.print(minhaFila.desenfileirar() + ", ");
            }
        }
    }

    public static void espelharFila(Fila<String> fila) {
        if (fila == null || fila.vazia()) {
            return;
        }

        int tamanhoOriginal = fila.tamanho();

        for (int i = 0; i < tamanhoOriginal; i++) {
            String elemento = fila.desenfileirar();
            fila.enfileirar(elemento);
        }

        Fila<String> auxiliar = new Fila<>();
        for (int i = 0; i < tamanhoOriginal; i++) {
            String elemento = fila.desenfileirar();
            auxiliar.enfileirar(elemento);
            fila.enfileirar(elemento);
        }

        for (int i = 0; i < tamanhoOriginal; i++) {
            fila.enfileirar(auxiliar.desenfileirar());
        }
    }
}