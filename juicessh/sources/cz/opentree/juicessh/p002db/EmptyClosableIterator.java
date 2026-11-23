package cz.opentree.juicessh.p002db;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class EmptyClosableIterator<T> implements CloseableIterator<T> {
    @Override // com.j256.ormlite.dao.CloseableIterator
    public void close() throws SQLException {
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public void closeQuietly() {
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T current() throws SQLException {
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T first() throws SQLException {
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public DatabaseResults getRawResults() {
        return null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T moveRelative(int i) throws SQLException {
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public void moveToNext() {
    }

    @Override // java.util.Iterator
    public T next() {
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T nextThrow() throws SQLException {
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T previous() throws SQLException {
        return null;
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
