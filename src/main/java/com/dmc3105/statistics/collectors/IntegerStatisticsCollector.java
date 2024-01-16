package com.dmc3105.statistics.collectors;

import com.dmc3105.statistics.types.NumberStatistics;
import com.dmc3105.statistics.types.ShortStatistics;
import com.dmc3105.statistics.types.Statistics;

public class IntegerStatisticsCollector extends ShortStatisticsCollector{
    private int minValue;
    private int maxValue;
    private int sumOfValues;



    @Override
    public void collectStatistics(String value) {
        super.collectStatistics(value);
        int integerValue = Integer.parseInt(value);

        if (getWrittenElementsCount() <= 1)
        {
            minValue = integerValue;
            maxValue = integerValue;
        }
        minValue = Math.min(integerValue, minValue);
        maxValue = Math.max(integerValue, maxValue);
        sumOfValues+=integerValue;
    }

    @Override
    public Statistics getStatistics() throws EmptyStatisticsException{
        ShortStatistics shortStatistics = (ShortStatistics)super.getStatistics();
        return new NumberStatistics<Integer>(
                shortStatistics,
                minValue,
                maxValue,
                sumOfValues,
                getAverageValue());
    }



    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getSumOfValues() {
        return sumOfValues;
    }

    public int getAverageValue() {
        return sumOfValues / getWrittenElementsCount();
    }
}
