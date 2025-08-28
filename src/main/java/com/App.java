package com;

import com.controller.CalculadoraController;
import com.view.CalculadoraView;

public class App {
    public static void main(String[] args) {
        CalculadoraView view = new CalculadoraView();
        CalculadoraController controller = new CalculadoraController(view);
        controller.iniciar();
    }
}