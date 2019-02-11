package com.zonov.cft.merge.verify;

import java.util.ArrayList;
import java.util.List;

/**
 * Util class for verification of data.
 */
public class Verification {

    /**
     * @param list the collection of raw parsed data
     * @param file the name of current parsed file
     * @return array of valid Integer data
     */
    public static Integer[] check(List<String> list, String file) {
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            try {
                data.add(Integer.valueOf(list.get(i)));
            } catch (NumberFormatException e) {
                System.err.println("Wrong data format: |" + list.get(i) + "| in file: |" + file + "|");
            }
        }
        return data.toArray(new Integer[data.size()]);
    }
}
