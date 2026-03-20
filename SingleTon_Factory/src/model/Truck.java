package model;

public class Truck implements Transport{
    @Override
    public void delever() {
        System.out.println("Transporting goods on the road with a truck.");
    }
}
