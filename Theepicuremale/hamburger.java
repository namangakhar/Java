package Theepicuremale;

import java.sql.SQLOutput;
import java.util.Scanner;

public class hamburger {
    private String breadtype, meat;
    private boolean lettuce, tomato, carrot, cheese;
    private double price;
    protected double options;


    public hamburger(String breadtype, String meat, double price) {
        this.breadtype = breadtype;
        this.meat = meat;
        this.price = price;
        options = 0.0D;
    }

    public void options() {
        boolean lettuce;
        boolean tomato;
        boolean carrot;
        boolean cheese;
        System.out.println("The Options available are :\n" + "1. lettuce\n" + "2. tomato\n" + "3. Carrot\n" + "4. Cheese\n\n\n" + "Press the number corresponding to option you want ");
        Scanner sin = new Scanner(System.in);
        int x = sin.nextInt();
        switch (x) {
            case 1:
                this.lettuce = true;
                options += .20;
                break;
            case 2:
                this.tomato = true;
                options += .25;
                break;
            case 3:
                this.carrot = true;
                options += .3;
                break;
            case 4:
                cheese = true;
                options += .5;
                break;
            default:
                System.out.println("Invalid entry");
                sin.close();
        }
    }
    protected void getoptions()
    {
        if (lettuce)
            System.out.println("Lettuce 20 cent");

        if (tomato)
            System.out.println("Tomatos 25 cent");

        if (carrot)
            System.out.println("Carrots 30 cent");

        if (cheese)
            System.out.println("Cheese 50 cents");

    }
    protected void getbaseprice()
    {
        System.out.println("Burger Base Price : $" + price + "\nOptions : $"+options);
    }
    protected void gettotalprice()
    {
        System.out.println("Total Price : $" +(price+options));
    }
    public void getprice() {
        getbaseprice();
        getoptions();
        if(!(lettuce||cheese||tomato||carrot))
            System.out.println("None");
        gettotalprice();
    }

}

