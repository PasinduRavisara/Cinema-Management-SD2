public class Ticket {

    // Declare private variables to store ticket information
    private int row_number;
    private int seat_num;
    private double price;
    private Person person; // Person associated with the ticket

    //Using a constructor
    public Ticket(int row_number, int seat_num, double price, Person person){
        this.row_number=row_number;
        this.seat_num=seat_num;
        this.price=price;
        this.person=person;
    }



    // Create getters and setters to get and set row letter, seat number, price of the seat and the person's details
    public int get_row(){
        return row_number;
    }

    public void set_row(int row_number){
        this.row_number=row_number;
    }

    public int get_seat(){
        return seat_num;
    }

    public void set_seat(int seat_num){
        this.seat_num=seat_num;
    }

    public double get_price(){
        return price;
    }

    public void set_price(double price){
        this.price=price;
    }

    public Person get_person(){
        return person;
    }

    public void set_person(Person person){
        this.person=person;
    }


    @Override
    public String toString() {
        return "Ticket [Row: " + row_number + ", Seat: " + seat_num + ", Price: £" + price + ", Person: " + person + "]";
    }



    //The method to return ticket information aa a formatted string
    public String ticket_info() {
        return ("\n\nRow:" + get_row() + "\nSeat:" + get_seat() + "\nPrice:£" + get_price() + "\n\nPerson's information:" + get_person().person_detail() + "\n\n");
    }

}