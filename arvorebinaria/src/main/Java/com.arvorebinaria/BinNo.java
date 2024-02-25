package com.arvorebinaria;
// Definindo a classe BinNo, que representa um nó em uma árvore binária.
public class BinNo<T extends Comparable<T>> {
    private final T conteudo;
    //Referência para o nó à esquerda.
    private BinNo<T> noEsq;
    //Referência para o nó à direita.
    private BinNo<T> noDir;
    //Construtor que inicializa um nó com um conteúdo específico.
    public BinNo(T conteudo) {
        this.conteudo = conteudo;
        noEsq = noDir = null; // Inicializa as referências à esquerda e à direita como nulas.
    }
    //Método para obter o conteúdo do nó.
    public T getConteudo() {
        return conteudo;
    }
    //Método para obter a referência para o nó à esquerda.
    public BinNo<T> getNoEsq() {
        return noEsq;
    }
    //Método para definir a referência para o nó à esquerda.
    public void setNoEsq(BinNo<T> noEsq) {
        this.noEsq = noEsq;
    }

    //Método para obter a referência para o nó à direita.
    public BinNo<T> getNoDir() {
        return noDir;
    }
    //Método para definir a referência para o nó à direita.
    public void setNoDir(BinNo<T> noDir) {
        this.noDir = noDir;
    }
    //Sobrescreve o método toString para fornecer uma representação em string do nó.
    @Override
    public String toString() {
        return "BinNo{" +
                "conteudo=" + conteudo +
                '}';
    }
}