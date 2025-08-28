package com.controller;

import com.model.Operacao;
import com.view.CalculadoraView;
import org.reflections.Reflections;

import java.util.*;

public class CalculadoraController {
    private final CalculadoraView view;
    private final Map<Integer, Operacao> operacoesDisponiveis;

    public CalculadoraController(CalculadoraView view) {
        this.view = view;
        this.operacoesDisponiveis = new HashMap<>();
    }

    private void carregarOperacoes() {

        Reflections reflections = new Reflections("com.model.operacoes");
        Set<Class<? extends Operacao>> classesDeOperacoes = reflections.getSubTypesOf(Operacao.class);

        int indice = 1;
        for (Class<? extends Operacao> classe : classesDeOperacoes) {
            try {
                Operacao operacao = classe.getDeclaredConstructor().newInstance();
                operacoesDisponiveis.put(Integer.valueOf(indice++), operacao);
            } catch (Exception e) {
                view.mostrarErro("Não foi possível carregar a operação: " + classe.getName());
            }
        }
    }

    public void iniciar() {
        carregarOperacoes();

        // Verifica se alguma operação foi carregada antes de continuar
        if (operacoesDisponiveis.isEmpty()) {
            view.mostrarErro("Nenhuma operação foi encontrada. Verifique o pacote de operações.");
            return;
        }

        List<String> nomesOperacoes = new ArrayList<>();
        operacoesDisponiveis.values().stream()
                .sorted(Comparator.comparing(Operacao::getNome))
                .forEach(op -> nomesOperacoes.add(op.getNome()));

        while (true) {
            view.mostrarMenu(nomesOperacoes);
            int escolha = view.getOpcaoUsuario();

            if (escolha == 0) {
                view.mostrarMensagem("Saindo da calculadora. Até logo!");
                break;
            }

            Operacao operacaoSelecionada = encontrarOperacaoPorEscolha(escolha, nomesOperacoes);

            if (operacaoSelecionada != null) {
                try {
                    double num1 = view.getNumero("Digite o primeiro número: ");
                    double num2 = view.getNumero("Digite o segundo número: ");
                    double resultado = operacaoSelecionada.calcular(num1, num2);
                    view.mostrarResultado(resultado);
                } catch (IllegalArgumentException e) {
                    view.mostrarErro(e.getMessage());
                }
            } else {
                view.mostrarErro("Opção inválida. Tente novamente.");
            }
        }
    }

    private Operacao encontrarOperacaoPorEscolha(int escolha, List<String> nomesOrdenados) {
        if (escolha < 1 || escolha > nomesOrdenados.size()) {
            return null;
        }
        String nomeEscolhido = nomesOrdenados.get(escolha - 1);
        return operacoesDisponiveis.values().stream()
                .filter(op -> op.getNome().equals(nomeEscolhido))
                .findFirst()
                .orElse(null);
    }
}