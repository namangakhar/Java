package Theepicuremale;

import java.util.Scanner;

public class Healthyburger extends hamburger
{

    private boolean lowfatcheese,chilly;
    public Healthyburger(String meat)
    {
        super("Brown rye",meat,15.25);
    }
    public void options()
    {
        System.out.println("The Options available are :\n" + "1. lettuce\n" + "2. tomato\n" + "3. Carrot\n" +"4. Low fat Cheese\n"+"5. Chilly\n\n\n" + "Press the number corresponding to option you want ");
        Scanner sin = new Scanner(System.in);
        int x = sin.nextInt();
        switch (x) {
            case 1:
                options+=.20;
                break;
            case 2:
                options+=.25;
                break;
            case 3:
                options+=.3;
                break;
            case 4:
                lowfatcheese=true;
                options+=.75;
                break;
            case 5:
                chilly=true;
                options+=1;
                break;
            default:
                System.out.println("Invalid entry");
                sin.close();
        }
    }


    public void dispoptions()
    {
        if (lowfatcheese)
            System.out.println("Low Fat Cheese 75 cent");
        if (chilly)
            System.out.println("Chilly 1.00 Dollar");
    }
    public void getprice()
    {
        super.getbaseprice();
        dispoptions();
        super.gettotalprice();
    }


}
