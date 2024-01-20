package com.dmc3105;

import com.dmc3105.statistics.collectors.EmptyStatisticsException;
import com.dmc3105.statistics.collectors.StatisticsCollector;
import com.dmc3105.statistics.types.Statistics;
import com.dmc3105.typeidentifier.Type;
import com.dmc3105.typeidentifier.TypeIdentifier;

import java.util.HashMap;


public class ApplicationStatisticsCollector
{
    private final HashMap<Type, StatisticsCollector> typeStatisticsCollectorHashMap;
    private final HashMap<Type, String> typeStatisticsCollectorNameHashMap;

    public ApplicationStatisticsCollector(StatisticsCollectorsFactory factory) {
        this.typeStatisticsCollectorHashMap = factory.createTypeStatisticsCollectorHashMap();
        this.typeStatisticsCollectorNameHashMap = factory.createTypeStatisticsCollectorNameHashMap();
    }

    //TODO: Поработать с исключениями, а то все печально
    public void collectStatistics(String value, TypeIdentifier typeIdentifier)
    {
        Type type = typeIdentifier.identify(value);
        collectStatistics(value, type);
    }

    public void collectStatistics(String value, Type type)
    {
        typeStatisticsCollectorHashMap.get(type).collectStatistics(value);
    }

    public void printStatistics() throws EmptyStatisticsException {
        for (var entry : typeStatisticsCollectorHashMap.entrySet()) {
            String type = typeStatisticsCollectorNameHashMap.get(entry.getKey());
            System.out.println(String.format("Статистика по типу \"%s\"", type));
            StatisticsCollector collector = entry.getValue();
            if (!collector.isEmpty()) {
                Statistics statistics = collector.getStatistics();
                System.out.println(statistics.asString());
            } else {
                System.out.println("Статистика отсутствует");
            }
            System.out.println();
        }
    }

    private String getNameByType(Type type)
    {
        return typeStatisticsCollectorNameHashMap.get(type);
    }
}
