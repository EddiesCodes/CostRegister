package Project;

import Person.Person;

import java.util.HashMap;

public class MapEventName {

    private HashMap<Event, EventName> eventName;

    MapEventName(){
        this.eventName = new HashMap<>();
    }

    void put(Event event, String nameEvent){
        eventName.put(event, new EventName(nameEvent));
    }

    public void checkEvent(Person person, HashMap<Person, MapEventEuro> personEventEuro){
        for (Person payer: personEventEuro.keySet()) {
            checkEvent(person, personEventEuro.get(payer), payer);
        }
    }


    private void checkEvent(Person person, MapEventEuro eventEuro, Person payer) {
        eventEuro.checkEvent(person, eventName, payer);
    }
}
