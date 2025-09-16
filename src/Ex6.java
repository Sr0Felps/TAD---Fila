/*
6. Implemente uma simulação de atendimento em
caixa de banco usando fila. Cada cliente possui
(nome, tempoAtendimento). Enfileire clientes de uma
lista de chegada, atenda sequencialmente (desenfileirar),
acumule o tempo total e imprima a ordem de atendimento
e o tempo médio.
 */

public class Ex6 {
    public static void main(String[] args) {

        Fila<Cliente> fila = new Fila<>();
        Cliente cliente1 = new Cliente(2,"João");
        Cliente cliente2 = new Cliente(3,"Marcos");
        Cliente cliente3 = new Cliente(1,"Maria");

        fila.enfileirar(cliente1);
        fila.enfileirar(cliente2);
        fila.enfileirar(cliente3);
        int tempoTotal = 0, tempoMedio = 0, tamanhoOriginal = fila.tamanho();

        atender(cliente1, cliente2, cliente3, fila, tempoTotal, tempoMedio, tamanhoOriginal);

    }
    public static void atender(Cliente a, Cliente b, Cliente c, Fila fila, int total, int medio, int tamanho) {
        Cliente cliente;
        String nome;
        int tempoAtendimento;


        while (!fila.vazia()) {
            cliente = (Cliente) fila.desenfileirar();
            nome = cliente.getNome();
            tempoAtendimento = cliente.getTempoAtendimento();
            System.out.println("---------------------------------------------");
            System.out.println("Cliente: " + nome);
            System.out.println("Tempo de atendimento: " + tempoAtendimento);
            System.out.println("---------------------------------------------");


            total = total + cliente.getTempoAtendimento();
        }
        System.out.println("Tempo total de atendimentos: " + total);

        medio = total / tamanho;
        System.out.println("Tempo médio de atendimento: " + medio);
    }

    public static class Cliente {
        private String nome;
        private int tempoAtendimento;

        public Cliente(int tempoAtendimento, String nome) {
            this.tempoAtendimento = tempoAtendimento;
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public int getTempoAtendimento() {
            return tempoAtendimento;
        }
    }
}


