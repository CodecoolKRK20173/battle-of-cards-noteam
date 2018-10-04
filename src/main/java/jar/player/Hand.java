
package jar.player;

import jar.model.*;
import java.util.List;

public class Hand
{
    private Deck deck;
    private int currentCard;

    public Hand (Deck deck)
    {
        this.deck = deck;
    }
    
    public Card getNextCard ()
    {
        incrementCurrentCart();
        return deck.getDeck().get(currentCard);
    }

    private void incrementCurrentCart()
    {
        if (++currentCard >= deck.getDeck().size())
        {
            currentCard = 0;
        }
    }

    public Card drawCard ()
    {
        if (getDeckSize() > 0 ) {
            Card temp = deck.getDeck().get(currentCard);
            deck.getDeck().remove(temp);
            return temp;
        }
        return null;
    }

    public void addCard(List<Card> cards)
    {
        for (Card card: cards)
        {
            deck.getDeck().add(card);
        }
    }

    public int getDeckSize() {
        return deck.getDeck().size();
    }
}