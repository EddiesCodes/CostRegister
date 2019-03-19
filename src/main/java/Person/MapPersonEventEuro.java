package Person;

import Project.Euro;
import Project.Event;
import Project.MapEventEuro;
import Project.MapEventName;
import java.util.HashMap;
import java.util.Set;

public class MapPersonEventEuro {

    private HashMap<Person, MapEventEuro> personEventEuro;

    public MapPersonEventEuro(){
        this.personEventEuro = new HashMap<Person, MapEventEuro>();
    }

    public void checkEmpty(Event event, Payer payer, Person person){
        if (personEventEuro.isEmpty()){
            payer.put(personEventEuro, event, person);
        }
    }

    public void addDebts(Event event, Payer payer, Person person){
        payer.putDebts(personEventEuro, event, person);
    }

    public void print(Person person, MapEventName affectedEvents){
        if (!personEventEuro.isEmpty()){
            printallPayer(person, affectedEvents);
        }
    }

    public void printallPayer(Person person, MapEventName affectedEvents){
        affectedEvents.checkEvent(person, personEventEuro);
    }

    public void calculateOtherCost(Euro otherCost, Person person, Set<Event> events){
        for (Person payerPayer: personEventEuro.keySet()) {
            checkPerson(payerPayer, person, personEventEuro.get(payerPayer), otherCost, events);
        }
    }

    public void checkPerson(Person payerPayer, Person person, MapEventEuro eventEuro, Euro otherCost, Set<Event> events){
        if (payerPayer.equals(person)){
            eventEuro.calculateOtherCost(otherCost, events);
        }
    }
}