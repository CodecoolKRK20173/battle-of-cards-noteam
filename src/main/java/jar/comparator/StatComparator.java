package jar.comparator;

import java.util.Comparator;

import jar.enums.StatEnum;
import jar.model.Card;

public class StatComparator implements Comparator<Card>{
    private Card c1;
    private Card c2;
    
    public boolean compare(int stat1, int stat2) {
        if(stat1 > stat2) {
            return true;
        } else if (stat1 < stat2) {
            return false;
        } else {
            return c1.getMagic() + c1.getStrength() + c1.getSpeed() + c1.getToughness() >
                    c2.getMagic() + c2.getStrength() + c2.getSpeed() + c2.getToughness();
        }
    }

    public Card compare(Card c1, Card c2, String stat) {
        boolean whichWin;
        setCards(c1, c2);
        StatEnum currentStat = StatEnum.valueOf(stat.toUpperCase());
        switch (currentStat) {
            case STRENGTH:
                whichWin = compare(c1.getStrength(), c2.getStrength());
                return (whichWin) ? c1 : c2;
            case SPEED:
                whichWin = compare(c1.getSpeed(), c2.getSpeed());
                return (whichWin) ? c1 : c2;
            case MAGIC:
                whichWin = compare(c1.getMagic(), c2.getMagic());
                return (whichWin) ? c1 : c2;
            case TOUGHNESS:
                whichWin = compare(c1.getToughness(), c2.getToughness());
                return (whichWin) ? c1 : c2;
        }
        return null;
    }

    private void setCards(Card c1, Card c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public int compare(Card c1, Card c2) {
        return 0;
    }

    public enum Stat {

    }

}