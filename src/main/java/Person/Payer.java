package Person;

import Project.Euro;
import Project.Event;
import Project.ListEuro;
import Project.MapEventEuro;

import java.util.HashMap;

public class Payer {

    private Date date;
    private MapPersonEuro personEuro;

    public Payer(String date, ListPerson payer, ListEuro cost, ListPerson member) {
        this.date = new Date(date);
        this.personEuro = new MapPersonEuro(payer, cost, member);
    }

    public void put(HashMap<Person, MapEventEuro> personEventEuro, Event event, Person person){
        personEuro.put(personEventEuro, event, person);
    }

    public void putDebts(HashMap<Person, MapEventEuro> personEventEuro, Event event, Person person){
        personEuro.putDebts(personEventEuro, event, person);
    }


}
