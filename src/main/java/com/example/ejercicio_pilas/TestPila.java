package com.example.ejercicio_pilas;

public class TestPila {
    private Pila<Object> pila;

    public TestPila() {
        pila = new Pila<>(15);
    }

    public String invierteCadena(String cadena) {
        for (char c : cadena.toCharArray()) {
            pila.push(c);
        }

        StringBuilder cadenaInvertida = new StringBuilder();
        while (!pila.estaVacia()) {
            cadenaInvertida.append(pila.pop());
        }

        return cadenaInvertida.toString();
    }

    public boolean revisarSintaxis(String cadena){
        for (char c : cadena.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pila.estaVacia()) {
                    return false;
                }
                char ultimo = (char) pila.pop();
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
        String cadena = "Julian Pasos";
        String cadenaInvertida = test.invierteCadena(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + cadenaInvertida);

        String sintaxis1 = (")");
        String sintaxis2 = "({[}])";
        System.out.println("Sintaxis 1: " + test.revisarSintaxis(sintaxis1));
        System.out.println("Sintaxis 2: " + test.revisarSintaxis(sintaxis2));
    }

}



