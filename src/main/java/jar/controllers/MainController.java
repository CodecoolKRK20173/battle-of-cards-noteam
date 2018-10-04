package jar.controllers;

public class MainController {
    
    public MainController() {
        DeckController deckController = new DeckController();
        PlayerController playerController = new PlayerController(deckController);
        TableController tableController = new TableController(playerController.getPlayerList());
        GameController gameController = new GameController(playerController, tableController);
        gameController.startGame();
    }
}