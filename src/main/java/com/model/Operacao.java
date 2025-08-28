// Local: src/main/java/com/model/Operacao.java
package com.model;

public interface Operacao {
    /**
     * Retorna o nome da operação para ser exibido no menu.
     * @return O nome da operação.
     */
    String getNome();

    /**
     * Executa o cálculo entre dois números.
     * @param a O primeiro número.
     * @param b O segundo número.
     * @return O resultado do cálculo.
     */
    double calcular(double a, double b);
}