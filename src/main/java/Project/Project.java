package Project;

import Person.ListPerson;

public class Project {

    private ListPerson affectedPerson;
    private MapEventName affectedEvents;

    public Project(ListPerson affectedPerson){
        this.affectedPerson = affectedPerson;
        this.affectedEvents = new MapEventName();
    }

    public void addEvent(Event event, String eventName){
        affectedEvents.put(event, eventName);
    }

    public void transaction(){
        affectedPerson.print(affectedEvents);
    }
}
