package Person;

import Project.Euro;
import Project.ListEuro;
import Project.MapEventName;

import java.util.ArrayList;
import java.util.HashMap;

public class ListPerson {

    private ArrayList<Person> listPerson;

    public ListPerson(){
        this.listPerson = new ArrayList<>();
    }

    public void add(Person person){
        listPerson.add(person);
    }

    void putInPersonEuro(HashMap<Person, Euro> personEuro, ListEuro cost, ListPerson member){
        for (Person person: listPerson) {
            personEuro.put(person, new Euro(0.0));
            cost.putEuro(personEuro, member, person);
        }
    }

    public void print(MapEventName affectedEvents){
        for (Person person : listPerson) {
            person.printDebts(person, affectedEvents);
        }
        System.out.println();
        System.out.println("Abrechnung beendet!!!");
        System.out.println();
    }

    public void replaceCost(HashMap<Person, Euro> personEuro, Double euro, Person person){
        Euro cost = new Euro(euro/listPerson.size());
        personEuro.replace(person, cost);
    }
}
