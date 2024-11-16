package L7;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class ExamplePartCollection {
    private ExamplePartCollection previous;
    private ExamplePartCollection next;
    private Object value;

    public ExamplePartCollection(Object value) {
        this.value = value;
    }

    public ExamplePartCollection getPrevious() {
        return previous;
    }

    public void setPrevious(ExamplePartCollection previous) {
        this.previous = previous;
    }

    public ExamplePartCollection getNext() {
        return next;
    }

    public void setNext(ExamplePartCollection next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
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
        ExamplePartCollection that = (ExamplePartCollection) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
