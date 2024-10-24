// Created by Anthony Rocci, Andres Garcia, Caleb Garcia, Ping-Hsuan Tseng
// Group #1
// CPSC-39 

import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    //Declare Arrays & Index
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int[] DECK = new int[52];
    private static int currentCardIndex = 0;
    private static int cash = 100;
    private static int bet = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        initializeDeck(); //Create & Shuffle Deck
        shuffleDeck();
        bet = placeBet();
        
        int playerTotal = dealInitialPlayerCards(); //Deal initial hands
        int dealerTotal = dealInitialDealerCards();

        playerTotal = playerTurn(scanner, playerTotal); //Checks if player busted
        if (playerTotal > 21) {
            System.out.println("You busted! Dealer wins.");
            return;
        }

        dealerTotal = dealerTurn(dealerTotal); //Checks if dealer busted
        determineWinner(playerTotal, dealerTotal);

        scanner.close();
    }

    private static int placeBet() {    //Asks how much you want to bet
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have $" + cash + ". How much would you like to bet?");
        int bet = scanner.nextInt();
        if (bet > cash) {
            System.out.println("You don't have enough money to place that bet.");
            scanner.close();
            return placeBet();  
        }
        cash -= bet;
        System.out.println("You placed a bet of $" + bet + ".");
        scanner.close();
        return bet;  
    }

    // Initializes the deck with 52 cards
    private static void initializeDeck() {
        for (int i = 0; i < DECK.length; i++) {
            DECK[i] = i;
        }
    }

    // Shuffles the deck
    private static void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < DECK.length; i++) {
            int index = random.nextInt(DECK.length);
            int temp = DECK[i];
            DECK[i] = DECK[index];
            DECK[index] = temp;
        }
    }
// Deals Players Inital Cards
    private static int dealInitialPlayerCards() {
        int card1 = dealCard();
        int card2 = dealCard();
        System.out.println("Your cards: " + RANKS[card1] + " of " + SUITS[card1 / 13] + " and " + RANKS[card2] + " of " + SUITS[card2 / 13]);
        return cardValue(card1) + cardValue(card2);
    }
// Deals Dealers Inital Cards
    private static int dealInitialDealerCards() {
        int card1 = dealCard();
        System.out.println("Dealer's card: " + RANKS[card1] + " of " + SUITS[card1 / 13]);
        return cardValue(card1);
    }
// Deals Cards tells player their total and gives them the option to hit or stand
    private static int playerTurn(Scanner scanner, int playerTotal) {
        while (true) {
            System.out.println("Your total is " + playerTotal + ". Do you want to hit or stand?");
            //logic for hit or stand and dealing cards based on choice
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("hit")) {
                int newCard = dealCard();
                playerTotal += cardValue(newCard);
                System.out.println("You drew a " + RANKS[newCard] + " of " + SUITS[newCard / 13]);
                if (playerTotal > 21) {
                    break;
                }
            } else if (action.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid action. Please type 'hit' or 'stand'.");
            }
        }
        return playerTotal;
    }
    
    private static int dealerTurn(int dealerTotal) {
        while (dealerTotal < 17) {
            int newCard = dealCard();
            dealerTotal += cardValue(newCard);
        }
        System.out.println("Dealer's total is " + dealerTotal);
        return dealerTotal;
    }
// Determines Winner and calculates winnings or los
    private static void determineWinner(int playerTotal, int dealerTotal) {
        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            cash += 2 * bet;
            System.out.println("You win! Now you have $" + cash + ".");
        } else if (dealerTotal == playerTotal) {
            cash = bet + cash;
            System.out.println("It's a tie! You still have $" + cash + "."); 
        } else {
            cash = bet - cash;
            System.out.println("Dealer wins! You lost $" + bet + ". Now you have $" + cash + ".");
            
        }
    }

    private static int dealCard() {
        return DECK[currentCardIndex++] % 13;
    }

    private static int cardValue(int card) {
        return card < 9 ? card + 2 : 10;
    }
}
