package JDBCFinalTest.Question1.Utility;

import JDBCFinalTest.Question1.ConnectionHelper.ConnectionHelper;
import JDBCFinalTest.Question1.Model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class filmOperationDAO implements FilmINterFace{
    private  static PreparedStatement preparedStatement=null;
    private  static Connection connection= ConnectionHelper.connectionHel();
    private static ResultSet resultSet=null;
    private  static String INsertQuery="insert into Film values(?,?,?,?,?)";
    private static String displayAllFilm="select * from Film";

    private static String updateFilmName="update film set film_name=? where film_id=?";
    private static String updateFilmYear="update film set film_year=? where film_name=?";
    private static String updateFilmLang="update film set film_lang=? where film_name=?";
    private static String updateFilmRating="update film set film_rating=? where film_name=?";
    @Override
    public int addFilm(Film film) {
        try {
            preparedStatement=connection.prepareStatement(INsertQuery);
            preparedStatement.setInt(1,film.getFilm_id());
            preparedStatement.setString(2, film.getFilm_name());
            preparedStatement.setInt(3,film.getFilm_year());
            preparedStatement.setString(4,film.getFilm_lang());
            preparedStatement.setDouble(5,film.getFilm_rating());

            int count=preparedStatement.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Film> displayFilmData() {
        ArrayList<Film> data =new ArrayList<>();

        try {
            preparedStatement=connection.prepareStatement(displayAllFilm);
            resultSet=preparedStatement.executeQuery();
            Film film;
            while (resultSet.next()){
                film=new Film();
                film.setFilm_id(resultSet.getInt(1));
                film.setFilm_name(resultSet.getString(2));
                film.setFilm_year(resultSet.getInt(3));
                film.setFilm_lang(resultSet.getString(4));
                film.setFilm_rating(resultSet.getDouble(5));

                data.add(film);
            }
            return data;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateFilmName(Film film) {
        try {
            preparedStatement=connection.prepareStatement(updateFilmName);
            preparedStatement.setString(1,film.getFilm_name());
            preparedStatement.setInt(2,film.getFilm_id());

           int count= preparedStatement.executeUpdate();
           return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       // return 0;
    }

    @Override
    public int updateFilmYear(Film film) {
        try {
            preparedStatement=connection.prepareStatement(updateFilmYear);
            preparedStatement.setInt(1,film.getFilm_year());
            preparedStatement.setString(2,film.getFilm_name());
           int count= preparedStatement.executeUpdate();
           return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateFilmLang(Film film) {
        try {
            preparedStatement=connection.prepareStatement(updateFilmLang);
            preparedStatement.setString(1,film.getFilm_lang());
            preparedStatement.setString(2,film.getFilm_name());
           int count= preparedStatement.executeUpdate();
           return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateFilmRating(Film film) {
        try {
            preparedStatement=connection.prepareStatement(updateFilmRating);
            preparedStatement.setDouble(1,film.getFilm_rating());
            preparedStatement.setString(2,film.getFilm_name());
            int count=preparedStatement.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
