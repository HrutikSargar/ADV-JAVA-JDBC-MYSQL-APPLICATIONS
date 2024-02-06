package JDBCFinalTest.Question1.Model;

public class Film {
   private int film_id;
    private  String film_name;
    private int film_year ;
    private String film_lang;
    private double film_rating;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public int getFilm_year() {
        return film_year;
    }

    public void setFilm_year(int film_year) {
        this.film_year = film_year;
    }

    public String getFilm_lang() {
        return film_lang;
    }

    public void setFilm_lang(String film_lang) {
        this.film_lang = film_lang;
    }

    public double getFilm_rating() {
        return film_rating;
    }

    public void setFilm_rating(double film_rating) {
        this.film_rating = film_rating;
    }
}
