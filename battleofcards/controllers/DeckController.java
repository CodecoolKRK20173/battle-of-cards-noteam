package controllers;

import model.Deck;
import model.Card;
import dao.CardDAO;

public class DeckController {

    public Deck loadDeck(int amountOfCards){
        CardDAO cardDao = new CardDAO();
        List<Card> wholeDeck = cardDao.getAll();
        
        
        Deck deck = new Deck(wholeDeck);
        deck.setDeckSize(amountOfCards);
        return deck;
    }
}