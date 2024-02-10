package iplpointstable;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
    private static Connection con;
    private  static Statement st;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavajdbc","root","hrutik");
            st= con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        operation();

    }
    private static void operation(){
        Scanner sc= new Scanner(System.in);

        boolean status =true;
        while (status) {
            System.out.println("==========================");
            System.out.println("SELECT QUESTION ");
            System.out.println("1: Question 1");
            System.out.println("2: Question 2");
            System.out.println("3: Question 3");
            System.out.println("4: Question 4");
            System.out.println("5: Question 5");
            System.out.println("6: Exit ");
            System.out.println("==========================");
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    question1();
                    break;
                case 2:
                    question2();
                    break;
                case 3:
                    question3();
                    break;
                case 4:
                    question4();
                    break;
                case 5:
                    question5();
                    break;
                case 6:
                    status=false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    //2nd method
    private static void question1(){
        String s1="select * from ipl order by win desc, nrr desc";
        System.out.println("Position\tTeam\tPlayed\tWin\tLoss\tnr\tnrr\tpoints");

        int pos=1;
        try {
            ResultSet rs=st.executeQuery(s1);
            while(rs.next()){
                System.out.println(pos+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getInt(6)+"\t\t"+rs.getDouble(7)+"\t\t"+rs.getInt(8));
                pos++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void question2(){
        String s1="select t1.team as TeamName,t2.team as TeamName , t2.win as TeamWins from ipl t1 inner join ipl t2 on t1.win=t2.win and t1.pos>t2.pos";
        System.out.println("TeamName TeamName TotalWins");
        try {
            ResultSet rs=st.executeQuery(s1);
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t\t   "+rs.getString(2)+"\t\t\t"+rs.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void question3(){
        String s1="select team as TeamName from ipl order by win desc,nrr desc limit 4";
      //  String s1= "select * from ipl_point_table order by win desc,nrr desc limit 4");
        System.out.println("Position  Team Name");
        int pos=1;
        try{
            ResultSet rs=st.executeQuery(s1);
           while(rs.next()){
               System.out.println(pos+"\t"+rs.getString(1));
               pos++;
           }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    private static void question4(){
        try {
            st.executeUpdate(  "update ipl set nrr = round((0.15 * nrr) + nrr, 4) where pos = (select pos from (select pos from ipl where win = (SELECT ROUND(AVG(win), 0) FROM ipl) ORDER BY nrr LIMIT 1) AS subquery)");
            ResultSet s = st.executeQuery("select * from ipl");
            System.out.println("================Update Successfully new Table Record are==============");
            System.out.println("POS\tTeam\tMatch\twin\tLoss\tnr\tnrr");
            int pos = 1;
            while (s.next()) {
                System.out.println((pos++) + "\t" + s.getString(2) + "\t" + s.getInt(3) + "\t"
                        + s.getInt(4) + "\t" + s.getInt(5) + "\t" + s.getInt(6)
                        + "\t" + s.getFloat(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void question5(){
        try {
            st.executeUpdate("delete from ipl where pos not in (select pos from (select pos from ipl order by win desc,nrr desc limit 4 )as subquery)");
            ResultSet rs=st.executeQuery("select * from ipl");
            System.out.println("POS\tTeam\tMatch\twin\tLoss\tnr\tnrr");

            int pos=1;
            while(rs.next()){
                System.out.println(pos+++"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7));
               // System.out.println(pos+++"\t"+rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
