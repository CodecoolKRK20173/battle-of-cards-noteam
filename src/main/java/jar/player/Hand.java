
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
        Card temp = deck.getDeck().get(currentCard);
        deck.getDeck().remove(temp);
        return temp;
    }

    public void addCard(List<Card> cards)
    {
        for (Card card: cards)
        {
            deck.getDeck().add(card);
        }
    }

}