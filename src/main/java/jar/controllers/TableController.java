package main.java.jar.model;
package main.java.jar.player;

public class TableController {
    List<Card> cardsOnTable = new ArrayList<>();


    public void round(List<Player> players, String stat) {
        
        
        for (int i = 0; i < players.size(); i++) {
            cardsOnTable.add(players[i].getNextCard());
        }
        
        // compare stats here to find who won

        
    }

    public getStatComparison(List<Card> cardsOnTable, String statName) { //cardsOnTable - list of cards to compare stats
        
        
        //for (int i = 0; i < cardsOnTable.size() ; i++) {
            // compare using 
            // if (statName.equals("Strength")) {
            //     cardsOnTable[i].getStrength()

            //}
            
        }
    }
}