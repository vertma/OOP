package L7;

public class Main {
    public static void main(String[] args) {
        ExampleCollection<String> list = new ExampleCollection<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("Размер после добавления 5 элементов: " + list.size());

        ExamplePartCollection<String> found = list.findByValue("F");
        System.out.println("Найденный элемент: " + (found != null ? found.getValue() : "не найдено"));

        ExamplePartCollection<String> deleted = list.delete("B");
        System.out.println("Удаленный элемент: " + (deleted != null ? deleted.getValue() : "не найдено"));

        System.out.println("Размер после удаления элемента: " + list.size());

        ExamplePartCollection<String> deletedHead = list.delete();
        System.out.println("Удаленный первый элемент: " + (deletedHead != null ? deletedHead.getValue() : "не найдено"));

        System.out.println("Размер после удаления первого элемента: " + list.size());

        for (ExamplePartCollection<String> part : list) {
            System.out.println("Итерация " + part.getValue());
        }
    }
}