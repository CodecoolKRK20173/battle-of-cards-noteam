package jar.player;

import jar.model.*;

public class NPC extends Player implements Comparable<Player>{
    private Hand hand;
    private String name;
    private Card currCard;
    private int hashCodeId;

    public NPC(Hand hand, String name, int id) {
        this.hand = hand;
        this.name = name;
        this.hashCodeId = id;
    }

    public Card getCard() {
        currCard = hand.drawCard();
        currCard.setHashCodeId(hashCodeId);
        return currCard;
    }

    @Override
    public String getName() {
        return name;
    }

    public String chooseStat() {
        int bestStat = currCard.getStrength();
        String stat = "strength";
        if (currCard.getToughness() > bestStat) {
            bestStat = currCard.getToughness();
            stat = "toughness";
        } else if (currCard.getMagic() > bestStat) {
            bestStat = currCard.getMagic();
            stat = "magic";
        } else if (currCard.getSpeed() > bestStat) {
            bestStat = currCard.getSpeed();
            stat = "speed";
        }

        return stat;
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