public class SwitchCase {
    public static void main(String[] args) {
        int season = 1;
        System.out.println(getSeason(season));
        System.out.println(getActivity(1, 23, false));

    }

    public static String getSeason(int month) {
        switch (month) {
            case 12, 1, 2:
                return "зима";
            case 3, 4, 5:
                return "весна";
            case 6, 7, 8:
                return "лето";
            case 9, 10, 11:
                return "осень";
            default:
                return "нет такого";
        }
    }

    public static String getActivity(int day, int hour, boolean isHoliday) {
        switch (day) {
            case 1: case 2: case 3: case 4: case 5:
                if (!isHoliday) {
                    if (hour >= 8 && hour <= 17) return "Работа";
                    if (hour == 7 || (hour >= 18 && hour <= 21)) return "Дорога";
                }
                return "Сон";
            case 6: case 7:
                return (hour >= 9 && hour < 23) ? "Отдых" : "Сон";
            default:
                return "Ошибка";
        }
    }
}
