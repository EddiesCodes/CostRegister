package Person;

import Project.Euro;
import Project.Event;
import Project.MapEventEuro;
import Project.MapEventName;
import java.util.HashMap;
import java.util.Set;

class MapPersonEventEuro {

    private HashMap<Person, MapEventEuro> personEventEuro;

    MapPersonEventEuro(){
        this.personEventEuro = new HashMap<Person, MapEventEuro>();
    }

    void checkEmpty(Event event, Payer payer, Person person){
        if (personEventEuro.isEmpty()){
            payer.put(personEventEuro, event, person);
        }
    }

    void addDebts(Event event, Payer payer, Person person){
        payer.putDebts(personEventEuro, event, person);
    }

    void print(Person person, MapEventName affectedEvents){
        if (!personEventEuro.isEmpty()){
            printallPayer(person, affectedEvents);
        }
    }

    private void printallPayer(Person person, MapEventName affectedEvents){
        affectedEvents.checkEvent(person, personEventEuro);
    }

    void calculateOtherCost(Euro otherCost, Person person, Set<Event> events){
        for (Person payerPayer: personEventEuro.keySet()) {
            checkPerson(payerPayer, person, personEventEuro.get(payerPayer), otherCost, events);
        }
    }

    private void checkPerson(Person payerPayer, Person person, MapEventEuro eventEuro, Euro otherCost, Set<Event> events){
        if (payerPayer.equals(person)){
            eventEuro.calculateOtherCost(otherCost, events);
        }
    }
}