package ru.sbt.collections.utils;

/** Util class for splitting string
 * Created by Home on 02.07.2018.
 */
public class StringSplitter {
    public static String[] getWords(String file) {
        String regex = "[;" + System.lineSeparator() + " .,]";
        return file.split(regex, -1);
    }

    public static String[] getLines(String file) {
        return file.split(System.lineSeparator());
    }
}
