package com.sonelli;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* compiled from: FileBitmapHunter.java */
/* loaded from: classes.dex */
public class kl0 extends hl0 {
    public kl0(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        super(context, picasso, jl0Var, cache, xl0Var, dl0Var);
    }

    /* renamed from: B */
    public static int m5944B(Uri uri) throws IOException {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    @Override // com.sonelli.hl0, com.sonelli.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        m3800u(m5944B(ul0Var.f6998c));
        return super.mo3528g(ul0Var);
    }
}
