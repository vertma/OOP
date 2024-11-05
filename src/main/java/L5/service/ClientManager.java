package L5.service;

import L5.exception.InvalidDateException;
import L5.model.Client.Client;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ClientManager {

    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    public void setRentalDate(Client client, String date) {
        validateDate(date);
        client.setRentalDate(LocalDate.parse(date));
    }

    private void validateDate(String date) {
        if (!DATE_PATTERN.matcher(date).matches()) {
            throw new InvalidDateException("Date format should be YYYY-MM-DD");
        }
        if (LocalDate.parse(date).isBefore(LocalDate.now())) {
            throw new InvalidDateException("Cannot set a past date for rental.");
        }
    }
}