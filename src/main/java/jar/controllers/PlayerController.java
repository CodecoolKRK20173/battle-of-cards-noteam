package main.java.jar.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.jar.player.*;

public class PlayerController {
    private int cardsAmount;
    private int npcNumber;
    private List<Player> playerList = new ArrayList<>();
    private DeckController deckController;

    PlayerController(DeckController deckController) {
        this.deckController = deckController;
        this.cardsAmount = View.getAmountOfCards();
        this.npcNumber = View.getNPCNumber();

        createPlayerList();
    }

    private void createPlayerList() {
        for(int i = 0; i < npcNumber; ++i) {
            playerList.add(new NPC(deckController.loadDeck(amountOfCards)));
        }

        for(int i = 0; i < 4 - npcNumber; ++i) {
            playerList.add(new HumanPlayer(deckController.loadDeck(amountOfCards)));
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

}