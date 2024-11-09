public class DLC {
    private String title;
    private double price;
    private LocalDate releaseDate;
    private Game game;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public DLC(String title, double price, LocalDate releaseDate, Game game) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.game = game;
    }


}