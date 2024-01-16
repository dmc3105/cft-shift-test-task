package com.dmc3105.statistics.collectors;

import com.dmc3105.statistics.types.Statistics;

public interface StatisticsCollector {
    void collectStatistics(String value);

    Statistics getStatistics();
}
