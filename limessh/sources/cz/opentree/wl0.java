package cz.opentree;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* compiled from: ResourceBitmapHunter.java */
/* loaded from: classes.dex */
public class wl0 extends fl0 {

    /* renamed from: e0 */
    public final Context f7764e0;

    public wl0(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        super(picasso, jl0Var, cache, xl0Var, dl0Var);
        this.f7764e0 = context;
    }

    /* renamed from: A */
    public final Bitmap m9582A(Resources resources, int i, ul0 ul0Var) {
        BitmapFactory.Options m3783f = fl0.m3783f(ul0Var);
        if (fl0.m3785t(m3783f)) {
            BitmapFactory.decodeResource(resources, i, m3783f);
            fl0.m3782d(ul0Var.f7001f, ul0Var.f7002g, m3783f);
        }
        return BitmapFactory.decodeResource(resources, i, m3783f);
    }

    @Override // cz.opentree.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        Resources m2573n = bm0.m2573n(this.f7764e0, ul0Var);
        return m9582A(m2573n, bm0.m2572m(m2573n, ul0Var), ul0Var);
    }

    @Override // cz.opentree.fl0
    /* renamed from: o */
    public Picasso.EnumC2454d mo3529o() {
        return Picasso.EnumC2454d.DISK;
    }
}
