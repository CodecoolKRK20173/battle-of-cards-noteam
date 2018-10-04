package jar.comparator;

import java.util.Comparator;

import jar.model.Card;

public class StatComparator implements Comparator<Card>{
    
    public boolean compare(int stat1, int stat2) {
        return stat1 > stat2;
    }

    public Card compare(Card o1, Card o2, String stat) {
        boolean whichWin;
        switch (stat.toLowerCase()) {
            case "strength":
                whichWin = compare(o1.getStrength(), o2.getStrength());
                return (whichWin) ? o1 : o2;
            case "speed":
                whichWin = compare(o1.getSpeed(), o2.getSpeed());
                return (whichWin) ? o1 : o2;
            case "magic":
                whichWin = compare(o1.getMagic(), o2.getMagic());
                return (whichWin) ? o1 : o2;
            case "toughness":
                whichWin = compare(o1.getToughness(), o2.getToughness());
                return (whichWin) ? o1 : o2;
        }

        return null;
    }

    @Override
    public int compare(Card o1, Card o2) {
        return 0;
    }

}