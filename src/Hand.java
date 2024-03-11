// ELEFTHERIOS-MARIOS MANIKAS 4723

import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> myHand;
    private int score;

    public Hand()
    {
        this.score = 0;
        this.myHand = new ArrayList<>();
    }

    public void addCard(Card card)
    {
        myHand.add(card);
    }

    public int score()
    {
        score = 0;
        for (Card card : myHand)
        {
            score = score + card.getValue();
        }
        for (Card card : myHand)
        {
            String cardValue = card.getCardValue();
            if (cardValue.equals("A"))
            {
                if (score <= 11)
                {
                    score = score + 10;
                }
            }
        }
        return score;
    }

    public boolean canSplit()
    {
        return myHand.get(0).equals(myHand.get(1));
    }

    public Hand[] split()
    {
        Hand[] myDoubleHand=new Hand[2];
        myDoubleHand[0]=new Hand();
        myDoubleHand[1]=new Hand();
        myDoubleHand[0].addCard(myHand.get(0));
        myDoubleHand[1].addCard(myHand.get(0));
        return myDoubleHand;
    }

    public boolean isBlackjack()
    {
        return myHand.size() == 2 && score == 21;
    }

    public boolean isBust()
    {
        return score > 21;
    }

    public String toString()
    {
        StringBuilder val = new StringBuilder();
        for (Card z : myHand)
        {
            val.append(z).append(" ");
        }
        return val.toString();
    }

    public static void main(String[] args)
    {
        Card firstCard = new Card("A");
        Card secondCard = new Card("A");
        Hand hand= new Hand();
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        System.out.println(hand.canSplit());
        System.out.println("My hand: "+hand);
        System.out.println("My hand score: "+hand.score());
        Card third=new Card("K");
        Hand[] myDoubleHand = hand.split();
        myDoubleHand[0].addCard(third);
        for(int i=0; i<myDoubleHand.length;i++)
        {
            System.out.println(myDoubleHand[i]);
        }
        System.out.println(myDoubleHand[0].score());
        System.out.println(myDoubleHand[0].isBlackjack());
        Card fourth=new Card("A");
        myDoubleHand[0].addCard(fourth);
        System.out.println(myDoubleHand[0]);
        System.out.println(myDoubleHand[0].score());
        Card fifth = new Card("10");
        myDoubleHand[0].addCard(fifth);
        System.out.println(myDoubleHand[0]);
        System.out.println(myDoubleHand[0].score());
        System.out.println(myDoubleHand[0].isBust());
    }
}
