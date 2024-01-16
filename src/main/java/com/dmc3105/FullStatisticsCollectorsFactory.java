package com.dmc3105;

import com.dmc3105.statistics.collectors.FloatStatisticsCollector;
import com.dmc3105.statistics.collectors.IntegerStatisticsCollector;
import com.dmc3105.statistics.collectors.StatisticsCollector;
import com.dmc3105.statistics.collectors.StringStatisticsCollector;

public class FullStatisticsCollectorsFactory implements StatisticsCollectorsFactory {
    @Override
    public StatisticsCollector createFloatStatisticsCollector() {
        return new FloatStatisticsCollector();
    }

    @Override
    public StatisticsCollector createIntegerStatisticsCollector() {
        return new IntegerStatisticsCollector();
    }

    @Override
    public StatisticsCollector createStringStatisticsCollector() {
        return new StringStatisticsCollector();
    }
}
