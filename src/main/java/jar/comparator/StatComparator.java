package jar.comparator;

import java.util.Comparator;

import jar.model.Card;

public class StatComparator implements Comparator<Card>{
    private Card o1;
    private Card o2;
    
    public boolean compare(int stat1, int stat2) {
        if(stat1 > stat2) {
            return true;
        } else if (stat1 < stat2) {
            return false;
        } else {
            return o1.getMagic() + o1.getStrength() + o1.getSpeed() + o1.getToughness() >
                    o2.getMagic() + o2.getStrength() + o2.getSpeed() + o2.getToughness();
        }
    }

    public Card compare(Card o1, Card o2, String stat) {
        boolean whichWin;
        setCards(o1, o2);
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

    private void setCards(Card o1, Card o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public int compare(Card o1, Card o2) {
        return 0;
    }

}