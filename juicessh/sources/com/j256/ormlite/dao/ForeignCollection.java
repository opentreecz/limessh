package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Collection;

/* loaded from: classes.dex */
public interface ForeignCollection<T> extends Collection<T>, CloseableIterable<T> {
    @Override // java.util.Collection
    boolean add(T t);

    void closeLastIterator() throws SQLException;

    /* synthetic */ CloseableIterator<T> closeableIterator();

    CloseableWrappedIterable<T> getWrappedIterable();

    boolean isEager();

    CloseableIterator<T> iteratorThrow() throws SQLException;

    int refresh(T t) throws SQLException;

    int refreshAll() throws SQLException;

    int refreshCollection() throws SQLException;

    int update(T t) throws SQLException;

    int updateAll() throws SQLException;
}
