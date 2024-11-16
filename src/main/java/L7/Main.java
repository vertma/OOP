package L7;

public class Main {
    public static void main(String[] args) {
        ExampleCollection list = new ExampleCollection();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println("Размер после добавления 5 элементов: " + list.size());
        ExamplePartCollection found = list.findByValue("E");
        System.out.println("Найденный элемент: " + (found != null ? found.getValue() : "не найдено"));
        ExamplePartCollection deleted = list.delete("B");
        System.out.println("Удаленный элемент: " + (deleted != null ? deleted.getValue() : "не найдено"));
        System.out.println("Размер после удаления элемента: " + list.size());
        ExamplePartCollection deletedHead = list.delete();
        System.out.println("Удаленный первый элемент: " + (deletedHead != null ? deletedHead.getValue() : "не найдено"));
        System.out.println("Размер после удаления первого элемента: " + list.size());
        for (ExamplePartCollection part : list) {
            System.out.println("Итерация " + part.getValue());
        }
    }
}