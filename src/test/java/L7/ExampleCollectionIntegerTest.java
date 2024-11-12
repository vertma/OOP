package L7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleCollectionIntegerTest {
    ExampleCollection<Integer> list = new ExampleCollection<>();

    @Test
    void addElemTest() {
        list.add(5);
        assertEquals(1, list.size());
        assertEquals(5, list.getHead().getValue());
        assertEquals(5, list.getTail().getValue());

        list.add(7);
        assertEquals(2, list.size());
        assertEquals(5, list.getHead().getValue());
        assertEquals(7, list.getTail().getValue());

        list.add(6);
        assertEquals(3, list.size());
        assertEquals(5, list.getHead().getValue());
        assertEquals(6, list.getTail().getValue());
    }

    @Test
    void findByElemTest() {
        list.add(5);
        list.add(7);
        list.add(6);

        assertEquals(6, list.findByValue(6).getValue());  // Ожидаем 6
        assertEquals(5, list.findByValue(5).getValue());  // Ожидаем 5
        assertEquals(7, list.findByValue(7).getValue());  // Ожидаем 7
    }

    @Test
    void deleteElemTest() {
        list.add(5);
        list.add(7);
        list.add(6);

        // Удаляем элемент по значению
        ExamplePartCollection<Integer> deleted = list.delete(5);
        assertEquals(2, list.size());
        assertEquals(7, list.getHead().getValue());

        // Удаляем первый элемент
        ExamplePartCollection<Integer> deletedHead = list.delete();
        assertEquals(1, list.size());
        assertEquals(6, list.getTail().getValue());
    }

    // Тест на исключения при операциях с пустым списком
    @Test
    void ExceptionsTest() {
        assertThrows(LinkedListException.class,
                () -> list.delete());
        list.add(5);
        assertThrows(LinkedListException.class,
                () -> list.findByValue(7));
        assertThrows(LinkedListException.class,
                () -> list.delete(7));
    }
}