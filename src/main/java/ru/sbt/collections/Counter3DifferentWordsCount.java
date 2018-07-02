package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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
    }
}
