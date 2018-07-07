package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class Counter3DifferentWordsCount {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        oldCounter();
        newCounter();


    }

    public static void oldCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        Map<String, Integer> map = new HashMap<>();

        for ( String word : words ) {
            int value = 1;
            if ( map.containsKey( word ) )
                value += map.get( word );

            map.put( word, Integer.valueOf( value ) );
        }

        System.out.println( map );
        System.out.println( "" + map.size() + '/' + words.length );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );

    }

    public static void newCounter() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        Map<String, Long> countsWord = Arrays.stream( words ).collect( Collectors.groupingBy( e -> e, Collectors.counting() ));
        System.out.println( countsWord );
        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );


    }






}
