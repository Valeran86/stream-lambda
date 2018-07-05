package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Выведите на экран все строки файла в обратном порядке.
 */
class Counter4ReverseLines {
    static long notStream() throws IOException {
        long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );

        for ( int i = lineArray.length - 1; i >= 0; i-- ) {
            System.out.println( lineArray[ i ] );
        }

        return System.nanoTime() - t1;
    }



    static long yesStreamLinkedList() throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );
        Arrays.stream(lineArray)
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(System.out::println);

        return System.nanoTime() - t1;
    }

    static long yesStreamArrayCollectionsReverse() throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );
        Collections.reverse(Arrays.asList(lineArray));
        Arrays.stream(lineArray).forEach(System.out::println);

        return System.nanoTime() - t1;
    }

    static long yesStreamArrayIntStreamRange() throws IOException {
        long t1 = System.nanoTime();

        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );
        int to=lineArray.length;
        IntStream.range(0, to).forEach(t->System.out.println(lineArray[to-1-t]));

        return System.nanoTime() - t1;
    }

}
