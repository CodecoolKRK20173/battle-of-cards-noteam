package main.java.jar;

public class MainController {
    
    public MainController() {
        PlayerController playerController = new PlayerController();
        GameController gameController = new GameController(playerController);
        gameController.startGame();
    }
}