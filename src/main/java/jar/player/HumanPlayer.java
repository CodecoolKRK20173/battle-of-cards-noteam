/*
wybiera karte z reki
wybiera statystyke z karty
położyc karte na stół 
podać nick

*/



package main.java.jar.player;

import main.java.jar.model.Deck;

public class HumanPlayer extends Player{
    private Hand hand;
    private String name;

    public NPC(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    @Override
    public Hand getCard() {
        return null;
    }
}