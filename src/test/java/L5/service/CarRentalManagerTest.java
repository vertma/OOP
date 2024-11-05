package L5.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import L5.exception.CarIsRentedException;
import L5.exception.WrongCarTypeException;
import L5.model.Car.Car;
import L5.model.Car.CarType;
import L5.model.Car.SUV;
import L5.model.Client.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalManagerTest {
    private CarRentalManager carRentalManager;
    private Car suv;
    private Client clientSUV;

    @BeforeEach
    void setUp() {
        carRentalManager = new CarRentalManager();
        suv = new SUV();
        clientSUV = new Client("John Doe", CarType.SUV, LocalDate.of(1990, 5, 15), LocalDate.of(2024, 11, 15));
    }

    @AfterEach
    void tearDown() {
        suv.clearCar();
    }

    @Test
    void addClientToCar_success() {
        assertDoesNotThrow(() -> carRentalManager.addClientToCar(suv, clientSUV), "Должно быть возможно назначить клиента на нужный тип автомобиля.");
        assertTrue(carRentalManager.cars.containsKey(CarType.SUV), "Автомобиль должен быть добавлен в список.");
        assertEquals(1, suv.getClients().size(), "Клиент должен быть добавлен к автомобилю.");
    }

    @Test
    void addClientToCar_carIsRented() {
        assertDoesNotThrow(() -> carRentalManager.addClientToCar(suv, clientSUV)); // Занимаем машину клиентом SUV
        Client clientSedan = new Client("Jane Doe", CarType.SUV, LocalDate.of(1990, 5, 15), LocalDate.of(2024, 11, 15)); // Создаем нового клиента для SUV
        assertThrows(CarIsRentedException.class, () -> carRentalManager.addClientToCar(suv, clientSedan), "Ожидается исключение CarIsRentedException");
    }
}