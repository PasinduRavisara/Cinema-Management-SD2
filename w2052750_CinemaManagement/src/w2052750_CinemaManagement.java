//Import necessary Java utilities package
import java.util.*;

// Main class
public class w2052750_CinemaManagement {

    //Method to display the menu options
    public static void the_menu() {
        //Menu options
        System.out.println("\n\n-------------------------------------------------------------");
        System.out.println("  \n*\t\t\t\t\t\tMENU OPTIONS\t\t\t\t\t\t*");
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("\nPlease select an option:");
        System.out.println("\t1)Buy ticket");
        System.out.println("\t2)Cancel ticket");
        System.out.println("\t3)See seating plan");
        System.out.println("\t4)Find first seat available");
        System.out.println("\t5)Print ticket information and total price");
        System.out.println("\t6)Search ticket");
        System.out.println("\t7)Sort tickets by price");
        System.out.println("\t8)Exit");
        System.out.println("\n-------------------------------------------------------------");

    }


    //Array to store all tickets sold during the session
    private static Ticket[] sold_tickets = new Ticket[1000]; //Assume maximum 1000 tickets sold in one session.

    //A counter to keep track of sold tickets
    private static int ticket_counter =0;


    //Main method
    public static void main(String[] args) {
        //Print welcome message
        System.out.println("\n\n\t\t\t\tWelcome to The London Lumiere");

        // Initialize arrays to represent seat availability in each row
        int[] Row_1 = new int[16];
        int[] Row_2 = new int[16];
        int[] Row_3 = new int[16];

        // Initializing variables
        String quit_option = ""; // Variable to control program quitting
        int User_option = 0; //Variable to store user's menu choice

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Main loop to display menu and process user input until quitting
        while (!quit_option.equals("Quit the program")) {
            the_menu(); //Print menu options
            System.out.print("Select option:");

            try {
                User_option = scanner.nextInt();// Getting user input for menu choice
                if (User_option < 1 || User_option > 8) {// Checking for valid menu option
                    System.out.println("\nNumber is INVALID.\nPlease enter a valid number.");
                }
            } catch (Exception error) {
                System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                break; //Exit the loop
            }

            // Perform actions based on user's choice
            if (User_option == 8) {
                quit_option = "Quit the program";
                System.out.println("\nExiting the Cinema Management application...");
            } else if (User_option == 1) {
                buy_seat(scanner, Row_1, Row_2, Row_3);
            } else if (User_option == 2) {
                cancel_seat(scanner, Row_1, Row_2, Row_3);
            } else if (User_option == 3) {
                show_seating_plan(Row_1, Row_2, Row_3);
            } else if (User_option == 4) {
                find_first_available(Row_1, Row_2, Row_3);
            } else if (User_option == 5) {
                print_tickets_info();
            } else if (User_option == 6) {
                search_ticket(scanner, Row_1, Row_2, Row_3);
            } else if (User_option == 7) {
                sort_tickets();
            }
        }
    }

