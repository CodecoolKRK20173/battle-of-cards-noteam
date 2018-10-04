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
    
    public GameController(PlayerController playerController, TableController tableController) {
        this.playerController = playerController;
        this.tableController = tableController;
    }

    public void startGame() {
        List<Card> cardsOnTable;
        Card winCard;
        String stat;
        Player playerWinner;
        Scanner scanner = new Scanner(System.in);
        while((cardsOnTable = tableController.prepareTable()) != null) {
            stat = playerController.getPlayerList().get(tableController.getTable().getWhoseTurn()).chooseStat();
            winCard = compareCards(stat);

            System.out.println(playerController.getPlayerList().get(0).getName() + " " + 
                playerController.getPlayerList().get(0).getHand().getDeckSize());
            
            System.out.println(playerController.getPlayerList().get(1).getName() + " " + 
                playerController.getPlayerList().get(0).getHand().getDeckSize());

            System.out.println(playerController.getPlayerList().get(2).getName() + " " + 
                playerController.getPlayerList().get(0).getHand().getDeckSize());

            System.out.println(playerController.getPlayerList().get(3).getName() + " " + 
                playerController.getPlayerList().get(0).getHand().getDeckSize());
            
            addCardsToWinningPlayer(winCard);
            scanner.next();
            tableController.getTable().changeTurn();
        }

        checkWinner();

    }

    private void checkWinner() {
        Collections.sort(playerController.getPlayerList());
        List<Player> winners = new ArrayList<>();
        winners.add(playerController.getPlayerList().get(0));
        for(int i = 1; i < 4; ++i) {
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
        
        for(int i = 2; i < 4; ++i) {
            winCard = statComp.compare(cardsOnTable.get(i), winCard, stat);
        }

        return winCard;
    }

    private void addCardsToWinningPlayer(Card winCard) {
        Player player;

        for(int i = 0; i < 4; ++i) {
            player = playerController.getPlayerList().get(i);
            System.out.println(player.equals(winCard));
            if (player.equals(winCard)) {
                
                player.getHand().addCard(tableController.getTable().getCardsOnTable());
                break;
            }
        }

    }

    // kto ma najwięcej kart comparable


}