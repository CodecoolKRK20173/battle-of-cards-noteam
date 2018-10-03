package main.java.jar.player;

import main.java.jar.model.Deck;

public class HumanPlayer extends Player{
    private Deck deck;
    public HumanPlayer(Deck deck) {
        this.deck = deck;
    }
}