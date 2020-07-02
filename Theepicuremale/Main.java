package Theepicuremale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Healthyburger h=new Healthyburger("beef");
        h.options();
        h.getprice();
        Deluxburger d=new Deluxburger("beef");
        d.options();
        d.getprice();
    }
}
