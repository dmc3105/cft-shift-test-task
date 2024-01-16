package com.dmc3105;

import com.dmc3105.statistics.collectors.ShortStatisticsCollector;
import com.dmc3105.statistics.collectors.StringStatisticsCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class ShortStatisticsCollectorTest {
    @Test
    void collectStatistics_5elements_returns5() {
        ShortStatisticsCollector collector = new StringStatisticsCollector();
        Collection<String> strings = List.of("1", "2", "3", "4", "5");

        for (var string :
                strings) {
            collector.collectStatistics(string);
        }
        Assertions.assertEquals(5, collector.getWrittenElementsCount());
    }
}
