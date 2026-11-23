package cz.opentree;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.s9 */
/* loaded from: classes.dex */
public final class C1850s9 {

    /* renamed from: a */
    public final Account f6397a;

    /* renamed from: b */
    public final Set<Scope> f6398b;

    /* renamed from: c */
    public final Set<Scope> f6399c;

    /* renamed from: d */
    public final Map<Api<?>, b> f6400d;

    /* renamed from: e */
    public final String f6401e;

    /* renamed from: f */
    public final String f6402f;

    /* renamed from: g */
    public final x40 f6403g;

    /* renamed from: h */
    public Integer f6404h;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.s9$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public Account f6405a;

        /* renamed from: b */
        public ArraySet<Scope> f6406b;

        /* renamed from: c */
        public Map<Api<?>, b> f6407c;

        /* renamed from: e */
        public View f6409e;

        /* renamed from: f */
        public String f6410f;

        /* renamed from: g */
        public String f6411g;

        /* renamed from: i */
        public boolean f6413i;

        /* renamed from: d */
        public int f6408d = 0;

        /* renamed from: h */
        public x40 f6412h = x40.f7866X;

        /* renamed from: a */
        public final a m8411a(Collection<Scope> collection) {
            if (this.f6406b == null) {
                this.f6406b = new ArraySet<>();
            }
            this.f6406b.addAll(collection);
            return this;
        }

        /* renamed from: b */
        public final C1850s9 m8412b() {
            return new C1850s9(this.f6405a, this.f6406b, this.f6407c, this.f6408d, this.f6409e, this.f6410f, this.f6411g, this.f6412h, this.f6413i);
        }

        /* renamed from: c */
        public final a m8413c(Account account) {
            this.f6405a = account;
            return this;
        }

        /* renamed from: d */
        public final a m8414d(String str) {
            this.f6411g = str;
            return this;
        }

        /* renamed from: e */
        public final a m8415e(String str) {
            this.f6410f = str;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.s9$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        public final Set<Scope> f6414a;
    }

    public C1850s9(Account account, Set<Scope> set, Map<Api<?>, b> map, int i, View view, String str, String str2, x40 x40Var, boolean z) {
        this.f6397a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f6398b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f6400d = map;
        this.f6401e = str;
        this.f6402f = str2;
        this.f6403g = x40Var;
        HashSet hashSet = new HashSet(emptySet);
        Iterator<b> it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f6414a);
        }
        this.f6399c = Collections.unmodifiableSet(hashSet);
    }

    @Nullable
    /* renamed from: a */
    public final Account m8400a() {
        return this.f6397a;
    }

    @Nullable
    @Deprecated
    /* renamed from: b */
    public final String m8401b() {
        Account account = this.f6397a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    /* renamed from: c */
    public final Account m8402c() {
        Account account = this.f6397a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    /* renamed from: d */
    public final Set<Scope> m8403d() {
        return this.f6399c;
    }

    /* renamed from: e */
    public final Set<Scope> m8404e(Api<?> api) {
        b bVar = this.f6400d.get(api);
        if (bVar == null || bVar.f6414a.isEmpty()) {
            return this.f6398b;
        }
        HashSet hashSet = new HashSet(this.f6398b);
        hashSet.addAll(bVar.f6414a);
        return hashSet;
    }

    @Nullable
    /* renamed from: f */
    public final Integer m8405f() {
        return this.f6404h;
    }

    @Nullable
    /* renamed from: g */
    public final String m8406g() {
        return this.f6402f;
    }

    @Nullable
    /* renamed from: h */
    public final String m8407h() {
        return this.f6401e;
    }

    /* renamed from: i */
    public final Set<Scope> m8408i() {
        return this.f6398b;
    }

    @Nullable
    /* renamed from: j */
    public final x40 m8409j() {
        return this.f6403g;
    }

    /* renamed from: k */
    public final void m8410k(Integer num) {
        this.f6404h = num;
    }
}
