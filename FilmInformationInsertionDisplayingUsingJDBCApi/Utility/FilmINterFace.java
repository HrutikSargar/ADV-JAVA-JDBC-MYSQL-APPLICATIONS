package JDBCFinalTest.Question1.Utility;

import JDBCFinalTest.Question1.Model.Film;

import java.util.ArrayList;

public interface FilmINterFace {
    int addFilm(Film film);

    ArrayList<Film> displayFilmData();

    int updateFilmName(Film film);
    int updateFilmYear(Film film);
    int updateFilmLang(Film film);
    int updateFilmRating(Film film);
}
