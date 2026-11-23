package com.sonelli.libssh.adapter;

import com.sonelli.ek0;

/* loaded from: classes.dex */
public interface SSHPortForward {
    void close();

    boolean isClosed();

    void start() throws ek0;
}
