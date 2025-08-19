import java.util.HashMap;
import java.util.Map;

public class Ternary {
    public static void main(String[] args) {
        int number = 7;
        System.out.println(number(number)); ;
        System.out.println(number2(number));
        System.out.println(numberInfo(number));
    }

    public static String number(int some) {
        String result = (some % 2 == 0) ? "чётное" : "нечётное";
        return result;
    }

    public static double number2(int some) {
        int result = (some > 0) ? some / 2 : some * -1;
        return result;
    }

    public static Map<String, Object> numberInfo(int number) {
        Map<String, Object> result = new HashMap<>();
        result.put("результат", (number > 0) ? number / 2.0 : number * -1);
        result.put("состояние", (number % 2 == 0) ? "чётное" : "нечётное");
        return result;
    }
}
