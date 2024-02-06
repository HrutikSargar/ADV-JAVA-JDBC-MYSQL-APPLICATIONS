package JDBCFinalTest.Question1.Utility;

import JDBCFinalTest.Question1.Model.Film;
import javax.swing.text.DefaultEditorKit;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private  static FilmINterFace filmOperation=new filmOperationDAO();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        operation();
    }

    private static void operation() {
        boolean status=true;
        while (status){
            System.out.println("***OPERATIONS***");
            System.out.println("1:ADD FILM INFO");
            System.out.println("2:DISPLAY FILM DATA");
            System.out.println("3:EXIT");
            System.out.print("Enter Choice : ");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    addNewFilm();
                    break;
                case 2:
                    dislayFilmData();
                    break;
                case 3:
                   status=false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
           }
        }
    }

    private static void dislayFilmData() {
        ArrayList<Film> data = filmOperation.displayFilmData();
        System.out.println("FILM DATA AS BELOW");
        System.out.println("---------------------------------------------------------------");
        System.out.println("filmIDt\t\tfilmName\t\tfilmReleaseYear\tfilmLang\tfilmRating");
        for (Film f:data){
            System.out.println(f.getFilm_id()+"\t\t"+f.getFilm_name()+"\t\t\t"+f.getFilm_lang()+"\t\t\t"+f.getFilm_year()+"\t\t\t"+f.getFilm_rating());
        }
        System.out.println("---------------------------------------------------------------");

    }

    private static void addNewFilm() {
        System.out.print("ENTER FILM ID :");
        int filmId=scanner.nextInt();

        System.out.print("enter film name:");
        scanner.nextLine();
        String filmName= scanner.nextLine().toUpperCase();

        System.out.print("enter film release year:");
        int releaseYear= scanner.nextInt();

        System.out.print("enter film language:");
        String filmLang= scanner.next().toUpperCase();

        System.out.print("enter film rating : ");
        double filmRating= scanner.nextDouble();
        Film film=new Film();
        film.setFilm_id(filmId);
        film.setFilm_name(filmName);
        film.setFilm_lang(filmLang);
        film.setFilm_year(releaseYear);
        film.setFilm_rating(filmRating);

        int count=filmOperation.addFilm(film);
        if (count>0){
            System.out.println(count+" film added successfully ");
        }else {
            System.out.println("SOMETHING WENT WRONG !!!");
        }
    }
}
