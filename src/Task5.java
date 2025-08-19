import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, -10, 7, 3, 5, 1};
        System.out.println(Arrays.toString(duplicates(numbers)));
    }

    public static int[] duplicates(int[] numbers) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        LinkedList<Integer> duplicates = new LinkedList<>();
        for (int num : numbers) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }

        int[] result = new int[duplicates.size()];
        for (int i = 0; i < duplicates.size(); i++) {
            result[i] = duplicates.get(i);
        }
        return result;
    }
}
