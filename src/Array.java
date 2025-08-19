import java.lang.String;
import java.util.*;

public class Array {
    public static void main(String[] args) {
        int[] numbers = {9, 20, 3, 4, 5, 6, 7, 8, 9, 5, 1, 7};
        int[] arr = {1, 1, -3, 5, 6, 1, 3, -5, -9};
        String[] hello = {"Hello", "World"};
        System.out.println(union(hello));
        char some = 'a';
        String string = "Alligator";
        System.out.println(Arrays.toString(minValue(numbers)));
        System.out.println(switchNumbers(numbers));
        System.out.println(countCharInWord(some, string));

        strangeTask(arr);
        System.out.println(Arrays.toString(arr));

        int[] numbers1 = {1, 2, 3, -10, 7, 3, 5, 1};
        int[] numbers2 = {5, 8, 9, 9, 5, 8};
        System.out.println(Arrays.toString(duplicates(numbers2)));
    }

    public static String switchNumbers(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 0 && array[i + 1] % 2 != 0) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        return Arrays.toString(array);
    }

    public static int[] minValue(int[] array) {
        int minValue = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
                index = i;
            }
        }
        return new int[]{minValue, index};
    }

    public static int countCharInWord(char letter, String string) {
        char[] array = string.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == letter) {
                count++;
            }
        }
        return count;
    }

    public static int[] strangeTask(int[] arrayInt) {
        for (int i = 2; i < arrayInt.length; i = i + 3) {
            if (arrayInt[i] < 0) {
                arrayInt[i] = arrayInt[i] * 2;
            }
        }
        return arrayInt;
    }

    public static String union(String[] strings) {
        String result = String.join(" ", strings);
        return result;
    }

    public static int[] duplicates(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : numbers) {
            if (set.contains(num) && !duplicates.contains(num)) {
                duplicates.add(num);
            }

            set.add(num);
        }
        int[] result = new int[duplicates.size()];

        for (int i = 0; i < duplicates.size(); i++) {
            result[i] = duplicates.get(i);
        }
        Arrays.sort(result);
        return result;
    }

}


