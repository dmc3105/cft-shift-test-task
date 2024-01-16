package com.dmc3105.statistics.types;

public final class StringStatistics implements Statistics{
    private final ShortStatistics shortStatistics;
    private final int longestStringLength;
    private final int shortestStringLength;


    public StringStatistics(ShortStatistics shortStatistics, int shortestStringLength, int longestStringLength) {
        if (longestStringLength <= 0 || shortestStringLength <= 0)
        {
            throw new IllegalArgumentException("String length cannot be less than 0");
        }

        this.shortStatistics = shortStatistics;
        this.shortestStringLength = shortestStringLength;
        this.longestStringLength = longestStringLength;
    }



    @Override
    public String asString() {
        return shortStatistics.asString() + "\n" +
                String.format(
                        "Размер самой короткой строки: %d\n" +
                        "Размер самой длинной строки: %d",
                        shortestStringLength, longestStringLength);
    }

    public int getLongestStringLength() {
        return longestStringLength;
    }

    public int getShortestStringLength() {
        return shortestStringLength;
    }

    public Statistics getShortStatistics() {
        return shortStatistics;
    }
}
