package main.java.jar.player;

import main.java.jar.dao.CardDao;

public class HumanPlayer extends Player{
    private Deck deck;
    HumanPlayer(Deck deck) {
        this.deck = deck;
    }
}