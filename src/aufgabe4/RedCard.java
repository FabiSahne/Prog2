package aufgabe4;

import java.util.Random;

public class RedCard extends Card{

    public RedCard(){
        Random r = new Random();
        suit = Suit.values()[r.nextInt(2)];
        rank = Rank.values()[r.nextInt(8)];
    }
    public RedCard(Suit farbe, Rank wert){
        if(farbe == Suit.HEARTS || farbe == Suit.DIAMONDS) {
            suit = farbe;
            rank = wert;
        } else {
            throw new IllegalArgumentException("RedCard darf nur rote Karten haben.");
        }
    }
}
