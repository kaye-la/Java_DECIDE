package week4.Task3;

import java.util.*;

/**
 * Написать итератор по массиву
 * @param <T> тип массива array
 */
public class ArrayIterator<T> implements Iterator<T> {
    private int size;       // размер array
    private int position;   // индекс текущего элемента
    private T[] array;

    public ArrayIterator(T[] array) {
        this.array = array;
        size = array.length;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        if (position >= size) {
            throw new NoSuchElementException("No such element!");
        }
        return array[position++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove element from array");
    }
}
