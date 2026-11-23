package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5158840898186237589L;
    public final transient Dao<T, ID> dao;
    private final transient FieldType foreignFieldType;
    private final transient boolean orderAscending;
    private final transient String orderColumn;
    private final transient Object parent;
    private final transient Object parentId;
    private transient PreparedQuery<T> preparedQuery;

    public BaseForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        this.dao = dao;
        this.foreignFieldType = fieldType;
        this.parentId = obj2;
        this.orderColumn = str;
        this.orderAscending = z;
        this.parent = obj;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection, java.util.Collection
    public boolean add(T t) {
        try {
            if (this.parent != null && this.foreignFieldType.getFieldValueIfNotDefault(t) == null) {
                this.foreignFieldType.assignField(t, this.parent, true, null);
            }
            Dao<T, ID> dao = this.dao;
            if (dao == null) {
                return false;
            }
            dao.create(t);
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Could not create data element in dao", e);
        }
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        if (this.dao == null) {
            return false;
        }
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            try {
                this.dao.create(it.next());
                z = true;
            } catch (SQLException e) {
                throw new IllegalStateException("Could not create data elements in dao", e);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        if (this.dao == null) {
            return;
        }
        CloseableIterator<T> closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                closeableIterator.next();
                closeableIterator.remove();
            } finally {
                try {
                    closeableIterator.close();
                } catch (SQLException unused) {
                }
            }
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ void closeLastIterator() throws SQLException;

    @Override // com.j256.ormlite.dao.ForeignCollection, com.j256.ormlite.dao.CloseableIterable
    public abstract /* synthetic */ CloseableIterator<T> closeableIterator();

    public PreparedQuery<T> getPreparedQuery() throws SQLException {
        if (this.dao == null) {
            return null;
        }
        if (this.preparedQuery == null) {
            SelectArg selectArg = new SelectArg();
            selectArg.setValue(this.parentId);
            QueryBuilder<T, ID> queryBuilder = this.dao.queryBuilder();
            String str = this.orderColumn;
            if (str != null) {
                queryBuilder.orderBy(str, this.orderAscending);
            }
            PreparedQuery<T> prepare = queryBuilder.where().m1916eq(this.foreignFieldType.getColumnName(), selectArg).prepare();
            this.preparedQuery = prepare;
            if (prepare instanceof MappedPreparedStmt) {
                ((MappedPreparedStmt) prepare).setParentInformation(this.parent, this.parentId);
            }
        }
        return this.preparedQuery;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableWrappedIterable<T> getWrappedIterable();

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ boolean isEager();

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableIterator<T> iteratorThrow() throws SQLException;

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refresh(T t) throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return 0;
        }
        return dao.refresh(t);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ int refreshAll() throws SQLException;

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ int refreshCollection() throws SQLException;

    @Override // java.util.Collection
    public abstract boolean remove(Object obj);

    @Override // java.util.Collection
    public abstract boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        if (this.dao == null) {
            return false;
        }
        CloseableIterator<T> closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                if (!collection.contains(closeableIterator.next())) {
                    closeableIterator.remove();
                    z = true;
                }
            } finally {
                try {
                    closeableIterator.close();
                } catch (SQLException unused) {
                }
            }
        }
        return z;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int update(T t) throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return 0;
        }
        return dao.update((Dao<T, ID>) t);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ int updateAll() throws SQLException;
}
