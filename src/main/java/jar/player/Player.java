package jar.player;

import jar.model.Card;

public abstract class Player implements Comparable<Player>{
    
    public abstract Card getCard();
    public abstract String getName();
    public abstract String chooseStat();
    public abstract Hand getHand();
    @Override
    public abstract int compareTo(Player o);

}