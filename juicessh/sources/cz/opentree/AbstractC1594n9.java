package cz.opentree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.n9 */
/* loaded from: classes.dex */
public abstract class AbstractC1594n9 {

    /* renamed from: a */
    public int f5242a;

    /* renamed from: a */
    public final void m6650a(Context context, Bitmap bitmap, boolean z) {
        C1804r9.m7890c(bitmap);
        m6652c(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* renamed from: b */
    public final void m6651b(Context context, C2166ve c2166ve, boolean z) {
        int i = this.f5242a;
        m6652c(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }

    /* renamed from: c */
    public abstract void m6652c(Drawable drawable, boolean z, boolean z2, boolean z3);
}
