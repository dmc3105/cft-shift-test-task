package com.dmc3105.statistics.types;

public final class NumberStatistics<T extends Number> implements Statistics{
    private final ShortStatistics shortStatistics;
    private final T minValue;
    private final T maxValue;
    private final T sumOfValues;
    private final T averageValue;



    public NumberStatistics(ShortStatistics shortStatistics, T minValue, T maxValue, T sumOfValues, T averageValue) {
        this.shortStatistics = shortStatistics;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.sumOfValues = sumOfValues;
        this.averageValue = averageValue;
    }



    @Override
    public String asString() {
        return shortStatistics.asString() + "\n" +
                String.format("""
                        Минимальное значение: %s
                        Максимальное значение: %s
                        Сумма всех значений: %s
                        Среднее всех значений: %s""",
                        minValue.toString(), maxValue.toString(),
                        sumOfValues.toString(), averageValue.toString());
    }


    public ShortStatistics getShortStatistics() {
        return shortStatistics;
    }

    public T getMinValue() {
        return minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public T getSumOfValues() {
        return sumOfValues;
    }

    public T getAverageValue() {
        return averageValue;
    }

}
