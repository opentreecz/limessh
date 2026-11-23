package cz.opentree;

import android.net.Uri;
import android.provider.BaseColumns;
import com.j256.ormlite.field.FieldType;

/* compiled from: PluginContract.java */
/* loaded from: classes.dex */
public final class pj0 implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5713a = Uri.parse("content://cz.opentree.limessh.api.v1/pluginlog");

    static {
        String.format("rowid AS %s", FieldType.FOREIGN_ID_FIELD_SUFFIX);
    }
}
