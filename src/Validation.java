import java.util.*;

public class Validation {
    public static void main(String[] args) {
        String string = "([{}])";
        System.out.println(isValidate(string));  // true

        System.out.println(isValidate(string));
        System.out.println(isValidateNewTwo(string));
    }

    public static boolean isValidate(String string) {
        // Правильное заполнение Map: открывающая -> закрывающая
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        Deque<Character> deque = new LinkedList<>();

        for (Character ch : string.toCharArray()) {
            if (map.containsKey(ch)) {
                // Если это открывающая скобка - кладём в стек
                deque.push(ch);
            } else {
                // Когда заполнили по ключам следующий элемент } 4-ый
                // он попадает в этот блок мапа получает последний элемент у себя это }
                // они не равны и далее
                // вот тут важно! если не совпадают то мы удаляем из deque
                // тем самым уменьшая ее чтобы прошла снизу проверка deque.isEmpty() = true
                // если она пройдет то значит валидация успешная
                // а если совпадают то false
                if (deque.isEmpty() || ch != map.get(deque.pop())) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static boolean isValidateNew(String string) {
        char[] array = string.toCharArray();
        int first = 0;
        int second = 0;
        int third = 0;
        for (char c : array) {
            switch (c) {
                case '[':
                    first++;
                    break;
                case ']':
                    first--;
                    break;
                case '{':
                    second--;
                    break;
                case '}':
                    second++;
                case '(':
                    third--;
                    break;
                case ')':
                    third++;
                    break;
                default:
                    System.out.println("Не валидно");
                    ;
            }
        }
        return first == 0 && second == 0 && third == 0;
    }

    public static boolean isValidateNewTwo (String string) {
        char [] chars = string.toCharArray();
        int first = 0;
        int second = 0;
        int therd = 0;
        for (int  i = 0; i < chars.length; i ++) {
            if (i == '{') {
                first ++;
            } else if (i == '}') {
                first --;
            } else if (i == '[') {
                second ++;
            } else if (i == ']') {
                second --;
            } else if (i == '(') {
                therd++;
            } else if (i == ')') {
                therd --;
            }
        }
        return first== 0 && second==0 && therd ==0;
    }
}