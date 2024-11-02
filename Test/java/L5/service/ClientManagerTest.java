package L5.service;

import L5.exception.InvalidDateException;
import L5.model.Car.CarType;
import L5.model.Client.Client;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientManagerTest {
    private static final Client client = new Client("John Doe", CarType.SUV, LocalDate.of(1990, 5, 15), null);
    private static final String VALID_DATE = "2024-11-15";
    private static final String INVALID_DATE_FORMAT = "2024/11/15";
    private static final String PAST_DATE = "2023-01-01";
    private final ClientManager clientManager = new ClientManager();

    @Test
    @DisplayName("Позитивный тест: проверка установки правильной даты аренды")
    void testSetValidRentalDate() throws InvalidDateException {
        clientManager.setRentalDate(client, VALID_DATE);
        assertEquals(LocalDate.parse(VALID_DATE), client.getRentalDate(), "Дата аренды не соответствует ожидаемой.");
    }

    @Test
    @DisplayName("Негативный тест: проверка установки даты аренды в неправильном формате.\n" +
            "Ожидается исключение InvalidDateException")
    void testInvalidDateFormat() {
        assertThrows(InvalidDateException.class,
                () -> clientManager.setRentalDate(client, INVALID_DATE_FORMAT),
                "Ожидалось исключение InvalidDateException из-за неверного формата даты.");
    }

    @Test
    @DisplayName("Негативный тест: проверка установки даты аренды в прошлом.\n" +
            "Ожидается исключение InvalidDateException.")
    void testPastDate() {
        assertThrows(InvalidDateException.class,
                () -> clientManager.setRentalDate(client, PAST_DATE),
                "Ожидалось исключение InvalidDateException из-за попытки установки прошедшей даты.");
    }
}