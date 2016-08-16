/**
  * Make program in Spanish one day...
  */

import java.util.Scanner;

public class PAExec
{
    private static PAServerAccess tehmanefraem = new PAServerAccess();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        int selection;

        do
        {


            System.out.println("Welcome to PA.pgh. What would you like to do?");
            System.out.println("1. Request Server Time");
            System.out.println("2. Request Route Information");
            System.out.println("3. Request Vehicles");
            System.out.println("4. Request Predictions");
            System.out.println("5. Quit");

            selection = input.nextInt();

            if (selection < 1 || selection > 5) {
                System.out.println("You have entered an invalid selection. Please enter a number between 1 and 5.");

                selection = input.nextInt();
            }

            menuSelect(selection);
        } while (selection != 5);
    }

    private static void menuSelect(int select) throws Exception
    {
        int selection = select;

        switch (selection)
        {
            case 1:
                tehmanefraem.getServerTime();
                break;
            case 2:
                tehmanefraem.getRouteInformation();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
        }
    }
}
