package com.arvorebinaria.model;
import java.util.Objects;
public class Obj extends ObjArvore<Obj> {
    //Atributo que armazena o valor inteiro associado a este objeto.
    Integer meuValor;
    //Construtor que recebe o valor inteiro e inicializa o objeto.
    public Obj(Integer meuValor) {
        this.meuValor = meuValor;
    }
    //Método sobrescrito para verificar a igualdade entre objetos.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obj obj = (Obj) o;
        return Objects.equals(meuValor, obj.meuValor);
    }
    //Método para gerar o código hash do objeto.
    @Override
    public int hashCode() {
        return Objects.hash(meuValor);
    }
    //Método para comparar este objeto com outro objeto do mesmo tipo.
    @Override
    public int compareTo(Obj outro) {
        int resultado = 0;

        if (this.meuValor > outro.meuValor) {
            resultado = 1;
        } else if (this.meuValor < outro.meuValor) {
            resultado = -1;
        }
        return resultado;
    }
    //Método para converter o objeto para uma representação de string.
    @Override
    public String toString() {
        return meuValor.toString();
    }
}