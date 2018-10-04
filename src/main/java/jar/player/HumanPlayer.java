package jar.player;

import jar.model.Card;
import jar.View;

public class HumanPlayer extends Player{
    private Hand hand;
    private String name;
    private Card currCard;

    public HumanPlayer(Hand hand) {
        this.hand = hand;
        setName();
    }

    @Override
    public Card getCard() {
        currCard = hand.drawCard();
        return currCard;
    }

    @Override
    public String getName() {
        return name;
    }

    public String setName()
    {
        String userNick = View.getPlayerNick();
        return userNick;
    }

    public String chooseStat()
    {
        String playerStat = View.chooseCardStat();
        return playerStat;
    }
}