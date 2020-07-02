package Theepicuremale;

import java.lang.management.PlatformLoggingMXBean;

public class Main {

    public static void main(String[] args) {
        Playlist p=new Playlist("Namans");
        p.addalbumn("Yolo");
        p.addsonginalbumn("yolo","los one and only",3.14);
        p.addsonginalbumn("yolo","Simba aala",3.14);
        p.addsonginalbumn("yolo","jalebi bai",3.14);
        p.addsonginalbumn("yolo","chikni chameli",3.14);
        p.addsongtoplaylist("yolo","los one and only");
        p.addsongtoplaylist("yolo","Simba aala");
        p.addsongtoplaylist("yolo","jalebi bai");
        p.addsongtoplaylist("yolo","chikni chameli");
        //p.totalsongs();
        p.nextsong();
        p.nextsong();
        p.nextsong();
        p.nextsong();
        p.previoussong();
        p.previoussong();
        p.previoussong();
        p.previoussong();
        p.previoussong();
        System.out.println("now forwand");
        p.nextsong();
        p.nextsong();
        System.out.println("now r");
        p.repeatsong();
        p.repeatsong();
        p.addsongtoplaylist("yolo","Life is changing");
        p.nextsong();
        p.nextsong();
        p.nextsong();
        p.nextsong();
        p.nextsong();
        p.nextsong();
        p.nextsong();
    }
}
