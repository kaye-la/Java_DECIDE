package week4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Напишите методы union(Set<?>... set) и intersect(Set<?> ... set),
 * реализующих операции объединения и пересечения множеств.
 * Протестируйте работу этих методов на предварительно заполненных множествах.
 */

public class Task5 {
    public static Set<?> union(Set <?> firstSet, Set <?> secondSet) {
        Set <Object> unionSet = new HashSet<>();
        Object[] arr = firstSet.toArray();

        for (int i = 0; i < arr.length; i++)
            unionSet.add(arr[i]);
        arr = secondSet.toArray();

        for (int i = 0; i < arr.length; i++)
            unionSet.add(arr[i]);
        return unionSet;
    }

    public static Set<?> intersection(Set <?> firstSet, Set <?> secondSet) {
        Set <Object> unionSet = new HashSet<>();
        Set <Object> retainSet = new HashSet<>();
        Object[] arr = firstSet.toArray();

        for (int i = 0; i < arr.length; i++)
            unionSet.add(arr[i]);
        arr = secondSet.toArray();

        for (int i = 0; i < arr.length; i++)
            retainSet.add(arr[i]);
        unionSet.retainAll(retainSet);
        return unionSet;
    }
}
