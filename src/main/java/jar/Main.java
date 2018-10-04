package jar;

import jar.controllers.MainController;
public class Main {
    public static void main(String[] args) {
        View.entryScreen();
        MainController mainController = new MainController();
    }
}