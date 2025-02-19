package tr.com.mustafacay.interceptor.performance;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@Getter
public class PerformanceMetrics {
    private final LongAdder totalTime = new LongAdder();
    private final LongAdder requestCount = new LongAdder();
    private long maxTime = 0;
    private long minTime = Long.MAX_VALUE;

    public void addRequest(long duration) {
        totalTime.add(duration);
        requestCount.increment();
        
        synchronized (this) {
            maxTime = Math.max(maxTime, duration);
            minTime = Math.min(minTime, duration);
        }
    }

    public double getAverageTime() {
        long count = requestCount.sum();
        return count > 0 ? totalTime.sum() / (double) count : 0;
    }

    public long getRequestCount() {
        return requestCount.sum();
    }
} 