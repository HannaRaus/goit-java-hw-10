import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTwo {
    private static final List<String> names = Arrays.asList("Ivan", "Peter", "Hanna", "Oleksandr", "Olha", "Oleh");
    public static void main(String[] args) {
        List<String> result = sortedListInUpperCase(names);

        System.out.println(result);
    }

//    Метод принимает на вход список из строк (можно список из Задания 1).
//    Возвращает список этих строк в верхнем регистре и отсортированные по убыванию (от Z до А).
    private static List<String> sortedListInUpperCase(List<String> input) {
        return input.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
