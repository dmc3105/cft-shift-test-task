package com.dmc3105.statistics;

public final class ShortStatistics implements Statistics{
    private final int writtenElementsCount;



    public ShortStatistics(int writtenElementsCount) {
        this.writtenElementsCount = writtenElementsCount;
    }



    @Override
    public String asString() {
        return String.format("Количество элементов записанных в файлов: %d", writtenElementsCount);
    }



    public int getWrittenElementsCount()
    {
        return this.writtenElementsCount;
    }
}
