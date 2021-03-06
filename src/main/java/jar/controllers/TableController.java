package jar.controllers;
import jar.player.*;
import jar.model.*;
import java.util.List;

public class TableController {
    private List<Player> players;
    Table table = new Table();

    public TableController(List<Player> players) {
        this.players = players;
    }
    public List<Card> prepareTable() {
        
        table.clearTable();
        
        for (int i = 0; i < players.size(); i++) {
            
            Card temp = players.get(i).getCard();

            if (temp != null) {
                table.addCardToTable(temp);
            }
        
        }
        return table.getCardsOnTable();
    }

    /**
     * @return the table
     */
    public Table getTable() {
        return table;
    }
    
    public boolean isEndGame() {
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getHand().getDeckSize() == 0) {
                return true;
            }
        }
        return false;
    }
}