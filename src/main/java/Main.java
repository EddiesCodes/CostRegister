import Person.ListPerson;
import Person.Person;
import Project.Project;
import Project.ListEuro;
import Person.Payer;
import Project.Event;

public class Main {

    public static void main(String[] args){

        //Alle Personen
        Person simon = new Person("Simon");
        Person thomas = new Person("Thomas");
        Person jens = new Person("Jens");
        Person gerd = new Person("Gerd");
        Person kathrin = new Person("Kathrin");
        Person christoph = new Person("Christoph");
        Person jessica = new Person("Jessica");
        Person sina = new Person("Sina");
        Person markus = new Person("Markus");


        //Simon, Thomas, Jens, Gerd, Kathrin, Christoph, Jessica und Sina nehmen an der Städtereise nach Hamburg teil.
        ListPerson cityTourMember = new ListPerson();
        cityTourMember.add(simon);
        cityTourMember.add(thomas);
        cityTourMember.add(jens);
        cityTourMember.add(gerd);
        cityTourMember.add(kathrin);
        cityTourMember.add(christoph);
        cityTourMember.add(jessica);
        cityTourMember.add(sina);
        Project cityTravel = new Project(cityTourMember);


        //Markus, Thomas und Christoph wohnen in einer WG, die Abrechnung findet jeden Monat statt.
        ListPerson communeMember = new ListPerson();
        communeMember.add(markus);
        communeMember.add(thomas);
        communeMember.add(christoph);
        Project commune = new Project(communeMember);


        //Christoph bezahlt die Miete in Höhe von 1275,80 Euro.
        ListPerson rentPayerPerson = new ListPerson();
        rentPayerPerson.add(christoph);

        ListEuro rentCost = new ListEuro();
        rentCost.add(1275.80);


        Payer rentPayer = new Payer(rentPayerPerson, rentCost, communeMember);
        Event rent = new Event(communeMember, rentPayer);
        commune.addEvent(rent, "Miete");

        thomas.addNewDebts(rent, rentPayer);
        markus.addNewDebts(rent, rentPayer);
        christoph.addNewDebts(rent, rentPayer);


        //Markus zahlt 29,99 Euro für die Internet Flat
        ListPerson flatPayerPerson = new ListPerson();
        flatPayerPerson.add(markus);

        ListEuro flatCost = new ListEuro();
        flatCost.add(29.99);

        Payer flatPayer = new Payer(flatPayerPerson, flatCost, communeMember);
        Event flat = new Event(communeMember, flatPayer);
        commune.addEvent(flat, "Internet-Flat");

        thomas.addNewDebts(flat, flatPayer);
        markus.addNewDebts(flat, flatPayer);
        christoph.addNewDebts(flat, flatPayer);


        //Thomas besorgt Bier für den Monat, er bezahlt 63,80 Euro. Markus trinkt kein Bier
        ListPerson beerMember = new ListPerson();
        beerMember.add(christoph);
        beerMember.add(thomas);

        ListPerson beerPayerPerson = new ListPerson();
        beerPayerPerson.add(thomas);

        ListEuro beerCost = new ListEuro();
        beerCost.add(63.80);

        Payer beerPayer = new Payer(beerPayerPerson, beerCost, beerMember);
        Event beer = new Event(beerMember, beerPayer);
        commune.addEvent(beer, "Bier");

        thomas.addNewDebts(beer, beerPayer);
        christoph.addNewDebts(beer, beerPayer);


        //Thomas füllt auch den Kühlschrank für alle, er bezahlt 104,88 Euro.
        ListPerson fridgePayerPerson = new ListPerson();
        fridgePayerPerson.add(thomas);

        ListEuro fridgeCost = new ListEuro();
        fridgeCost.add(104.88);

        Payer fridgePayer = new Payer(fridgePayerPerson, fridgeCost, communeMember);
        Event fridge = new Event(communeMember, fridgePayer);
        commune.addEvent(fridge, "Kühlschrank");

        thomas.addNewDebts(fridge, fridgePayer);
        christoph.addNewDebts(fridge, fridgePayer);
        markus.addNewDebts(fridge, fridgePayer);


        //Jens bezahlt bei der Städtereise am 30.10.2017 den Betrag von 148 Euro für die Stadtrundfahrt, an der alle teilnehmen.
        ListPerson cityTourPayerPerson = new ListPerson();
        cityTourPayerPerson.add(jens);

        ListEuro cityTourCost = new ListEuro();
        cityTourCost.add(148.00);

        Payer cityTourPayer = new Payer("30.10.2017", cityTourPayerPerson, cityTourCost, cityTourMember);
        Event cityTour = new Event(cityTourMember, cityTourPayer);
        cityTravel.addEvent(cityTour, "Stadtrundfahrt");

        jens.addNewDebts(cityTour, cityTourPayer);
        thomas.addNewDebts(cityTour, cityTourPayer);
        gerd.addNewDebts(cityTour, cityTourPayer);
        christoph.addNewDebts(cityTour, cityTourPayer);
        sina.addNewDebts(cityTour, cityTourPayer);
        simon.addNewDebts(cityTour, cityTourPayer);
        jessica.addNewDebts(cityTour, cityTourPayer);
        kathrin.addNewDebts(cityTour, cityTourPayer);


        //Die Tickets für das Musical kosten 864.50 Euro, Sina bezahlt davon 500 Euro, der Rest wird von Kathrin übernommen.
        //Es nehmen alle, ausser Simon, Thomas und Jens teil.
        ListPerson musicalMember = new ListPerson();
        musicalMember.add(sina);
        musicalMember.add(kathrin);
        musicalMember.add(christoph);
        musicalMember.add(jessica);
        musicalMember.add(gerd);

        ListPerson musicalPayerPerson = new ListPerson();
        musicalPayerPerson.add(sina);
        musicalPayerPerson.add(kathrin);

        ListEuro musicalCost = new ListEuro();
        musicalCost.add(500.00);
        musicalCost.add(864.50 - 500.00);

        Payer musicalPayer = new Payer(musicalPayerPerson, musicalCost, musicalMember);
        Event musical = new Event(musicalMember, musicalPayer);
        cityTravel.addEvent(musical, "Musical");

        sina.addNewDebts(musical, musicalPayer);
        kathrin.addNewDebts(musical, musicalPayer);
        christoph.addNewDebts(musical, musicalPayer);
        jessica.addNewDebts(musical, musicalPayer);
        gerd.addNewDebts(musical, musicalPayer);


        //Thomas bezahlt 66 Euro für das Bier am Abend, Simon hatte Kopfschmerzen und ist im Hotel geblieben.
        ListPerson beerEveningMember = new ListPerson();
        beerEveningMember.add(sina);
        beerEveningMember.add(jens);
        beerEveningMember.add(jessica);
        beerEveningMember.add(christoph);
        beerEveningMember.add(thomas);
        beerEveningMember.add(gerd);
        beerEveningMember.add(kathrin);

        ListPerson beerEveningPayerPerson = new ListPerson();
        beerEveningMember.add(thomas);

        ListEuro beerEveningCost = new ListEuro();
        beerEveningCost.add(66.00);

        Payer beerEveningPayer = new Payer(beerEveningPayerPerson, beerEveningCost, beerEveningMember);
        Event beerEvening = new Event(beerEveningMember, beerEveningPayer);
        cityTravel.addEvent(beerEvening, "Bier am Abend");

        sina.addNewDebts(beerEvening, beerEveningPayer);
        jens.addNewDebts(beerEvening, beerEveningPayer);
        jessica.addNewDebts(beerEvening, beerEveningPayer);
        christoph.addNewDebts(beerEvening, beerEveningPayer);
        thomas.addNewDebts(beerEvening, beerEveningPayer);
        gerd.addNewDebts(beerEvening, beerEveningPayer);
        kathrin.addNewDebts(beerEvening, beerEveningPayer);


        //Gerd hat für Benzin 61,38 Euro ausgegeben, bei ihm sind Jens, Kathrin, Sina und Christoph mitgefahren.
        //Simon hat den Rest der Gruppe mitgenommen und hat 54,43 Euro für Benzin ausgegeben.
        ListPerson fuelMember = new ListPerson();
        fuelMember.add(gerd);
        fuelMember.add(jens);
        fuelMember.add(kathrin);
        fuelMember.add(sina);
        fuelMember.add(christoph);
        fuelMember.add(simon);
        fuelMember.add(thomas);
        fuelMember.add(jessica);

        ListPerson fuelPayerPerson = new ListPerson();
        fuelPayerPerson.add(gerd);
        fuelPayerPerson.add(simon);

        ListEuro fuelCost = new ListEuro();
        fuelCost.add(61.38);
        fuelCost.add(54.43);

        Payer fuelPayer = new Payer(fuelPayerPerson, fuelCost, fuelMember);
        Event fuel = new Event(fuelMember, fuelPayer);
        cityTravel.addEvent(fuel, "Kraftstoff");

        gerd.addNewDebts(fuel, fuelPayer);
        jens.addNewDebts(fuel, fuelPayer);
        kathrin.addNewDebts(fuel, fuelPayer);
        sina.addNewDebts(fuel, fuelPayer);
        christoph.addNewDebts(fuel, fuelPayer);
        simon.addNewDebts(fuel, fuelPayer);
        thomas.addNewDebts(fuel, fuelPayer);
        jessica.addNewDebts(fuel, fuelPayer);


        //Die Abrechnung für die Städtereise wird durchgeführt, damit ist das Projekt beendet.
        cityTravel.transaction();


        //Die erste Abrechnung für die WG wird durchgeführt.
        commune.transaction();


        //Christoph bezahlt die Miete in Höhe von 1275,80 Euro.
        Project commune2 = new Project(communeMember);


        Event rent2 = new Event(communeMember, rentPayer);
        commune2.addEvent(rent2, "Miete");

        thomas.addNewDebts(rent2, rentPayer);
        markus.addNewDebts(rent2, rentPayer);
        christoph.addNewDebts(rent2, rentPayer);


        //Markus zahlt 29,99 Euro für die Internet Flat.
        Event flat2 = new Event(communeMember, flatPayer);
        commune2.addEvent(flat2, "Internet-Flat");

        thomas.addNewDebts(flat2, flatPayer);
        markus.addNewDebts(flat2, flatPayer);
        christoph.addNewDebts(flat2, flatPayer);


        //Die zweite Abrechnung für die WG wird durchgeführt.
        commune2.transaction();
    }
}
