package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.l5 */
/* loaded from: classes.dex */
public class C1490l5 implements Result {

    /* renamed from: O */
    public Status f4743O;

    /* renamed from: P */
    @Nullable
    public GoogleSignInAccount f4744P;

    public C1490l5(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.f4744P = googleSignInAccount;
        this.f4743O = status;
    }

    @Nullable
    /* renamed from: a */
    public GoogleSignInAccount m6068a() {
        return this.f4744P;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    /* renamed from: n */
    public Status mo991n() {
        return this.f4743O;
    }
}
