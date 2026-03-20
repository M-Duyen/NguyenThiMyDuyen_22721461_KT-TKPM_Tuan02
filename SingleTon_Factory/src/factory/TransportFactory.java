package factory;

import model.Transport;

public abstract class TransportFactory {
    public abstract Transport createTransport();

    public void planDelivery(){
        Transport t = createTransport();
        t.delever();
    }
}

