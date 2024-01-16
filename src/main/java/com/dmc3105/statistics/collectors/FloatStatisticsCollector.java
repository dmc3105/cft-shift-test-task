package com.dmc3105.statistics.collectors;

import com.dmc3105.statistics.types.NumberStatistics;
import com.dmc3105.statistics.types.ShortStatistics;
import com.dmc3105.statistics.types.Statistics;

public class FloatStatisticsCollector extends ShortStatisticsCollector{
    private float minValue;
    private float maxValue;
    private float sumOfValues;



    @Override
    public void collectStatistics(String value) {
        super.collectStatistics(value);
        float floatValue = Float.parseFloat(value);

        if (getWrittenElementsCount() <= 1)
        {
            minValue = floatValue;
            maxValue = floatValue;
        }
        minValue = Math.min(floatValue, minValue);
        maxValue = Math.max(floatValue, maxValue);
        sumOfValues+=floatValue;
    }

    @Override
    public Statistics getStatistics() throws EmptyStatisticsException{
        ShortStatistics shortStatistics = (ShortStatistics)super.getStatistics();
        return new NumberStatistics<Float>(
                shortStatistics,
                minValue,
                maxValue,
                sumOfValues,
                getAverageValue());
    }



    public float getMinValue() {
        return minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public float getSumOfValues() {
        return sumOfValues;
    }

    public float getAverageValue() {
        return sumOfValues / getWrittenElementsCount();
    }
}