package com.sonelli;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentStreamBitmapHunter.java */
/* loaded from: classes.dex */
public class hl0 extends fl0 {

    /* renamed from: e0 */
    public final Context f3170e0;

    public hl0(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        super(picasso, jl0Var, cache, xl0Var, dl0Var);
        this.f3170e0 = context;
    }

    /* renamed from: A */
    public Bitmap m4486A(ul0 ul0Var) throws IOException {
        ContentResolver contentResolver = this.f3170e0.getContentResolver();
        BitmapFactory.Options m3783f = fl0.m3783f(ul0Var);
        InputStream inputStream = null;
        if (fl0.m3785t(m3783f)) {
            try {
                InputStream openInputStream = contentResolver.openInputStream(ul0Var.f6998c);
                try {
                    BitmapFactory.decodeStream(openInputStream, null, m3783f);
                    bm0.m2564e(openInputStream);
                    fl0.m3782d(ul0Var.f7001f, ul0Var.f7002g, m3783f);
                } catch (Throwable th) {
                    th = th;
                    inputStream = openInputStream;
                    bm0.m2564e(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        InputStream openInputStream2 = contentResolver.openInputStream(ul0Var.f6998c);
        try {
            return BitmapFactory.decodeStream(openInputStream2, null, m3783f);
        } finally {
            bm0.m2564e(openInputStream2);
        }
    }

    @Override // com.sonelli.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        return m4486A(ul0Var);
    }

    @Override // com.sonelli.fl0
    /* renamed from: o */
    public Picasso.EnumC2454d mo3529o() {
        return Picasso.EnumC2454d.DISK;
    }
}
