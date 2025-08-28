// Local: src/main/java/com/suacalculadora/model/operacoes/Soma.java
package com.model.operacoes;

import com.model.Operacao;

public class Soma implements Operacao {
    @Override
    public String getNome() {
        return "Soma";
    }

    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}