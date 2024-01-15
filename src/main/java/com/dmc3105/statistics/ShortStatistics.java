package com.dmc3105.statistics;

public class ShortStatistics implements Statistics{
    private int writtenElementsCount;



    @Override
    public String asString() {
        return String.format("Количество элементов записанных в файлов: %d", writtenElementsCount);
    }



    public void addWrittenElementsCount(int value)
    {
        if (value <= 0)
        {
            throw new IllegalArgumentException("Added value cannot be less or equals 0");
        }
        writtenElementsCount +=value;
    }

    public void incrementWrittenElementsCount(){
        writtenElementsCount++;
    }



    public int getWrittenElementsCount() {
        return writtenElementsCount;
    }
}
