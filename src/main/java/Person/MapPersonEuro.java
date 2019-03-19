package Person;

import Project.Euro;
import Project.Event;
import Project.ListEuro;
import Project.MapEventEuro;
import java.util.HashMap;
import java.util.Set;

class MapPersonEuro {

    private HashMap<Person, Euro> personEuro;

    MapPersonEuro(ListPerson payer, ListEuro cost, ListPerson member) {
        fillHashMap(payer, cost, member);
    }

    private void fillHashMap(ListPerson payerList, ListEuro cost, ListPerson member) {
        this.personEuro = new HashMap<Person, Euro>();
        payerList.putInPersonEuro(personEuro, cost, member);
    }

    void put(HashMap<Person, MapEventEuro> personEventEuro, Event event, Person person) {
        for (Person payer : personEuro.keySet()) {
            checkSamePerson(personEventEuro, person, payer, new MapEventEuro(event, personEuro.get(payer)));
        }
    }

    private void checkSamePerson(HashMap<Person, MapEventEuro> personEventEuro, Person person, Person payer, MapEventEuro eventEuro) {
        if (!payer.equals(person)) personEventEuro.put(payer, eventEuro);
    }

    void putDebts(HashMap<Person, MapEventEuro> personEventEuro, Event event, Person person){
        for (Person payer: personEuro.keySet()) {
            checkContain(personEventEuro, event, payer, personEventEuro.keySet(), person);
        }
    }

    private void checkContain(HashMap<Person, MapEventEuro> personEventEuro, Event event, Person payer, Set<Person> personKeySet, Person person){
        if (personKeySet.contains(payer)) putEventEuro(personEventEuro.get(payer), payer, event);
        if (!personKeySet.contains(payer)) put(personEventEuro, event, person);
    }

    private void putEventEuro(MapEventEuro eventEuro, Person payer, Event event){
        Euro cost = personEuro.get(payer);
        eventEuro.putEventEuro(cost, event);
    }
}