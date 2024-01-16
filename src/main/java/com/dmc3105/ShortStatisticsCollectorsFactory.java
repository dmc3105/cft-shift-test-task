package com.dmc3105;

import com.dmc3105.statistics.collectors.ShortStatisticsCollector;
import com.dmc3105.statistics.collectors.StatisticsCollector;

public class ShortStatisticsCollectorsFactory implements StatisticsCollectorsFactory {
    @Override
    public StatisticsCollector createFloatStatisticsCollector() {
        return new ShortStatisticsCollector();
    }

    @Override
    public StatisticsCollector createIntegerStatisticsCollector() {
        return new ShortStatisticsCollector();
    }

    @Override
    public StatisticsCollector createStringStatisticsCollector() {
        return new ShortStatisticsCollector();
    }
}
