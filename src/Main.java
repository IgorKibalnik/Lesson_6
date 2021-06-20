import java.util.*;

public class Main {

    static final int MIN = 1;
    static final int MAX = 599;

    public static void main(String[] args) {
        String[] units = new String[]{"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] dozens = new String[]{"десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
                "семдесят", "восемдесят", "девяносто"};
        String[] hundreds = new String[]{"сто", "двести", "триста", "четыреста", "пятьсот"};
        String[] currency = new String[]{"рубль", "рубля", "рублей"};

        List<String> unitsList = new ArrayList<>(Arrays.asList(units));
        List<String> dozensList = new ArrayList<>(Arrays.asList(dozens));
        List<String> hundredsList = new ArrayList<>(Arrays.asList(hundreds));
        Map<Integer, String> declinationsOfRuble = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (i == 1)
                declinationsOfRuble.put(i, currency[0]);
            else if ((1 < i) && (i < 5))
                declinationsOfRuble.put(i, currency[1]);
            else
                declinationsOfRuble.put(i, currency[2]);
        }

        int value = getRandomValue(MIN, MAX);
        System.out.println("Random number is " + value);
        StringBuilder stringValue = new StringBuilder();
        if ((value / 100) > 0)
            stringValue
                    .append(hundredsList.get((value/100) - 1))
                    .append(" ");
        if (((value % 100) / 10) > 0)
            stringValue
                    .append(dozensList.get(((value % 100) / 10) - 1))
                    .append(" ");
        int lastDigit = value % 10;
        if (lastDigit > 0)
            stringValue
                    .append(unitsList.get(lastDigit - 1))
                    .append(" ");

        stringValue.append(declinationsOfRuble.get(lastDigit));
        System.out.println(stringValue);
    }

    static int getRandomValue(int minValue, int maxValue) {
        return (new Random()).nextInt(maxValue) + minValue;
    }
}
