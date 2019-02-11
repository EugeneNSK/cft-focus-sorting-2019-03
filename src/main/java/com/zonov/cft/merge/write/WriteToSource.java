package com.zonov.cft.merge.write;

import java.io.*;

/**
 * Util class for writing data to File.
 */
public class WriteToSource {

    /**
     * @param fileName input file name
     * @param arr      merged result
     * @param desc     sorting type marker
     */
    public static <T> void write(String fileName, T[] arr, Boolean desc) {
        File output = new File(fileName);

        try (Writer writer = new BufferedWriter(new FileWriter(output))) {
            if (desc) {
                for (int i = arr.length - 1; i >= 0; i--) {
                    writer.write(arr[i] + "\n");
                }
            } else {
                for (int i = 0; i < arr.length; i++) {
                    writer.write(arr[i] + "\n");
                }
            }

        } catch (IOException e) {
            System.err.println("Something wrong with file: " + fileName);
            e.printStackTrace();
            System.exit(2);
        }

    }
}
