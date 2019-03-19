package Person;

import Project.Euro;
import Project.Event;
import Project.MapEventName;
import java.util.Set;

public class Person {

    private Name name;
    private Debts debts;

    public Person(String name){
        this.name = new Name(name);
        this.debts = new Debts();
    }

    public void addNewDebts(Event event, Payer payer){
        debts.checkEmpty(event, payer, this);
        debts.addDebts(event, payer, this);
    }

    public void printName(){
        name.print();
    }

    void printDebts(Person person, MapEventName affectedEvents){
        debts.printDebts(person, affectedEvents);
    }

    public void calculateOtherCost(Euro otherCost, Person person, Set<Event> events){
        debts.calculateOtherCost(otherCost, person, events);
    }
}
