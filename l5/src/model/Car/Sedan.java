package model.Car;


import L5.model.Client.Client;

public class Sedan extends Car {
    public Sedan() {
        super(CarType.SEDAN);
    }

    @Override
    public void clearCar() {
        getClients().clear();
    }

    @Override
    public void removeClientFromCar(Client client) {
        getClients().removeIf(c -> c.equals(client));
    }

    @Override
    public void addClientToCar(Client client) {
        getClients().add(client);
    }
}

