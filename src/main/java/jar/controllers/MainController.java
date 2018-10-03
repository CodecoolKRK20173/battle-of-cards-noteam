package main.java.jar.controllers;

public class MainController {
    
    public MainController() {
        DeckController deckController = new DeckController();
        PlayerController playerController = new PlayerController(deckController);
        GameController gameController = new GameController(playerController);
        gameController.startGame();
    }
}