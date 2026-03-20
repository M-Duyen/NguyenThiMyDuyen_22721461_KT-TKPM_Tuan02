package factory;

import model.Ship;
import model.Transport;

public class SeaLogistics extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
