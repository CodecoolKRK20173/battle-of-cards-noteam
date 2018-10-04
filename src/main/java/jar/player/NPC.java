package jar.player;

import jar.model.*;

public class NPC extends Player{
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
    
}