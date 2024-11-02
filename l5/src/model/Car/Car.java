package model.Car;

import L5.model.Client.Client;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Car {
    @Getter
    private final CarType carType;
    private final List<Client> clients;

    public Car(CarType carType) {
        this.carType = carType;
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void clearCar() {
        clients.clear();
    }

    public void removeClientFromCar(Client client) {
        clients.removeIf(c -> c.equals(client));
    }

    public void addClientToCar(Client client) {
        clients.add(client);
    }
}

