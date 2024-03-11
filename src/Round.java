// ELEFTHERIOS-MARIOS MANIKAS 4723

import java.util.ArrayList;
import java.util.Scanner;

public class Round
{
    private Dealer dealer;
    private ArrayList <Player> currentPlayers;
    private ArrayList <Player> waitingPlayers;

    public Round(River other)
    {
        this.dealer=new Dealer(other);
        currentPlayers=new ArrayList <Player>();
        waitingPlayers= new ArrayList <Player>();
    }

    public void addPlayer(CasinoCustomer other)
    {
        Player onePlayer=new Player(other);
        currentPlayers.add(onePlayer);
    }

    public void playRound()
    {
        System.out.println("----New Round!----");
        for (Player player : currentPlayers)
        {
            player.placeBet();
        }

        for (Player player : currentPlayers)
        {
            dealer.deal(player);
        }

        System.out.println("Dealer's hand: " +dealer.draw());

        for(Player player:currentPlayers)
        {
            dealer.deal(player);
        }

        dealer.draw();

        for(Player player:currentPlayers)
        {
            System.out.println(player.getCustomer().getName()+": " + player.getHand());
        }
        System.out.println();

        if(dealer.getDealerHand().score()==21)
        {

            for(Player y : currentPlayers)
            {
                if(y.getHand().score()!=21)
                {
                    y.loses();
                }
                else
                {
                    y.wins();
                }
            }
            System.out.println("BlackJack!! Dealer wins!!! ");
        }
        if(dealer.getDealerHand().score()<21)
        {
            for(Player y : currentPlayers)
            {
                if(y.getHand().score()==21)
                {
                    y.winsBlackJack();
                }
                else
                {
                    playPlayer(y);
                }
            }
            dealer.play();
            if(dealer.getDealerHand().score()>21)
            {
                for(Player x : waitingPlayers)
                {
                    x.wins();
                }
            }
            for(Player x : waitingPlayers)
            {
                dealer.settle(x);
            }
        }
    }

    private void playNormalHand(Player other)
    {
        boolean help = true;
        System.out.println ("Player "+other.getCustomer().getName() + " : "+other.getHand());
        while(help)
        {
            Scanner input = new Scanner(System.in);
            System.out.println();
            if (other.getHand().score() < 21)
            {
                System.out.println("Hit? ");
                String answer = input.nextLine();
                if (answer.equals("no"))
                {
                    help = false;
                } else if (answer.equals("yes"))
                {
                    dealer.deal(other);
                    System.out.println(other.getCustomer().getName() + ": " + other.getHand());
                }
                else
                {
                    System.exit(-1);
                }
           }
            else
                {
                    help = false;
                }

        }
        if(other.getHand().score()>21)
        {
            other.loses();
        }
        else
        {
            waitingPlayers.add(other);
        }
    }

    private void playDoubleHand(Player other)
    {
        other.doubleBet();
        dealer.deal(other);
        System.out.println(other.getCustomer().getName()+": "+other.getHand());
        if(other.getHand().score()>21)
        {
            other.loses();
        }else
            {
                waitingPlayers.add(other);
            }

    }

    private void playSplitHand(Player other)
    {

        Hand[] doubleHand= other.getHand().split();
        Player firstHand=new Player(other.getCustomer(),doubleHand[0],other.getBet());
        Player secondHand=new Player(other.getCustomer(),doubleHand[1],other.getBet());
        playNormalHand(firstHand);
        playNormalHand(secondHand);
    }

    private void playPlayer(Player other)
    {
        if(other.getHand().canSplit())
        {
            if(other.wantsToSplit())
            {
                playSplitHand(other);
            }
        }else
            {
                if(other.wantsToDouble())
                {
                    playDoubleHand(other);
                }
                else
                {
                    playNormalHand(other);
                }
            }
    }
    public ArrayList getCurrentPlayers()
    {
        return currentPlayers;
    }

    public static void main(String[] args)
    {
        River river = new River(6);
        Round newRound= new Round(river);
        CasinoCustomer me = new CasinoCustomer("Lefteris",100);
        newRound.addPlayer(me);
        newRound.playRound();
    }
}
