package cz.opentree.libssh.adapter;

import cz.opentree.ek0;

/* loaded from: classes.dex */
public interface SSHPortForward {
    void close();

    boolean isClosed();

    void start() throws ek0;
}
