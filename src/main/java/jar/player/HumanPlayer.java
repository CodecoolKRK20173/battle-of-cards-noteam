package jar.player;

import jar.model.Card;
import jar.View;

public class HumanPlayer extends Player implements Comparable<Player>{
    private Hand hand;
    private String name;
    private Card currCard;
    private int hashCodeId;

    public HumanPlayer(Hand hand, int id) {
        this.hand = hand;
        this.hashCodeId = id;
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

    public void setName()
    {
        this.name = View.getPlayerNick();
    }

    public String chooseStat()
    {
        String playerStat = View.chooseCardStat();
        return playerStat;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int compareTo(Player o) {
        if(getHand().getDeckSize() > o.getHand().getDeckSize()) {
            return 1;
        } else if (getHand().getDeckSize() < o.getHand().getDeckSize()) {
            return -1;
        } else {
            return 0;
        }
    }
}