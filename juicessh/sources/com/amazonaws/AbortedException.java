package com.amazonaws;

/* loaded from: classes.dex */
public class AbortedException extends AmazonClientException {
    public AbortedException() {
        super("");
    }

    @Override // com.amazonaws.AmazonClientException
    public boolean isRetryable() {
        return false;
    }
}
