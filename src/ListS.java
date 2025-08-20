import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Условие	Что проверяет
//startsWith("A")	Строка начинается с A (регистр важен).
//toLowerCase().startsWith("a")	Начинается с a или A.
//contains("A")	Строка содержит A в любом месте.
//equals("A")	Строка в точности равна A.

public class ListS {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Алексей", "Василий", "Александр", "Дмитрий");
        List<Integer> integer = Arrays.asList(1, 2, 3, 6);
        List<Integer> numbers = Arrays.asList(1, 3, -5, 8);
        System.out.println(makeAllPositive(numbers));


        System.out.println(onlyA(list));
        System.out.println(count(integer));
        System.out.println(newList(integer));
        System.out.println("сортировка"+ sorted(integer));
        System.out.println("сортировка2"+ sorted2(integer));
    }

    public static List<String> onlyA(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            if (current.startsWith("А")) {
                newList.add(current);
            }
        }
        return newList;
    }

    public static int count(List<Integer> listOfInt) {
        int count = 0;
        for (int i = 0; i < listOfInt.size(); i++) {
            if (i % 2 != 0) {
                count = count + listOfInt.get(i);
            }
        }
        return count;
    }

    public static List<Integer> newList(List<Integer> list) {
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                count.add(list.get(i));
            }
        }
        return count;
    }

    public static List<Integer> makeAllPositive(List<Integer> list) {
        List<Integer> allPositive = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                allPositive.add(list.get(i));
            } else {
                int negative = list.get(i) * -1;
                allPositive.add(negative);
            }
        }
        return allPositive;
    }

    public static List<Integer> sorted(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        return sorted;
    }

    public static List<Integer> sorted2(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);

        for (int i = 0; i < sorted.size(); i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i) > sorted.get(j)) {
                    // Меняем местами
                    int temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }
}
