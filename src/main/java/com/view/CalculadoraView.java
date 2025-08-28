package com.view;

import java.util.List;
import java.util.Scanner;

public class CalculadoraView {
    private final Scanner scanner;

    public CalculadoraView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(List<String> nomesOperacoes) {
        System.out.println("\n--- Calculadora Dinâmica ---");
        System.out.println("Escolha uma operação:");
        for (int i = 0; i < nomesOperacoes.size(); i++) {
            System.out.printf("%d. %s%n", (i + 1), nomesOperacoes.get(i));
        }
        System.out.println("0. Sair");
        System.out.print("Sua opção: ");
    }

    public int getOpcaoUsuario() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Opção inválida
        }
    }

    public double getNumero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarErro("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    public void mostrarResultado(double resultado) {
        System.out.printf("O resultado é: %.2f%n", resultado);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarErro(String erro) {
        System.out.println("ERRO: " + erro);
    }
}