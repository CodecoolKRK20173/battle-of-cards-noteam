package main.java.jar.player;

import main.java.jar.model.Card;
import main.java.jar.model.Deck;
import main.java.jar.View;
import main.java.jar.Hand;

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