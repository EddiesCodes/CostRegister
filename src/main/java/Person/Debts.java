package Person;

import Project.Euro;
import Project.Event;
import Project.MapEventName;
import java.util.Set;

public class Debts {

    private MapPersonEventEuro personEventEuro;

    public Debts(){
        this.personEventEuro = new MapPersonEventEuro();
    }

    public void checkEmpty(Event event, Payer payer, Person person){
        personEventEuro.checkEmpty(event, payer, person);
    }

    public void addDebts(Event event, Payer payer, Person person){
        personEventEuro.addDebts(event, payer, person);
    }

    public void printDebts(Person person, MapEventName affectedEvents){
        personEventEuro.print(person, affectedEvents);
    }

    public void calculateOtherCost(Euro otherCost, Person person, Set<Event> events){
        personEventEuro.calculateOtherCost(otherCost, person, events);
    }
}
