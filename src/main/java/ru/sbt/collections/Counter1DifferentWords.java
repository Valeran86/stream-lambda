package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {
    private static String[] words;

    static {
        try {
            words = StringSplitter.getWords( FileLoader.loadFile() );
        } catch ( IOException e ) {
            e.printStackTrace( System.out );
        }
    }


    public static Result getResultOld( ) {
        Result res = Result.of( "Counter1DifferentWords old", System.nanoTime() );

        Set<String> set = new HashSet<>( Arrays.asList( words ) );

        res.setFinish( System.nanoTime() );
        res.setResultSummary( set.size() + "/" + words.length );
        return res;
    }

    public static Result getResultNew( ) {
        Result res = Result.of( "Counter1DifferentWords new", System.nanoTime() );

        int distinctWordCount = (int) Arrays.stream( words ).distinct().count();

        res.setFinish( System.nanoTime() );
        res.setResultSummary( distinctWordCount + "/" + words.length );
        return res;
    }
}
