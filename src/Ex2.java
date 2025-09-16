/*
2. Implemente um procedimento que inverta apenas
os primeiros k elementos de uma fila de inteiros,
preservando a ordem do restante. Utilize uma pilha
auxiliar para a parte a ser invertida e a própria
fila para recompor a ordem.
 */

import java.util.NoSuchElementException;

public class Ex2 {
    public static void main(String[] args) {

        Fila<Integer> fila = new Fila();
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(4);
        fila.enfileirar(5);

        int tamanho = fila.tamanho()/2;

        Pilha<Integer> pilhaAuxiliar = new Pilha<>(tamanho);

        inverterPrimeirosKElem(pilhaAuxiliar, fila, tamanho);

        System.out.print("Fila: ");
        for (int i = fila.tamanho(); i > 0; i--) {
            System.out.print(fila.desenfileirar() + " ");
        }
    }

    public static void inverterPrimeirosKElem(Pilha<Integer> pilha, Fila<Integer> fila,int tamanho) {

        // Tirando os primeiros k elementos da fila e colocando em uma pilha auxiliar
        for (int i = tamanho; i > 0; i--) {
            pilha.push(fila.desenfileirar());
        }

        int quantRestoDaFila = fila.tamanho();

        //Voltando os elementos retirados para a fila já invertidos
        for (int i = tamanho; i > 0; i--) {
            fila.enfileirar(pilha.pop());
        }

        //Reajustando a ordem dos elementos que ficaram na fila
        for (int i = quantRestoDaFila; i > 0; i--) {
            fila.enfileirar(fila.desenfileirar());
        }
    }

    public static class Pilha <T> {
        private Object[] dados;
        private Integer topo;
        private int size;

        public Pilha(int tamanho) {
            if(tamanho <= 0){
                tamanho = 1;
            }
            this.size = tamanho;
            this.dados = new Object[size];
            this.topo = 0;
        }

        public void push(T item) {
            if(topo == dados.length){
                System.out.println("Pilha cheia!!");
                return;
            }
            dados[topo] = item;
            topo++;
        }

        public T pop() {
            if(empty()) throw new NoSuchElementException("Pilha Vazia!!");
            T item = (T) dados[topo-1];
            --topo;
            return item;
        }

        public T top() {
            if(empty()) throw new NoSuchElementException("Pilha Vazia!!");
            return (T) dados[topo-1];
        }

        public Boolean empty() {
            return topo == 0;
        }

        public Integer size() {
            return topo;
        }
    }

}
