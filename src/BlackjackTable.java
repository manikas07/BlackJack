// ELEFTHERIOS-MARIOS MANIKAS 4723

import java.util.Scanner;

public class BlackjackTable
{
    private River river;
    private CasinoCustomer[] allTheCustomers;
    private int numberOfPlayers;

    public BlackjackTable(int numberOfPlayers)
    {
        river = new River(6);
        this.numberOfPlayers=numberOfPlayers;
        allTheCustomers=new CasinoCustomer[numberOfPlayers];
        for(int i = 0; i<numberOfPlayers;i++)
        {
            allTheCustomers[i] = createCasinoCustomer();
        }
    }

    private CasinoCustomer createCasinoCustomer()
    {
        Scanner input =new Scanner(System.in);
        System.out.println("Give customer name and available money:");
        String name= input.next();
        double  money = input.nextInt();
        CasinoCustomer player = new CasinoCustomer(name,money);
        return player;
    }

    public void play()
    {
        while(numberOfPlayers!=0)
        {
            Round round = new Round(river);
            for(CasinoCustomer casinoCustomer : allTheCustomers)
            {
                if(!casinoCustomer.isBroke())
                {
                    round.addPlayer(casinoCustomer);
                }
                else
                {
                    numberOfPlayers = numberOfPlayers - 1;
                }
            }
            if(numberOfPlayers==0)
            {
                break;


            }
            if(river.shouldRestart())
            {
                river.restart();
            }
            round.playRound();
        }
    }
}
