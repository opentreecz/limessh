package cz.opentree;

import android.content.Context;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.Tag;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ConnectionCounter;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.models.ConnectionGroupMembership;
import cz.opentree.juicessh.models.ConnectionIdentity;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.models.ec2link.Ec2Connection;
import cz.opentree.juicessh.models.ec2link.Ec2Filter;
import cz.opentree.juicessh.models.ec2link.Ec2GroupMapping;
import cz.opentree.juicessh.models.ec2link.Ec2Mapping;
import cz.opentree.juicessh.models.ec2link.Ec2Profile;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.services.Ec2Link;
import cz.opentree.qg0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: Ec2LinkRunnable.java */
/* loaded from: classes.dex */
public class si0 implements Runnable {

    /* renamed from: O */
    public final String f6464O;

    /* renamed from: P */
    public Context f6465P;

    /* renamed from: Q */
    public Ec2Profile f6466Q;

    /* renamed from: R */
    public Ec2Link.AbstractC1386j f6467R;

    /* renamed from: S */
    public Ec2Link.AbstractC1386j f6468S;

    /* compiled from: Ec2LinkRunnable.java */
    /* renamed from: cz.opentree.si0$a */
    /* loaded from: classes.dex */
    public class C1868a extends Ec2Link.AbstractC1386j {

        /* renamed from: c */
        public int f6469c;

        public C1868a(Context context) {
            super(context);
            this.f6469c = 0;
        }

        @Override // cz.opentree.juicessh.services.Ec2Link.AbstractC1386j
        /* renamed from: a */
        public void mo5637a() {
            si0.this.m8450a(this.f6469c);
        }

        @Override // cz.opentree.juicessh.services.Ec2Link.AbstractC1386j
        /* renamed from: b */
        public void mo5638b() {
            int i = this.f6469c + 1;
            this.f6469c = i;
            si0 si0Var = si0.this;
            tj0.m8705c(si0Var.f6465P, si0Var.f6466Q.f3993id, i);
        }

        @Override // cz.opentree.juicessh.services.Ec2Link.AbstractC1386j
        /* renamed from: d */
        public void mo5640d(C1869b c1869b, Ec2Profile ec2Profile) {
            m5641e();
        }
    }

    /* compiled from: Ec2LinkRunnable.java */
    /* renamed from: cz.opentree.si0$b */
    /* loaded from: classes.dex */
    public class C1869b extends Exception {

        /* renamed from: O */
        public String f6471O;

        public C1869b(si0 si0Var, String str) {
            this.f6471O = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String str = this.f6471O;
            return str != null ? str : "";
        }
    }

    /* compiled from: Ec2LinkRunnable.java */
    /* renamed from: cz.opentree.si0$c */
    /* loaded from: classes.dex */
    public class RunnableC1870c implements Runnable {

        /* renamed from: O */
        public Ec2Mapping f6472O;

        /* renamed from: P */
        public List<Ec2GroupMapping> f6473P = new ArrayList();

        /* renamed from: Q */
        public List<Ec2Filter> f6474Q = new ArrayList();

        /* renamed from: R */
        public List<Instance> f6475R;

        /* renamed from: S */
        public Ec2Link.AbstractC1386j f6476S;

        public RunnableC1870c(Ec2Mapping ec2Mapping, List<Instance> list, Ec2Link.AbstractC1386j abstractC1386j) {
            this.f6472O = ec2Mapping;
            this.f6475R = list;
            this.f6476S = abstractC1386j;
        }

