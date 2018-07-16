package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class Counter3DifferentWordsCount {
    private static String[] words;

    static {
        try {
            words = StringSplitter.getWords( FileLoader.loadFile() );
        } catch ( IOException e ) {
            e.printStackTrace( System.out );
        }
    }


    public static Result getResultOld( ) {
        Result res = Result.of( "Counter3DifferentWordsCount old", System.nanoTime() );

        Map<String, Integer> map = new HashMap<>();
        for ( String word : words ) {
            int value = 1;
            if ( map.containsKey( word ) )
                value += map.get( word );

            map.put( word, value );
        }

        res.setFinish( System.nanoTime() );
        res.setResultSummary( "" + map.size() + '/' + words.length );
        res.setResult( map );
        return res;
    }

    public static Result getResultNew( ) {
        Result res = Result.of( "Counter3DifferentWordsCount new", System.nanoTime() );

        Map<String, Integer> map = Arrays
                .stream( words )
                .collect( Collectors.toMap( s -> s, s -> 1, ( v1, v2 ) -> v1 + v2 ) );

        res.setFinish( System.nanoTime() );
        res.setResultSummary( "" + map.size() + '/' + words.length );
        res.setResult( map );
        return res;
    }
}
