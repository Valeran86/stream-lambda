package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class CounterMain {
    public static void main( String[] args ) throws IOException {
        long nanoDurationNo1;
        long nanoDurationYes1;
        long nanoDurationNo2;
        long nanoDurationYes2;
        long nanoDurationNo3;
        long nanoDurationYes3;
        long nanoDurationNo4;
        long nanoDurationYesLinkedList4;
        long nanoDurationYesCollectionsReverse4;
        long nanoDurationYesIntStreamRange4;
        long nanoDurationNo5;
        long nanoDurationYes5;
        long nanoDurationYesDescendingIterator5;


        nanoDurationNo1=Counter1DifferentWords.notStream();
        nanoDurationYes1=Counter1DifferentWords.yesStream();

        nanoDurationNo2=Counter2DifferentWordsList.notStream();
        nanoDurationYes2=Counter2DifferentWordsList.yesStream();

        nanoDurationNo3=Counter3DifferentWordsCount.notStream();
        nanoDurationYes3=Counter3DifferentWordsCount.yesStream();

        nanoDurationNo4=Counter4ReverseLines.notStream();
        nanoDurationYesLinkedList4=Counter4ReverseLines.yesStreamLinkedList();
        nanoDurationYesCollectionsReverse4=Counter4ReverseLines.yesStreamArrayCollectionsReverse();
        nanoDurationYesIntStreamRange4=Counter4ReverseLines.yesStreamArrayIntStreamRange();
        nanoDurationNo5=Counter5ReverseIterator.notStream();
        nanoDurationYes5=Counter5ReverseIterator.yesStream();
        nanoDurationYesDescendingIterator5=Counter5ReverseIterator.yesStreamDescendingIterator();



        System.out.println("Задача 1");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo1 ));
        System.out.println(" Со Stream:"+Duration.ofNanos( nanoDurationYes1 ));
        System.out.println("Задача 2");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo2 ));
        System.out.println(" Со Stream:"+Duration.ofNanos( nanoDurationYes2 ));
        System.out.println("Задача 3");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo3 ));
        System.out.println(" Со Stream:"+Duration.ofNanos( nanoDurationYes3 ));
        System.out.println("Задача 4");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo4 ));
        System.out.print(" Со Stream ArrayDeque:"+Duration.ofNanos( nanoDurationYesLinkedList4 ));
        System.out.print(" Со Stream CollectionsReverse:"+Duration.ofNanos( nanoDurationYesCollectionsReverse4 ));
        System.out.println(" Со Stream IntStreamRange:"+Duration.ofNanos( nanoDurationYesIntStreamRange4 ));
        System.out.println("Задача 5");
        System.out.print("Без Stream:"+Duration.ofNanos( nanoDurationNo5 ));
        System.out.print(" Со Stream:"+Duration.ofNanos( nanoDurationYes5 ));
        System.out.print(" Со Stream DescendingIterator:"+Duration.ofNanos( nanoDurationYesDescendingIterator5 ));




    }



}
