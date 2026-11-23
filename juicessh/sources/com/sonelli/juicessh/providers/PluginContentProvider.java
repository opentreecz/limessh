package com.sonelli.juicessh.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.sonelli.gj0;
import com.sonelli.juicessh.activities.PurchaseActivity;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.ConnectionGroup;
import com.sonelli.juicessh.models.ConnectionGroupMembership;
import com.sonelli.juicessh.models.PluginLog;
import com.sonelli.juicessh.models.PortForward;
import com.sonelli.juicessh.models.Snippet;
import com.sonelli.juicessh.models.ec2link.Ec2Connection;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.kj0;
import com.sonelli.lj0;
import com.sonelli.mj0;
import com.sonelli.nj0;
import com.sonelli.oj0;
import com.sonelli.pi0;
import com.sonelli.pj0;
import com.sonelli.qj0;
import com.sonelli.rj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class PluginContentProvider extends ContentProvider {

    /* renamed from: O */
    public static final UriMatcher f4147O;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f4147O = uriMatcher;
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "connections", 1);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "connections/*", 2);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "ec2connections", 13);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "ec2connections/*", 14);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "snippets", 3);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "snippets/*", 4);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "portforwards", 5);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "portforwards/*", 6);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "connectiongroups", 7);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "connectiongroups/*", 8);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "connectiongroupmemberships", 9);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "connectiongroupmemberships/*", 10);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "pluginlog", 11);
        uriMatcher.addURI("com.sonelli.juicessh.api.v1", "pluginlog/*", 12);
    }

    /* renamed from: a */
    public final boolean m5604a(String str, String[] strArr) {
        if (str == null && strArr == null) {
            return true;
        }
        String[] strArr2 = {"select", "identity", "given_name", "family_name", NotificationCompat.CATEGORY_EMAIL, "picture", "signature", "sessionIdentifier", "username", "privatekey", "password", "encryption"};
        for (int i = 0; i < 12; i++) {
            String str2 = strArr2[i];
            if (str != null) {
                Locale locale = Locale.ENGLISH;
                if (str.toLowerCase(locale).contains(str2.toLowerCase(locale))) {
                    return false;
                }
            }
            for (String str3 : strArr) {
                Locale locale2 = Locale.ENGLISH;
                if (str3.toLowerCase(locale2).contains(str2.toLowerCase(locale2))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    public final Uri m5605b(Uri uri, long j) {
        Cursor query = C1328DB.m5402b(getContext()).getWritableDatabase().query(m5608e(uri), new String[]{"id"}, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        UUID fromString = query.moveToNext() ? UUID.fromString(query.getString(0)) : null;
        query.close();
        switch (f4147O.match(uri)) {
            case 1:
            case 2:
                return Uri.withAppendedPath(nj0.f5302a, String.valueOf(fromString));
            case 3:
            case 4:
                return Uri.withAppendedPath(rj0.f6224a, String.valueOf(fromString));
            case 5:
            case 6:
                return Uri.withAppendedPath(qj0.f6012a, String.valueOf(fromString));
            case 7:
            case 8:
                return Uri.withAppendedPath(mj0.f5084a, String.valueOf(fromString));
            case 9:
            case 10:
                return Uri.withAppendedPath(lj0.f4848a, String.valueOf(fromString));
            case 11:
            case 12:
                return Uri.withAppendedPath(pj0.f5713a, String.valueOf(fromString));
            case 13:
            case 14:
                return Uri.withAppendedPath(oj0.f5502b, String.valueOf(fromString));
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    /* renamed from: c */
    public final String m5606c(Uri uri) throws IllegalArgumentException {
        switch (f4147O.match(uri)) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return "id";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    /* renamed from: d */
    public final Class m5607d(Uri uri) {
        switch (f4147O.match(uri)) {
            case 1:
            case 2:
                return Connection.class;
            case 3:
            case 4:
                return Snippet.class;
            case 5:
            case 6:
                return PortForward.class;
            case 7:
            case 8:
                return ConnectionGroup.class;
            case 9:
            case 10:
                return ConnectionGroupMembership.class;
            case 11:
            case 12:
                return PluginLog.class;
            case 13:
            case 14:
                return Ec2Connection.class;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x005f. Please report as an issue. */
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int deleteIds;
        int i = 0;
        if (!kj0.m5917a().m5929i()) {
            return 0;
        }
        if (kj0.m5917a().m5930j() && !pi0.m7334m(getContext())) {
            Intent intent = new Intent(getContext(), (Class<?>) PurchaseActivity.class);
            intent.putExtra("LAUNCHED_FROM_PLUGIN", true);
            intent.setFlags(268566528);
            getContext().startActivity(intent);
            return 0;
        }
        if (!m5604a(str, strArr)) {
            return 0;
        }
        String lastPathSegment = uri.getLastPathSegment();
        switch (f4147O.match(uri)) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                try {
                    List<String[]> results = C1328DB.m5404d(m5607d(uri), getContext()).queryRaw("SELECT id FROM " + m5608e(uri) + " WHERE " + str, strArr).getResults();
                    ArrayList arrayList = new ArrayList();
                    for (String[] strArr2 : results) {
                        try {
                            try {
                                arrayList.add(UUID.fromString(strArr2[0]));
                            } catch (NullPointerException unused) {
                                gj0.m4142c("PluginContentProvider", "Couldn't delete " + m5607d(uri).getName() + " with null id");
                            }
                        } catch (IllegalArgumentException unused2) {
                            gj0.m4142c("PluginContentProvider", "Couldn't delete " + m5607d(uri).getName() + " with invalid id: " + strArr2[0]);
                        }
                    }
                    deleteIds = C1328DB.m5404d(m5607d(uri), getContext()).deleteIds(arrayList);
                    i = 0 + deleteIds;
                } catch (SQLException e) {
                    gj0.m4142c("PluginContentProvider", "Error while deleting " + m5607d(uri).getName() + " via content provider: " + e.getMessage());
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return i;
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
                try {
                    List<String[]> results2 = C1328DB.m5404d(m5607d(uri), getContext()).queryRaw(TextUtils.isEmpty(str) ? "SELECT id FROM " + m5608e(uri) + " WHERE " + m5606c(uri) + " = '" + lastPathSegment + "'" : "SELECT id FROM " + m5608e(uri) + " WHERE " + m5606c(uri) + " = '" + lastPathSegment + "' AND " + str, strArr).getResults();
                    ArrayList arrayList2 = new ArrayList();
                    for (String[] strArr3 : results2) {
                        try {
                            try {
                                arrayList2.add(UUID.fromString(strArr3[0]));
                            } catch (IllegalArgumentException unused3) {
                                gj0.m4142c("PluginContentProvider", "Couldn't delete " + m5607d(uri).getName() + " with invalid id: " + strArr3[0]);
                            }
                        } catch (NullPointerException unused4) {
                            gj0.m4142c("PluginContentProvider", "Couldn't delete " + m5607d(uri).getName() + " with null id");
                        }
                    }
                    deleteIds = C1328DB.m5404d(m5607d(uri), getContext()).deleteIds(arrayList2);
                    i = 0 + deleteIds;
                } catch (SQLException e2) {
                    gj0.m4142c("PluginContentProvider", "Error while deleting " + m5607d(uri).getName() + " via content provider: " + e2.getMessage());
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return i;
            case 11:
            case 12:
            case 13:
            case 14:
                return 0;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    /* renamed from: e */
    public final String m5608e(Uri uri) {
        switch (f4147O.match(uri)) {
            case 1:
            case 2:
                return "connection";
            case 3:
            case 4:
                return "snippet";
            case 5:
            case 6:
                return "portforward";
            case 7:
            case 8:
                return "connectiongroup";
            case 9:
            case 10:
                return "connectiongroupmembership";
            case 11:
            case 12:
                return "plugin_log";
            case 13:
            case 14:
                return "ec2connection";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f4147O.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.connection";
            case 2:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.connection";
            case 3:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.snippet";
            case 4:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.snippet";
            case 5:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.portforward";
            case 6:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.portforward";
            case 7:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.connectiongroup";
            case 8:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.connectiongroup";
            case 9:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.connectiongroupmembership";
            case 10:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.connectiongroupmembership";
            case 11:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.pluginlog";
            case 12:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.pluginlog";
            case 13:
                return "vnd.android.cursor.dir/com.sonelli.juicessh.models.ec2link.ec2connection";
            case 14:
                return "vnd.android.cursor.item/com.sonelli.juicessh.models.ec2link.ec2connection";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!kj0.m5917a().m5929i()) {
            return null;
        }
        if (kj0.m5917a().m5930j() && !pi0.m7334m(getContext())) {
            Intent intent = new Intent(getContext(), (Class<?>) PurchaseActivity.class);
            intent.putExtra("LAUNCHED_FROM_PLUGIN", true);
            intent.setFlags(268566528);
            getContext().startActivity(intent);
            return null;
        }
        switch (f4147O.match(uri)) {
            case 11:
            case 12:
            case 13:
            case 14:
                return null;
            default:
                SQLiteDatabase writableDatabase = C1328DB.m5402b(getContext()).getWritableDatabase();
                contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                long insert = writableDatabase.insert(m5608e(uri), null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return m5605b(uri, insert);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!kj0.m5917a().m5929i()) {
            return null;
        }
        if (kj0.m5917a().m5930j() && !pi0.m7334m(getContext())) {
            Intent intent = new Intent(getContext(), (Class<?>) PurchaseActivity.class);
            intent.putExtra("LAUNCHED_FROM_PLUGIN", true);
            intent.setFlags(268566528);
            getContext().startActivity(intent);
            return null;
        }
        if (!m5604a(str, strArr2)) {
            return null;
        }
        SQLiteDatabase readableDatabase = C1328DB.m5402b(getContext()).getReadableDatabase();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        if (TextUtils.isEmpty(str2) && Arrays.asList(strArr).contains("COALESCE(NULLIF(nickname,''), address) AS name")) {
            str2 = "name COLLATE NOCASE ASC";
        }
        String str3 = str2;
        sQLiteQueryBuilder.setTables(m5608e(uri));
        int match = f4147O.match(uri);
        if (match == 2 || match == 4 || match == 6 || match == 8 || match == 10 || match == 12 || match == 14) {
            sQLiteQueryBuilder.appendWhere(m5606c(uri) + " = " + uri.getLastPathSegment());
        }
        Cursor query = sQLiteQueryBuilder.query(readableDatabase, strArr, str, strArr2, null, null, str3);
        getContext().getContentResolver().notifyChange(uri, null);
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        if (!kj0.m5917a().m5929i()) {
            return 0;
        }
        if (kj0.m5917a().m5930j() && !pi0.m7334m(getContext())) {
            Intent intent = new Intent(getContext(), (Class<?>) PurchaseActivity.class);
            intent.putExtra("LAUNCHED_FROM_PLUGIN", true);
            intent.setFlags(268566528);
            getContext().startActivity(intent);
            return 0;
        }
        if (!m5604a(str, strArr)) {
            return 0;
        }
        SQLiteDatabase writableDatabase = C1328DB.m5402b(getContext()).getWritableDatabase();
        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
        String lastPathSegment = uri.getLastPathSegment();
        switch (f4147O.match(uri)) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                update = writableDatabase.update(m5608e(uri), contentValues, str, strArr);
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
                if (!TextUtils.isEmpty(str)) {
                    update = writableDatabase.update(m5608e(uri), contentValues, m5606c(uri) + "= \"" + lastPathSegment + "\" and " + str, strArr);
                    break;
                } else {
                    update = writableDatabase.update(m5608e(uri), contentValues, m5606c(uri) + "= \"" + lastPathSegment + "\"", null);
                    break;
                }
            case 11:
            case 12:
            case 13:
            case 14:
                return 0;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return update;
    }
}
