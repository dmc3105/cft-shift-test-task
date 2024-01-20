package com.dmc3105;

import com.dmc3105.statistics.collectors.StatisticsCollector;
import com.dmc3105.typeidentifier.Type;

import java.util.HashMap;
import java.util.Map;

public interface StatisticsCollectorsFactory {
    HashMap<Type,StatisticsCollector> createTypeStatisticsCollectorHashMap();
}