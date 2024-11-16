package L7;

import java.util.Iterator;

public class ExampleCollection implements Iterable<ExamplePartCollection> {
    private ExamplePartCollection head;
    private ExamplePartCollection tail;
    private int size;

    public void add(Object value) {
        ExamplePartCollection newPart = new ExamplePartCollection(value);
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

    public ExamplePartCollection delete() {
        if (head == null) {
            throw new LinkedListException("Cannot delete from empty list");
        }
        ExamplePartCollection removed = head;
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        size--;
        return removed;
    }

    public ExamplePartCollection delete(Object value) {
        ExamplePartCollection current = head;
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

    public ExamplePartCollection findByValue(Object value) {
        ExamplePartCollection current = head;
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

    public ExamplePartCollection getHead() {
        return head;
    }

    public ExamplePartCollection getTail() {
        return tail;
    }

    @Override
    public Iterator<ExamplePartCollection> iterator() {
        return new Iterator<ExamplePartCollection>() {
            private ExamplePartCollection current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public ExamplePartCollection next() {
                ExamplePartCollection temp = current;
                current = current.getNext();
                return temp;
            }
        };
    }
}
