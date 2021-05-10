
import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();
    
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String statement() {
        // header        
        String header = String.format("Rental Record for %s\n", this.name);

        // body
        String body = "\tTitle\t\tDays\tAmount\n";
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental: this.rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
            totalAmount += rental.getAmount();
            
            body += String.format(
                "\t%s\t\t%s\t%s\n",
                rental.getMovie().getTitle(),
                rental.getDaysRented(),
                String.valueOf(rental.getAmount())
            );
        }

        // footer
        String footer = String.format(
            """
            Amount owed is %s
            You earned %s frequent renter points
            """,
            String.valueOf(totalAmount),
            String.valueOf(frequentRenterPoints)
        );
        
        return header + "\n" + body + "\n" + footer;
    }

}
    