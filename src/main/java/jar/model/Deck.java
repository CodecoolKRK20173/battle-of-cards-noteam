package jar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List <Card> deck;

    public Deck(List<Card> deck){
        this.deck = deck;
        Collections.shuffle(this.deck);
    }

    public List<Card> getDeck(){
        return deck;
    }

    public void setDeckSize(int numOfCards){
        if(numOfCards < deck.size()){
            deck = deck.subList(0, numOfCards);
        }
    }
}