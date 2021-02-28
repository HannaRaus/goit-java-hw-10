import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.LongConsumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TaskFour {
    /*
    Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, но не используя Math.random.
    Реализуйте свой "линейный конгруэнтный генератор".
    Для этого начните с x[0] = seed и затем каждый следующий элемент x[n + 1] = 1 (a x[n] + c) % m,
    для корректных значений a, c, и m.
    Необходимо имплементировать метод, который принимает на вход параметры a, c, m и seed и
    возвращает Stream<Long>. Для теста используйте данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).
     */
    private static final long A = 25214903917l;
    private static final long C = 11;
    private static final long M = (long) Math.pow(2, 48);

    public static void main(String[] args) {

//        generator(2, A, C, M)
//                .limit(50)
//                .forEach(System.out::println);

        generator(7, 7, 7, 10)
                .limit(50)
                .forEach(System.out::println);

    }

    private static Stream<Long> generator(final long seed, long a, long c, long m) {
        Spliterator<Long> spliterator = new Spliterators.AbstractLongSpliterator(a,
                Spliterator.ORDERED | Spliterator.IMMUTABLE) {
            long prev;
            boolean started;

            @Override
            public boolean tryAdvance(LongConsumer action) {
                Objects.requireNonNull(action);
                long t;
                if (started) {
                    t = (a * prev + c) % m;
                } else {
                    t = seed;
                    started = true;
                }
                action.accept(prev = t);
                return true;
            }
        };
        return StreamSupport.stream(spliterator, false);
    }
}