        /* renamed from: a */
        public void m8452a(Ec2Connection ec2Connection) {
            List arrayList;
            try {
                arrayList = C1328DB.m5404d(ConnectionGroupMembership.class, si0.this.f6465P).queryForEq("connection_id", ec2Connection.f3993id);
            } catch (SQLException unused) {
                arrayList = new ArrayList();
            }
            for (Ec2GroupMapping ec2GroupMapping : this.f6473P) {
                ConnectionGroup m5383m = ec2GroupMapping.group.m5383m();
                if (m5383m == null) {
                    try {
                        gj0.m4142c("Ec2LinkRunnable", "Deleting ec2 link group mapping for non-existent group");
                        C1328DB.m5404d(Ec2GroupMapping.class, si0.this.f6465P).delete(ec2GroupMapping);
                    } catch (SQLException e) {
                        gj0.m4142c("Ec2LinkRunnable", "Could not delete ec2 link group mapping for non-existent group (May have just been deleted.)");
                        e.printStackTrace();
                    }
                } else {
                    ConnectionGroupMembership connectionGroupMembership = new ConnectionGroupMembership();
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ConnectionGroupMembership connectionGroupMembership2 = (ConnectionGroupMembership) it.next();
                        ConnectionGroup m5383m2 = connectionGroupMembership2.group.m5383m();
                        if (m5383m2 != null && m5383m.f3993id.equals(m5383m2.f3993id)) {
                            arrayList.remove(connectionGroupMembership2);
                            connectionGroupMembership = connectionGroupMembership2;
                            break;
                        }
                    }
                    connectionGroupMembership.group = m5383m;
                    connectionGroupMembership.connection = ec2Connection;
                    try {
                        C1328DB.m5404d(ConnectionGroupMembership.class, si0.this.f6465P).createOrUpdate(connectionGroupMembership);
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            try {
                C1328DB.m5404d(ConnectionGroupMembership.class, si0.this.f6465P).delete((Collection) arrayList);
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

        /* renamed from: b */
        public Ec2Connection m8453b(Instance instance, Ec2Connection ec2Connection) {
            if (ec2Connection == null) {
                ec2Connection = new Ec2Connection();
            }
            ec2Connection.instanceId = instance.m378i();
            Ec2Mapping ec2Mapping = this.f6472O;
            ec2Connection.mapping = ec2Mapping;
            ec2Connection.type = ec2Mapping.defaultType;
            ec2Connection.port = ec2Mapping.defaultPort;
            ec2Connection.via = ec2Mapping.defaultConnectVia;
            if (ec2Mapping.privateIps) {
                ec2Connection.address = instance.m399t();
            } else if (instance.m401v() != null && !instance.m401v().isEmpty()) {
                ec2Connection.address = instance.m401v();
            } else {
                if (instance.m402w() == null || instance.m402w().isEmpty()) {
                    return null;
                }
                ec2Connection.address = instance.m402w();
            }
            Iterator<Tag> it = instance.m344H().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Tag next = it.next();
                if (next.m555a().equals("Name")) {
                    if (next.m556b() != null && !next.m556b().isEmpty()) {
                        ec2Connection.nickname = next.m556b();
                    }
                }
            }
            return ec2Connection;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0088, code lost:
        
            return false;
         */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean m8454c(com.amazonaws.services.ec2.model.Instance r8) {
            /*
                r7 = this;
                java.util.List<cz.opentree.juicessh.models.ec2link.Ec2Filter> r0 = r7.f6474Q
                java.util.Iterator r0 = r0.iterator()
            L6:
                boolean r1 = r0.hasNext()
                r2 = 1
                if (r1 == 0) goto L89
                java.lang.Object r1 = r0.next()
                cz.opentree.juicessh.models.ec2link.Ec2Filter r1 = (cz.opentree.juicessh.models.ec2link.Ec2Filter) r1
                java.lang.String r3 = r1.key
                java.lang.String r4 = "Instance Type"
                boolean r3 = r3.equals(r4)
                r4 = 0
                if (r3 == 0) goto L2b
                java.lang.String r2 = r8.m382k()
                java.lang.String r1 = r1.pattern
                boolean r1 = r2.contains(r1)
                if (r1 != 0) goto L6
                return r4
            L2b:
                java.lang.String r3 = r1.key
                java.lang.String r5 = "Security Group"
                boolean r3 = r3.equals(r5)
                if (r3 == 0) goto L5a
                java.util.List r3 = r8.m337A()
                java.util.Iterator r3 = r3.iterator()
            L3d:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L56
                java.lang.Object r5 = r3.next()
                com.amazonaws.services.ec2.model.GroupIdentifier r5 = (com.amazonaws.services.ec2.model.GroupIdentifier) r5
                java.lang.String r5 = r5.m328b()
                java.lang.String r6 = r1.pattern
                boolean r5 = r5.contains(r6)
                if (r5 == 0) goto L3d
                goto L57
            L56:
                r2 = r4
            L57:
                if (r2 != 0) goto L6
                return r4
            L5a:
                java.lang.String r3 = r1.key
                java.lang.String r5 = "Tag Value"
                boolean r3 = r3.equals(r5)
                if (r3 == 0) goto L88
                java.util.List r3 = r8.m344H()
                java.util.Iterator r3 = r3.iterator()
            L6c:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L85
                java.lang.Object r5 = r3.next()
                com.amazonaws.services.ec2.model.Tag r5 = (com.amazonaws.services.ec2.model.Tag) r5
                java.lang.String r5 = r5.m556b()
                java.lang.String r6 = r1.pattern
                boolean r5 = r5.contains(r6)
                if (r5 == 0) goto L6c
                goto L86
            L85:
                r2 = r4
            L86:
                if (r2 != 0) goto L6
            L88:
                return r4
            L89:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.opentree.si0.RunnableC1870c.m8454c(com.amazonaws.services.ec2.model.Instance):boolean");
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Ec2Connection> arrayList;
            try {
                this.f6473P = C1328DB.m5404d(Ec2GroupMapping.class, si0.this.f6465P).queryForEq("mapping_id", this.f6472O);
            } catch (SQLException unused) {
            }
            try {
                this.f6474Q = C1328DB.m5404d(Ec2Filter.class, si0.this.f6465P).queryForEq("mapping_id", this.f6472O);
                try {
                    arrayList = C1328DB.m5404d(Ec2Connection.class, si0.this.f6465P).queryForEq("mapping_id", this.f6472O);
                } catch (SQLException unused2) {
                    arrayList = new ArrayList();
                }
                ArrayList<Ec2Connection> arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Instance instance : this.f6475R) {
                    if (m8454c(instance)) {
                        Ec2Connection ec2Connection = null;
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Ec2Connection ec2Connection2 = (Ec2Connection) it.next();
                            try {
                                if (ec2Connection2.mapping.m5383m().f3993id.equals(this.f6472O.f3993id) && ec2Connection2.instanceId.equals(instance.m378i())) {
                                    try {
                                        arrayList3.add(ec2Connection2);
                                        ec2Connection = ec2Connection2;
                                        break;
                                    } catch (NullPointerException unused3) {
                                        ec2Connection = ec2Connection2;
                                    }
                                }
                            } catch (NullPointerException unused4) {
                            }
                        }
                        Ec2Connection m8453b = m8453b(instance, ec2Connection);
                        if (m8453b != null) {
                            arrayList2.add(m8453b);
                            this.f6476S.mo5638b();
                        }
                    }
                }
                arrayList.removeAll(arrayList3);
                for (Ec2Connection ec2Connection3 : arrayList) {
                    try {
                        C1328DB.m5404d(ConnectionGroupMembership.class, si0.this.f6465P).delete((Collection) C1328DB.m5404d(ConnectionGroupMembership.class, si0.this.f6465P).queryForEq("connection_id", ec2Connection3.f3993id));
                        C1328DB.m5404d(ConnectionCounter.class, si0.this.f6465P).delete((Collection) C1328DB.m5404d(ConnectionCounter.class, si0.this.f6465P).queryForEq("connection_id", ec2Connection3.f3993id));
                        C1328DB.m5404d(ConnectionIdentity.class, si0.this.f6465P).delete((Collection) C1328DB.m5404d(ConnectionIdentity.class, si0.this.f6465P).queryForEq("connection_id", ec2Connection3.f3993id));
                        C1328DB.m5404d(Ec2Connection.class, si0.this.f6465P).delete(ec2Connection3);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                for (Ec2Connection ec2Connection4 : arrayList2) {
                    try {
                        C1328DB.m5404d(Ec2Connection.class, si0.this.f6465P).createOrUpdate(ec2Connection4);
                        Identity identity = this.f6472O.defaultIdentity;
                        if (identity == null || identity.m5383m() == null) {
                            try {
                                Iterator it2 = C1328DB.m5404d(ConnectionIdentity.class, si0.this.f6465P).queryForEq("connection_id", ec2Connection4.f3993id).iterator();
                                while (it2.hasNext()) {
                                    C1328DB.m5404d(ConnectionIdentity.class, si0.this.f6465P).delete((ConnectionIdentity) it2.next());
                                }
                            } catch (SQLException unused5) {
                                gj0.m4142c("Ec2LinkRunnable", "Couldnt' delete the identity mapping for the connection " + ec2Connection4.toString());
                            }
                        } else if (ec2Connection4.m5470v(si0.this.f6465P) == null) {
                            ec2Connection4.m5472z(this.f6472O.defaultIdentity, si0.this.f6465P);
                        } else if (!ec2Connection4.m5470v(si0.this.f6465P).f3993id.equals(this.f6472O.defaultIdentity.f3993id)) {
                            ec2Connection4.m5472z(this.f6472O.defaultIdentity, si0.this.f6465P);
                        }
                        m8452a(ec2Connection4);
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
                this.f6476S.m5641e();
            } catch (SQLException unused6) {
                Ec2Link.AbstractC1386j abstractC1386j = this.f6476S;
                si0 si0Var = si0.this;
                abstractC1386j.mo5640d(new C1869b(si0Var, si0Var.f6465P.getString(R.string.ec2exception_couldnt_fetch_filters)), si0.this.f6466Q);
            }
        }
    }

    public si0(Context context, Ec2Profile ec2Profile, Ec2Link.AbstractC1386j abstractC1386j) {
        this.f6468S = new C1868a(this.f6465P);
        this.f6465P = context;
        this.f6466Q = ec2Profile;
        this.f6467R = abstractC1386j;
        this.f6464O = "Ec2LinkRunnable/" + ec2Profile.name;
    }

    /* renamed from: a */
    public void m8450a(int i) {
        this.f6466Q.lastSyncTime = System.currentTimeMillis() / 1000;
        this.f6466Q.lastSyncItemCount = i;
        try {
            C1328DB.m5404d(Ec2Profile.class, this.f6465P).update(this.f6466Q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Context context = this.f6465P;
        Ec2Profile ec2Profile = this.f6466Q;
        tj0.m8704b(context, ec2Profile.f3993id, ec2Profile.lastSyncItemCount);
        Ec2Link.AbstractC1386j abstractC1386j = this.f6467R;
        if (abstractC1386j != null) {
            abstractC1386j.m5641e();
        }
    }

    /* renamed from: b */
    public final void m8451b() throws C1869b {
        try {
            List<Ec2Mapping> queryForEq = C1328DB.m5404d(Ec2Mapping.class, this.f6465P).queryForEq("profile_id", this.f6466Q);
            if (queryForEq == null || queryForEq.isEmpty()) {
                throw new C1869b(this, this.f6465P.getString(R.string.ec2exception_couldnt_find_mappings));
            }
            try {
                String m7700a = qg0.m7700a(this.f6466Q.key, User.m5527u(this.f6465P));
                String m7700a2 = qg0.m7700a(this.f6466Q.secret, User.m5527u(this.f6465P));
                if (m7700a == null || m7700a2 == null) {
                    throw new C1869b(this, this.f6465P.getString(R.string.ec2exception_bad_credentials));
                }
                AmazonEC2Client amazonEC2Client = new AmazonEC2Client(new BasicAWSCredentials(m7700a, m7700a2));
                amazonEC2Client.m289c(this.f6466Q.region.contains(".") ? this.f6466Q.region : String.format("ec2.%s.amazonaws.com", this.f6466Q.region));
                tj0.m8706d(this.f6465P, this.f6466Q.f3993id, 2);
                try {
                    List<Reservation> m311b = amazonEC2Client.mo287a().m311b();
                    gj0.m4141b(this.f6464O, "Found " + m311b.size() + " reservation sets.");
                    List<Instance> list = null;
                    for (Reservation reservation : m311b) {
                        if (list == null) {
                            list = reservation.m502c();
                        } else {
                            list.addAll(reservation.m502c());
                        }
                    }
                    if (list == null) {
                        gj0.m4141b(this.f6464O, "Couldn't find any instances");
                        m8450a(0);
                        return;
                    }
                    tj0.m8706d(this.f6465P, this.f6466Q.f3993id, 3);
                    Iterator<Instance> it = list.iterator();
                    String str = "";
                    while (it.hasNext()) {
                        str = str + " " + it.next().m378i();
                    }
                    gj0.m4141b(this.f6464O, "Parsing instances:" + str);
                    for (Ec2Mapping ec2Mapping : queryForEq) {
                        this.f6468S.m5639c();
                        new Thread(new RunnableC1870c(ec2Mapping, list, this.f6468S)).start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (e.getMessage().contains("Unable to execute HTTP request: Unable to resolve host")) {
                        Context context = this.f6465P;
                        tj0.m8703a(context, this.f6466Q.f3993id, context.getString(R.string.ec2exception_bad_connection), false);
                    } else if (e.getMessage().contains("Unable to execute HTTP request: No peer certificate")) {
                        Context context2 = this.f6465P;
                        tj0.m8703a(context2, this.f6466Q.f3993id, context2.getString(R.string.ec2exception_api_certificate_error), false);
                    } else {
                        if (e.getMessage().contains("AWS was not able to validate the provided access credentials")) {
                            throw new C1869b(this, this.f6465P.getString(R.string.ec2exception_bad_credentials));
                        }
                        Context context3 = this.f6465P;
                        tj0.m8703a(context3, this.f6466Q.f3993id, context3.getString(R.string.ec2exception_uncaught_reason), false);
                    }
                }
            } catch (qg0.C1762a unused) {
                throw new C1869b(this, this.f6465P.getString(R.string.ec2exception_bad_credentials));
            } catch (NullPointerException unused2) {
                throw new C1869b(this, this.f6465P.getString(R.string.ec2exception_bad_credentials));
            }
        } catch (SQLException unused3) {
            throw new C1869b(this, this.f6465P.getString(R.string.ec2exception_couldnt_fetch_mappings));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            m8451b();
        } catch (C1869b e) {
            if (this.f6467R != null) {
                this.f6467R.mo5640d(e, this.f6466Q);
            }
        }
    }
}
