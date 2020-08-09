package week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Напишите метод, который добавляет 1.000.000 элементов в ArrayList и LinkedList.
 * Напишите еще один метод, который выбирает из заполненного списка элемент наугад 100.000 раз.
 * Замерьте время, которое потрачено на это.
 * Сравните результаты и предположите, почему они именно такие.
 */

public class Task2 {
    static ArrayList<String> arrayList;
    static LinkedList<String> linkedList;
    static final int size = 1000000;

    public static void randomGenerateLists() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 1; i <= size; i++) {
            arrayList.add("Word#" + i);
            linkedList.add("Word#" + i);
        }
    }

    public static void compareLists() {
        long then = System.nanoTime();

        for (int i = 1; i < 100000; i++)
            arrayList.get((int)Math.random() * (size - 1));
        System.out.println("ArrayList .get operation 100000times: " +
                TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then) + "ms");
        then = System.nanoTime();

        for (int i = 1; i < 100000; i++)
            linkedList.get((int)Math.random() * (size - 1));
        System.out.println("LinkedList .get operation 100000times: " +
                TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then) + "ms");
    }

}

/*
public static void main(String... ignored) throws InterruptedException {
final long then = System.nanoTime();
        TimeUnit.SECONDS.sleep(1);
final long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then);
        System.out.println("Slept for (ms): " + millis); // = something around 1000.
        }
 */
