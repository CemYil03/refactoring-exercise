
public class Movie {

    private String title;
    private MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public MovieType getType() {
        return this.type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

}
