/*
4. Implemente um procedimento que verifique se
duas filas de strings são iguais em conteúdo e
ordem, devolvendo true/false. Ao final, ambas as
filas devem permanecer exatamente como estavam.
Evite copiar para arrays.
 */

import java.util.Objects;

public class Ex4 {
    public static void main(String[] args) {

        Fila<String> filaA = new Fila<>();
        filaA.enfileirar("Meu ");
        filaA.enfileirar("nome é");
        filaA.enfileirar(" João");

        Fila<String> filaB = new Fila<>();
        filaB.enfileirar("Meu ");
        filaB.enfileirar("nome é");
        filaB.enfileirar(" João");

        if (verificarIgualdade(filaA, filaB)) {
            System.out.println("As filas são iguais!");
        } else {
            System.out.println("As filas são diferentes");
        }
    }

    public static boolean verificarIgualdade(Fila A, Fila B) {
        String conteudoA, conteudoB;
        boolean igual = true;

        while(!A.vazia() && !B.vazia()) {
            conteudoA = (String) A.desenfileirar();
            conteudoB = (String) B.desenfileirar();

            if (!Objects.equals(conteudoA, conteudoB)) {
                igual = false;
            }
        }
        return igual;
    }
}
