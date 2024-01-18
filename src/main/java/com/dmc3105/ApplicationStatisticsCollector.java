package com.dmc3105;

import com.dmc3105.statistics.collectors.EmptyStatisticsException;
import com.dmc3105.statistics.collectors.StatisticsCollector;
import com.dmc3105.statistics.types.Statistics;
import com.dmc3105.typeidentifier.RegexTypeIdentifier;
import com.dmc3105.typeidentifier.Type;
import com.dmc3105.typeidentifier.TypeIdentifier;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class ApplicationStatisticsCollector
{
    private final SortedMap<Type, StatisticsCollector> typeStatisticsCollectorHashMap;
    public ApplicationStatisticsCollector(StatisticsCollectorsFactory factory) {
        typeStatisticsCollectorHashMap = new TreeMap<>();
        typeStatisticsCollectorHashMap.put(Type.FLOAT, factory.createFloatStatisticsCollector());
        typeStatisticsCollectorHashMap.put(Type.INTEGER, factory.createIntegerStatisticsCollector());
        typeStatisticsCollectorHashMap.put(Type.STRING, factory.createStringStatisticsCollector());
    }

    public void collectStatistics(String value, TypeIdentifier typeIdentifier)
    {
        Type type = typeIdentifier.identify(value);
        collectStatistics(value, type);
    }

    public void collectStatistics(String value, Type type)
    {
        typeStatisticsCollectorHashMap.get(type).collectStatistics(value);
    }

    public void printStatistics()
    {
        for (var entry : typeStatisticsCollectorHashMap.entrySet()) {
            System.out.println(entry.getKey());
            StatisticsCollector collector = entry.getValue();
            if (!collector.isEmpty())
            {
                Statistics statistics;
                try {
                    statistics = collector.getStatistics();
                    System.out.println(statistics.asString());
                } catch (EmptyStatisticsException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Статистика отсутствует");
            }
        }
    }
}
