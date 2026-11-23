package com.sonelli;

import android.net.Uri;
import android.provider.BaseColumns;
import com.j256.ormlite.field.FieldType;

/* compiled from: PluginContract.java */
/* loaded from: classes.dex */
public final class lj0 implements BaseColumns {

    /* renamed from: a */
    public static final Uri f4848a = Uri.parse("content://com.sonelli.juicessh.api.v1/connectiongroupmemberships");

    static {
        String.format("rowid AS %s", FieldType.FOREIGN_ID_FIELD_SUFFIX);
    }
}
