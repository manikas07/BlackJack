// ELEFTHERIOS-MARIOS MANIKAS 4723

public class CasinoCustomer
{
    private String name;
    private double money;

    public CasinoCustomer(String name, double money)
    {
        this.name = name;
        this.money = money;
    }

    public void payBet(double bet)
    {
        money = money - bet;
    }

    public void collectBet(double bet)
    {
        money = money + bet;
    }

    public void collectBlackjack(double bet)
    {
        money = money + (bet * 1.5);
    }

    public boolean canCover(double bet)
    {
        return bet <= money;
    }

    public boolean isBroke()
    {
        return money < 1;
    }

    public String toString()
    {
        return "Player's name: " + name;
    }

    public void printState()
    {
        System.out.println(name + " has " + money + " left.");
    }

    public String getName()
    {
        return name;
    }

    public double getMoney()
    {
        return money;
    }
    public void setMoney(double newMoney)
    {
        money = money + newMoney;
    }

    public static void main(String[] args)
    {
        CasinoCustomer casinoCustomer= new CasinoCustomer("Lefteris",100);
        casinoCustomer.payBet(80);
        casinoCustomer.collectBet(40);
        System.out.println("Can player cover the bet ? " + casinoCustomer.canCover(50));
        System.out.println(casinoCustomer);
        casinoCustomer.printState();
        casinoCustomer.payBet(40);
        System.out.println("Is player broke? " + casinoCustomer.isBroke());
    }
}
