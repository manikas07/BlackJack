// ELEFTHERIOS-MARIOS MANIKAS 4723

public class Dealer
{
    private Hand dealerHand;
    private River river;

    public Dealer(River river)
    {
        this.river = river;
        dealerHand = new Hand();
    }

    public Card draw()
    {
        Card card = river.nextCard();
        dealerHand.addCard(card);
        return card;
    }

    public void deal(Player player)
    {
        player.addToHand(river.nextCard());
        player.getHand();

    }

    public void play()
    {
        while (dealerHand.score() < 17)
        {
            dealerHand.addCard(river.nextCard());
        }
    }

    public void settle(Player player)
    {
        if(dealerHand.score()<21)
        {
            if (dealerHand.score() > player.getHand().score())
            {
                player.loses();
            }

            else if(dealerHand.score() < player.getHand().score())
            {
                player.wins();
            }

            else
            {
                System.out.println("Tie with "+player.getCustomer().getName()+".Nobody wins");
            }
        }
    }

    public String toString()
    {
        return "Dealer: " + dealerHand;
    }

    public Hand getDealerHand()
            
    {
        return dealerHand;
    }


    public static void main(String[] args)
    {
        River newCard=new River(1);
        Dealer dealer = new Dealer(newCard);
        dealer.play();
        System.out.println(dealer);
        CasinoCustomer testCustomer=new CasinoCustomer("Manikas",100);
        Player testPlayer=new Player(testCustomer);
        dealer.deal(testPlayer);
        dealer.deal(testPlayer);
        dealer.settle(testPlayer);
        testCustomer.printState();
    }
}
