package Person;

class Date {

    private String date;

    Date(String inputDate){
        setDate(inputDate);
    }

    private void setDate(String inputDate){
        if (inputDate.equals("Kein Datum")){
            this.date = null;
        }
        if (!inputDate.equals("Kein Datum")){
            this.date = inputDate;
        }
    }
}
