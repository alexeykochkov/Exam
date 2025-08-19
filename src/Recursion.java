public class Recursion {
    public static void main(String[] args) {
        String s = "Hello World";
        String reversed = reverseString(s);
        System.out.println(reversed); // Выведет: "dlroW olleH"

        int index = s.length()-1;
        System.out.println(reverseString2(s,index));
    }

    // Рекурсивная функция для разворота строки
    public static String reverseString(String str) {
        // Базовый случай: если строка пустая или односимвольная
        if (str.length() <= 1) {
            return str;
        }
        // Рекурсивный вызов: берем последний символ и ставим впереди обратного порядка остальных символов
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static String reverseString2(String str, int index) {
        if (index == 0) {
            return String.valueOf(str.charAt(0));
        }else {
            char symbal = str.charAt(index);
            return symbal + reverseString2(str, index - 1);
        }
    }
}
