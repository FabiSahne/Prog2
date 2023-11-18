package aufgabe4;

public abstract class Card {


    protected Suit suit;
    protected Rank rank;

    public enum Suit{
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
    }

    public enum Rank{
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }


    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return this.suit == card.suit && this.rank == card.rank;
    }
    
    public String toString(){
        return rank + " of " + suit;
    }

}
