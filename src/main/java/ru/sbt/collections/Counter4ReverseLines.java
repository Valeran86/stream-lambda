package ru.sbt.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
class Counter4ReverseLines {
    static long notStream(String[] lineArray) {
        long t1 = System.nanoTime();

        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            System.out.println( lineArray[ i ] );
        }

        return System.nanoTime() - t1;
    }



    static long yesStreamLinkedList(String[] lineArray) {
        long t1 = System.nanoTime();

        Arrays.stream(lineArray)
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(System.out::println);

        return System.nanoTime() - t1;
    }

    static long yesStreamArrayCollectionsReverse(String[] lineArray) {
        long t1 = System.nanoTime();

        Collections.reverse(Arrays.asList(lineArray));
        Arrays.stream(lineArray).forEach(System.out::println);

        return System.nanoTime() - t1;
    }

    static long yesStreamArrayIntStreamRange(String[] lineArray) {
        long t1 = System.nanoTime();

        int to=lineArray.length;
        IntStream.range(0, to).forEach(t->System.out.println(lineArray[to-1-t]));

        return System.nanoTime() - t1;
    }

}
