package model.Client;

import L5.model.Car.CarType;

import java.time.LocalDate;
import java.util.Objects;


public class Client {
    private String name;
    private CarType preferredCarType;
    private LocalDate birthDate;
    private LocalDate rentalDate;

    public Client(String name, CarType preferredCarType, LocalDate birthDate, LocalDate rentalDate) {
        this.name = name;
        this.preferredCarType = preferredCarType;
        this.birthDate = birthDate;
        this.rentalDate = rentalDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarType getPreferredCarType() { // Добавили геттер
        return preferredCarType;
    }

    public void setPreferredCarType(CarType preferredCarType) {
        this.preferredCarType = preferredCarType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        return Objects.equals(name, other.name) &&
                preferredCarType == other.preferredCarType &&
                birthDate.equals(other.birthDate) &&
                rentalDate.equals(other.rentalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preferredCarType, birthDate, rentalDate);
    }
}


