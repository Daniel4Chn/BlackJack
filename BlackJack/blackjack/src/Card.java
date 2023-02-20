public class Card {
    private final String rank;
    private final String suit;
    private final String color;
    public Card(String rank, String suit, String color){
        this.rank = rank;
        this.suit = suit;
        this.color = color;
    }
    public String getRank(){
        if(this.rank.equals("Queen") || this.rank.equals("King") || this.rank.equals("Jack")){
            return "10";
        } else if(this.rank.equals("Ace")){
            if(Setup.value + 11 > 21){
                return "1";
            } else{
                return "11";
            }

        }
        return rank;
    }
    public String getSuit(){
        return suit;
    }
    public String getColor(){
        return color;
    }
    public String toString(){
        return "The Suit of This Card is " + this.suit + " and the rank is " + this.rank + " and the color of this card is " + this.color + " .";
    }

}
