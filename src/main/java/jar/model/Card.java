package jar.model;

import jar.View;

public class Card {

    private String id;
    private String name;
    private int strength;
    private int toughness;
    private int magic;
    private int speed;
    private int hashCodeId;

    public Card(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString(Card card){
        String title = "Title: " + card.name +"\n";
        String stat1 = "Strength: " + card.getStrength() +"\n";
        String stat2 = "Toughness: " + card.getToughness() +"\n";
        String stat3 = "Magic: " + card.getMagic() + "\n";
        String stat4 = "Speed: " + card.getSpeed() + "\n";
        return View.printCard(title, stat1, stat2, stat3, stat4);
    }

    public void setHashCodeId(int hashCodeId) {
        this.hashCodeId = hashCodeId;
    }

    @Override
    public int hashCode(){
        return hashCodeId;
    }

}

