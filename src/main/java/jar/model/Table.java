package jar.model;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Card> cardsOnTable = new ArrayList<>();
    private int whoseTurn = 0;
    private final int playerNumber = 4;
    

    public void addCardToTable(Card card) {
        cardsOnTable.add(card);
    }

    public void clearTable() {
        cardsOnTable.clear();
    }

    public void changeTurn() {
        whoseTurn++;
        if (whoseTurn == playerNumber ) {
            whoseTurn = 0;
        }
    }

    
    public List<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    /**
     * @return the whoseTurn
     */
    public int getWhoseTurn() {
        return whoseTurn;
    }
}

