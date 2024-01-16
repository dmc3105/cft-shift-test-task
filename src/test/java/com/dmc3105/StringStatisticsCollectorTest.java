package com.dmc3105;

import com.dmc3105.statistics.collectors.StringStatisticsCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class StringStatisticsCollectorTest {
    private StringStatisticsCollector collector;
    private final Collection<String> strings = List.of("123", "12", "12345", "12345678", "1234");

    @BeforeEach
    void initEach() {
        collector = new StringStatisticsCollector();
    }
    
    @Test
    void getLongestStringLength_returns8()
    {
        for (var string :
                strings) {
            collector.collectStatistics(string);
        }

        Assertions.assertEquals(8, collector.getLongestStringLength());
    }

    @Test
    void getShortestStringLength_returns2()
    {
        for (var string :
                strings) {
            collector.collectStatistics(string);
        }

        Assertions.assertEquals(2, collector.getShortestStringLength());
    }
}
