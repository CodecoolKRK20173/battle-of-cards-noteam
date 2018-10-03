package main.java.jar.player;

import main.java.jar.dao.CardDao;

public class NPC extends Player{
    private Deck deck;
    NPC(Deck deck) {
        this.deck = deck;
    }
}