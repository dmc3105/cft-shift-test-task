package com.dmc3105.statistics.collectors;

import com.dmc3105.statistics.types.ShortStatistics;
import com.dmc3105.statistics.types.Statistics;
import com.dmc3105.statistics.types.StringStatistics;

public class StringStatisticsCollector extends ShortStatisticsCollector {
    private int shortestStringLength;
    private int longestStringLength;

    @Override
    public void collectStatistics(String value) {
        super.collectStatistics(value);

        int stringLength = value.length();
        shortestStringLength = Math.min(stringLength, this.shortestStringLength);
        longestStringLength = Math.max(stringLength, this.longestStringLength);

    }

    @Override
    public Statistics getStatistics() {
        return new StringStatistics((ShortStatistics)super.getStatistics(), shortestStringLength, longestStringLength);
    }



    public int getShortestStringLength() {
        return shortestStringLength;
    }

    public void setShortestStringLength(int value) {
        this.shortestStringLength = value;
    }

    public int getLongestStringLength() {
        return longestStringLength;
    }

    public void setLongestStringLength(int value) {
        this.longestStringLength = value;
    }
}
