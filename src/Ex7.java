/*
7. Implemente um procedimento que receba duas
filas de eventos, cada evento contendo (nome, tempo),
e mescle-as em uma terceira fila, de modo que os elementos
fiquem ordenados pelo tempo. Compare o tempo do primeiro de
cada fila; desenfileire o menor e enfileire na fila resultante.
Em caso de empate de tempo, enfileire primeiro o evento da
primeira fila. Continue até que as duas filas estejam vazias.
 */

public class Ex7 {
    public static void main(String[] args) {
        Fila<Eventos> evento1 = new Fila<>();
        Eventos A = new Eventos("Boliche", 2);
        Eventos B = new Eventos("Festa" , 3);

        evento1.enfileirar(A);
        evento1.enfileirar(B);

        Fila<Eventos> evento2 = new Fila<>();
        Eventos C = new Eventos("Lanche", 1);
        Eventos D = new Eventos("Futebol", 2);
        Eventos E = new Eventos("Aula", 5);

        evento2.enfileirar(C);
        evento2.enfileirar(D);
        evento2.enfileirar(E);

        Fila<Eventos> evento3 = new Fila<>();

        mesclar(evento1, evento2, evento3);

    }

    public static void mesclar(Fila<Eventos> a, Fila<Eventos> b, Fila<Eventos> c) {
        Eventos evento1, evento2;

        while (!a.vazia() && !b.vazia()) {
            evento1 = a.primeiro();
            evento2 = b.primeiro();

            if (evento1.getTempo() <= evento2.getTempo()) {
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

        while (!c.vazia()) {
            Eventos evento = c.desenfileirar();
            System.out.println("---------------------------------------------");
            System.out.println("Evento: " + evento.getNome());
            System.out.println("Tempo: " + evento.getTempo());
            System.out.println("---------------------------------------------");
        }
    }

    public static class Eventos {
        private String nome;
        private int tempo;

        public Eventos(String nome, int tempo) {
            this.nome = nome;
            this.tempo = tempo;
        }

        public String getNome() {
            return nome;
        }

        public int getTempo() {
            return tempo;
        }
    }
}
