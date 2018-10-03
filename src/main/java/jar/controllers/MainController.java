package main.java.jar.controllers;

public class MainController {
    
    public MainController() {
        PlayerController playerController = new PlayerController();
        GameController gameController = new GameController(playerController);
        gameController.startGame();
    }
}