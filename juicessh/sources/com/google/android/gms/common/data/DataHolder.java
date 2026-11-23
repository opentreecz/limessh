package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1439k9;
import com.sonelli.C1496l9;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new C1496l9();

    /* renamed from: O */
    public final int f762O;

    /* renamed from: P */
    public final String[] f763P;

    /* renamed from: Q */
    public Bundle f764Q;

    /* renamed from: R */
    public final CursorWindow[] f765R;

    /* renamed from: S */
    public final int f766S;

    /* renamed from: T */
    public final Bundle f767T;

    /* renamed from: U */
    public int[] f768U;

    /* renamed from: V */
    public boolean f769V = false;

    /* renamed from: W */
    public boolean f770W = true;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.data.DataHolder$a */
    /* loaded from: classes.dex */
    public static class C0432a {
        public C0432a(String[] strArr, String str) {
            C0813ca.m2729k(strArr);
            new ArrayList();
            new HashMap();
        }

        public /* synthetic */ C0432a(String[] strArr, String str, C1439k9 c1439k9) {
            this(strArr, null);
        }
    }

    static {
        new C1439k9(new String[0], null);
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f762O = i;
        this.f763P = strArr;
        this.f765R = cursorWindowArr;
        this.f766S = i2;
        this.f767T = bundle;
    }

    /* renamed from: K */
    public final int m1031K() {
        return this.f766S;
    }

    /* renamed from: Y */
    public final boolean m1032Y() {
        boolean z;
        synchronized (this) {
            z = this.f769V;
        }
        return z;
    }

    /* renamed from: Z */
    public final void m1033Z() {
        this.f764Q = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.f763P;
            if (i2 >= strArr.length) {
                break;
            }
            this.f764Q.putInt(strArr[i2], i2);
            i2++;
        }
        this.f768U = new int[this.f765R.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f765R;
            if (i >= cursorWindowArr.length) {
                return;
            }
            this.f768U[i] = i3;
            i3 += this.f765R[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
            i++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f769V) {
                this.f769V = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f765R;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.f770W && this.f765R.length > 0 && !m1032Y()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + KeycodeConstants.KEYCODE_TV_INPUT);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4413r(parcel, 1, this.f763P, false);
        C1099ha.m4415t(parcel, 2, this.f765R, i, false);
        C1099ha.m4406k(parcel, 3, m1031K());
        C1099ha.m4400e(parcel, 4, m1034x(), false);
        C1099ha.m4406k(parcel, 1000, this.f762O);
        C1099ha.m4397b(parcel, m4396a);
        if ((i & 1) != 0) {
            close();
        }
    }

    /* renamed from: x */
    public final Bundle m1034x() {
        return this.f767T;
    }
}
