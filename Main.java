package Theepicuremale;

import java.util.Scanner;

public class Main {
    public static Scanner sin=new Scanner(System.in);
    public static void main(String[] args) {
        Albumn ab1=new Albumn("Justin Beiber");
        ab1.addsong("As Long as You Love me",1.20);
        ab1.addsong("let Love me",2.20);
        ab1.addsong("Baby",3.20);




        Playlist p=new Playlist("Namans");
        p.addalbumn(ab1);
        p.addalbumn("yolo");
        p.addsonginalbumn("yolo","one and only",3.20);
        p.addsonginalbumn("yolo","Kali range",3.14);
        p.addsonginalbumn("yolo","Dhaka",3.14);
        p.addsonginalbumn("yolo","Lifestyle",3.14);
        p.addsongtoplaylist("yolo","one and only");
        p.addsongtoplaylist("yolo","Kali range");
        p.addsongtoplaylist("yolo","Dhaka");
        p.addsongtoplaylist("yolo","Lifestyle");

        int x=1;
        while (x!=0) {
            System.out.println("1. To create a albumn");
            System.out.println("2. To Add a Song into a albumn");
            System.out.println("3. To Add Songs to playlist");
            System.out.println("4. To Start Playing Playlist From the Start");
            System.out.println("5. To play previous song");
            System.out.println("6. To play next song");
            System.out.println("7. To repeat current song");
            System.out.println("8. To remove current song");
            System.out.println("9. To See all songs in playlist");
            System.out.println("0. To Exit Application");
            x=sin.nextInt();
            switch(x){
                case 0:
                    sin.close();
                    System.out.println("Application closed.");break;
                case 1:
                    System.out.println("Enter Name of New Albumn");
                    sin.nextLine();
                    p.addalbumn(sin.nextLine());break;
                case 2:
                    System.out.println("Enter Name of albumn of song and its title and duration in minutes");
                    sin.nextLine();
                    p.addsonginalbumn(sin.nextLine(),sin.nextLine(),sin.nextDouble());break;
                case 3:
                    System.out.println("Enter Name of albumn of song and its title");
                    sin.nextLine();
                    p.addsongtoplaylist(sin.nextLine(),sin.nextLine());break;
                case 4:
                    p.startplaylist();break;
                case 6:p.nextsong();break;
                case 5:p.previoussong();break;
                case 7:p.repeatsong();break;
                case 8:p.removecurrent();break;
                case 9:p.totalsongs();break;
                default:
                    System.out.println("please enter a valid i/p");
            }
        }
    }
}
