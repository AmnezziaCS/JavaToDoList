package bo;

import java.util.ArrayList;

public class Todolist {
    ArrayList<Event> arrayEvent = new ArrayList<Event>();

    public void addEvent(Event event) {
        arrayEvent.add(event);
    }

    public void removeEvent(int index) {
        arrayEvent.remove(index);
    }

    public void eventPrint(int index) {
        System.out.println("\n- Event " + (index + 1) + " : ");
        System.out.println("Description : " + arrayEvent.get(index).getDescription());
        System.out.println("Title : " + arrayEvent.get(index).getTitle());
        System.out.println("State : " + arrayEvent.get(index).getState());
        System.out.println("Version : " + arrayEvent.get(index).getVersion() + "\n");
    }

    public void arrayPrint() {
        for (int i = 0; i < arrayEvent.size(); i++) {
            this.eventPrint(i);
        }
    }

    public Event getEvent(int index) {
        return arrayEvent.get(index);
    }

    public int getSize() {
        return arrayEvent.size();
    }
}
