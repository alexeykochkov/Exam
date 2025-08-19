import java.util.Arrays;
import java.util.Locale;

public class String_Tasks {
    public static void main(String[] args) {
        String text = "Hellow";
        String newText = "Неуд*ч* это возможность н*ч*ть снов*";
        String palindrom = "Казак";
        String annogramma1 = "кропание";
        String annogramma2 = "пионерка";
        String withoutSpace = "a b c";
        String dealDup = "abc";
        String telephone = "+7 (123) 456-7890";
        String fruits = "apple,orange,banana";

        System.out.println(rever(text));
        System.out.println(countChar(text));
        System.out.println(changeChar(newText));
        System.out.println(deleteChar(text, 'l'));
        System.out.println(isPalindrom(palindrom));
        System.out.println(annogramma(annogramma1, annogramma2));
        System.out.println(count(text, 'H'));
        System.out.println(reversedIf(text));
        System.out.println(deleteSpaces(withoutSpace));
        System.out.println(repeatCharacters(dealDup));
        System.out.println(telephoneValidate(telephone));
        System.out.println(formatFruits(fruits));
    }

    static String rever(String string) {
        int clenghs = string.length();
        char[] newChar = string.toCharArray();
        char[] chars = new char[clenghs];
        for (int i = 0; i < clenghs; i++) {
            chars[i] = newChar[clenghs - 1 - i];
        }
        return String.valueOf(chars);
    }

    public static int countChar(String string) {
        char[] array = string.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'l') {
                count++;
            }
        }
        return count;
    }

    public static String changeChar(String string) {
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '*') {
                array[i] = 'a';
            }
        }
        return new String(array);
    }

    public static String deleteChar(String string, char some) {
        char[] array = string.toCharArray();
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != some) {
                size++;
            }
        }
        char[] newArray = new char[size];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != some) {
                newArray[index] = array[i];
                index++;
            }
        }
        return new String(newArray);
    }

    public static boolean isPalindrom(String string) {
        char[] array = string.toLowerCase().toCharArray();
        int lenghtArray = array.length;
        char[] reverseArray = new char[lenghtArray];
        for (int i = 0; i < lenghtArray; i++) {
            reverseArray[i] = array[lenghtArray - 1 - i];
        }
        return Arrays.equals(array, reverseArray);
    }

    public static boolean annogramma(String string1, String string2) {
        char[] first = string1.toLowerCase().toCharArray();
        char[] second = string2.toLowerCase().toCharArray();

        if (first.length != second.length) return false;

        //сюда складывается индэкс чтобы потом его не проверять
        boolean[] used = new boolean[second.length]; // Массив для пометки
        int count = 0;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (!used[j] && first[i] == second[j]) { // Проверяем, что символ ещё не использован
                    used[j] = true; // Помечаем индекс как использованный
                    count++;
                    break;
                }
            }
        }
        return count == first.length;
    }

    public static int count(String string, char some) {
        char[] newChars = string.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < newChars.length; i++) {
            if (newChars[i] == Character.toLowerCase(some)) {
                count++;
            }
        }
        return count;
    }

    public static String reversedIf(String string) {
        char[] newChars = string.toCharArray();
        int start = 0;
        int finish = newChars.length - 1;
        for (; start <= finish; start++, finish--) {
            char stash = newChars[start];
            newChars[start] = newChars[finish];
            newChars[finish] = stash;
        }
        return String.valueOf(newChars);
    }

    public static String deleteSpaces(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                count++;
            }
        }
        int index = 0;
        char[] newArray = new char[count];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                newArray[index++] = chars[i];
            }
        }
        return Arrays.toString(newArray);
    }

    public static String repeatCharacters(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        char[] doubled = new char[chars.length * 2];

        for (int i = 0, j = 0; i < chars.length; i++) {
            doubled[j++] = chars[i];
            doubled[j++] = chars[i];
        }

        return new String(doubled);
    }

    public static String telephoneValidate(String telephone) {
        char[] telChars = telephone.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < telChars.length; i++) {
            char someChar = telephone.charAt(i);
            if (Character.isDigit(someChar)) {
                stringBuilder.append(someChar);
            }
        }
        return stringBuilder.toString();
    }

    public static String formatFruits(String fruits) {
        return Arrays.toString(fruits.toLowerCase().split("\\s*,\\s*"));
    }
}