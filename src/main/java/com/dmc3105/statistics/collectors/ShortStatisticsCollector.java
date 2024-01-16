package com.dmc3105.statistics.collectors;

import com.dmc3105.statistics.types.ShortStatistics;
import com.dmc3105.statistics.types.Statistics;

public class ShortStatisticsCollector implements StatisticsCollector{
    private int writtenElementsCount = 0;

    @Override
    public void collectStatistics(String value) {
        writtenElementsCount++;
    }

    @Override
    public Statistics getStatistics() {
        return new ShortStatistics(writtenElementsCount);
    }

    public int getWrittenElementsCount() {
        return writtenElementsCount;
    }
}
