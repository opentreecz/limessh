package com.j256.ormlite.dao;

import java.sql.SQLException;

/* loaded from: classes.dex */
public interface CloseableWrappedIterable<T> extends CloseableIterable<T> {
    void close() throws SQLException;

    @Override // com.j256.ormlite.dao.CloseableIterable
    /* synthetic */ CloseableIterator<T> closeableIterator();
}
