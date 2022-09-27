package bo;

import java.util.Scanner;

public class Process {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    Scanner scanner = new Scanner(System.in);
    boolean quit = false;

    public void processStart() {
        Todolist mylist = new Todolist();
        while (quit == false) {
            System.out.print(
                    "- If you want to create a new Event, please type C,\n- If you want to delete an Event, plase type D, \n- If you want to see the available Events, please type A, \n- If you desire to quit the program, type Q.\n");
            String optionchoice = scanner.nextLine();
            optionchoice = optionchoice.toLowerCase();

            switch(optionchoice) {

            case "c":
                System.out.println(
                            "You chose to create a new event.\n\n- You will need a title as well as a description.");
                System.out.print("Please choose your event title :");
                String taskOriginalTitle = scanner.nextLine();
                System.out.print("Please choose your description :");
                String taskOriginalDescription = scanner.nextLine();
                Event event = new Event(taskOriginalTitle, taskOriginalDescription);
                mylist.addEvent(event);
                System.out.println("The event has been created succesfully !\n");
                break;
            case "d":
                if (mylist.getSize() == 0) {
                    System.out.println("You don't have any Events to delete. Please add Events in the first place.\n");
                    break;
                }
                mylist.arrayPrint();
                System.out.println(
                        "Please pick the number of the Event you want to delete. Note that if you want to delete none, you can type 0.");
                String deleteString = scanner.nextLine();
                int deleteNumber = Integer.parseInt(deleteString);
                if (deleteNumber == 0) {
                    System.out.println("You chose to delete nothing.");
                    break;
                } 
                if (deleteNumber > mylist.getSize() || deleteNumber < 0) {
                    System.out.println("The event you chose to delete doesn't exist");
                    break;
                }
                mylist.removeEvent(deleteNumber - 1);
                System.out.println("The event N°" + deleteNumber + " has been deleted succesfully.");
                break;
            case "a":
                if (mylist.getSize() == 0) {
                    System.out.println("You don't have any Events to access. Please add Events in the first place.\n");
                    break;
                }
                mylist.arrayPrint();
                System.out.println(
                        "Please pick the number of the Event you want to access, Note that if you want to access none, you can type 0.");
                String accessString = scanner.nextLine();
                int accessNumber = Integer.parseInt(accessString);
                if (accessNumber == 0) {
                    System.out.println("\nYou chose to access nothing.");
                    break;
                }
                if (accessNumber > mylist.getSize() || accessNumber < 0) {
                    System.out.println("You chose an impossible index");
                    break;
                }
                System.out.println("\nHere is the event you wanted :");
                mylist.eventPrint(accessNumber - 1);
                String pickedEvent;
                do {
                    System.out.println(
                            "\n- If you want to change it's Title and Description, please type C,\n- If you want to change it's state, please type S,\n- If you want to see the update history, please type H,\n- If you want to quit, please type Q");
                    pickedEvent = scanner.nextLine();
                    pickedEvent = pickedEvent.toLowerCase();
                } while (!(pickedEvent.equals("c")) && !(pickedEvent.equals("s")) && !(pickedEvent.equals("h"))
                        && !(pickedEvent.equals("q")));
                switch(pickedEvent) {
                    case "c":
                        System.out.print("Please choose your event title :");
                        String taskModifiedTitle = scanner.nextLine();
                        System.out.print("Please choose your description :");
                        String taskModifiedDescription = scanner.nextLine();
                        mylist.getEvent(accessNumber - 1).changeEvent(taskModifiedTitle, taskModifiedDescription);
                        System.out.println("The Event has been updated succesfully !\n");
                        break;
                    case "s":
                        mylist.getEvent(accessNumber - 1).stateChanger();
                        System.out.println("The state have been changed succesfully !\n");
                        break;
                    case "q":
                        System.out.println("You chose to quit.\n");
                        break;
                    case "h":
                        System.out.println("\nHere is the history of you Event :");
                        mylist.getEvent(accessNumber - 1).printHistory();
                        break;
                }
                break;
            case "q":
                System.out.println("You ended the process, the program is going to stop.");
                quit = true;
                break;
            default:
                System.out.println("What you typed isn't correct, please pick again.\n");
                break;
            }
        }
        scanner.close();
    }
}
