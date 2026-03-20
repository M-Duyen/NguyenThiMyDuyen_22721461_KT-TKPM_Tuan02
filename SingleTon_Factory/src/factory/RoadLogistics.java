package factory;

import model.Transport;
import model.Truck;

public class RoadLogistics extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
