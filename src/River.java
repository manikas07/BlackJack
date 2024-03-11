// ELEFTHERIOS-MARIOS MANIKAS 4723

import java.util.Random;

public class River
{
    private Card[] packOfCards;
    private int cardsLeft;
    private int numberOfCards;

    public River(int packOfCards)
    {
        String[] playingCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int myCards = packOfCards * 52;
        cardsLeft = myCards;
        numberOfCards = myCards;
        this.packOfCards = new Card[myCards];
        int index = 0;
        for (int m = 0; m < packOfCards; m++)
        {
            for (int i = 0; i < 4; i++)
            {
                for (String playingCard : playingCards)
                {
                    this.packOfCards[index] = new Card(playingCard);
                    index = index + 1;
                }
            }
        }
    }

    public Card nextCard()
    {

        if (cardsLeft > 0)
        {
            Random RCard = new Random();
            int result = RCard.nextInt(cardsLeft);
            Card help;
            help = packOfCards[result];
            packOfCards[result] = packOfCards[cardsLeft - 1];
            packOfCards[cardsLeft - 1] = help;
            cardsLeft = cardsLeft - 1;
            return help;
        }
        return null;
    }

    public boolean shouldRestart()
    {
        return cardsLeft == numberOfCards / 4;
    }

    public void restart()
    {
        this.cardsLeft = numberOfCards;
    }

   public static void main(String[] args)
    {
        River c = new River(1);
        while(!c.shouldRestart())
        {
            System.out.println(c.nextCard());
        }

        c.restart();
        while(c.cardsLeft>=0)
        {
            System.out.println(c.nextCard());
            if(c.cardsLeft==0)
            {
                System.out.println(c.nextCard());
                break;
            }
        }
   }
}