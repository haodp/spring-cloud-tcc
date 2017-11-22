package com.lakala.ppay.domain.type;

/**
 * @author user
 */
public enum EventStatus {
    ERROR(-128), NOT_FOUND(-3), NO_ROUTE(-2), FAILED(-1), NEW(0), PENDING(1), DONE(2);

    private final int status;

    EventStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
