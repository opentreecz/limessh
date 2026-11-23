package cz.opentree;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import cz.opentree.v70;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class fd0 implements HeartBeatInfo {

    /* renamed from: a */
    public gd0 f2665a;

    public fd0(Context context) {
        this.f2665a = gd0.m4115a(context);
    }

    @NonNull
    /* renamed from: b */
    public static v70<HeartBeatInfo> m3732b() {
        v70.C2157b m9172a = v70.m9172a(HeartBeatInfo.class);
        m9172a.m9187b(b80.m2394f(Context.class));
        m9172a.m9191f(ed0.m3475b());
        return m9172a.m9189d();
    }

    /* renamed from: c */
    public static /* synthetic */ HeartBeatInfo m3733c(ComponentContainer componentContainer) {
        return new fd0((Context) componentContainer.mo1598a(Context.class));
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    /* renamed from: a */
    public HeartBeatInfo.EnumC0664a mo1864a(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean m4117c = this.f2665a.m4117c(str, currentTimeMillis);
        boolean m4116b = this.f2665a.m4116b(currentTimeMillis);
        return (m4117c && m4116b) ? HeartBeatInfo.EnumC0664a.COMBINED : m4116b ? HeartBeatInfo.EnumC0664a.GLOBAL : m4117c ? HeartBeatInfo.EnumC0664a.SDK : HeartBeatInfo.EnumC0664a.NONE;
    }
}
