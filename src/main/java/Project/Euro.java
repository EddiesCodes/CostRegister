package Project;

import Person.Person;

import java.util.HashMap;
import java.util.Set;

public class Euro {

    private double cost;

    public Euro(double cost) {
        this.cost = cost;
    }

    public void print(double costs, Person person, Person payer) {
        if (cost - costs > 0) {
            person.printName();
            System.out.print(" schuldet ");
            payer.printName();
            System.out.println(" " +  ((double)((int)((cost-costs)*100))/100) + " Euro.");
        }
    }

    public void calculate(HashMap<Event, Euro> eventEuro, Set<Event> events, Euro otherCost, Person person, Person payer) {
        for (Event event : eventEuro.keySet()) {
            eventContain(eventEuro.get(event), events, event);
        }
        print(otherCost.cost, person, payer);
    }

    private void eventContain(Euro costs, Set<Event> events, Event event) {
        if (events.contains(event)) {
            cost = cost + costs.cost;
        }
    }

    public void calculateOtherCost(HashMap<Event, Euro> eventEuro, Set<Event> events) {
        for (Event event : eventEuro.keySet()) {
            eventContain(eventEuro.get(event), events, event);
        }
    }
}
