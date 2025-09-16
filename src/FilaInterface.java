public interface FilaInterface<T> {
    void enfileirar(T item);
    T desenfileirar();
    T primeiro();
    Boolean vazia();
    Integer tamanho();
}
