package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class Counter3DifferentWordsCount {

    public static void main( String[] args ) throws IOException, URISyntaxException {
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
        stream();
    }

    public static void stream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        Stream<String> stream = Arrays.stream( StringSplitter.getWords( file ) );

        Map<String, Long> counted = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(counted);

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos( nanoDuration );
        System.out.println( d );
    }
}
