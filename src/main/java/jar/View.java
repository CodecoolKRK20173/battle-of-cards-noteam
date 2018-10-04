package jar;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import jar.player.Player;

import java.io.FileNotFoundException;
import java.io.File;

public class View 
{

    public static String getPlayerNick()
    {
        //String userNick;
        Scanner nick = new Scanner(System.in);
        System.out.println("Please enter your nick: \n ");
        String userNick = nick.nextLine();
        //nick.close();
        return userNick;
    }

    public static String chooseCardStat()
    {
        List <String> statisctics = Arrays.asList("strenght","toughness","magic","speed");
        while (true)
        {
            Scanner stat = new Scanner(System.in);

            System.out.println("Choose statisctic to fight:  strenght / toughness / magic / speed\n");
            String fightstat = stat.nextLine();

            if (statisctics.contains(fightstat))
            {
                return fightstat;
            }

            else
            {
                System.out.println("There is no statistic like this. Please enter corect statistic!");
            }
        }
    }

    public static int getNumberOfPlayers ()
    {
        while (true)
        {
            int maxAmountOfPlayers = 4;
            Scanner nr = new Scanner(System.in);

            System.out.println("Please enter amount of players (max 4): \n");
            int playersAmount = nr.nextInt();

            if (playersAmount <= maxAmountOfPlayers)
            {
                return playersAmount;
            }

            else
            {
                System.out.println("To many players. There could be max 4 players!");
            }

        }
    }

    public void menuScreen()
    {
        System.out.println("\033\143");

        try
        {
            Scanner file = new Scanner(new File("ASCII/GameMenu.txt"));

            while (file.hasNextLine())
            {
                System.out.println(file.nextLine());
            }
            file.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

    }

    public int getOptionFromUser()
    {
        Scanner opt = new Scanner(System.in);

        System.out.println("Option: ");
        int option = opt.nextInt();
        return option;
    }

    public static int getNumberOfCards()
    {
        int maxNrOfCardOnHand = 20;
        Scanner cardNr = new Scanner(System.in);

        while (true)
        {
            System.out.println("Give amount of cards on hand (max number is 20):\n");
            int cardNrOnHand = cardNr.nextInt();
            if (cardNrOnHand < maxNrOfCardOnHand)
            {
                return cardNrOnHand;
            }
            else
            {
                System.out.println("To many cards!");
            }
                
        }
    }

    public static void printWinners(List<Player> winners) {
        System.out.println("Winner: ");
        for(int i = 0; i < winners.size(); ++i) {
            System.out.println(winners.get(i).getName());
        }
    }



}