import java.util.*;

public class Task1 {
    public static void main(String[] args) {
// Удалить дубликаты из сортированного списка с помощью коллекций

        //        Реализуй программу, которая поменяет ключи и значения в HashMap местами
//        На вход в метод поступает HashMap<Integer, String>, надо вернуть HashMap<String, Integer>


        int[] sortedList = {1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 8, 8, 9, 9, 10};
        System.out.println(Arrays.toString(duplicates2(sortedList)));
        HashMap<Integer, String> newMap = new HashMap();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        System.out.println(newMap);
        System.out.println(newMap(newMap));

    }

    public static Set<Integer> duplicates(int[] ints) {
        Set<Integer> set = new HashSet<>();
        for (int nums : ints) {
            set.add(nums);
        }
        return set;
    }

    public static int[] duplicates2(int[] ints) {
        return Arrays.stream(ints)
                .distinct()
                .toArray();
    }

    public static HashMap<String, Integer> newMap(HashMap<Integer, String> map) {
        HashMap<String, Integer> newMap2 = new HashMap<>();
        for (Map.Entry<Integer, String> temp : map.entrySet()) {
            newMap2.put(temp.getValue(), temp.getKey());
        }
        return newMap2;
    }
}
