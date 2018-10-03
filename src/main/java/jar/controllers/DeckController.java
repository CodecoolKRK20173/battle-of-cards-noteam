package main.java.jar.controllers;

import main.java.jar.model.Deck;
import main.java.jar.model.Card;
import main.java.jar.dao.CardDAO;

import java.util.List;

public class DeckController {

    public Deck loadDeck(int amountOfCards){
        CardDAO cardDao = new CardDAO();
        List<Card> wholeDeck = cardDao.getAll();
        
        Deck deck = new Deck(wholeDeck);
        deck.setDeckSize(amountOfCards);
        return deck;
    }
}