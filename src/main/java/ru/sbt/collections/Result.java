package ru.sbt.collections;

import lombok.*;

import java.time.Duration;

@Builder
@ToString
@RequiredArgsConstructor( staticName = "of" )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
public class Result {
    @NonNull
    @Getter
    private final String name;
    @NonNull
    @Getter
    private final long start;
    @Getter
    private long finish;
    @Getter
    private Duration duration;
    @Setter
    @Getter
    private String resultSummary;
    @Setter
    @Getter
    private Object result;

    public void setFinish( long finish ) {
        this.finish = finish;
        this.duration = Duration.ofNanos( finish - start );
    }
}
