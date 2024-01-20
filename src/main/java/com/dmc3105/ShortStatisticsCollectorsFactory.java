package com.dmc3105;

import com.dmc3105.statistics.collectors.ShortStatisticsCollector;
import com.dmc3105.statistics.collectors.StatisticsCollector;
import com.dmc3105.typeidentifier.Type;

import java.util.HashMap;


public class ShortStatisticsCollectorsFactory implements StatisticsCollectorsFactory {
    @Override
    public HashMap<Type, StatisticsCollector> createTypeStatisticsCollectorHashMap() {
        HashMap<Type, StatisticsCollector> resultHashMap = new HashMap<>();
        resultHashMap.put(Type.FLOAT, new ShortStatisticsCollector());
        resultHashMap.put(Type.STRING, new ShortStatisticsCollector());
        resultHashMap.put(Type.INTEGER, new ShortStatisticsCollector());
        return resultHashMap;
    }
}
