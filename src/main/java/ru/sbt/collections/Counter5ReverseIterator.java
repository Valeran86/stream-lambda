package ru.sbt.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализуйте свой Iterator для обхода списка слов в обратном порядке.
 */
class Counter5ReverseIterator {

    static long notStream(String[] word) {
        Long t1 = System.nanoTime();
        List<String> words = Arrays.asList( word );

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

    static long yesStream(String[] word) {
        Long t1 = System.nanoTime();
        List<String> words = Arrays.asList( word );

        Iterator<String> reverseArrayIterator = new ReverseIterator( words );
        reverseArrayIterator.forEachRemaining(System.out::println);
        /*Iterable<String> iterable = () -> reverseArrayIterator;
        StreamSupport.stream(iterable.spliterator(), false).forEach(System.out::println);*/


        return System.nanoTime() - t1;
    }

    static long yesStreamDescendingIterator(String[] word) {
        Long t1 = System.nanoTime();
        List<String> words = Arrays.asList( word );

        words.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                .forEachRemaining(System.out::println);


        return System.nanoTime() - t1;
    }
    
    static long yesStreamReduce(String[] word) {
        Long t1 = System.nanoTime();
        List<String> words = Arrays.asList( word );

        Arrays.stream(words.stream().reduce("", (e1, e2) -> e2 + " " + e1).split(" "))
                .forEach(System.out::println);

        return System.nanoTime() - t1;
    }
}
