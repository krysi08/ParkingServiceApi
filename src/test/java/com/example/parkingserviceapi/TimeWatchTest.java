package com.example.parkingserviceapi;

import com.example.parkingserviceapi.time.TimeWatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
