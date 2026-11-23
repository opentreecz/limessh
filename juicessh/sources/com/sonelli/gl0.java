package com.sonelli;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContactsPhotoBitmapHunter.java */
/* loaded from: classes.dex */
public class gl0 extends fl0 {

    /* renamed from: f0 */
    public static final UriMatcher f2887f0;

    /* renamed from: e0 */
    public final Context f2888e0;

    /* compiled from: ContactsPhotoBitmapHunter.java */
    @TargetApi(14)
    /* renamed from: com.sonelli.gl0$a */
    /* loaded from: classes.dex */
    public static class C1049a {
        /* renamed from: a */
        public static InputStream m4167a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f2887f0 = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public gl0(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        super(picasso, jl0Var, cache, xl0Var, dl0Var);
        this.f2888e0 = context;
    }

    /* renamed from: A */
    public final Bitmap m4165A(InputStream inputStream, ul0 ul0Var) throws IOException {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options m3783f = fl0.m3783f(ul0Var);
        if (fl0.m3785t(m3783f)) {
            InputStream m4166B = m4166B();
            try {
                BitmapFactory.decodeStream(m4166B, null, m3783f);
                bm0.m2564e(m4166B);
                fl0.m3782d(ul0Var.f7001f, ul0Var.f7002g, m3783f);
            } catch (Throwable th) {
                bm0.m2564e(m4166B);
                throw th;
            }
        }
        return BitmapFactory.decodeStream(inputStream, null, m3783f);
    }

    /* renamed from: B */
    public final InputStream m4166B() throws IOException {
        ContentResolver contentResolver = this.f2888e0.getContentResolver();
        Uri uri = m3793l().f6998c;
        int match = f2887f0.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        return Build.VERSION.SDK_INT < 14 ? ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri) : C1049a.m4167a(contentResolver, uri);
    }

    @Override // com.sonelli.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        InputStream inputStream;
        try {
            inputStream = m4166B();
            try {
                Bitmap m4165A = m4165A(inputStream, ul0Var);
                bm0.m2564e(inputStream);
                return m4165A;
            } catch (Throwable th) {
                th = th;
                bm0.m2564e(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    @Override // com.sonelli.fl0
    /* renamed from: o */
    public Picasso.EnumC2454d mo3529o() {
        return Picasso.EnumC2454d.DISK;
    }
}
