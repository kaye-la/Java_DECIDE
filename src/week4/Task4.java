package week4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Напишите метод, который получает на вход массив элементов типа К (Generic) и
 * возвращает Map<K, Integer>, где K — значение из массива, а Integer — количество вхождений в массив.
 * То есть сигнатура метода выглядит так:
 * <K> Map<K, Integer> arrayToMap(K[] ks);
 */

public class Task4 {
    public static <K> Map<K, Integer> arrayToMap(K[] ks){
        Map<K, Integer> res = new HashMap<>();

        for (int i = 0; i < ks.length; i++) {
            int count = 0;
            for (int j = 0; j < ks.length; j++){
                if (ks[j] == ks[i])
                    count += 1;
            }
            res.put(ks[i], count);
        }
        return res;
    }
}
