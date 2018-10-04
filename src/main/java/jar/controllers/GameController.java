package jar.controllers;

import java.util.List;
import java.util.Scanner;

import jar.model.Card;

public class GameController {
    private PlayerController playerController;
    private TableController tableController;
    private String stat;
    
    public GameController(PlayerController playerController, TableController tableController) {
        this.playerController = playerController;
        this.tableController = tableController;
    }

    public void startGame() {
        List<Card> cardsOnTable;
        while((cardsOnTable = tableController.prepareTable()) != null) {
            stat = playerController.getPlayerList().get(tableController.getTable().getWhoseTurn()).chooseStat();
            // porównywanie statystyk comparator
            // dodanie kart dla gracza który wygrał

            Scanner scanner = new Scanner(System.in);
            scanner.next();
            tableController.getTable().changeTurn();
        }
    }

    // kto ma najwięcej kart comparable


}