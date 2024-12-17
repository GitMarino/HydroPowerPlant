package com.hydropowerplant.waterlevel.businesslayer.object.event;

import java.util.Objects;

public class Event {

    private String recordedAt;

    public Event(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    public String getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Event event)) return false;
        return Objects.equals(recordedAt, event.recordedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(recordedAt);
    }

    @Override
    public String toString() {
        return "Event{" +
                "recordedAt='" + recordedAt + '\'' +
                '}';
    }

}
