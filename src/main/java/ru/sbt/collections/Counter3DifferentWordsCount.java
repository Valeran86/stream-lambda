package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
class Counter3DifferentWordsCount {

    static long notStream() throws IOException {
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

        return System.nanoTime() - t1;
    }

    static long yesStream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] words = StringSplitter.getWords( file );
        Map<String, Integer> map = new HashMap<>();
        Stream.of(words).forEach(w->map.merge(w,1,Integer::sum));

        System.out.println( map );
        System.out.println( "" + map.size() + '/' + words.length );

        return System.nanoTime() - t1;
    }

}
