
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TaskOne {

    private static final List<String> names = Arrays.asList("Ivan", "Peter", "Hanna", "Oleksandr", "Olha", "Oleh");

    public static void main(String[] args) {
        String result = getOddIndexValue(names);

        System.out.println(result);
    }

    // Метод принимает на вход список имен.
    // Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка, стоящими под нечетным индексом (1, 3 и т.д.).
    private static <T> String getOddIndexValue(List<T> input) {
        return input.stream()
                .filter(word -> input.indexOf(word) % 2 != 0)
                .map(word -> input.indexOf(word) + ". " + word)
                .collect(Collectors.joining(", "));
    }
}
