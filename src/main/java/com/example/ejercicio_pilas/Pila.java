package com.example.ejercicio_pilas;

public class Pila<T> {
    private int tope = -1;
    private T[] pila;

    public Pila(int capacidad) {
        pila = (T[]) new Object[capacidad];
    }

    public void Push(T valor){
        if (!estaLlena()) {
            tope++;
            pila[tope] = valor;
        } else {
            System.out.println("La pila está llena");
        }
    }


    public T Pop(){
        if (!estaVacia()) {
            T valor = pila[tope];
            tope--;
            return valor;
        } else {
            System.out.println("La pila está vacía");
            return null;
        }
    }

    public boolean estaVacia(){
        return tope == -1;
    }

    public boolean estaLlena(){
        return tope == pila.length - 1;
    }

    public static void main(String[] args) {
        Pila<Character> pila = new Pila<Character>(10);
        pila.Push('C');
        pila.Push('Y');
        pila.Push('Z');
        System.out.println(pila.Pop());
        System.out.println(pila.Pop());
        System.out.println(pila.Pop());
    }
}
