import java.util.*;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        Map<String, Integer> natural = Map.of("s", 1, "b", 2);
        System.out.println(reverse(natural));

        List<String> family = List.of("Alex", "Bob", "Andy");
        System.out.println(filterNames(family));

        String name = "Аргентина манит негра";
        System.out.println(isPalindrome(name));

        List<Integer> integer = List.of(1, -2, 5, -10);
        System.out.println(module(integer));

        String alligator = "alligator";
        System.out.println(count(alligator));

        List<Integer> integers = List.of(1, 2, 3, 4, 4);
        System.out.println(deleteDuplicates(integers));

        String string = "упади семь раз и восемь раз поднимись";
        System.out.println(countWords(string));

    }

    public static Map<Integer, String> reverse(Map<String, Integer> map) {
        Map<Integer, String> rev = new HashMap<>();
        for (Map.Entry<String, Integer> temp : map.entrySet()) {
            rev.put(temp.getValue(), temp.getKey());
        }
        return rev;
    }

    public static List<String> filter(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("A")) {
                result.add(name);
            }
        }
        return result;
    }

    public static boolean isPalindrome(String string) {
        String[] all = string.toLowerCase().split(" ");
        String result = String.join("", all);
        StringBuilder reverce = new StringBuilder(result);
        reverce.reverse();
        return result.equals(reverce.toString());
    }

    public static List<Integer> module(List<Integer> list) {
        return list.stream()
                .map(Math::abs).collect(Collectors.toList());
    }

    public static List<String> filterNames(List<String> list) {
        return list.stream()
                .filter(x -> x.startsWith("A"))
                .collect(Collectors.toList());
    }

    public static int count(String string) {
        char[] chars = string.toCharArray();
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                counter++;
            }
        }
        return counter;
    }

    public static List<Integer> deleteDuplicates(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (Integer element : list) {
            if (!set.contains(element)) {
                result.add(element);
                set.add(element);
            }
        }
        return result;
    }

    public static Map<String, Integer> countWords(String string) {
        Map<String, Integer> count = new HashMap();
        String[] splitString = string.toLowerCase().split(" ");
        for (String element : splitString) {
            count.put(element, count.getOrDefault(element, 0) + 1);
        }
        return count;
    }
}
