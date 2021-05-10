
import java.util.Vector;
import java.util.Enumeration;

public class Customer {

    private String name;
    private Vector rentals = new Vector();
    
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.addElement(rental);
    }

    public String getName() {
        return this.name;
    }

    public String statement() {
        Enumeration enum_rentals = this.rentals.elements();

        // header        
        String header = String.format(
            """
            Rental Record for %s
            
                    Title\t\tDays\tAmount
            """,
            this.getName()
        );

        // body
        String body = "";
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            totalAmount += rental.getAmount();
            
            //show figures for this rental
            body += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getAmount()) + "\n";
        }

        // footer
        String footer = String.format(
            """
            \nAmount owed is %s
            You earned %s frequent renter points
            """,
            String.valueOf(totalAmount),
            String.valueOf(frequentRenterPoints)
        );
        
        return header + body + footer;
    }

}
    