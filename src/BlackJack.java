// ELEFTHERIOS-MARIOS MANIKAS 4723

import java.util.Scanner;

public class BlackJack
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Give the number of players: ");
        int numberOfPlayers=input.nextInt();
        BlackjackTable newTable = new BlackjackTable(numberOfPlayers);
        newTable.play();
    }
}
