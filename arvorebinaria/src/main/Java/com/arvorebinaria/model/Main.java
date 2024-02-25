package com.arvorebinaria.model;
import com.arvorebinaria.ArvoreBinaria;
public class Main {
    //método principal que será executado ao iniciar o programa.
    public static void main(String[] args) {

        //Criação de uma instância da árvore binária que armazenará objetos da classe Obj.
        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

        //Inserção de objetos na árvore binária.
        minhaArvore.inserir(new Obj(13));
        minhaArvore.inserir(new Obj(10));
        minhaArvore.inserir(new Obj(25));
        minhaArvore.inserir(new Obj(2));
        minhaArvore.inserir(new Obj(12));
        minhaArvore.inserir(new Obj(20));
        minhaArvore.inserir(new Obj(31));
        minhaArvore.inserir(new Obj(29));
        minhaArvore.inserir(new Obj(32));

        //Remoção de um objeto da árvore binária.
        minhaArvore.remover(new Obj(32));

        //Exibição da árvore binária nos diferentes tipos de ordens.
        minhaArvore.exibirInOrdem();
        minhaArvore.exibirPreOrdem();
        minhaArvore.exibirPosOrdem();
    }
}
