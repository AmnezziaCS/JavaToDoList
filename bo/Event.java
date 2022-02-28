package bo;

import java.util.ArrayList;

public class Event {
    String title;
    String description;
    Boolean state = false;
    ArrayList<String> eventHistory = new ArrayList<String>();
    int version = 1;

    public Event(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void changeEvent(String title, String description) {
        eventHistory.add("Version " + version + " : " + title + " " + description);
        version += 1;
        this.title = title;
        this.description = description;
    }

    public void printHistory() {
        if (version == 1) {
            System.out.println("\nThe history is empty.\n");
        } else {
            for (int i = 0; i < eventHistory.size(); i++) {
                System.out.println("\n Version " + (i + 1) + " : ");
                System.out.println(" Title and Description : " + eventHistory.get(i) + "\n");
            }
        }
    }

    public void stateChanger() {
        if (state == true) {
            state = false;
        } else {
            state = true;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        if (state == true) {
            return "Event completed !";
        } else {
            return "Event still going";
        }
    }

    public int getVersion() {
        return version;
    }
}
