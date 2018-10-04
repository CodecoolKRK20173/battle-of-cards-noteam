package main.java.jar.model;
import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Card> cardsOnTable = new ArrayList<>();
    int whoseTurn = 0;
    

    public void addCardToTable(Card card) {
        cardsOnTable.add(card);
    }

    public void clearTable() {
        cardsOnTable.clear();
    }

    public void changeTurn() {
        whoseTurn++;
        if (whoseTurn == 4 ) {
            whoseTurn = 0;
        }
    }

    
    public List<Card> getCardsOnTable() {
        return cardsOnTable;
    }
}

