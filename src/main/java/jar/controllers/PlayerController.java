package jar.controllers;

import java.util.ArrayList;
import java.util.List;

import jar.player.*;
import jar.View;

public class PlayerController {
    private int cardsAmount;
    private int npcNumber;
    private final int PLAYER_NUMBER = 4;
    private List<Player> playerList = new ArrayList<>();
    private DeckController deckController;

    public PlayerController(DeckController deckController) {
        this.deckController = deckController;
        this.cardsAmount = View.getNumberOfCards();
        this.npcNumber = PLAYER_NUMBER - View.getNumberOfPlayers();

        createPlayerList();
    }

    private void createPlayerList() {
        for(int i = 0; i < npcNumber; ++i) {
            Hand hand = new Hand(deckController.loadDeck(cardsAmount));
            playerList.add(new NPC(hand, "Computer " + (i+1)));
        }

        for(int i = npcNumber; i < PLAYER_NUMBER; ++i) {
            playerList.add(new HumanPlayer(new Hand(deckController.loadDeck(cardsAmount))));
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

}