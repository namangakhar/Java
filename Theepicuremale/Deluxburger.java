package Theepicuremale;

import java.util.Scanner;

public class Deluxburger extends hamburger{
    private boolean chips,drinks;
    public Deluxburger(String meat)
    {
        super("",meat,19.99);
    }
    public void options()
    {
        System.out.println("The Options available are :\n" +"1. Chips\n"+"2. Drinks\n\n\n" + "Press the number corresponding to option you want ");
        Scanner sin = new Scanner(System.in);
        int x = sin.nextInt();
        switch (x) {
            case 1:
                chips=true;
                options+=.60;
                break;
            case 2:
                drinks=true;
                options+=1;
                break;
            default:
                System.out.println("Invalid entry");
                sin.close();
        }
    }
    public void dispoptions()
    {
        if (chips)
            System.out.println("Chips are 60 cents");
        if (drinks)
            System.out.println("Drinks are 1.00 Dollar");
    }
    public void getprice()
    {
        super.getbaseprice();
        dispoptions();
        super.gettotalprice();
    }




}
