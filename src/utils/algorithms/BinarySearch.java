package utils.algorithms;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearch {
    public static <T> int search(ArrayList<T> list, T value, Comparator<T> comparator) {
        int f = 0;
        int l = list.size() - 1;
        int m;
        while (f <= l) {
            m = (f + l) / 2;
            int r = comparator.compare(list.get(m), value);
            if (r == 0) {
                return m;
            } else if (r > 0) {
                l = m - 1;
            } else {
                f = m + 1;
            }
        }
        return list.size();
    }

    public static <T> int search(ArrayList list, T value) {
        return search(list, value, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
    }
}
