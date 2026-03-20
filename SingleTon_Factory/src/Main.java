import factory.RoadLogistics;
import factory.SeaLogistics;
import factory.TransportFactory;
import singleton.LogisticsManager;

public class Main {
    public static void main(String[] args) {
        LogisticsManager manager = LogisticsManager.getInstance();
        manager.manage("Starting logistics system !!!");

        System.out.println("---Local Order ---");
        TransportFactory roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        System.out.println("--- Global Order ---");
        TransportFactory seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}