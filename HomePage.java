import java.util.Scanner;

public class HomePage
  {
    public static void main(String[] args)
    {
      System.out.println("Welcome to Rythmix - an AI lyrics Generator");

      boolean running = true;
      while(running)
        {
          System.out.println("Please choose an option: ");
          System.out.println("1. Generate New Lyrics");
          System.out.println("2. View Saved Lyrics");
          System.out.println("3. Profile Page");
          System.out.println("4. Settings");
          System.out.println("5. Logout");
          System.out.pring("Enter your choice(1-5): ");

          int choice = sc.nextInt();
          running = nav.navigation(choice);
        }
      sc.close();
    }
  }
