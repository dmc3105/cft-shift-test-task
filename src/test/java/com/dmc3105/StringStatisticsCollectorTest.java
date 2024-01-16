package com.dmc3105;

import com.dmc3105.statistics.collectors.StringStatisticsCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class StringStatisticsCollectorTest {
    private static StringStatisticsCollector collector;
    private static final Collection<String> strings = List.of("123", "12", "12345", "12345678", "1234");

    @BeforeAll
    static void initEach() {
        collector = new StringStatisticsCollector();
        for (var string :
                strings) {
            collector.collectStatistics(string);
        }
    }
    
    @Test
    void getLongestStringLength_returns8()
    {
        Assertions.assertEquals(8, collector.getLongestStringLength());
    }

    @Test
    void getShortestStringLength_returns2()
    {
        Assertions.assertEquals(2, collector.getShortestStringLength());
    }
}
