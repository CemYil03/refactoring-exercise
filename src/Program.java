
public class Program {
    
    public static void main(String args[]) {
        System.out.println("\n\n" + "Welcome to the Movie Store");

        Movie m1 = new Movie("movie1", Movie.MovieType.NEW_RELEASE);
        Movie m2 = new Movie("movie2", Movie.MovieType.CHILDRENS);

        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);

        Customer c1 = new Customer("joe");

        c1.addRental(r1);
        c1.addRental(r2);

        System.out.println("Let's get the Statement" + c1.statement() + "\n");
    }

}
