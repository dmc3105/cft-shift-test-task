package com.dmc3105.statistics;

public class StringStatistics extends ShortStatistics {
    private int longestStringLength;
    private int shortestStringLength;



    public StringStatistics() {

    }

    public StringStatistics(int longestStringLength, int shortestStringLength) {
        setLongestStringLength(longestStringLength);
        setShortestStringLength(shortestStringLength);
    }



    @Override
    public String asString() {
        return super.asString() + "\n" +
                String.format(
                        "Размер самой короткой строки: %d\n" +
                        "Размер самой длинной строки: %d",
                        shortestStringLength, longestStringLength);
    }



    public int getLongestStringLength() {
        return longestStringLength;
    }

    public void setLongestStringLength(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("String length can't be less than 0");
        }
        else if (value <= this.longestStringLength)
        {
            throw new IllegalArgumentException("Setting value can't be less than current longest string length");
        }
        this.longestStringLength = value;
    }

    public int getShortestStringLength() {
        return shortestStringLength;
    }

    public void setShortestStringLength(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("String length can't be less than 0");
        }
        else if (value >= this.shortestStringLength)
        {
            throw new IllegalArgumentException("Setting value can't be more than current shortest string length");
        }
        this.shortestStringLength = value;
    }
}
