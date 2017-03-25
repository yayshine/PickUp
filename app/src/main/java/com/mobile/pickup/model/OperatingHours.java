package com.mobile.pickup.model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class OperatingHours {
    private long start;
    private long end;

    public OperatingHours() {
    }

    public OperatingHours(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
}
