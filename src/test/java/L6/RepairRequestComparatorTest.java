package L6;

import L6.model.Client;
import L6.model.RepairRequest;
import L6.model.comparator.RepairRequestTitleComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RepairRequestComparatorTest {

    private static Client client1 = new Client()
            .setName("John")
            .setSurname("Doe")
            .setPhoneNumber("123456789");
    private static Client client2 = new Client()
            .setName("Jane")
            .setSurname("Smith")
            .setPhoneNumber("987654321");

    private static RepairRequest request1 = new RepairRequest()
            .setId(1)
            .setTitle("Fix washing machine")
            .setClient(client1);
    private static RepairRequest request2 = new RepairRequest()
            .setId(2)
            .setTitle("Repair air conditioner")
            .setClient(client2);

    @Test
    @DisplayName("Сортировка только по клиенту")
    void sortByClient() {
        List<RepairRequest> requests = new ArrayList<>();
        requests.add(request2);
        requests.add(request1);
        requests.sort(Comparator.comparing(RepairRequest::getClient));
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    @Test
    @DisplayName("Сортировка только по id")
    void sortById() {
        List<RepairRequest> requests = new ArrayList<>();
        requests.add(request2);
        requests.add(request1);
        requests.sort(Comparator.comparing(RepairRequest::getId));
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    @Test
    @DisplayName("Сортировка только по названию")
    void sortByTitle() {
        List<RepairRequest> requests = new ArrayList<>();
        requests.add(request2);
        requests.add(request1);
        requests.sort(new RepairRequestTitleComparator());
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }
}