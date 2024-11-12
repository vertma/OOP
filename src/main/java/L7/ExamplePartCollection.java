package L7;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class ExamplePartCollection<T> {
    private ExamplePartCollection<T> previous;
    private ExamplePartCollection<T> next;
    private T value;

    // Конструктор для создания узла с значением
    public ExamplePartCollection(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamplePartCollection<?> that = (ExamplePartCollection<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
