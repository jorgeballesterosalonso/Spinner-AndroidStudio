package com.example.spinner;

public class operacion {
    int numero1 = (int) Math.round(Math.random() * 100);
    int numero2 = (int) Math.round(Math.random() * 100);
    int resultado;
    String simbolo;

    public operacion(int nivel) {

        switch (nivel) {
            case 0:
                this.resultado = numero1 + numero2;
                this.simbolo = "+";
                break;

            case 1:
                this.resultado = numero1 - numero2;
                this.simbolo = "-";
                break;

            case 2:
                this.resultado = numero1 * numero2;
                this.simbolo = "x";
                break;

            case 3:
                this.resultado = numero1 / numero2;
                this.simbolo = "/";
                break;

        }


    }

    @Override
    public String toString() {
        return "operacion{" +
                "numero1=" + numero1 +
                ", numero2=" + numero2 +
                ", resultado=" + resultado +
                ", simbolo=" + simbolo +
                '}';
    }

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }


    public int getResultado() {
        return resultado;
    }

    public String getSimbolo() {
        return simbolo;
    }

}
