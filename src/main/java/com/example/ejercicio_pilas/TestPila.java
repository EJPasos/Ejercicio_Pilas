package com.example.ejercicio_pilas;

public class TestPila {
    private Pila<Object> pila;

    public TestPila() {
        pila = new Pila<>(10);
    }

    public String invierteCadena(String cadena) {
        for (char c : cadena.toCharArray()) {
            pila.Push(c);
        }

        StringBuilder cadenaInvertida = new StringBuilder();
        while (!pila.estaVacia()) {
            cadenaInvertida.append(pila.Pop());
        }

        return cadenaInvertida.toString();
    }

    public boolean revisarSintaxis(String cadena){
        for (char c : cadena.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pila.Push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pila.estaVacia()) {
                    return false;
                }
                char ultimo = (char) pila.Pop();
                if ((c == ')' && ultimo != '(') ||
                    (c == '}' && ultimo != '{') ||
                    (c == ']' && ultimo != '[')) {
                    return false;
                }
            }
        }
        return pila.estaVacia();
    }


    public static void main(String[] args) {
        TestPila test = new TestPila();
        String cadena = "Hola Mundo";
        String cadenaInvertida = test.invierteCadena(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + cadenaInvertida);

        String sintaxis1 = "({[]})";
        String sintaxis2 = "({[})";
        System.out.println("Sintaxis 1 es correcta: " + test.revisarSintaxis(sintaxis1));
        System.out.println("Sintaxis 2 es correcta: " + test.revisarSintaxis(sintaxis2));
    }

}



