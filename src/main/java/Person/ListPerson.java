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

    public void putInPersonEuro(HashMap<Person, Euro> personEuro, ListEuro cost, ListPerson member){
        int size = 0;
        for (Person person : member.listPerson) {
            size++;
        }
        int index = 0;
        for (Person payer: listPerson) {
            cost.putInPersonEuro(personEuro, payer, index, size);
            index++;
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
}
