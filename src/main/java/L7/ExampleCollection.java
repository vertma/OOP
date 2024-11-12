package L7;

import java.util.Iterator;

public class ExampleCollection<T> implements Iterable<ExamplePartCollection<T>> {
    private ExamplePartCollection<T> head;
    private ExamplePartCollection<T> tail;
    private int size;

    public void add(T value) {
        ExamplePartCollection<T> newPart = new ExamplePartCollection<>(value);
        if (tail == null) {
            head = newPart;
            tail = newPart;
        } else {
            tail.setNext(newPart);
            newPart.setPrevious(tail);
            tail = newPart;
        }
        size++;
    }

    public ExamplePartCollection<T> delete() {
        if (head == null) {
            throw new LinkedListException("Cannot delete from empty list");
        }
        ExamplePartCollection<T> removed = head;
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        size--;
        return removed;
    }

    public ExamplePartCollection<T> delete(T value) {
        ExamplePartCollection<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    tail = current.getPrevious();
                }
                size--;
                return current;
            }
            current = current.getNext();
        }
        throw new LinkedListException("Cannot delete from empty list");
    }

    public ExamplePartCollection<T> findByValue(T value) {
        ExamplePartCollection<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        throw new LinkedListException("Cannot delete from empty list");
    }

    public int size() {
        return size;
    }

    public ExamplePartCollection<T> getHead() {
        return head;
    }

    public ExamplePartCollection<T> getTail() {
        return tail;
    }

    @Override
    public Iterator<ExamplePartCollection<T>> iterator() {
        return new Iterator<ExamplePartCollection<T>>() {
            private ExamplePartCollection<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public ExamplePartCollection<T> next() {
                ExamplePartCollection<T> temp = current;
                current = current.getNext();
                return temp;
            }
        };
    }
}
