package main.java.jar.controllers;
import main.java.jar.player;
import main.java.jar.model;
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