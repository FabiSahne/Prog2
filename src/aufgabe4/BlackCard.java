package aufgabe4;

import java.util.Random;

public class BlackCard extends Card{

    public BlackCard(){
        Random r = new Random();
        suit = Suit.values()[r.nextInt(2) + 2];
        rank = Rank.values()[r.nextInt(8)];
    }
    public BlackCard(Suit farbe, Rank wert){
        if(farbe == Suit.SPADES || farbe == Suit.CLUBS) {
            suit = farbe;
            rank = wert;
        } else {
            throw new IllegalArgumentException("BlackCard darf nur schwaze Karten haben.");
        }
    }
}
