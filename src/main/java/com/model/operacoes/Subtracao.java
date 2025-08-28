// Local: src/main/java/com/model/operacoes/Subtracao.java
package com.model.operacoes;

import com.model.Operacao;

public class Subtracao implements Operacao {
    @Override
    public String getNome() {
        return "Subtração";
    }

    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}