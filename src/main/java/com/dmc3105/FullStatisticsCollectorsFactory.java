package com.dmc3105;


import com.dmc3105.statistics.collectors.FloatStatisticsCollector;
import com.dmc3105.statistics.collectors.IntegerStatisticsCollector;
import com.dmc3105.statistics.collectors.StatisticsCollector;
import com.dmc3105.statistics.collectors.StringStatisticsCollector;
import com.dmc3105.typeidentifier.Type;

import java.util.HashMap;

public class FullStatisticsCollectorsFactory implements StatisticsCollectorsFactory {
    @Override
    public HashMap<Type, StatisticsCollector> createTypeStatisticsCollectorHashMap() {
        HashMap<Type, StatisticsCollector> resultHashMap = new HashMap<>();
        resultHashMap.put(Type.FLOAT, new FloatStatisticsCollector());
        resultHashMap.put(Type.STRING, new StringStatisticsCollector());
        resultHashMap.put(Type.INTEGER, new IntegerStatisticsCollector());
        return resultHashMap;
    }

    @Override
    public HashMap<Type, String> createTypeStatisticsCollectorNameHashMap() {
        HashMap<Type,String> resultedHashMap = new HashMap<>();
        resultedHashMap.put(Type.FLOAT, "Вещественное число");
        resultedHashMap.put(Type.INTEGER, "Целое число");
        resultedHashMap.put(Type.STRING, "Строка");
        return resultedHashMap;
    }
}
