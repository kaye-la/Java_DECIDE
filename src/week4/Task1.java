package week4;

import java.util.*;

/**
 * Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
 */
public class Task1 {
    public static <T> Collection<T> collectionWithoutDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}
