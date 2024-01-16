package com.dmc3105;

import com.dmc3105.statistics.collectors.IntegerStatisticsCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class IntegerStatisticsCollectorTest {
    private static IntegerStatisticsCollector collector;
    private static final Collection<String> strings = List.of("12", "-4", "6", "9", "-3");

    @BeforeAll
    static void initEach() {
        collector = new IntegerStatisticsCollector();
        for (var string : strings) {
            collector.collectStatistics(string);
        }
    }

    @Test
    void getMinValue_returns_minus4()
    {
        Assertions.assertEquals(-4, collector.getMinValue());
    }

    @Test
    void getMaxValue_returns12()
    {
        Assertions.assertEquals(12, collector.getMaxValue());
    }

    @Test
    void getSumOfValues_returns20() {
        Assertions.assertEquals(20, collector.getSumOfValues());
    }

    @Test
    void getAverageValue_returns4()
    {
        Assertions.assertEquals(4, collector.getAverageValue());
    }
}
