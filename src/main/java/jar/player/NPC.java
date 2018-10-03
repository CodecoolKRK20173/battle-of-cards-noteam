package main.java.jar.player;

import main.java.jar.model.*;

public class NPC extends Player{
    private Hand hand;
    private String name;

    public NPC(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    public Card getCard() {
        return hand.getCard();
    }

    public String chooseStat() {
        Card currCard = hand.getCard();
        int bestStat = currCard.getStrength();
        String stat = "strength";
        if (currCard.getToughness() > currCard) {
            bestStat = currCard.getToughness();
            stat = "toughness";
        } else (currCard.getMagic() > currCard) {
            bestStat = currCard.getToughness();
            stat = "magic";
        } else (currCard.getSpeed() > currCard) {
            bestStat = currCard.getToughness();
            stat = "speed";
        }

        return stat;
    }
    
}