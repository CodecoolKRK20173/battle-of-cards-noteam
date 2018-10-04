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

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int hashCode() {
        return hashCodeId;
    }

    @Override
    public int compareTo(Player o) {
        return getHand().getDeckSize() - o.getHand().getDeckSize();
    }
}