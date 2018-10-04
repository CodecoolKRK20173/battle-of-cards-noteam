package main.java.jar.model;
package main.java.jar.player;

public class TableController {
    List<Card> cardsOnTable = new ArrayList<>();

    public List<Card> round(List<Player> players, String stat) {
        
        
        for (int i = 0; i < players.size(); i++) {
            
            Card temp = players[i].drawCard();
            
            if (temp != null) {
                cardsOnTable.add(temp);
            } else {
                return null;
            }
        
        return cardsOnTable;
        }

    }
}