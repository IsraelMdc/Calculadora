package com.model.operacoes;

import com.model.Operacao;

public class Divisao implements Operacao {
    @Override
    public String getNome() {
        return "Divisão";
    }

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}