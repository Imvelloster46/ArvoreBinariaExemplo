package com.arvorebinaria.model;
public abstract class ObjArvore<T> implements Comparable<T> {
    //Método para verificar a igualdade entre objetos.
    public abstract boolean equals(Object o);
    //Método para gerar o código hash do objeto.
    public abstract int hashCode();
    //Método para comparar o objeto com outro objeto do mesmo tipo.
    public abstract int compareTo(T outro);
    //Método para converter o objeto para uma representação de string.
    public abstract String toString();
}
