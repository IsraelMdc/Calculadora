package com.model.operacoes;

import com.model.Operacao;

public class Multiplicacao implements Operacao {
    @Override
    public String getNome() {
        return "Multiplicação";
    }

    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}