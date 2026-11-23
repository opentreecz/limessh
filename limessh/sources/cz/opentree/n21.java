package cz.opentree;

import cz.opentree.t21;
import cz.opentree.v21;
import cz.opentree.w21;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class n21 implements Serializable {

    /* renamed from: O */
    public transient x21 f5201O;

    /* renamed from: P */
    public final int f5202P;

    /* renamed from: Q */
    public final List<p21> f5203Q;

    /* renamed from: R */
    public int f5204R;

    /* renamed from: S */
    public h31 f5205S;

    /* renamed from: T */
    public List<h31> f5206T;

    /* renamed from: U */
    public Map<Integer, LinkedList<h31>> f5207U;

    /* renamed from: V */
    public Stack<h31> f5208V;

    /* renamed from: W */
    public Map<Integer, h31> f5209W;

    /* renamed from: X */
    public int f5210X;

    /* renamed from: Y */
    public boolean f5211Y;

    /* renamed from: Z */
    public transient int f5212Z;

    public n21(j31 j31Var, int i, int i2) {
        this(j31Var.m5048i(), j31Var.m5041b(), j31Var.m5042c(), i2);
        this.f5212Z = i;
        this.f5210X = i2;
        this.f5211Y = true;
    }

    public n21(j31 j31Var, byte[] bArr, byte[] bArr2, w21 w21Var) {
        this(j31Var.m5048i(), j31Var.m5041b(), j31Var.m5042c(), (1 << j31Var.m5041b()) - 1);
        m6632e(bArr, bArr2, w21Var);
    }

    public n21(j31 j31Var, byte[] bArr, byte[] bArr2, w21 w21Var, int i) {
        this(j31Var.m5048i(), j31Var.m5041b(), j31Var.m5042c(), (1 << j31Var.m5041b()) - 1);
        m6632e(bArr, bArr2, w21Var);
        while (this.f5210X < i) {
            m6633f(bArr, bArr2, w21Var);
            this.f5211Y = false;
        }
    }

    public n21(n21 n21Var) {
        this.f5201O = new x21(n21Var.f5201O.m9677d());
        this.f5202P = n21Var.f5202P;
        this.f5204R = n21Var.f5204R;
        this.f5205S = n21Var.f5205S;
        ArrayList arrayList = new ArrayList();
        this.f5206T = arrayList;
        arrayList.addAll(n21Var.f5206T);
        this.f5207U = new TreeMap();
        for (Integer num : n21Var.f5207U.keySet()) {
            this.f5207U.put(num, (LinkedList) n21Var.f5207U.get(num).clone());
        }
        Stack<h31> stack = new Stack<>();
        this.f5208V = stack;
        stack.addAll(n21Var.f5208V);
        this.f5203Q = new ArrayList();
        Iterator<p21> it = n21Var.f5203Q.iterator();
        while (it.hasNext()) {
            this.f5203Q.add(it.next().clone());
        }
        this.f5209W = new TreeMap(n21Var.f5209W);
        this.f5210X = n21Var.f5210X;
        this.f5212Z = n21Var.f5212Z;
        this.f5211Y = n21Var.f5211Y;
    }

    public n21(n21 n21Var, aq0 aq0Var) {
        this.f5201O = new x21(new z21(aq0Var));
        this.f5202P = n21Var.f5202P;
        this.f5204R = n21Var.f5204R;
        this.f5205S = n21Var.f5205S;
        ArrayList arrayList = new ArrayList();
        this.f5206T = arrayList;
        arrayList.addAll(n21Var.f5206T);
        this.f5207U = new TreeMap();
        for (Integer num : n21Var.f5207U.keySet()) {
            this.f5207U.put(num, (LinkedList) n21Var.f5207U.get(num).clone());
        }
        Stack<h31> stack = new Stack<>();
        this.f5208V = stack;
        stack.addAll(n21Var.f5208V);
        this.f5203Q = new ArrayList();
        Iterator<p21> it = n21Var.f5203Q.iterator();
        while (it.hasNext()) {
            this.f5203Q.add(it.next().clone());
        }
        this.f5209W = new TreeMap(n21Var.f5209W);
        this.f5210X = n21Var.f5210X;
        this.f5212Z = n21Var.f5212Z;
        this.f5211Y = n21Var.f5211Y;
        m6634h();
    }

    public n21(n21 n21Var, byte[] bArr, byte[] bArr2, w21 w21Var) {
        this.f5201O = new x21(n21Var.f5201O.m9677d());
        this.f5202P = n21Var.f5202P;
        this.f5204R = n21Var.f5204R;
        this.f5205S = n21Var.f5205S;
        ArrayList arrayList = new ArrayList();
        this.f5206T = arrayList;
        arrayList.addAll(n21Var.f5206T);
        this.f5207U = new TreeMap();
        for (Integer num : n21Var.f5207U.keySet()) {
            this.f5207U.put(num, (LinkedList) n21Var.f5207U.get(num).clone());
        }
        Stack<h31> stack = new Stack<>();
        this.f5208V = stack;
        stack.addAll(n21Var.f5208V);
        this.f5203Q = new ArrayList();
        Iterator<p21> it = n21Var.f5203Q.iterator();
        while (it.hasNext()) {
            this.f5203Q.add(it.next().clone());
        }
        this.f5209W = new TreeMap(n21Var.f5209W);
        this.f5210X = n21Var.f5210X;
        this.f5212Z = n21Var.f5212Z;
        this.f5211Y = false;
        m6633f(bArr, bArr2, w21Var);
    }

    public n21(x21 x21Var, int i, int i2, int i3) {
        this.f5201O = x21Var;
        this.f5202P = i;
        this.f5212Z = i3;
        this.f5204R = i2;
        if (i2 <= i && i2 >= 2) {
            int i4 = i - i2;
            if (i4 % 2 == 0) {
                this.f5206T = new ArrayList();
                this.f5207U = new TreeMap();
                this.f5208V = new Stack<>();
                this.f5203Q = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    this.f5203Q.add(new p21(i5));
                }
                this.f5209W = new TreeMap();
                this.f5210X = 0;
                this.f5211Y = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    /* renamed from: a */
    public final p21 m6628a() {
        p21 p21Var = null;
        for (p21 p21Var2 : this.f5203Q) {
            if (!p21Var2.m7226j() && p21Var2.m7227k() && (p21Var == null || p21Var2.m7222c() < p21Var.m7222c() || (p21Var2.m7222c() == p21Var.m7222c() && p21Var2.m7223d() < p21Var.m7223d()))) {
                p21Var = p21Var2;
            }
        }
        return p21Var;
    }

    /* renamed from: b */
    public int m6629b() {
        return this.f5210X;
    }

    /* renamed from: c */
    public int m6630c() {
        return this.f5212Z;
    }

    /* renamed from: d */
    public n21 m6631d(byte[] bArr, byte[] bArr2, w21 w21Var) {
        return new n21(this, bArr, bArr2, w21Var);
    }

    /* renamed from: e */
    public final void m6632e(byte[] bArr, byte[] bArr2, w21 w21Var) {
        Objects.requireNonNull(w21Var, "otsHashAddress == null");
        v21 v21Var = (v21) new v21.C2150b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c()).m9153l();
        t21 t21Var = (t21) new t21.C1897b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c()).m8582k();
        for (int i = 0; i < (1 << this.f5202P); i++) {
            w21.C2198b m2370h = new w21.C2198b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c());
            m2370h.m9400p(i);
            m2370h.m9398n(w21Var.m9390e());
            m2370h.m9399o(w21Var.m9391f());
            w21Var = (w21) m2370h.m2368f(w21Var.m2359a()).m9396l();
            x21 x21Var = this.f5201O;
            x21Var.m9681h(x21Var.m9680g(bArr2, w21Var), bArr);
            a31 m9678e = this.f5201O.m9678e(w21Var);
            v21.C2150b m2370h2 = new v21.C2150b().m2369g(v21Var.m2360b()).m2370h(v21Var.m2361c());
            m2370h2.m9155n(i);
            m2370h2.m9156o(v21Var.m9148f());
            m2370h2.m9157p(v21Var.m9149g());
            v21Var = (v21) m2370h2.m2368f(v21Var.m2359a()).m9153l();
            h31 m4713a = i31.m4713a(this.f5201O, m9678e, v21Var);
            t21.C1897b m2370h3 = new t21.C1897b().m2369g(t21Var.m2360b()).m2370h(t21Var.m2361c());
            m2370h3.m8585n(i);
            t21Var = (t21) m2370h3.m2368f(t21Var.m2359a()).m8582k();
            while (!this.f5208V.isEmpty() && this.f5208V.peek().m4347a() == m4713a.m4347a()) {
                int m4347a = i / (1 << m4713a.m4347a());
                if (m4347a == 1) {
                    this.f5206T.add(m4713a);
                }
                if (m4347a == 3 && m4713a.m4347a() < this.f5202P - this.f5204R) {
                    this.f5203Q.get(m4713a.m4347a()).m7228l(m4713a);
                }
                if (m4347a >= 3 && (m4347a & 1) == 1 && m4713a.m4347a() >= this.f5202P - this.f5204R && m4713a.m4347a() <= this.f5202P - 2) {
                    if (this.f5207U.get(Integer.valueOf(m4713a.m4347a())) == null) {
                        LinkedList<h31> linkedList = new LinkedList<>();
                        linkedList.add(m4713a);
                        this.f5207U.put(Integer.valueOf(m4713a.m4347a()), linkedList);
                    } else {
                        this.f5207U.get(Integer.valueOf(m4713a.m4347a())).add(m4713a);
                    }
                }
                t21.C1897b m2370h4 = new t21.C1897b().m2369g(t21Var.m2360b()).m2370h(t21Var.m2361c());
                m2370h4.m8584m(t21Var.m8578e());
                m2370h4.m8585n((t21Var.m8579f() - 1) / 2);
                t21 t21Var2 = (t21) m2370h4.m2368f(t21Var.m2359a()).m8582k();
                h31 m4714b = i31.m4714b(this.f5201O, this.f5208V.pop(), m4713a, t21Var2);
                h31 h31Var = new h31(m4714b.m4347a() + 1, m4714b.m4348b());
                t21.C1897b m2370h5 = new t21.C1897b().m2369g(t21Var2.m2360b()).m2370h(t21Var2.m2361c());
                m2370h5.m8584m(t21Var2.m8578e() + 1);
                m2370h5.m8585n(t21Var2.m8579f());
                t21Var = (t21) m2370h5.m2368f(t21Var2.m2359a()).m8582k();
                m4713a = h31Var;
            }
            this.f5208V.push(m4713a);
        }
        this.f5205S = this.f5208V.pop();
    }

    /* renamed from: f */
    public final void m6633f(byte[] bArr, byte[] bArr2, w21 w21Var) {
        List<h31> list;
        h31 removeFirst;
        Objects.requireNonNull(w21Var, "otsHashAddress == null");
        if (this.f5211Y) {
            throw new IllegalStateException("index already used");
        }
        int i = this.f5210X;
        if (i > this.f5212Z - 1) {
            throw new IllegalStateException("index out of bounds");
        }
        int m6352b = m31.m6352b(i, this.f5202P);
        if (((this.f5210X >> (m6352b + 1)) & 1) == 0 && m6352b < this.f5202P - 1) {
            this.f5209W.put(Integer.valueOf(m6352b), this.f5206T.get(m6352b));
        }
        v21 v21Var = (v21) new v21.C2150b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c()).m9153l();
        t21 t21Var = (t21) new t21.C1897b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c()).m8582k();
        if (m6352b == 0) {
            w21.C2198b m2370h = new w21.C2198b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c());
            m2370h.m9400p(this.f5210X);
            m2370h.m9398n(w21Var.m9390e());
            m2370h.m9399o(w21Var.m9391f());
            w21Var = (w21) m2370h.m2368f(w21Var.m2359a()).m9396l();
            x21 x21Var = this.f5201O;
            x21Var.m9681h(x21Var.m9680g(bArr2, w21Var), bArr);
            a31 m9678e = this.f5201O.m9678e(w21Var);
            v21.C2150b m2370h2 = new v21.C2150b().m2369g(v21Var.m2360b()).m2370h(v21Var.m2361c());
            m2370h2.m9155n(this.f5210X);
            m2370h2.m9156o(v21Var.m9148f());
            m2370h2.m9157p(v21Var.m9149g());
            this.f5206T.set(0, i31.m4713a(this.f5201O, m9678e, (v21) m2370h2.m2368f(v21Var.m2359a()).m9153l()));
        } else {
            t21.C1897b m2370h3 = new t21.C1897b().m2369g(t21Var.m2360b()).m2370h(t21Var.m2361c());
            int i2 = m6352b - 1;
            m2370h3.m8584m(i2);
            m2370h3.m8585n(this.f5210X >> m6352b);
            t21 t21Var2 = (t21) m2370h3.m2368f(t21Var.m2359a()).m8582k();
            x21 x21Var2 = this.f5201O;
            x21Var2.m9681h(x21Var2.m9680g(bArr2, w21Var), bArr);
            h31 m4714b = i31.m4714b(this.f5201O, this.f5206T.get(i2), this.f5209W.get(Integer.valueOf(i2)), t21Var2);
            this.f5206T.set(m6352b, new h31(m4714b.m4347a() + 1, m4714b.m4348b()));
            this.f5209W.remove(Integer.valueOf(i2));
            for (int i3 = 0; i3 < m6352b; i3++) {
                if (i3 < this.f5202P - this.f5204R) {
                    list = this.f5206T;
                    removeFirst = this.f5203Q.get(i3).m7224e();
                } else {
                    list = this.f5206T;
                    removeFirst = this.f5207U.get(Integer.valueOf(i3)).removeFirst();
                }
                list.set(i3, removeFirst);
            }
            int min = Math.min(m6352b, this.f5202P - this.f5204R);
            for (int i4 = 0; i4 < min; i4++) {
                int i5 = this.f5210X + 1 + ((1 << i4) * 3);
                if (i5 < (1 << this.f5202P)) {
                    this.f5203Q.get(i4).m7225i(i5);
                }
            }
        }
        for (int i6 = 0; i6 < ((this.f5202P - this.f5204R) >> 1); i6++) {
            p21 m6628a = m6628a();
            if (m6628a != null) {
                m6628a.m7229m(this.f5208V, this.f5201O, bArr, bArr2, w21Var);
            }
        }
        this.f5210X++;
    }

    /* renamed from: h */
    public final void m6634h() {
        if (this.f5206T == null) {
            throw new IllegalStateException("authenticationPath == null");
        }
        if (this.f5207U == null) {
            throw new IllegalStateException("retain == null");
        }
        if (this.f5208V == null) {
            throw new IllegalStateException("stack == null");
        }
        if (this.f5203Q == null) {
            throw new IllegalStateException("treeHashInstances == null");
        }
        if (this.f5209W == null) {
            throw new IllegalStateException("keep == null");
        }
        if (!m31.m6362l(this.f5202P, this.f5210X)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    /* renamed from: i */
    public n21 m6635i(aq0 aq0Var) {
        return new n21(this, aq0Var);
    }
}
