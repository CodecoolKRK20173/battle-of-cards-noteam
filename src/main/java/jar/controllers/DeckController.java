package jar.controllers;

import jar.model.Deck;
import jar.model.Card;
import jar.dao.CardDAO;

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