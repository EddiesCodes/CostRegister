package Project;


import Person.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class ListEuro {

    private ArrayList<Double> listEuro;

    public ListEuro(){
        this.listEuro = new ArrayList<>();
    }

    public void add(Double cost){
        listEuro.add(cost);
    }

    public void putInPersonEuro(HashMap<Person, Euro> personEuro, Person payer, int index, int size){
        Euro cost = new Euro(listEuro.get(index)/size);
        personEuro.put(payer, cost);
    }
}
