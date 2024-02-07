package JDBCFinalTest.Question1.Utility;

import JDBCFinalTest.Question1.Model.Film;

import java.util.ArrayList;
import java.util.Scanner;

//Write a java program to store values into your
//        database. Accept film_id,film_name , film_year ,
//        film_lang, film_rating from the end user and store them
//        into your database table.
//        (Note: id should be auto incremented and use
//        Prepared-Statement Interface.)
public class MainApp {
    private  static FilmINterFace filmOperation=new filmOperationDAO();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        operation();
    }

    private static void operation() {
        boolean status=true;
        while (status){
            System.out.println("\n***OPERATIONS***\n");
            System.out.println("1:ADD FILM INFO");
            System.out.println("2:DISPLAY FILM DATA");
            System.out.println("3:UPDATE EXISTING FILM RECORD");
            System.out.println("4:EXIT");
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
                   UpdateFilm();
                    break;
                    case 4:
                    status=false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
           }
        }
    }

    private static void UpdateFilm() {
        Film film = new Film();

        boolean status=true;
        while (status){
            System.out.println("-------------------------------");
            System.out.println("What do you want to update ?");
            System.out.println("--------------------------------");
            System.out.println("1:Film name");
            System.out.println("2:Film Yeat");
            System.out.println("3:Film lang");
            System.out.println("4:Film rating ");
            System.out.println("5:Exit ");
            int choice= scanner.nextInt();
            int count=0;
            switch (choice){
                case 1:
                    updateFilmName();
                    break;
                case 2:
                    updateFilmYear();
                    break;
                case 3:
                    updateFIlmLang();
                    break;
                case 4:
                    updateFilmRating();
                    break;
                case 5:
                    status=false;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
    }
    private static void countInfo(int count){
        System.out.println("-------------------------------------------");
        if (count>0){
            System.out.println(count+" record updated successfully");
        }else {
            System.out.println("SOMETHING WENT WRONG !!!");
        }
        System.out.println("-------------------------------------------");
    }

    private static void updateFilmRating() {
        Film film = new Film();
        System.out.println("Enter existing film name: ");
        String filmName= scanner.nextLine();
        System.out.println("Enter  updated film rating: ");
        double filmRating= scanner.nextDouble();

        film.setFilm_name(filmName);
        film.setFilm_rating(filmRating);
        int count=  filmOperation.updateFilmRating(film);
        countInfo(count);
    }

    private static void updateFIlmLang() {
        Film film = new Film();
        System.out.println("Enter existing film name: ");
        scanner.nextLine();
        String filmName= scanner.nextLine();
        System.out.println("Enter updated  film Language : ");
        String updFilmLang= scanner.next().toUpperCase();
        film.setFilm_name(filmName);
        film.setFilm_lang(updFilmLang);
        int count= filmOperation.updateFilmLang(film);
        countInfo(count);
    }

    private static void updateFilmYear() {
        Film film = new Film();
        System.out.println("Enter existing film name: ");
        String filmName= scanner.nextLine();
        System.out.println("Enter  updated film year: ");
        int filmYear= scanner.nextInt();

        film.setFilm_name(filmName);
        film.setFilm_year(filmYear);
        int count= filmOperation.updateFilmYear(film);
        countInfo(count);
    }

    private static void updateFilmName() {

        System.out.println("Enter existing film id: ");
        int filmId= scanner.nextInt();
        System.out.println("Enter updated  film name: ");
        scanner.nextLine();
        String updFilmName= scanner.nextLine().toUpperCase();
        Film film = new Film();
        film.setFilm_id(filmId);
        film.setFilm_name(updFilmName);


        int count= filmOperation.updateFilmName(film);
        countInfo(count);
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
