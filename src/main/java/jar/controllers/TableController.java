package jar.controllers;
import jar.player;
import jar.model;
import java.util.ArrayList;
import java.util.List;

public class TableController {
    Table table = new Table();
    public List<Card> prepareTable(List<Player> players) {
        
        
        for (int i = 0; i < players.size(); i++) {
            
            Card temp = players[i].drawCard();
            
            if (temp != null) {
                addCardToTable(temp);
            } else {
                return null;
            }
        
        return getCardsOnTable();
        }

    }

    
}