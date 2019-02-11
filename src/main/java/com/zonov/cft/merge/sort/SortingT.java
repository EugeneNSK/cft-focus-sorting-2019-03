package com.zonov.cft.merge.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Util class for merging data.
 */
public class SortingT {

    /**
     * @param <T>  the class of the objects in the array
     * @param list the collection of arrays with valid data
     * @return resulting merged array
     */
    public static <T extends Comparable<T>> T[] sort(List<T[]> list) {
        int i = 0;
        T[] sortedData = list.get(i);
        while (i < list.size() - 1) {
            sortedData = merge(sortedData, list.get(i + 1));
            i++;
        }
        return sortedData;
    }

    /**
     * @param <T> the class of the objects in the array
     * @param a   the first array to merge
     * @param b   the second array to merge
     * @return resulting merged array of [a] and [b]
     */
    private static <T extends Comparable<T>> T[] merge(T[] a, T[] b) {
        T[] result = Arrays.copyOf(a, a.length + b.length);
        int aIndex = 0;
        int bIndex = 0;
        int i = 0;

        while (i < result.length) {
            result[i] = a[aIndex].compareTo(b[bIndex]) < 0 ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
            i++;
        }

        return result;
    }

}
