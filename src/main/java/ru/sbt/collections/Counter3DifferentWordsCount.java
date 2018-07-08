package ru.sbt.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
class Counter3DifferentWordsCount {

    static long notStream(String[] words) {
        long t1 = System.nanoTime();

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

    static long yesStream(String[] words) {
        long t1 = System.nanoTime();

        Map<String, Integer> map = new HashMap<>();
        Stream.of(words).forEach(w->map.merge(w,1,Integer::sum));

        System.out.println( map );
        System.out.println( "" + map.size() + '/' + words.length );

        return System.nanoTime() - t1;
    }

    static long yesStreamGrouping(String[] words){
        long t1 = System.nanoTime();

        Map<String, Long> map = Stream.of(words)
                .collect(Collectors.groupingBy(t->t, Collectors.counting()));

        System.out.println( map );
        System.out.println( "" + map.size() + '/' + words.length );

        return System.nanoTime() - t1;
    }



}
