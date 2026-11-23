package cz.opentree;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.ha */
/* loaded from: classes.dex */
public class C1099ha {
    /* renamed from: a */
    public static int m4396a(Parcel parcel) {
        return m4417v(parcel, 20293);
    }

    /* renamed from: b */
    public static void m4397b(Parcel parcel, int i) {
        m4419x(parcel, i);
    }

    /* renamed from: c */
    public static void m4398c(Parcel parcel, int i, boolean z) {
        m4420y(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: d */
    public static void m4399d(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            m4420y(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            m4420y(parcel, i, 0);
        }
    }

    /* renamed from: e */
    public static void m4400e(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.writeBundle(bundle);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: f */
    public static void m4401f(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.writeByteArray(bArr);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: g */
    public static void m4402g(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            m4420y(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            m4420y(parcel, i, 0);
        }
    }

    /* renamed from: h */
    public static void m4403h(Parcel parcel, int i, float f) {
        m4420y(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: i */
    public static void m4404i(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            m4420y(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            m4420y(parcel, i, 0);
        }
    }

    /* renamed from: j */
    public static void m4405j(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: k */
    public static void m4406k(Parcel parcel, int i, int i2) {
        m4420y(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: l */
    public static void m4407l(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m4420y(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            m4420y(parcel, i, 0);
        }
    }

    /* renamed from: m */
    public static void m4408m(Parcel parcel, int i, long j) {
        m4420y(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: n */
    public static void m4409n(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m4420y(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m4420y(parcel, i, 0);
        }
    }

    /* renamed from: o */
    public static void m4410o(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: p */
    public static void m4411p(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: q */
    public static void m4412q(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.writeString(str);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: r */
    public static void m4413r(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.writeStringArray(strArr);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: s */
    public static void m4414s(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                m4420y(parcel, i, 0);
            }
        } else {
            int m4417v = m4417v(parcel, i);
            parcel.writeStringList(list);
            m4419x(parcel, m4417v);
        }
    }

    /* renamed from: t */
    public static <T extends Parcelable> void m4415t(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                m4420y(parcel, i, 0);
                return;
            }
            return;
        }
        int m4417v = m4417v(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m4418w(parcel, t, i2);
            }
        }
        m4419x(parcel, m4417v);
    }

    /* renamed from: u */
    public static <T extends Parcelable> void m4416u(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                m4420y(parcel, i, 0);
                return;
            }
            return;
        }
        int m4417v = m4417v(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m4418w(parcel, t, 0);
            }
        }
        m4419x(parcel, m4417v);
    }

    /* renamed from: v */
    public static int m4417v(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: w */
    public static <T extends Parcelable> void m4418w(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: x */
    public static void m4419x(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: y */
    public static void m4420y(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
        } else {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
        }
    }
}
