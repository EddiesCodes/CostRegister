package Person;

import Project.Euro;
import Project.Event;
import Project.MapEventName;
import java.util.Set;

class Debts {

    private MapPersonEventEuro personEventEuro;

    Debts(){
        this.personEventEuro = new MapPersonEventEuro();
    }

    void checkEmpty(Event event, Payer payer, Person person){
        personEventEuro.checkEmpty(event, payer, person);
    }

    void addDebts(Event event, Payer payer, Person person){
        personEventEuro.addDebts(event, payer, person);
    }

    void printDebts(Person person, MapEventName affectedEvents){
        personEventEuro.print(person, affectedEvents);
    }

    void calculateOtherCost(Euro otherCost, Person person, Set<Event> events){
        personEventEuro.calculateOtherCost(otherCost, person, events);
    }
}
