// ELEFTHERIOS-MARIOS MANIKAS 4723

public class Card
{
    private String card;
    private int value;

    public Card(String card)
    {
        this.card = card;
        this.value = 0;
    }

    public int getValue()
    {
        if (card.equals("A"))
        {
            value = 1;
        }
        else if (card.equals("J") || card.equals("Q") || card.equals("K"))
        {
            value = 10;
        }
        else
        {
            value = Integer.parseInt(card);
        }
        return value;
    }

    public boolean isAce()
    {
        return card.equals("A");
    }

    public boolean equals(Card other)
    {
        return this.card.equals(other.card);
    }

    public String toString()
    {
        return card;
    }

    public String getCardValue()
    {
        return card;
    }

    public static void main(String[] args)
    {
        Card c = new Card("A");
        Card d = new Card("K");
        System.out.println(c.toString() +" "+ d.toString());
        System.out.println(c.isAce());
        System.out.println(c.getValue());
        System.out.println(c.equals(d));
        System.out.println(d);
    }
}
