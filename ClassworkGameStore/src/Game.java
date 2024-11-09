public class Game {
    private String title;
    private String genre;
    private double price;
    private LocalDate releaseDate;

    prublic Game(string title, String genre, double price, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getGenre(){
        return genre;
    }

    public void getGenre(String genre){
        this.genre = genre;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(duble price){
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}