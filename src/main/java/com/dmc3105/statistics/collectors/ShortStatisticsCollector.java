package com.dmc3105.statistics.collectors;

import com.dmc3105.statistics.types.ShortStatistics;
import com.dmc3105.statistics.types.Statistics;

public class ShortStatisticsCollector implements StatisticsCollector {
    private int writtenElementsCount = 0;
    private boolean isEmpty = true;

    @Override
    public void collectStatistics(String value) {
        writtenElementsCount++;
        isEmpty = false;
    }

    @Override
    public Statistics getStatistics() throws EmptyStatisticsException{
        if (isEmpty())
        {
            throw new EmptyStatisticsException("Can't return empty statistic");
        }
        return new ShortStatistics(writtenElementsCount);
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }



    public int getWrittenElementsCount() {
        return writtenElementsCount;
    }
}
