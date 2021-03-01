import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class TaskFive {
    /*
    Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
    который "перемешивает" элементы из стримов first и second,
    останавливается тогда, когда у одного из стримов закончатся элементы.
     */
    private static final List<String> firstName = Arrays.asList("Ivan", "Peter", "Hanna", "Oleksandr", "Olha", "Oleh");
    private static final List<String> lastName = Arrays.asList("1", "2", "3", "4", "5", "6");

    public static void main(String[] args) {

        Stream<String> result = zip(firstName.stream(), lastName.stream());
        System.out.println(result.collect(Collectors.joining(", ")));

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> mix = Stream.concat(first, second).collect(Collectors.toList());
        Collections.shuffle(mix);
        return mix.stream();

    }

}
