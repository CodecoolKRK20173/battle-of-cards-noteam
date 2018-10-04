package jar.controllers;

import jar.View;

public class MainController {
    
    public MainController() {
        View.clearScreen();
        DeckController deckController = new DeckController();
        PlayerController playerController = new PlayerController(deckController);
        TableController tableController = new TableController(playerController.getPlayerList());
        GameController gameController = new GameController(playerController, tableController);
        gameController.startGame();
    }
}