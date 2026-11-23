package com.sonelli.juicessh.p002db;

import android.content.Context;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;
import com.sonelli.gj0;
import com.sonelli.juicessh.models.DeletedItem;
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.p002db.BaseModel;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class DAO<T extends BaseModel<?>, ID> extends BaseDaoImpl<T, ID> {

    /* renamed from: O */
    public Context f3997O;

    public DAO(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, User.class);
    }

    public DAO(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        super(connectionSource, databaseTableConfig);
    }

    public DAO(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        super(connectionSource, cls);
    }

    public DAO(Class<T> cls) throws SQLException {
        super(cls);
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    public int delete(Collection<T> collection) throws SQLException {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            m5393m(it.next().f3993id);
        }
        try {
            return super.delete((Collection) collection);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    public int deleteById(ID id) throws SQLException {
        m5393m((UUID) id);
        try {
            return super.deleteById(id);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    public int deleteIds(Collection<ID> collection) throws SQLException {
        Iterator<ID> it = collection.iterator();
        while (it.hasNext()) {
            m5393m((UUID) it.next());
        }
        try {
            return super.deleteIds(collection);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int create(T t) throws SQLException {
        Context context;
        t.modified = System.currentTimeMillis();
        try {
            int create = super.create(t);
            if (create > 0 && (context = this.f3997O) != null) {
                t.m5381k(context);
            }
            return create;
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public T createIfNotExists(T t) throws SQLException {
        t.modified = System.currentTimeMillis();
        try {
            return (T) super.createIfNotExists(t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Dao.CreateOrUpdateStatus createOrUpdate(T t) throws SQLException {
        t.modified = System.currentTimeMillis();
        try {
            return super.createOrUpdate(t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: h */
    public int m5389h(T t) throws SQLException {
        t.modified = System.currentTimeMillis();
        try {
            return super.create(t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: i */
    public int m5390i(T t) throws SQLException {
        try {
            return super.create(t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        try {
            return super.iterator();
        } catch (IllegalStateException unused) {
            return new EmptyClosableIterator();
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int delete(T t) throws SQLException {
        m5393m(t.f3993id);
        try {
            return super.delete((DAO<T, ID>) t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: k */
    public int m5392k(T t) throws SQLException {
        try {
            return super.delete((DAO<T, ID>) t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: m */
    public void m5393m(UUID uuid) {
        gj0.m4141b("DB/DAO", "Intercepted a delete() for: " + getDataClass().getName() + " (" + uuid.toString() + ")");
        try {
            DeletedItem deletedItem = new DeletedItem();
            deletedItem.f3993id = uuid;
            DaoManager.createDao(this.connectionSource, DeletedItem.class).createIfNotExists(deletedItem);
        } catch (SQLException e) {
            gj0.m4142c("DB/DAO", "Unable to save intercepted delete() record. " + e.getMessage());
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public T queryForId(ID id) throws SQLException {
        try {
            return (T) super.queryForId(id);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: o */
    public List<T> m5395o(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next.modified < 1) {
                try {
                    gj0.m4142c("DB/DAO", "Found invalid " + next.getClass().getName() + ": " + next.f3993id.toString());
                    m5392k(next);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                it.remove();
            }
        }
        return list;
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int update(T t) throws SQLException {
        Context context;
        t.modified = System.currentTimeMillis();
        try {
            int update = super.update((DAO<T, ID>) t);
            if (update > 0 && (context = this.f3997O) != null) {
                t.m5381k(context);
            }
            return update;
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int updateId(T t, ID id) throws SQLException {
        t.modified = System.currentTimeMillis();
        try {
            return super.updateId(t, id);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        try {
            List<T> query = super.query(preparedQuery);
            m5395o(query);
            return query;
        } catch (IllegalStateException unused) {
            throw new SQLException("Database closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    public List<T> queryForAll() throws SQLException {
        try {
            List<T> queryForAll = super.queryForAll();
            m5395o(queryForAll);
            return queryForAll;
        } catch (IllegalStateException unused) {
            throw new SQLException("Database closed");
        }
    }

    @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao
    public List<T> queryForEq(String str, Object obj) throws SQLException {
        try {
            List<T> queryForEq = super.queryForEq(str, obj);
            m5395o(queryForEq);
            return queryForEq;
        } catch (IllegalStateException unused) {
            throw new SQLException("Database closed");
        }
    }

    /* renamed from: r */
    public int m5398r(T t) throws SQLException {
        t.modified = System.currentTimeMillis();
        try {
            return super.update((DAO<T, ID>) t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: s */
    public int m5399s(T t) throws SQLException {
        try {
            return super.update((DAO<T, ID>) t);
        } catch (IllegalStateException unused) {
            throw new SQLException("Database Closed");
        }
    }

    /* renamed from: t */
    public void m5400t() {
        try {
            TableUtils.clearTable(this.connectionSource, getDataClass());
        } catch (SQLException e) {
            gj0.m4142c("DB/DAO", "Unable to wipe DB " + getDataClass().getName() + ": " + e.getMessage());
        }
    }
}
