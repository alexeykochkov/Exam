import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapS {
    public static void main(String[] args) {
        String some = "Hellow";
        int[] numbers = {9, 20, 3, 4, 5, 6, 7, 8, 9, 5, 3, 7};
        Map<String, Integer> map = Map.of("a", 1, "b", 2);
        System.out.println(count(numbers));
        System.out.println(countCharMap(some));
        System.out.println(duplicates(numbers));
        System.out.println(mapDuplicates(numbers));
        System.out.println(reverseMap(map));
    }

    public static Map<String, Integer> countCharMap (String string) {
        Map<String,Integer> map = new HashMap<>();
        char[] charsArray = string.toCharArray();
        int lengh = charsArray.length;
        for (int i=0; i<lengh; i++) {
            map.put(String.valueOf(charsArray[i]), map.getOrDefault(String.valueOf(charsArray[i]), 0)+1);
        }
        Map<String,Integer> duplicatesMap = new HashMap<>();
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            if (entry.getValue()>1){
                duplicatesMap.put(entry.getKey(), entry.getValue());
            }
        }
        return duplicatesMap;
    }

    public static java.util.Map<Integer, Integer> count(int[] some) {
        java.util.Map<Integer, Integer> collect = new HashMap<>();
        for (int x : some) {
            collect.put(x, collect.getOrDefault(x, 0) + 1);
        }
        return collect;
    }

    public static Set<Integer> duplicates(int[] array) {
        Set<Integer> map = new HashSet<>();
        Set<Integer> newMap = new HashSet<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (map.contains(array[i])) {
                newMap.add(array[i]);
            } else {
                map.add(array[i]);
            }
        }
        return map;
    }

    public static java.util.Map<Integer, Integer> mapDuplicates(int[] array) {
        java.util.Map<Integer, Integer> map = new HashMap<>() {
        };
        for (int x : array) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        java.util.Map<Integer, Integer> duplicate = new HashMap<>();
        for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicate.put(entry.getKey(), entry.getValue());
            }
        }
        return duplicate;
    }

    public static java.util.Map<Integer, String> reverseMap (java.util.Map<String, Integer> map) {
        java.util.Map<Integer, String> reverMap = new HashMap();
        for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value =  entry.getValue();
            reverMap.put(value, key);
        }
        return reverMap;
    }
}
