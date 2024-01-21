package com.dmc3105.statistics.collectors;

public class EmptyStatisticsException extends RuntimeException {
    public EmptyStatisticsException() { super(); }
    public EmptyStatisticsException(String message) { super(message); }
    public EmptyStatisticsException(String message, Throwable cause) { super(message, cause); }
    public EmptyStatisticsException(Throwable cause) { super(cause); }
}