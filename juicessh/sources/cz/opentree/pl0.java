package cz.opentree;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;
import com.sun.jna.Function;
import java.io.IOException;

/* compiled from: MediaStoreBitmapHunter.java */
/* loaded from: classes.dex */
public class pl0 extends hl0 {

    /* renamed from: f0 */
    public static final String[] f5715f0 = {"orientation"};

    /* compiled from: MediaStoreBitmapHunter.java */
    /* renamed from: cz.opentree.pl0$a */
    /* loaded from: classes.dex */
    public enum EnumC1724a {
        MICRO(3, 96, 96),
        MINI(1, 512, Function.USE_VARARGS),
        FULL(2, -1, -1);


        /* renamed from: O */
        public final int f5720O;

        /* renamed from: P */
        public final int f5721P;

        /* renamed from: Q */
        public final int f5722Q;

        EnumC1724a(int i, int i2, int i3) {
            this.f5720O = i;
            this.f5721P = i2;
            this.f5722Q = i3;
        }
    }

    public pl0(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        super(context, picasso, jl0Var, cache, xl0Var, dl0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r1.close();
     */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m7390B(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String[] r4 = cz.opentree.pl0.f5715f0     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            if (r1 == 0) goto L20
            boolean r8 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            if (r8 != 0) goto L16
            goto L20
        L16:
            int r8 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L2d
            if (r1 == 0) goto L1f
            r1.close()
        L1f:
            return r8
        L20:
            if (r1 == 0) goto L25
            r1.close()
        L25:
            return r0
        L26:
            r8 = move-exception
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            throw r8
        L2d:
            if (r1 == 0) goto L32
            r1.close()
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.pl0.m7390B(android.content.ContentResolver, android.net.Uri):int");
    }

    /* renamed from: C */
    public static EnumC1724a m7391C(int i, int i2) {
        EnumC1724a enumC1724a = EnumC1724a.MICRO;
        if (i <= enumC1724a.f5721P && i2 <= enumC1724a.f5722Q) {
            return enumC1724a;
        }
        EnumC1724a enumC1724a2 = EnumC1724a.MINI;
        return (i > enumC1724a2.f5721P || i2 > enumC1724a2.f5722Q) ? EnumC1724a.FULL : enumC1724a2;
    }

    @Override // cz.opentree.hl0, cz.opentree.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.f3170e0.getContentResolver();
        m3800u(m7390B(contentResolver, ul0Var.f6998c));
        String type = contentResolver.getType(ul0Var.f6998c);
        boolean z = type != null && type.startsWith("video/");
        if (ul0Var.m8920c()) {
            EnumC1724a m7391C = m7391C(ul0Var.f7001f, ul0Var.f7002g);
            if (!z && m7391C == EnumC1724a.FULL) {
                return super.mo3528g(ul0Var);
            }
            long parseId = ContentUris.parseId(ul0Var.f6998c);
            BitmapFactory.Options m3783f = fl0.m3783f(ul0Var);
            m3783f.inJustDecodeBounds = true;
            fl0.m3781c(ul0Var.f7001f, ul0Var.f7002g, m7391C.f5721P, m7391C.f5722Q, m3783f);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, m7391C != EnumC1724a.FULL ? m7391C.f5720O : 1, m3783f);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, m7391C.f5720O, m3783f);
            }
            if (thumbnail != null) {
                return thumbnail;
            }
        }
        return super.mo3528g(ul0Var);
    }
}
