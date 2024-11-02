package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Objects;

// Класс заявки на ремонт
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RepairRequest {
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairRequest that = (RepairRequest) o;
        return id == that.id &&
                title.equals(that.title) &&
                client.equals(that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, client);
    }
}
