package cz.opentree.limessh.pluginlibrary.parcelables;

import android.os.Parcel;
import android.os.Parcelable;
import cz.opentree.lk0;

/* loaded from: classes.dex */
public class ParcelableAttributesEntry implements Parcelable {
    public static final Parcelable.Creator<ParcelableAttributesEntry> CREATOR = new C1363a();

    /* renamed from: O */
    public String f4120O;

    /* renamed from: P */
    public String f4121P;

    /* renamed from: Q */
    public String f4122Q;

    /* renamed from: R */
    public int f4123R;

    /* renamed from: S */
    public long f4124S;

    /* renamed from: T */
    public int f4125T;

    /* renamed from: U */
    public int f4126U;

    /* renamed from: V */
    public String f4127V;

    /* renamed from: W */
    public String f4128W;

    /* renamed from: X */
    public int f4129X;

    /* renamed from: Y */
    public long f4130Y;

    /* renamed from: Z */
    public int f4131Z;

    /* renamed from: a0 */
    public int f4132a0;

    /* renamed from: b0 */
    public long f4133b0;

    /* renamed from: c0 */
    public int f4134c0;

    /* renamed from: d0 */
    public long f4135d0;

    /* renamed from: e0 */
    public int f4136e0;

    /* renamed from: f0 */
    public int f4137f0;

    /* renamed from: g0 */
    public String f4138g0;

    /* renamed from: h0 */
    public int f4139h0;

    /* renamed from: i0 */
    public String f4140i0;

    /* renamed from: j0 */
    public String f4141j0;

    /* renamed from: k0 */
    public boolean f4142k0;

    /* renamed from: l0 */
    public boolean f4143l0;

    /* renamed from: m0 */
    public short f4144m0;

    /* renamed from: n0 */
    public int f4145n0;

    /* renamed from: o0 */
    public String f4146o0;

    /* renamed from: cz.opentree.limessh.pluginlibrary.parcelables.ParcelableAttributesEntry$a */
    /* loaded from: classes.dex */
    public static class C1363a implements Parcelable.Creator<ParcelableAttributesEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableAttributesEntry createFromParcel(Parcel parcel) {
            return new ParcelableAttributesEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableAttributesEntry[] newArray(int i) {
            return new ParcelableAttributesEntry[i];
        }
    }

    public ParcelableAttributesEntry(Parcel parcel) {
        this.f4120O = (String) parcel.readSerializable();
        this.f4121P = (String) parcel.readSerializable();
        this.f4122Q = (String) parcel.readSerializable();
        ((Integer) parcel.readSerializable()).intValue();
        this.f4123R = ((Integer) parcel.readSerializable()).intValue();
        this.f4124S = ((Long) parcel.readSerializable()).longValue();
        this.f4125T = ((Integer) parcel.readSerializable()).intValue();
        this.f4126U = ((Integer) parcel.readSerializable()).intValue();
        this.f4127V = (String) parcel.readSerializable();
        this.f4128W = (String) parcel.readSerializable();
        this.f4129X = ((Integer) parcel.readSerializable()).intValue();
        this.f4130Y = ((Long) parcel.readSerializable()).longValue();
        this.f4131Z = ((Integer) parcel.readSerializable()).intValue();
        this.f4132a0 = ((Integer) parcel.readSerializable()).intValue();
        this.f4133b0 = ((Long) parcel.readSerializable()).longValue();
        this.f4134c0 = ((Integer) parcel.readSerializable()).intValue();
        this.f4135d0 = ((Long) parcel.readSerializable()).longValue();
        this.f4136e0 = ((Integer) parcel.readSerializable()).intValue();
        this.f4137f0 = ((Integer) parcel.readSerializable()).intValue();
        this.f4138g0 = (String) parcel.readSerializable();
        this.f4139h0 = ((Integer) parcel.readSerializable()).intValue();
        this.f4140i0 = (String) parcel.readSerializable();
        this.f4141j0 = (String) parcel.readSerializable();
        this.f4142k0 = ((Boolean) parcel.readSerializable()).booleanValue();
        this.f4143l0 = ((Boolean) parcel.readSerializable()).booleanValue();
        this.f4144m0 = ((Short) parcel.readSerializable()).shortValue();
        this.f4145n0 = ((Integer) parcel.readSerializable()).intValue();
        this.f4146o0 = (String) parcel.readSerializable();
    }

