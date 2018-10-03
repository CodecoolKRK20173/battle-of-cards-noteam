package main.java.jar.player;

import main.java.jar.model.Deck;

public class NPC extends Player{
    private Deck deck;
    public NPC(Deck deck) {
        this.deck = deck;
    }
}