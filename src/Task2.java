import java.util.*;

public class Task2 {
    //    Написать программу, которая удаляет дубликаты из массива чисел и заменяет их нижним подчеркиванием,
//    а также сортирует массив и выводит количество уникальных значений в консоль
//    Input: nums = [1, 3, 2, 3]
//    Output: nums = [1, 2, 3, _]
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3};
        System.out.println(array(nums));
    }

    public static String array(int[] ints) {
        Set<Integer> set = new HashSet<>();
        for (int nums : ints) {
            set.add(nums);
        }
        //создаем список лист из множества сет.
        // порядок элементов может быть произвольным так как хэш сет не гаррантирует порядок втсавки
        List<Integer> list = new ArrayList<>(set);
        // создаем массив строк длинна которого равна длинне исходного массива
        String[] string = new String[ints.length];
        //заполнение массива результатами
        for (int i = 0; i < string.length; i++) {
            // если индэкс i массива меньше списка лист мы добавляем в этот массив string[i] строковое представление элемента из листа.
            // если индэес больше размеру списка мы добавляем _ (подчеркивание)
            if (i < list.size()) {
                string[i] = String.valueOf(list.get(i));
            } else {
                string[i] = "_";
            }
        }
        return Arrays.toString(string);
    }
}
