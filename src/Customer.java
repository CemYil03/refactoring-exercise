
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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration enum_rentals = this.rentals.elements();

        // header        
        String result = String.format("""
            Rental Record for %s
                Title\t\tDays\tAmount
        """, this.getName());

        // body
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getAmount()) + "\n";

            totalAmount += rental.getAmount();
        }

        // footer
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        
        return result;
    }

}
    