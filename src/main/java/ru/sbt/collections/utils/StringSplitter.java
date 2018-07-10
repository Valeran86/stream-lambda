package ru.sbt.collections.utils;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/** Util class for splitting string
 * Created by Home on 02.07.2018.
 */
public class StringSplitter {
    public static String[] getWordsOld(String file ) {
        String regex = "[;" + System.lineSeparator() + " .,]";
        return file.split( regex, -1 );
    }

    public static String[] getLinesOld(String file ) {
        return file.split( System.lineSeparator() );
    }
    public static Stream<String> getWords(String file ) {
        String regex = "[;" + System.lineSeparator() + " .,]";
        return Pattern.compile(regex).splitAsStream(file);
    }

    public static Stream<String> getLines( String file ) {
        return Pattern.compile(System.lineSeparator()).splitAsStream(file);
    }
}
