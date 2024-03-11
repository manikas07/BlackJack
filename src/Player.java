// ELEFTHERIOS-MARIOS MANIKAS 4723

import java.util.Scanner;

public class Player
{
    private CasinoCustomer customer;
    private Hand hand;
    private double bet;

    public Player(CasinoCustomer customer)
    {
        this.customer = customer;
        hand = new Hand();
    }

    public Player(CasinoCustomer casinoCustomer, Hand hand, double bet)
    {
        this.customer = casinoCustomer;
        this.hand = hand;
        this.bet = bet;
    }

    public void wins()
    {
        customer.collectBet(bet);
        System.out.println("Player " + customer.getName() + " won!" + " Collects " + bet + "€");
        bet = 0;
    }

    public void winsBlackJack()
    {
        customer.collectBlackjack(bet);
        System.out.println("Blackjack! Collect " + bet * 1.5 + " €");
        bet = 0;
    }

    public void loses()
    {
        customer.payBet(bet);
        System.out.println("Player " + customer.getName() + " lost!" + " Pay " + bet + "€");
        bet = 0;
    }

    public void placeBet()
    {
        System.out.println(customer.getName() + " has " + customer.getMoney() + " left.");
        bet = 0;
        while (bet < 1)
        {
            Scanner input = new Scanner(System.in);
            System.out.println(customer.getName() + " place your bet: ");
            double myBet = input.nextDouble();
            bet = myBet;
            if (!(customer.getMoney() >= myBet && bet > 1))
            {
                bet = 0;
            }
        }
    }

    public void doubleBet()
    {
        bet = bet * 2;
    }

    public boolean wantsToDouble()
    {
        if (customer.getMoney() >= bet * 2)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Do you want to double?(yes/no) : ");
            String myDecision = input.nextLine();
            myDecision = myDecision.toLowerCase();
            return myDecision.equals("yes") || myDecision.equals("y");
        }
        return false;
    }

    public boolean wantsToSplit()
    {
        if (customer.getMoney() >= bet * 2)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Do you want to split?(yes/no) : ");
            String myDecision = input.nextLine();
            myDecision = myDecision.toLowerCase();
            return myDecision.equals("yes") || myDecision.equals("y");
        }
        return false;
    }


    public String toString()
    {
        return "Player " + customer.getName() + ": " + hand;
    }

    public void addToHand(Card card)
    {
        hand.addCard(card);
    }

    public Hand getHand()
    {
        return hand;
    }

    public CasinoCustomer getCustomer()
    {
        return customer;
    }

    public double getBet()
    {
        return bet;
    }

    public static void main(String[] args)
    {
        CasinoCustomer newCustomer = new CasinoCustomer("Lefteris",50);
        Player newPlayer = new Player(newCustomer);
        newPlayer.placeBet();
        System.out.println(newPlayer);
        newCustomer.printState();
        newPlayer.wantsToSplit();
        newPlayer.wantsToDouble();
        newPlayer.wins();
        newCustomer.printState();
        newPlayer.loses();
        newCustomer.printState();
        newPlayer.winsBlackJack();
        System.out.println( newPlayer.getHand());
    }
}
