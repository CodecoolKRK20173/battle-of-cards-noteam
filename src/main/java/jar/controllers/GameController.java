package jar.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import jar.View;
import jar.comparator.StatComparator;
import jar.model.Card;
import jar.player.Player;

public class GameController {
    private PlayerController playerController;
    private TableController tableController;
    private final int PLAYER_NUMBER = 4;
    
    public GameController(PlayerController playerController, TableController tableController) {
        this.playerController = playerController;
        this.tableController = tableController;
    }

    public void startGame() {
        View.clearScreen();
        Card winCard;
        String stat;

        Scanner scanner = new Scanner(System.in);
        while(!tableController.isEndGame()) {
            tableController.prepareTable();

            stat = playerController.getPlayerList().get(tableController.getTable().getWhoseTurn()).chooseStat();
            winCard = compareCards(stat);
            View.printTable(playerController, tableController);

            scanner.nextLine();
            addCardsToWinningPlayer(winCard);
            View.clearScreen();

            tableController.getTable().changeTurn();
        }

        View.printTable(playerController, tableController);
        
        checkWinner();
    }

    private void checkWinner() {
        List<Player> winners = new ArrayList<>();
        int firstWinner = 0;

        Collections.sort(playerController.getPlayerList(), Collections.reverseOrder());
        winners.add(playerController.getPlayerList().get(firstWinner));

        int nextToCheck = 1;
        for(int i = nextToCheck; i < PLAYER_NUMBER; ++i) {
            Player anotherPlayer = playerController.getPlayerList().get(i);
            if(winners.get(0).compareTo(anotherPlayer) == 0) {
                winners.add(anotherPlayer);
            } else {
                break;
            }
        }

        View.printWinners(winners);
    }

    private Card compareCards(String stat) {
        StatComparator statComp = new StatComparator();
        List<Card> cardsOnTable = tableController.getTable().getCardsOnTable();
        Card winCard = statComp.compare(cardsOnTable.get(0), cardsOnTable.get(1), stat);
        
        int nextToCompare = 2;
        for(int i = nextToCompare; i < PLAYER_NUMBER; ++i) {
            winCard = statComp.compare(cardsOnTable.get(i), winCard, stat);
        }

        return winCard;
    }

    private void addCardsToWinningPlayer(Card winCard) {
        Player player;

        for(int i = 0; i < PLAYER_NUMBER; ++i) {
            player = playerController.getPlayerList().get(i);
            if (tableController.getTable().getCardsOnTable().get(i).equals(winCard)) {
                player.getHand().addCard(tableController.getTable().getCardsOnTable());
                break;
            }
        }

    }

}