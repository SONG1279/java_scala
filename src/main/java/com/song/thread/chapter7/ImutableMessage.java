package com.song.thread.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImutableMessage {

    private final int sequenceNumber;

    private final List<String> values;

    public ImutableMessage(int sequenceNumber, List<String> values) {
        this.sequenceNumber = sequenceNumber;
        this.values = Collections.unmodifiableList(new ArrayList<>(values));

    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public List<String> getValues() {
        return values;
    }
}
