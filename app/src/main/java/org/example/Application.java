package app.src.main.java.org.example;


import app.src.main.java.org.example.controller.LottoController;


public class Application {
    public static void main(String[] args) {

        LottoController lotto = new LottoController();

        lotto.start();

    }
}