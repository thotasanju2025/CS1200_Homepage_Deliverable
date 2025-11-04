public class Navigation 
{
  public boolean navigate(int choice)
  {
    switch(choice)
      {
        case 1: 
          System.out.println("Opening Lyric Generator..");
          System.out.println("Users can enter text, select genre, length, and language here.");
          break;
        case 2:
          System.out.println("Opening Saved lyrics...");
          System.out.println("Users can view and edit previously generated lyrics.");
          break;
        case 3:
          System.out.println("Opening Profile Page");
          system.out.println("Display users info and preference.");
          break;
        case 4:
          System.out.println("Opening Settings");
          System.out.println("Users can adjust account or app settings.");
          break;
        case 5:
          System.out.println("Logging out... Goodbye!!");
          return false;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    return true; 
  }
}
