package com.arvorebinaria;

//Classe que representa uma Árvore Binária parametrizada por um tipo que estende Comparable.
public class ArvoreBinaria<T extends Comparable<T>> {

    //Referência para o nó raiz da árvore.
    private BinNo<T> raiz;

    //Construtor da árvore, inicializa a raiz como nula.
    public ArvoreBinaria() {
        this.raiz = null;
    }

    //Método para inserir um novo conteúdo na árvore.
    public void inserir(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }
    //Método privado de inserção recursiva.
    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        } else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }
    //Método para exibir a árvore em ordem.
    public void exibirInOrdem() {
        System.out.println("\n Exibindo InOrdem");
        exibirInOrdem(this.raiz);
    }
    //Método privado de exibição em ordem recursiva.
    private void exibirInOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }
    //Método para exibir a árvore em pós-ordem.
    public void exibirPosOrdem() {
        System.out.println("\n Exibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }
    //Método privado de exibição em pós-ordem recursiva.
    private void exibirPosOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    //Método para exibir a árvore em pré-ordem.
    public void exibirPreOrdem() {
        System.out.println("\n Exibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }
    //Método privado de exibição em pré-ordem recursiva.
    private void exibirPreOrdem(BinNo<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    //Método para remover um conteúdo da árvore.
    public void remover(T conteudo) {
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho;
            BinNo<T> temp;

            //Encontrar o nó a ser removido.
            while (atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }
            }

            //Se o nó não for encontrado, imprimir mensagem.
            if (atual == null) {
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            //Remoção do nó da árvore com diferentes casos.
            assert atual != null;
            if (pai == null) {
                if (atual.getNoDir() == null) {
                    this.raiz = atual.getNoEsq();
                } else if (atual.getNoEsq() == null) {
                    this.raiz = atual.getNoDir();
                } else {
                    for (temp = atual, filho = atual.getNoEsq();
                         filho.getNoDir() != null;
                         temp = filho, filho = filho.getNoEsq()) {
                        if (filho != atual.getNoEsq()) {
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }
            } else {
                if (atual.getNoDir() == null) {
                    if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(atual.getNoEsq());
                    } else {
                        pai.setNoDir(atual.getNoEsq());
                    }
                } else if (atual.getNoEsq() == null) {
                    if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(atual.getNoDir());
                    } else {
                        pai.setNoDir(atual.getNoDir());
                    }
                } else {
                    for (temp = atual, filho = atual.getNoEsq();
                         filho.getNoDir() != null;
                         temp = filho, filho = filho.getNoDir()) {
                        if (filho != atual.getNoEsq()) {
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(atual.getNoEsq());
                        }
                        filho.setNoDir(atual.getNoDir());
                        if (pai.getNoEsq() == atual) {
                            pai.setNoEsq(filho);
                        } else {
                            pai.setNoDir(filho);
                        }
                    }
                }
            }
        } catch (NullPointerException erro) {
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }
}