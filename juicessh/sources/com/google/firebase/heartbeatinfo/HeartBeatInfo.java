package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public interface HeartBeatInfo {

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    /* renamed from: com.google.firebase.heartbeatinfo.HeartBeatInfo$a */
    /* loaded from: classes.dex */
    public enum EnumC0664a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* renamed from: O */
        public final int f1260O;

        EnumC0664a(int i) {
            this.f1260O = i;
        }

        /* renamed from: f */
        public int m1865f() {
            return this.f1260O;
        }
    }

    @NonNull
    /* renamed from: a */
    EnumC0664a mo1864a(@NonNull String str);
}