    // The method to buy seats
    public static void buy_seat(Scanner scanner, int[] Row_1, int[] Row_2, int[] Row_3) {
        int[] user_selected_row;

        //Ask for user's personal information
        System.out.print("\nPlease enter your first name:");
        String user_name= scanner.next();
        System.out.print("Please enter your surname:");
        String user_surname=scanner.next();
        System.out.print("Please enter your email:");
        String user_email=scanner.next();

        //Creating a new person object
        Person person_detail= new Person(user_name,user_surname,user_email);


        // Asking for seat selection
        int catchError = 1;
        while (catchError == 1) { //A while loop to repeat the process until right input
            System.out.print("\n\nPlease enter the row number (1,2 or 3):");

            try {
                int row_number = scanner.nextInt();// Getting user input row number
                if (row_number < 4 && row_number > 0) { // Checking for valid row number
                    System.out.print("Please enter the seat number (1 to 16):");

                    try {
                        int seat_num = scanner.nextInt();// Getting user input seat number
                        if (seat_num < 17 && seat_num > 0) { // Checking for valid row number

                            catchError = 0; //Stop repeating the process

                            // Determine which row was selected based on user input
                            if (row_number == 1) {
                                user_selected_row = Row_1;
                            } else if (row_number == 2) {
                                user_selected_row = Row_2;
                            } else {
                                user_selected_row = Row_3;
                            }

                            //Book the seat if it is available
                            if (user_selected_row[seat_num - 1] == 0) {
                                user_selected_row[seat_num - 1] = 1;

                                if (row_number==1){
                                    //Create a new ticket object and add information to  tickets
                                    Ticket ticket_info= new Ticket(row_number,seat_num,12.0,person_detail);
                                    sold_tickets[ticket_counter++]=ticket_info;
                                } else if (row_number==2) {
                                    //Create a new ticket object and add information to  tickets
                                    Ticket ticket_info= new Ticket(row_number,seat_num,10.0,person_detail);
                                    sold_tickets[ticket_counter++]=ticket_info;
                                } else if (row_number==3) {
                                    //Create a new ticket object and add information to  tickets
                                    Ticket ticket_info= new Ticket(row_number,seat_num,8.0,person_detail);
                                    sold_tickets[ticket_counter++]=ticket_info;
                                }


                                System.out.println("\nYour seat is successfully booked.\n");
                            } else {
                                System.out.println("\nWe are sorry!!\nSelected seat is already booked.\n");
                            }


                        } else {
                            System.out.println("\nSeat number is INVALID.\nPlease choose a seat between 0 and 17");
                        }

                    } catch (Exception error) {
                        System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                        break; //Exit the loop
                    }

                } else {
                    System.out.println("\nRow number is INVALID.\nPlease choose row 1 or 2 or 3.");
                }

            } catch (Exception error) {
                System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                break; //Exit the loop
            }
        }

    }

    // The method to buy seats
    public static void cancel_seat(Scanner scanner, int[] Row_1, int[] Row_2, int[] Row_3) {
        int[] user_selected_row;

        // Asking for seat selection
        int catchError = 1;
        while (catchError == 1) { //A while loop to repeat the process until right input
            System.out.print("\n\nPlease enter the row number (1,2 or 3):");

            try {
                int row_number = scanner.nextInt();// Getting user input row number
                if (row_number < 4 && row_number > 0) { // Checking for valid row number
                    System.out.print("Please enter the seat number (1 to 16):");

                    try {
                        int seat_num = scanner.nextInt();// Getting user input seat number
                        if (seat_num < 17 && seat_num > 0) { // Checking for valid row number

                            catchError = 0; //Stop repeating the process

                            // Determine which row was selected based on user input
                            if (row_number == 1) {
                                user_selected_row = Row_1;
                            } else if (row_number == 2) {
                                user_selected_row = Row_2;
                            } else {
                                user_selected_row = Row_3;
                            }

                            //Book the seat if it is available
                            if (user_selected_row[seat_num - 1] == 1) {
                                user_selected_row[seat_num - 1] = 0;

                                System.out.println("\nBooking cancellation is successful!!!\n");
                            } else {
                                System.out.println("\nThe seat is not booked.\n");
                            }


                        } else {
                            System.out.println("\nSeat number is INVALID.\nPlease choose a seat between 0 and 17");
                        }

                    } catch (Exception error) {
                        System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                        break; //Exit the loop
                    }

                } else {
                    System.out.println("\nRow number is INVALID.\nPlease choose row 1 or 2 or 3.");
                }

            } catch (Exception error) {
                System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                break; //Exit the loop
            }
        }

    }


    // The method to display the seating plan
    public static void show_seating_plan(int[] Row_1, int[] Row_2, int[] Row_3) {
        System.out.println("\n\t\t\t\t   The seating plan\n\n");

        System.out.println(" ****************************************************");
        System.out.println("\n \t\t\t\t\t\tSCREEN\t\t\t\t\t\t");
        System.out.println("\n ****************************************************\n");


        //Display seating plan for row 1
        for (int i = 0; i < Row_1.length; i++) {
            if (Row_1[i] == 0) {
                System.out.print(" 0 ");
            } else {
                System.out.print(" X ");
            }
            // Add a space after the 8th element
            if (i == 7) {
                System.out.print("      ");
            }
        }

        //Add a space between each row
        System.out.println("\n");

        //Display seating plan for row 2
        for (int i = 0; i < Row_2.length; i++) {
            if (Row_2[i] == 0) {
                System.out.print(" 0 ");
            } else {
                System.out.print(" X ");
            }
            // Add a space after the 8th element
            if (i == 7) {
                System.out.print("      ");
            }
        }

        //Add a space between each row
        System.out.println("\n");

        //Display seating plan for row 3
        for (int i = 0; i < Row_3.length; i++) {
            if (Row_3[i] == 0) {
                System.out.print(" 0 ");
            } else {
                System.out.print(" X ");
            }
            // Add a space after the 8th element
            if (i == 7) {
                System.out.print("      ");
            }
        }

        //Add a space between each row
        System.out.println("\n");

    }

