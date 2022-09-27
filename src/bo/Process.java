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
            String choice = scanner.nextLine();
            choice = choice.toLowerCase();

            if (choice.equals("c")) {
                System.out.println(
                        "You chose you wanted to create a new event.\n\n- You will need a title aswell as a description.");
                System.out.print("Please choose your event title :");
                String title = scanner.nextLine();
                System.out.print("Please choose your description :");
                String description = scanner.nextLine();
                Event event = new Event(title, description);
                mylist.addEvent(event);
                System.out.println("The event has been created succesfully !\n");
            } else if (choice.equals("d")) {
                if (mylist.getSize() == 0) {
                    System.out.println("You don't have any Events to delete. Please add Events in the first place.\n");
                } else {
                    mylist.arrayPrint();
                    System.out.println(
                            "Please pick the number of the Event you want to delete. Note that if you want to delete none, you can type 0.");
                    String deleteString = scanner.nextLine();
                    int deleteNumber = Integer.parseInt(deleteString);
                    if (deleteNumber == 0) {
                        System.out.println("You chose to delete nothing.");
                    } else if (deleteNumber > mylist.getSize() || deleteNumber < 0) {
                        System.out.println("You chose an impossible index");
                    } else {
                        mylist.removeEvent(deleteNumber - 1);
                        System.out.println("The event number " + deleteNumber + " has been deleted succesfully.");
                    }
                }
            } else if (choice.equals("a")) {
                if (mylist.getSize() == 0) {
                    System.out.println("You don't have any Events to access. Please add Events in the first place.\n");
                } else {
                    mylist.arrayPrint();
                    System.out.println(
                            "Please pick the number of the Event you want to access, Note that if you want to access none, you can type 0.");
                    String accessString = scanner.nextLine();
                    int accessNumber = Integer.parseInt(accessString);
                    String choice2;
                    if (accessNumber == 0) {
                        System.out.println("\nYou chose to access nothing.");
                    } else if (accessNumber > mylist.getSize() || accessNumber < 0) {
                        System.out.println("You chose an impossible index");
                    } else {
                        System.out.println("\nHere is the event you wanted :");
                        mylist.eventPrint(accessNumber - 1);
                        do {
                            System.out.println(
                                    "\n- If you want to change it's Title and Description, please type C,\n- If you want to change it's state, please type S,\n- If you want to see the update history, please type H,\n- If you want to quit, please type Q");
                            choice2 = scanner.nextLine();
                            choice2 = choice2.toLowerCase();
                        } while (!(choice2.equals("c")) && !(choice2.equals("s")) && !(choice2.equals("h"))
                                && !(choice2.equals("q")));
                        if (choice2.equals("c")) {
                            System.out.print("Please choose your event title :");
                            String title = scanner.nextLine();
                            System.out.print("Please choose your description :");
                            String description = scanner.nextLine();
                            mylist.getEvent(accessNumber - 1).changeEvent(title, description);
                            System.out.println("The Event has been updated succesfully !\n");
                        } else if (choice2.equals("s")) {
                            mylist.getEvent(accessNumber - 1).stateChanger();
                            System.out.println("The state have been changed succesfully !\n");
                        } else if (choice2.equals("q")) {
                            System.out.println("You chose to quit.\n");
                        } else if (choice2.equals("h")) {
                            System.out.println("\nHere is the history of you Event :");
                            mylist.getEvent(accessNumber - 1).printHistory();
                        }
                    }
                }
            } else if (choice.equals("q")) {
                quit = true;
                System.out.println("You ended the process, the program is going to stop.");
            } else {
                System.out.println("What you typed isn't correct, please pick again.\n");
            }
        }
    }
}
