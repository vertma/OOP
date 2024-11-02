package L5.service;

import L5.exception.CarIsRentedException;
import L5.exception.WrongCarTypeException;
import L5.model.Car.Car;
import L5.model.Car.CarType;
import L5.model.Client.Client;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

// Объявляем логгер
@Slf4j
public class CarRentalManager {
    final Map<CarType, Car> cars = new HashMap<>();

    public void addClientToCar(Car car, Client client) throws WrongCarTypeException {
        try {
            checkCarAvailabilityAndType(car, client);
            car.addClientToCar(client);
            cars.put(car.getCarType(), car);
            log.info("Клиенту присвоен нужный тип автомобиля: {}", car.getCarType());
        } catch (CarIsRentedException | WrongCarTypeException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            logRentalStatus(car);
        }
    }

    private void logRentalStatus(Car car) {
        if (cars.containsKey(car.getCarType())) {
            log.info("Автомобиль {} доступен.", car.getCarType());
        } else {
            log.warn("Автомобиль {} не доступен.", car.getCarType());
        }
    }

    private void checkCarAvailabilityAndType(Car car, Client client) throws CarIsRentedException, WrongCarTypeException {
        // Проверяем тип автомобиля
        if (car.getCarType() != client.getPreferredCarType()) {
            throw new WrongCarTypeException("Клиент запросил другой тип автомобиля: " + client.getPreferredCarType());
        }
        // Проверяем доступность автомобиля
        if (!car.getClients().isEmpty()) { // Проверяем на занятость
            throw new CarIsRentedException("Запрашиваемый тип автомобиля в данный момент недоступен.");
        }
    }
}

