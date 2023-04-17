import java.util.Random;
public class Deck {
    public static Card[] creationsOfDeckOfCards() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
        String[] color = {"Red", "Black"};
        Card[] deck = new Card[52];
        int cardNum = 0;
        String temp = "";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if(i == 2 || i == 0){
                    temp = color[0];
                } else {
                    temp = color[1];
                }
                deck[cardNum] = new Card(ranks[j], suits[i], temp);
                cardNum++;
            }
        }
        return deck;
    }
    public static void traverse(Card[] deck){
        for(Card card: deck){
            System.out.println("Rank: " + card.getRank() + ", Suit: " + card.getSuit() + ", Color: " + card.getColor());
        }

    }
    public static Card[] shuffle(Card[] deck){
        Random random = new Random();

        for(int i = 0; i < 52; i++){
            int randomIndex = random.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
        return deck;


    }




}
