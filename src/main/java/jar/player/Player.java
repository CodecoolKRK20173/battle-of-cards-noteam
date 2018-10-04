package jar.player;

import jar.model.Card;

public abstract class Player {
    
    public abstract Card getCard();
    public abstract String getName();
    public abstract String chooseStat();

}