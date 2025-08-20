import java.lang.String;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        // Условие: Напишите метод, который принимает строку
        // и возвращает количество гласных букв (a, e, i, o, u) в ней (без учёта регистра).
        // Ожидаемый результат: 3 (e, o, o)

        int n = 5;
        System.out.println(Arrays.toString(createSquareArray(n)));

        Map<String, Integer> original = Map.of(
                "one", 1,
                "two", 2,
                "three", 3);

        Map<Integer, String> reversedStream = reversedStream(original);
        System.out.println(reversedStream);

        Map<Integer, String> reversedLoop = reversedLoop(original);
        System.out.println(reversedLoop);

        String input = "Привет мир!";
        String[] words = {"a", "s", "e"};
        List<String> names = Arrays.asList("Анна", "Римма", "Александра");
        List<Integer> integer = Arrays.asList(1, 2, 3, 6);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        String newInput = "Java is awesome! Streams make life easier.";
        int[] ints = {1, 4, -3, 7};
        int[] newInts = convertNegative(ints);
        int[] newInts2 = convertNumbers(ints);
        System.out.println(Arrays.toString(newInts));
        System.out.println(Arrays.toString(newInts2));
        System.out.println(newList(integer));
        System.out.println(newListNames(names));
        System.out.println(filter(numbers));
        System.out.println(onTwo(numbers));
        System.out.println(sum(numbers));
        System.out.println(wordsSplit(newInput));
        System.out.println(replaceChars(newInput));


        System.out.println(countChars(input));
        System.out.println(stream(words));
        System.out.println(countOddNumbers(ints));
        System.out.println(replaceVowelsInLongWords(newInput));

        //MAX NUMBER
        Stream<Integer> stringInteger = Stream.of(1, 2, 3, 4, 5);
        int maxNumber = stringInteger.max(Integer::compare).get();
        System.out.println(maxNumber);

        //SORTED NUMBER
        Stream<Integer> sorted = Stream.of(1, 5, 4, 7, 9);
        sorted.sorted().forEach(System.out::print);

        //SORTED NUMBER WITH SPACE
        Stream<Integer> sortedWith = Stream.of(1, 5, 4, 7, 9);
        sortedWith.sorted().map(x -> x + " ").forEach(System.out::print);

        //COUNT
        List<Integer> countNumbers = Stream.of(1, 5, 4, 7, 9).toList();
        System.out.println("COUNT - " + countNumbers.size());

        //COUNT ПРИВОДИМ К СПИСКУ
        Stream<Integer> countNumbers2 = Stream.of(1, 5, 4, 7, 9);
        List<Integer> numbersList = countNumbers2.toList(); // Собираем в список
        System.out.println("Count: " + numbersList.size()); // Выводим количество
        System.out.println("Elements: " + numbersList);    // Выводим элементы

        //Сумма НЕ ЧЕТНЫХ ЗНАЧЕНИЙ
        Stream<Integer> countNumbers3 = Stream.of(1, 5, 4, 7, 9);
        int sum = countNumbers3.filter(x -> x % 2 != 0)
                .reduce(Integer::sum).orElseThrow();
        System.out.println("сумма не четных чисел - " + sum);

        //Сумма ЧЕТНЫХ ЗНАЧЕНИЙ
        Stream<Integer> countNumbers4 = Stream.of(1, 5, 4, 7, 9);
        int sums = countNumbers4.filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue).sum();
        System.out.println("сумма Четных чисел - " + sums);

        //найти минимальное и найти максимальное значение в одной
        Supplier<Stream<Integer>> minMax = () -> Stream.of(1, 5, 4, 7, 9);
        Optional<Integer>  min = minMax.get().min(Integer:: compare);
        System.out.println(min.get());
        Optional<Integer>  max = minMax.get().max(Integer:: compare);
        System.out.println(max.get());

        //
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> newList = list.stream()
                .map(x -> x%2 ==0? x*100: x-100)
                .toList();
        System.out.println("ololo" + newList);


    }


    public static long countChars(String someString) {
        return someString.
                toLowerCase() // Приводим строку к нижнему регистру
                .chars()  // Преобразуем в поток символов (IntStream)
                .filter(chars -> "ие".indexOf(chars) != -1) // Оставляем только гласные
                .count();  // Считаем количество
    }

    public static String stream(String[] strings) {
        return Arrays.stream(strings)
                .filter(r -> r.equals("a"))
                .collect(Collectors.joining());
    }

    public static int[] convertNegative(int[] ints) {
        return Arrays.stream(ints)
                .map(r -> r > 0 ? r : r * -1)
                .toArray();
    }

    public static int[] convertNumbers(int[] ints) {
        return Arrays.stream(ints)
                .map(r -> r % 2 == 0 ? r * 100 : r - 100)
                .toArray();
    }

    public static int countOddNumbers(int[] ints) {
        return Arrays.stream(ints)
                .filter(r -> r % 2 != 0)
                .sum();
    }

    public static List<Integer> newList(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
    }

    public static List<String> newListNames(List<String> strings) {
        return strings.stream()
                .filter(name -> name.startsWith("А"))
                .collect(Collectors.toList());
    }

    public static List<Integer> filter(List<Integer> list) {
        return list.stream()
                .filter(numbers -> numbers % 2 == 0)
                .toList();
    }

    public static List<Integer> onTwo(List<Integer> list) {
        return list.stream()
                .map(numbers -> numbers * 2)
                .toList();
    }

    public static long sum(List<Integer> list) {
        return list.stream()
                .filter(numbers -> numbers % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

        public static int[] createSquareArray(int n){
        return IntStream.range(0, n)
                .map(i -> i * i)
                .toArray();
    }

    public static Map<Integer, String> reversedStream (Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getValue,
                        Map.Entry::getKey));
    }

    public static Map<Integer, String> reversedLoop (Map<String, Integer> map) {
        Map <Integer, String> reversed = new HashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            reversed.put(entry.getValue(),entry.getKey());
        }
        return reversed;
    }

    public static String wordsSplit(String string) {
        return Arrays.toString(string.split("\\s+"));
    }

    public static String replaceChars(String string) {
        return string.replaceAll("[aeiou]", "*");
    }

    public static String replaceVowelsInLongWords(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(word -> word.length() > 5 ?
                        word.replaceAll("(?i)[aeiou]", "*") : word)
                .collect(Collectors.joining(" "));
    }

}