package model;

public class Ship implements Transport{
    @Override
    public void delever() {
        System.out.println("Transporting goods across the sea with a ship.");
    }
}
