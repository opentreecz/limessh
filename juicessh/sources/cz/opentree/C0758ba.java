package cz.opentree;

import androidx.annotation.Nullable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.ba */
/* loaded from: classes.dex */
public final class C0758ba {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: cz.opentree.ba$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final List<String> f1616a;

        /* renamed from: b */
        public final Object f1617b;

        public a(Object obj) {
            C0813ca.m2729k(obj);
            this.f1617b = obj;
            this.f1616a = new ArrayList();
        }

        /* renamed from: a */
        public final a m2407a(String str, @Nullable Object obj) {
            List<String> list = this.f1616a;
            C0813ca.m2729k(str);
            String str2 = str;
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f1617b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f1616a.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.f1616a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static boolean m2404a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: b */
    public static int m2405b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: c */
    public static a m2406c(Object obj) {
        return new a(obj);
    }
}