    public ParcelableAttributesEntry(lk0 lk0Var) {
        this.f4120O = lk0Var.f4851a;
        String str = lk0Var.f4852b;
        this.f4121P = str;
        this.f4122Q = str;
        int i = lk0Var.f4861k;
        int i2 = lk0Var.f4862l;
        this.f4123R = i2;
        this.f4124S = lk0Var.f4863m;
        this.f4125T = lk0Var.f4864n;
        this.f4126U = lk0Var.f4865o;
        this.f4127V = lk0Var.f4853c;
        this.f4128W = lk0Var.f4854d;
        this.f4129X = lk0Var.f4866p;
        this.f4130Y = lk0Var.f4867q;
        this.f4131Z = lk0Var.f4868r;
        this.f4132a0 = lk0Var.f4869s;
        this.f4133b0 = lk0Var.f4870t;
        this.f4134c0 = lk0Var.f4871u;
        this.f4135d0 = lk0Var.f4872v;
        this.f4136e0 = lk0Var.f4873w;
        this.f4137f0 = lk0Var.f4874x;
        this.f4138g0 = lk0Var.f4855e;
        this.f4139h0 = lk0Var.f4875y;
        this.f4140i0 = lk0Var.f4856f;
        this.f4141j0 = lk0Var.f4857g;
        this.f4142k0 = i2 == 2;
        this.f4143l0 = i2 == 3;
        this.f4144m0 = lk0Var.f4858h.shortValue();
        this.f4145n0 = lk0Var.f4859i;
        this.f4146o0 = lk0Var.f4860j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f4122Q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f4120O);
        parcel.writeSerializable(this.f4121P);
        parcel.writeSerializable(this.f4122Q);
        parcel.writeSerializable(Integer.valueOf(i));
        parcel.writeSerializable(Integer.valueOf(this.f4123R));
        parcel.writeSerializable(Long.valueOf(this.f4124S));
        parcel.writeSerializable(Integer.valueOf(this.f4125T));
        parcel.writeSerializable(Integer.valueOf(this.f4126U));
        parcel.writeSerializable(this.f4127V);
        parcel.writeSerializable(this.f4128W);
        parcel.writeSerializable(Integer.valueOf(this.f4129X));
        parcel.writeSerializable(Long.valueOf(this.f4130Y));
        parcel.writeSerializable(Integer.valueOf(this.f4131Z));
        parcel.writeSerializable(Integer.valueOf(this.f4132a0));
        parcel.writeSerializable(Long.valueOf(this.f4133b0));
        parcel.writeSerializable(Integer.valueOf(this.f4134c0));
        parcel.writeSerializable(Long.valueOf(this.f4135d0));
        parcel.writeSerializable(Integer.valueOf(this.f4136e0));
        parcel.writeSerializable(Integer.valueOf(this.f4137f0));
        parcel.writeSerializable(this.f4138g0);
        parcel.writeSerializable(Integer.valueOf(this.f4139h0));
        parcel.writeSerializable(this.f4140i0);
        parcel.writeSerializable(this.f4141j0);
        parcel.writeSerializable(Boolean.valueOf(this.f4142k0));
        parcel.writeSerializable(Boolean.valueOf(this.f4143l0));
        parcel.writeSerializable(Short.valueOf(this.f4144m0));
        parcel.writeSerializable(Integer.valueOf(this.f4145n0));
        parcel.writeSerializable(this.f4146o0);
    }
}
