package jar;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import jar.player.Player;

import java.io.FileNotFoundException;
import java.io.File;

import jar.controllers.PlayerController;
import jar.controllers.TableController;
import jar.model.Table;

public class View 
{

    public static String getPlayerNick()
    {
        Scanner nick = new Scanner(System.in);
        System.out.println("Please enter your nick: \n ");
        if (nick.hasNextLine()) {
            return nick.nextLine();
        }

        return "";
    }

    public static String chooseCardStat()
    {
        List <String> statisctics = Arrays.asList("strength","toughness","magic","speed");
        Scanner stat = new Scanner(System.in);
        while (true)
        {
            
            System.out.println("Choose statisctic to fight:  strength / toughness / magic / speed\n");
            String fightstat = stat.nextLine();

            if (statisctics.contains(fightstat))
            {
                return fightstat;
            }

            else
            {
                System.out.println("There is no statistic like this. Please enter correct statistic!");
            }
        }
    }

    public static int getNumberOfPlayers ()
    {
        Scanner nr = new Scanner(System.in);
        int maxAmountOfPlayers = 4;
        int playersAmount = -1;

        while (true)
        {
            
            System.out.println("Please enter amount of players (max 4): \n");
            if (nr.hasNextInt()) {
                playersAmount = nr.nextInt();
            } else {
                nr.nextLine();
            }

            if (playersAmount <= maxAmountOfPlayers)
            {
                return playersAmount;
            }

            else if (playersAmount == -1) {
                System.out.println("Wrong amount of players.");
            } else
            {
                System.out.println("Top many players. There could be max 4 players!");
            }

        }
    }

    public void menuScreen()
    {
        clearScreen();

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


    public static void entryScreen()
    {
        clearScreen();

        try
        {
            Scanner file = new Scanner (new File("jar/ASCII/logo.txt"));

            while (file.hasNextLine())
            {
                System.out.println(file.nextLine());
            }
            file.close();
        }

        catch (FileNotFoundException e) 
        {
            System.out.println("File not found!");
        }

        sleep();
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getOptionFromUser()
    {
        Scanner opt = new Scanner(System.in);

        System.out.println("Option: ");
        int option = opt.nextInt();
        opt.close();
        return option;
    }

    public static int getNumberOfCards()
    {
        int maxNrOfCardOnHand = 20;
        Scanner cardNr = new Scanner(System.in);
        int cardNrOnHand = 0;

        while (true)
        {
            System.out.println("Give amount of cards on hand (max number is 20):\n");
            if (cardNr.hasNextInt()) {
                cardNrOnHand = cardNr.nextInt();
            } else {
                cardNr.nextLine();
            }
            if (cardNrOnHand < maxNrOfCardOnHand && cardNrOnHand > 0)
            {
                return cardNrOnHand;
            }
            else
            {
                System.out.println("Wrong number of cards!");
            }
                
        }
    }

    public static void printWinners(List<Player> winners) {
        System.out.println("Winner: ");
        for(int i = 0; i < winners.size(); ++i) {
            System.out.println(winners.get(i).getName());
        }
    }

    public static String printCard(String title, String stat1, String stat2, String stat3, String stat4)
    {
        String name = String.format(" Name: %s", title) ;
        String statStrenth = String.format(" Strength: %s", stat1);
        String statToughness = String.format(" Toughness: %s", stat2);
        String statMagic = String.format(" Magic: %s", stat3);
        String statSpeed = String.format(" Speed: %s", stat4);

        String cardprint = " " + (repeat('_', 27)) + "\n";
        cardprint += "| " + name + repeat(' ', 26 -name.length()) + "|" + "\n";
        cardprint += "| " + statStrenth + repeat(' ', 26 - statStrenth.length()) + "|" + "\n";
        cardprint += "| " + statToughness + repeat(' ', 26 - statToughness.length()) + "|" + "\n";
        cardprint += "| " + statMagic + repeat(' ', 26 - statMagic.length()) + "|" + "\n";
        cardprint += "| " + statSpeed + repeat(' ', 26 - statSpeed.length()) + "|" + "\n";
        cardprint += "|" + (repeat('_', 27)) + "|\n";

        return cardprint;
    }

    private static String repeat(char c, int n) {
        String temp = "";
        for(int i = 0; i < n; ++i) {
            temp += c;
        }

        return temp;
    }

    public static void clearScreen() {
        System.out.println("\033\143");
    }

    public static void printTable(PlayerController playerController, TableController tableController) {
        int playerNumber = 4;
        for(int i = 0; i < playerNumber; ++i) {
            System.out.println(playerController.getPlayerList().get(i).getName() + ":");
            System.out.println("Amount of cards: " + playerController.getPlayerList().get(i).getHand().getDeckSize());
            System.out.println(tableController.getTable().getCardsOnTable().get(i));
        }
    }
}