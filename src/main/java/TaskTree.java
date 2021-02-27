import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TaskTree {
    private static final List<String> numbers = Arrays.asList("1, 2, 0", "4, 5");

    public static void main(String[] args) {
        String result = getSortedNumberFromList(numbers);

        System.out.println(result);

    }

    //    Получить из массива все числа, вернуть в отсортированном виде, разделенные запятой, то есть
    //    Expecting result - "0, 1, 2, 4, 5"
    private static String getSortedNumberFromList(List<String> input) {
        return Arrays.stream(String.join(", ", input).split(", "))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(", "));
    }
}
