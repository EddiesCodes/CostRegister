package Project;

import Person.Person;
import java.util.HashMap;
import java.util.Set;

public class MapEventEuro {

    private HashMap<Event, Euro> eventEuro;

    public MapEventEuro(Event event, Euro cost) {
        fillEventEuro(event, cost);
    }

    private void fillEventEuro(Event event, Euro cost) {
        this.eventEuro = new HashMap<Event, Euro>();
        eventEuro.put(event, cost);
    }

    public void putEventEuro(Euro cost, Event event) {
        eventEuro.put(event, cost);
    }

    private void print(Set<Event> events, Person payer, Person person) {
        Euro totalCost = new Euro(0.0);
        Euro otherCost = new Euro(0.0);
        payer.calculateOtherCost(otherCost, person, events);
        totalCost.calculate(eventEuro, events, otherCost, person, payer);
    }

    void checkEvent(Person person, HashMap<Event, EventName> eventName, Person payer) {
        for (Event event : eventEuro.keySet()) {
            eventContain(eventName.keySet(), person, payer, event);
        }
    }

    private void eventContain(Set<Event> events, Person person, Person payer, Event event){
        if (events.contains(event)){
            getSetPrint(events, payer, person);
        }
    }

    private void getSetPrint(Set<Event> events, Person payer, Person person){
        print(events, payer, person);
    }

    public void calculateOtherCost(Euro otherCost, Set<Event> events){
        otherCost.calculateOtherCost(eventEuro, events);
    }
}