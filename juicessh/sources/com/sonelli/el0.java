package com.sonelli;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: AssetBitmapHunter.java */
/* loaded from: classes.dex */
public class el0 extends fl0 {

    /* renamed from: f0 */
    public static final int f2493f0 = 22;

    /* renamed from: e0 */
    public final AssetManager f2494e0;

    public el0(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        super(picasso, jl0Var, cache, xl0Var, dl0Var);
        this.f2494e0 = context.getAssets();
    }

    /* renamed from: A */
    public Bitmap m3527A(String str) throws IOException {
        BitmapFactory.Options m3783f = fl0.m3783f(this.f2709T);
        InputStream inputStream = null;
        if (fl0.m3785t(m3783f)) {
            try {
                InputStream open = this.f2494e0.open(str);
                try {
                    BitmapFactory.decodeStream(open, null, m3783f);
                    bm0.m2564e(open);
                    ul0 ul0Var = this.f2709T;
                    fl0.m3782d(ul0Var.f7001f, ul0Var.f7002g, m3783f);
                } catch (Throwable th) {
                    th = th;
                    inputStream = open;
                    bm0.m2564e(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        InputStream open2 = this.f2494e0.open(str);
        try {
            return BitmapFactory.decodeStream(open2, null, m3783f);
        } finally {
            bm0.m2564e(open2);
        }
    }

    @Override // com.sonelli.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        return m3527A(ul0Var.f6998c.toString().substring(f2493f0));
    }

    @Override // com.sonelli.fl0
    /* renamed from: o */
    public Picasso.EnumC2454d mo3529o() {
        return Picasso.EnumC2454d.DISK;
    }
}
