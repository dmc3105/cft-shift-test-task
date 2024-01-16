package com.dmc3105;

import com.dmc3105.statistics.collectors.StatisticsCollector;

public interface StatisticsCollectorsFactory {
    StatisticsCollector createFloatStatisticsCollector();
    StatisticsCollector createIntegerStatisticsCollector();
    StatisticsCollector createStringStatisticsCollector();
}