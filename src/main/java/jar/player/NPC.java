package jar.player;

import jar.enums.StatEnum;
import jar.model.*;

public class NPC extends Player implements Comparable<Player>{
    private Hand hand;
    private String name;
    private Card currCard;

    public NPC(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    public Card getCard() {
        currCard = hand.drawCard();
        return currCard;
    }

    @Override
    public String getName() {
        return name;
    }

    public String chooseStat() {
        int bestStat = currCard.getStrength();
        StatEnum statEnum = StatEnum.STRENGTH;

        if (currCard.getToughness() > bestStat) {
            bestStat = currCard.getToughness();
            statEnum = StatEnum.TOUGHNESS;
        } else if (currCard.getMagic() > bestStat) {
            bestStat = currCard.getMagic();
            statEnum = StatEnum.MAGIC;
        } else if (currCard.getSpeed() > bestStat) {
            bestStat = currCard.getSpeed();
            statEnum = StatEnum.SPEED;
        }

        return statEnum.toString().toLowerCase();
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