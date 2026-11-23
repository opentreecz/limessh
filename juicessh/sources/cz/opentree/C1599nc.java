package cz.opentree;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.nc */
/* loaded from: classes.dex */
public class C1599nc {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    /* renamed from: a */
    public static boolean m6663a(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
