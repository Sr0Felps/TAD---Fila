/*
8. Implemente um gerador de números binários de 1 até N usando fila.
Enfileire “1”; para cada i de 1 a N: desenfileire s, imprima s, e
enfileire s+"0" e s+"1". Armazene as strings geradas em uma lista e exiba ao final.
 */

import java.util.ArrayList;
import java.util.List;

public class Ex8 {
    public static void main(String[] args) {
        int N = 10;
        List<String> resultados = gerarBinarios(N);

        System.out.println("Gerando os primeiros " + N + " números binários:");
        for (String binario : resultados) {
            System.out.println(binario);
        }

    }

    public static List<String> gerarBinarios(int n) {
        List<String> binarios = new ArrayList<>();

        Fila<String> fila = new Fila<>();

        fila.enfileirar("1");

        for (int i = 0; i < n; i++) {
            String s = fila.desenfileirar();

            binarios.add(s);

            fila.enfileirar(s + "0");
            fila.enfileirar(s + "1");
        }

        return binarios;
    }
}
