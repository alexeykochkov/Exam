import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task3 {

    public static void main(String[] args) {
        String string = "Привет я java я";
        System.out.println(countWords(string));
        System.out.println(Arrays.toString(array(3)));
    }

    public static Map<String, Integer> countWords(String string) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = string.split("\\s+");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> duplicates = new HashMap<>();
        for (Map.Entry<String, Integer> temp : map.entrySet()) {
            if (temp.getValue() > 1) {
                duplicates.put(temp.getKey(), temp.getValue());
            }
        }
        return duplicates;
    }

    public static int[] array(int integer) {
        int[] newArray = new int[integer];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = i*i;
        }
        return newArray;
    }
}
