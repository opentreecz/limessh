package cz.opentree;

import android.net.Uri;
import com.j256.ormlite.field.FieldType;

/* compiled from: PluginContract.java */
/* loaded from: classes.dex */
public final class oj0 extends nj0 {

    /* renamed from: b */
    public static final Uri f5502b = Uri.parse("content://cz.opentree.limessh.api.v1/ec2connections");

    static {
        String.format("rowid AS %s", FieldType.FOREIGN_ID_FIELD_SUFFIX);
        String.format("COALESCE(NULLIF(nickname,''), address) AS %s", "name");
    }
}
