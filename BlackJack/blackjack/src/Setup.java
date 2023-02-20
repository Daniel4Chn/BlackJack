import java.util.Scanner;
public class Setup {
    public static int value = 0;
    public static int value2 = 0;
    public static double money = 1000;

    public static void main(String[] args) {
        //Beginning of the BlackJack Game
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Hello " + name + " . How old are you? (Enter an Integer ex. \"18\", \"13\")");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old");
        if (age < 18) {
            System.out.println("You are too young to play this game");
            System.exit(0);
        } else {
            System.out.println("Welcome to Online Blackjack");

        }
        int status = 0;

        System.out.println("Type \" 1 \" to continue or Type \" 2 \" to end the program");
        while (status != 1 || status != 2) {
            status = scanner.nextInt();

            if (status == 2) {
                System.exit(0);
            }
            if (status == 1) {
                break;
            }
        }
        Player newPlayer = new Player(name, age, 1000);

        System.out.println("I'm glad you decided to continue with the game.");
        System.out.println("Press \" R \" if you need a refresher on how BlackJack works; type anything else if you don't");
        String status2 = "";
        status2 = scanner.next();
        String status3 = "";
        if (status2.equals("R")) {
            rules();
            System.out.println("Type \" B\" if you need a refresher on each card's value");
            status3 = scanner.next();
            if (status3.equals("B")) {
                cardValue();
            }

        } else {
            System.out.println("Type \" B\" if you need a refresher on each card's value");
            status2 = scanner.next();
            if (status2.equals("B")
            ) {
                cardValue();
            }

        }

        while (money > 0) {
            value = 0;
            Card[] deck = Deck.creationsOfDeckOfCards();
            for(int k = 0; k<20; k++){
                Deck.shuffle(deck);
            }

            System.out.println("You will start off with " + money);


            double bettingAmount = 0;
            boolean forWhile = true;
            while (forWhile) {
                System.out.println("Dealer: Welcome! Type in the amount you want to bet. (Has to be an amount greater than 0 and less than the money you have)");
                bettingAmount = scanner.nextDouble();
                if (bettingAmount > money) {
                    forWhile = true;
                } else {
                    forWhile = false;
                }
            }


            money -= bettingAmount;
            boolean NoWinner = true;
            String trueWinner = "";
            String hitOrStand = "";


            Scanner scanner2 = new Scanner(System.in);
            while (NoWinner) {
                int cardsValue2 = 0;
                int deckCounter = 0;
                int cardsValue = 0;
                for(int i = deckCounter; i < deckCounter+2; i++){
                    cardsValue += Integer.parseInt(deck[i].getRank());
                    value += Integer.parseInt(deck[i].getRank());
                    System.out.println("Card drawn is a " + deck[i].toString());
                }
                System.out.println(cardsValue + " is the total value of the cards you drew");
                deckCounter += 2;
                System.out.println("Hit or stand?");
                hitOrStand = scanner2.next();
                if(hitOrStand.equals("Hit") || hitOrStand.equals("hit")) {
                    for (int i = deckCounter; i < deckCounter + 1; i++) {
                        cardsValue += Integer.parseInt(deck[i].getRank());
                        value += Integer.parseInt(deck[i].getRank());
                        System.out.println("Card drawn is a " + deck[i].toString());
                    }
                    deckCounter++;
                    System.out.println(cardsValue + " is the total value of the cards you drew");
                    if (cardsValue > 21) {
                        NoWinner = false;
                        trueWinner = "Computer";
                        System.out.println("YOU BUSTED, You Lost.");
                        winner();
                        break;

                    } else if (cardsValue == 21) {
                        NoWinner = false;
                        trueWinner = "Player";
                        winner2();
                        break;
                    } else if (cardsValue < 21) {
                        System.out.println("Hit or stand?");
                        hitOrStand = scanner2.next();
                        while ((hitOrStand.equals("Hit") || hitOrStand.equals("hit"))) {
                            for (int i = deckCounter; i < deckCounter + 1; i++) {
                                cardsValue += Integer.parseInt(deck[i].getRank());
                                value += Integer.parseInt(deck[i].getRank());
                                System.out.println("Card drawn is a " + deck[i].toString());
                            }
                            deckCounter++;
                            System.out.println(cardsValue + " is the total value of the cards you drew");
                            if (cardsValue > 21) {
                                System.out.println("YOU BUSTED, You Lost.");
                                NoWinner = false;
                                trueWinner = "Computer";
                                break;

                            } else if (cardsValue == 21) {
                                System.out.println("YOU WIN!");
                                NoWinner = false;
                                trueWinner = "Player";
                                break;
                            } else{
                                System.out.println("Hit or stand?");
                                hitOrStand = scanner2.next();
                                if(hitOrStand.equals("stand") || hitOrStand.equals("Stand")){
                                    break;
                                }
                            }



                        }


                    }

                }
                    System.out.println("The card value of the player is " + cardsValue);


                for(int i = deckCounter; i < deckCounter+2; i++){
                    cardsValue2 += Integer.parseInt(deck[i].getRank());
                    value += Integer.parseInt(deck[i].getRank());
                    System.out.println("Dealer Card drawn is a " + deck[i].toString());
                }
                deckCounter += 2;
                if(value2 > 17 || cardsValue2 > 17){
                    System.out.println("Dealer stands at value2");
                } else if(value2 < 17 || cardsValue2 < 17){
                    while(value2 < 17 || cardsValue2 < 17){
                        for (int i = deckCounter; i < deckCounter + 1; i++) {
                            cardsValue2 += Integer.parseInt(deck[i].getRank());
                            value2 += Integer.parseInt(deck[i].getRank());
                            System.out.println("Card drawn is a " + deck[i].toString());
                        }
                        deckCounter++;
                        if(value2 > 21){
                            System.out.println("YOU WIN!");
                            NoWinner = false;
                            trueWinner = "Player";
                            money += bettingAmount *2;
                            break;
                    } else if(value2 == 21){
                            System.out.println("YOU LOSE!");
                            NoWinner = false;
                            trueWinner = "Dealer";
                            break;
                        }

                    }
                    }
                if(cardsValue > cardsValue2){
                    System.out.println("YOU WIN!");
                    NoWinner = false;
                    trueWinner = "Player";
                    money += bettingAmount *2;
                    break;
                } else if(cardsValue < cardsValue2){
                    System.out.println("YOU LOSE!");
                    NoWinner = false;
                    trueWinner = "Dealer";

                    break;
                } else{
                    System.out.println("YOU TIE");
                    NoWinner = false;
                    money += bettingAmount;
                    break;
                }

            }






        }
        if(money <= 0){
            System.out.println("Sorry! Better luck next time");
        }
    }
        public static void rules () {
            System.out.println("The rules of Blackjack are pretty simple");
            System.out.println("You type in an amount of money you are willing to gamble (You start off with $1,000)");
            System.out.println("After, you and the dealer will each draw two cards. The goal of the game is to get to 21 in terms of card value-in which you win.");

            System.out.println("There is a deck of cards (Don't worry, it is shuffled well to ensure fair gameplay) and you and the dealer (the person you compete against) each draw 2 cards at the start of the game");
            System.out.println("Unless your two cards add up to 21,-each card's value will be shown after the rules are listed out-you will be prompted to either stand or hit");
            System.out.println("If you stand, you wait until the dealer decides to stand or hit");
            System.out.println("Whoever gets 21 first or whoever get the closest to 21 will win the game. So if the dealer wins, he will be able to take all of the money you bet. If you win, you get to double the money you bet");
            System.out.println("If you \" bust \" , meaning you went over 21 in terms of card value, you automatically lose the game. The same applies to the dealer");

        }
        public static void cardValue () {
            System.out.println("A card that is a number card (2,3,4,7,8,etc.) has a card value of that number");
            System.out.println("A card that is a face card (Jack, Queen, King) has a card value of 10");
            System.out.println("A card that is an Ace has a value of either 1 or 11.");
        }
        public static int value () {
            return value;
        }
        public static void winner(){
        System.out.println("Dealer won!");
        }
        public static void winner2(){
        System.out.println("Player won!");
        }

    }