    // The method to find the first available seat
    public static void find_first_available(int[] Row_1,int[] Row_2,int[] Row_3) {
        int[] free_array;
        int free_space = 0;
        int count = 1;

        // Iterate through each row to find the first available seat
        while (count < 4) {
            if (count == 1) {
                free_array = Row_1;
            } else if (count == 2) {
                free_array = Row_2;

            } else {
                free_array = Row_3;
            }


            for (int x = 0; x <= free_array.length - 1; x++) {
                if (free_array[x] == 0) {
                    System.out.println("\nRow number " + count + ", seat number " + (x + 1) + " is empty.");
                    free_space = 1;
                    break;
                }
            }
            if (free_space == 1) {
                break;
            }
            count++;
        }
    }


    //The method for print tickets information and calculate total sales
    public static void print_tickets_info(){
        double total_sales = 0.0;
        System.out.println("\n\t_Information of all the tickets_\t");

        // Print information of each ticket and calculating total sale
        for(int i= 0;i<ticket_counter;i++){
            System.out.println(sold_tickets[i].ticket_info());
            total_sales+=sold_tickets[i].get_price();
        }
        System.out.println("\nTotal Sales:£"+total_sales);
    }


    // The method to search for a ticket
    public static void search_ticket(Scanner scanner,int[] Row_1,int[] Row_2,int[] Row_3) {
        int[] user_selected_row;

        // Asking for seat selection
        int catchError = 1;
        while (catchError == 1) { //A while loop to repeat the process until right input
            System.out.print("\n\nPlease enter the row number (1,2 or 3):");

            try {
                int row_number = scanner.nextInt();// Getting user input row number
                if (row_number < 4 && row_number > 0) { // Checking for valid row number
                    System.out.print("Please enter the seat number (1 to 16):");

                    try {
                        int seat_num = scanner.nextInt();// Getting user input seat number
                        if (seat_num < 17 && seat_num > 0) { // Checking for valid row number

                            catchError = 0; //Stop repeating the process

                            // Determine which row was selected based on user input
                            if (row_number == 1) {
                                user_selected_row = Row_1;
                            } else if (row_number == 2) {
                                user_selected_row = Row_2;
                            } else {
                                user_selected_row = Row_3;
                            }

                            //Book the seat if it is available
                            if (user_selected_row[seat_num - 1] == 0) {
                                System.out.println("\nThis seat is not booked!!!\n");
                            } else {
                                System.out.println("\nThis seat is booked!!!\n");
                            }


                        } else {
                            System.out.println("\nSeat number is INVALID.\nPlease choose a seat between 0 and 17");
                        }

                    } catch (Exception error) {
                        System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                        break; //Exit the loop
                    }

                } else {
                    System.out.println("\nRow number is INVALID.\nPlease choose row 1 or 2 or 3.");
                }

            } catch (Exception error) {
                System.out.println((error.getMessage() != null) ? error.getMessage() : "\nOnly integers are valid, please enter an integer." + "\nProgram will quit automatically." + "\n\nPlease restart the program manually.");
                break; //Exit the loop
            }
        }
    }

    //The method to sort tickets by price
    public static void sort_tickets(){

        //Bubble sort
        for(int i = 0; i < ticket_counter-1; i++){
            for(int j = 0; j<ticket_counter-1-i; j++){
                if(sold_tickets[j].get_price() > sold_tickets[j+1].get_price()){
                    Ticket temp = sold_tickets[j];
                    sold_tickets[j] = sold_tickets[j+1];
                    sold_tickets[j+1] = temp;
                }
            }
        }

        System.out.println("\n\nTickets sorted by price:\n");

        for( int i = 0; i<ticket_counter; i++){
            Ticket ticket = sold_tickets[i];
            System.out.println(ticket);
        }
    }
}



