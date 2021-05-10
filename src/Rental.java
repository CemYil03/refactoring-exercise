
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        this.movie = newmovie;
        this.daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public double getAmount() {

        switch (this.movie.getType()) {
            case REGULAR:
                return 2.0 + this.daysRented > 2 ? (this.daysRented - 2) * 1.5 : 0;

            case NEW_RELEASE:
                return this.daysRented * 3;

            case CHILDRENS:
                return 1.5 + this.daysRented > 3 ? (this.daysRented - 3) * 1.5 : 0;
            
            default:
                throw new Error();
        }

    }
    
}
