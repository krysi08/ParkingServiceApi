package com.example.parkingserviceapi;

import com.example.parkingserviceapi.time.TimeWatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
public class TimeWatchTest {

    private TimeWatch timeWatch;


    public TimeWatchTest(TimeWatch timeWatch) {
        this.timeWatch = timeWatch;
    }
    @Test
    void startTimeWatch(long Date, long timeWatch) {
        assertEquals(Date,timeWatch);
    }
    @Test
    void stopTimeWatch(long Date, long timeWatch) {
        assertEquals(Date,timeWatch);
    }
}
