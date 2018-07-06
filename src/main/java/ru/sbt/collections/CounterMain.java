package ru.sbt.collections;

import ru.sbt.collections.utils.FileLoader;
import ru.sbt.collections.utils.StringSplitter;

import java.io.IOException;
import java.time.Duration;

public class CounterMain {
    public static void main( String[] args ) throws IOException {

        String file = FileLoader.loadFile();
        String[] lineArray = StringSplitter.getLines( file );
        String[] words = StringSplitter.getWords( file );

        long nanoDurationNo1=Counter1DifferentWords.notStream(words);
        long nanoDurationYes1=Counter1DifferentWords.yesStream(words);
        long nanoDurationNo2=Counter2DifferentWordsList.notStream(words);
        long nanoDurationYes2=Counter2DifferentWordsList.yesStream(words);
        long nanoDurationNo3=Counter3DifferentWordsCount.notStream(words);
        long nanoDurationYes3=Counter3DifferentWordsCount.yesStream(words);
        long nanoDurationYesGrouping3=Counter3DifferentWordsCount.yesStreamGrouping(words);
        long nanoDurationNo4=Counter4ReverseLines.notStream(lineArray);
        long nanoDurationYesLinkedList4=Counter4ReverseLines.yesStreamLinkedList(lineArray);
        long nanoDurationYesCollectionsReverse4=Counter4ReverseLines.yesStreamArrayCollectionsReverse(lineArray);
        long nanoDurationYesIntStreamRange4=Counter4ReverseLines.yesStreamArrayIntStreamRange(lineArray);
        long nanoDurationNo5=Counter5ReverseIterator.notStream(words);
        long nanoDurationYes5=Counter5ReverseIterator.yesStream(words);
        long nanoDurationYesDescendingIterator5=Counter5ReverseIterator.yesStreamDescendingIterator(words);


        System.out.println("Задача 1");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo1 ));
        System.out.println(" Со Stream:"+Duration.ofNanos( nanoDurationYes1 ));
        System.out.println("Задача 2");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo2 ));
        System.out.println(" Со Stream:"+Duration.ofNanos( nanoDurationYes2 ));
        System.out.println("Задача 3");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo3 ));
        System.out.print(" Со Stream:"+Duration.ofNanos( nanoDurationYes3 ));
        System.out.println(" Со Stream Grouping:"+Duration.ofNanos( nanoDurationYesGrouping3 ));
        System.out.println("Задача 4");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo4 ));
        System.out.print(" Со Stream LinkedList:"+Duration.ofNanos( nanoDurationYesLinkedList4 ));
        System.out.print(" Со Stream CollectionsReverse:"+Duration.ofNanos( nanoDurationYesCollectionsReverse4 ));
        System.out.println(" Со Stream IntStreamRange:"+Duration.ofNanos( nanoDurationYesIntStreamRange4 ));
        System.out.println("Задача 5");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo5 ));
        System.out.print(" Со Stream:"+Duration.ofNanos( nanoDurationYes5 ));
        System.out.print(" Со Stream DescendingIterator:"+Duration.ofNanos( nanoDurationYesDescendingIterator5 ));
    }



}
