package Project;

import Person.ListPerson;
import Person.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class ListEuro {

    private ArrayList<Double> listEuro;

    public ListEuro() {
        this.listEuro = new ArrayList<>();
    }

    public void add(Double cost) {
        listEuro.add(cost);
    }

    public void putEuro(HashMap<Person, Euro> personEuro, ListPerson member, Person person) {
       replaceCost(personEuro, member, person, listEuro.get(0));
    }

    private void replaceCost(HashMap<Person, Euro> personEuro, ListPerson member, Person person, Double cost){
        member.replaceCost(personEuro, cost, person);
        listEuro.remove(0);
    }
}
