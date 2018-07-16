package ru.sbt.collections;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main( String[] args ) {
        List<Result> results = new ArrayList<>();
        Result res;
        res = Counter1DifferentWords.getResultOld();
        results.add( res );
        res = Counter1DifferentWords.getResultNew();
        results.add( res );

        res = Counter2DifferentWordsList.getResultOld();
        results.add( res );
        res = Counter2DifferentWordsList.getResultNew();
        results.add( res );

        res = Counter3DifferentWordsCount.getResultOld();
        results.add( res );
        res = Counter3DifferentWordsCount.getResultNew();
        results.add( res );

        res = Counter4ReverseLines.getResultOld();
        results.add( res );
        res = Counter4ReverseLines.getResultNew();
        results.add( res );

        res = Counter5ReverseIterator.getResultOld();
        results.add( res );
        res = Counter5ReverseIterator.getResultNew();
        results.add( res );

        results.forEach( System.out::println );
    }
}
