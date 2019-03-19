package Project;

import Person.ListPerson;
import Person.Payer;

public class Event {

    private ListPerson affectedPerson;
    private Payer payer;

    public Event(ListPerson affectedPerson, Payer payer){
        this.affectedPerson = affectedPerson;
        this.payer = payer;
    }
}
