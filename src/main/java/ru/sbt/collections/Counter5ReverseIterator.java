package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
class Counter5ReverseIterator {

    static long notStream() throws IOException {
        Long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );

        while ( reverseArrayIterator.hasNext() )
            System.out.println( reverseArrayIterator.next() );

        return System.nanoTime() - t1;
    }

    static class ReverseIterator implements Iterator<String> {
        private int index;
        private final List<String> array;

        ReverseIterator(List<String> array) {
            this.array = array;
            index = array.size();
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public String next() {
            --index;
            return index >= 0 && index < array.size() ? array.get(index) : null;

        }
    }

    static long yesStream() throws IOException {
        Long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        reverseArrayIterator.forEachRemaining(System.out::println);
        /*Iterable<String> iterable = () -> reverseArrayIterator;
        StreamSupport.stream(iterable.spliterator(), false).forEach(System.out::println);*/


        return System.nanoTime() - t1;
    }

    static long yesStreamDescendingIterator() throws IOException {
        Long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        words.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                .forEachRemaining(System.out::println);


        return System.nanoTime() - t1;
    }

/*
    public static long yesStreamIterable() throws IOException {
        Long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        Iterable<String> iterable = () -> reverseArrayIterator;
        StreamSupport.stream(iterable.spliterator(), false).forEach(System.out::println);


        long nanoDuration = System.nanoTime() - t1;
        return nanoDuration;
    }

    public static long yesStreamSpliterators() throws IOException {
        Long t1 = System.nanoTime();
        String file = FileLoader.loadFile();
        List<String> words = Arrays.asList( StringSplitter.getWords( file ) );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(reverseArrayIterator, Spliterator.ORDERED),
                false).forEach(System.out::println);

        long nanoDuration = System.nanoTime() - t1;
        return nanoDuration;
    }
*/
}
