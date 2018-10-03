package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import parsers.XMLLoader;
import model.Card;

public class CardDAO {

    private XMLLoader xmlLoader = new XMLLoader();
    private Map<String, Card> cardMap = new HashMap<>();

    public CardDAO(){
        xmlLoader.loadXmlDocument("/home/rageoverkill/jabba/cardsgame/battle-of-cards-noteam/battleofcards/xml/Deck.xml");
        createCardMap();
    }

    public Card get(String id){
        Card card = cardMap.get(id);
        return card;
    }

    public List<Card> getAll(){
        List<Card> cardList = new ArrayList<Card>(cardMap.values());
        return cardList;
    }

    private void createCardMap(){
        Document document = xmlLoader.getXMLDocument();
        NodeList deck = document.getElementsByTagName("Card");

        for(int i = 0; i < deck.getLength(); i++) {
            
            Node card = deck.item(i);

            String id = getCardIdFromNode(card);
            String name = getCardDescriptionFromNode(card);
            Card theCard = new Card(id, name);

            NodeList stats = card.getChildNodes().item(3).getChildNodes();

            for(int j = 1; j < stats.getLength(); j = j+2) {
                Node stat = stats.item(j);
                Element e = (Element)stat;
                String statId = e.getAttribute("id");
                String statText = stat.getTextContent();
                if(statId.equals("strength")){
                    theCard.setStrength(Integer.valueOf(statText)); 
                }
                if(statId.equals("toughness")){
                    theCard.setToughness(Integer.valueOf(statText));
                }
                if(statId.equals("magic")){
                    theCard.setMagic(Integer.valueOf(statText));
                }
                if(statId.equals("speed")){
                    theCard.setSpeed(Integer.valueOf(statText));
                }
            }
            cardMap.put(id, theCard);
        }
    }

    private String getCardIdFromNode(Node card) {
        Element f = (Element)card;
        String id = f.getAttribute("id");
        return id;
    }

    private String getCardDescriptionFromNode(Node card) {
        Node description = card.getChildNodes().item(1); 
        Element d = (Element)description;
        String descriptionString = d.getAttribute("name"); 
        return descriptionString;
    }
}