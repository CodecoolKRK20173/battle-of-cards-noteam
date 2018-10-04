package jar.player;

import jar.model.Card;
import jar.model.Deck;
import jar.View;
import jar.Hand;

public class HumanPlayer extends Player{
    private Hand hand;
    private String name;
    private Card currCard;

    public HumanPlayer(Hand hand) {
        this.hand = hand;
        setName();
    }

    @Override
    public Hand getCard() {
        currCard = hand.drawCard();
        return currCard;
    }

    @Override
    public String getName() {
        return name;
    }

    public String setName()
    {
        String userNick = getPlayerNick();
        return userNick;
    }

    public String getStat()
    {
        String playerStat = chooseCardStat();
        return playerStat;
    }
}