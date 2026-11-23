package com.sonelli;

import android.os.Environment;
import android.os.Handler;
import android.util.SparseArray;
import com.sonelli.juicessh.controllers.SftpControllerInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: SftpGetsController.java */
/* loaded from: classes.dex */
public class yi0 implements SftpControllerInterface {

    /* renamed from: a */
    public int f8228a;

    /* renamed from: b */
    public final File f8229b;

    /* renamed from: c */
    public String f8230c;

    /* renamed from: d */
    public int f8231d;

    /* renamed from: e */
    public EnumC2355g f8232e;

    /* renamed from: f */
    public hi0 f8233f;

    /* renamed from: g */
    public boolean f8234g;

    /* renamed from: h */
    public ArrayList<String> f8235h;

    /* renamed from: i */
    public ArrayList<String> f8236i;

    /* renamed from: j */
    public int f8237j;

    /* renamed from: k */
    public LinkedList<Integer> f8238k;

    /* renamed from: l */
    public HashMap<String, File> f8239l;

    /* renamed from: m */
    public HashMap<String, File> f8240m;

    /* renamed from: n */
    public HashMap<String, File> f8241n;

    /* renamed from: o */
    public HashMap<String, File> f8242o;

    /* renamed from: p */
    public HashMap<String, File> f8243p;

    /* renamed from: q */
    public vi0 f8244q;

    /* renamed from: r */
    public final Handler f8245r;

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$a */
    /* loaded from: classes.dex */
    public class C2349a extends LinkedList<Integer> {

        /* renamed from: O */
        public final /* synthetic */ String[] f8246O;

        public C2349a(yi0 yi0Var, String[] strArr) {
            this.f8246O = strArr;
            for (int i = 0; i < this.f8246O.length; i++) {
                add(Integer.valueOf(i));
            }
        }
    }

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$b */
    /* loaded from: classes.dex */
    public class RunnableC2350b implements Runnable {
        public RunnableC2350b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yi0.this.m10156n();
        }
    }

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$c */
    /* loaded from: classes.dex */
    public class RunnableC2351c implements Runnable {
        public RunnableC2351c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yi0.this.f8232e = EnumC2355g.READY;
            yi0.this.f8244q.m9240n();
        }
    }

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$d */
    /* loaded from: classes.dex */
    public class C2352d extends SparseArray<String> {
        public C2352d() {
            for (String str : yi0.this.f8239l.keySet()) {
                put(yi0.this.f8236i.indexOf(str), str);
            }
        }
    }

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$e */
    /* loaded from: classes.dex */
    public class C2353e implements Map.Entry<String, String> {

        /* renamed from: O */
        public final /* synthetic */ String f8250O;

        /* renamed from: P */
        public final /* synthetic */ String f8251P;

        public C2353e(yi0 yi0Var, String str, String str2) {
            this.f8250O = str;
            this.f8251P = str2;
        }

        @Override // java.util.Map.Entry
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getKey() {
            return this.f8250O;
        }

        @Override // java.util.Map.Entry
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            return this.f8251P;
        }

        @Override // java.util.Map.Entry
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String setValue(String str) {
            return null;
        }
    }

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$f */
    /* loaded from: classes.dex */
    public class C2354f extends Exception {
        public C2354f(yi0 yi0Var, String str) {
            super(str);
        }
    }

    /* compiled from: SftpGetsController.java */
    /* renamed from: com.sonelli.yi0$g */
    /* loaded from: classes.dex */
    public enum EnumC2355g {
        READY,
        ACTIVE,
        STOPPED
    }

    public yi0(hi0 hi0Var, String[] strArr, String[] strArr2, String[] strArr3) throws C2354f {
        new HashMap();
        this.f8228a = 0;
        this.f8229b = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        this.f8231d = -1;
        this.f8232e = EnumC2355g.READY;
        this.f8234g = false;
        this.f8239l = new HashMap<>();
        this.f8240m = new HashMap<>();
        this.f8241n = new HashMap<>();
        this.f8242o = new HashMap<>();
        this.f8243p = new HashMap<>();
        this.f8245r = new Handler();
        int length = strArr.length + strArr2.length;
        this.f8237j = length;
        if (length == 0) {
            throw new C2354f(this, "Can't initiate a Gets job with no paths to get!");
        }
        this.f8233f = hi0Var;
        hi0Var.m4454F();
        Arrays.sort(strArr);
        this.f8235h = new ArrayList<>(Arrays.asList(strArr));
        this.f8236i = new ArrayList<>(Arrays.asList(strArr2));
        this.f8238k = new C2349a(this, strArr2);
        for (String str : strArr3) {
            this.f8240m.put(str, this.f8229b);
        }
        this.f8230c = m10151i(strArr3);
        gj0.m4141b("SftpGetsController", "Replacing any path prefixes with download dir. Relevant regex: '" + this.f8230c + "'");
        gj0.m4141b("SftpGetsController", "Created SftpGetsJob for\nDirectories: " + Arrays.toString(strArr) + "\nFiles: " + Arrays.toString(strArr2));
    }

    @Override // com.sonelli.juicessh.controllers.SftpControllerInterface
    /* renamed from: a */
    public String mo5379a() {
        int length = String.valueOf(this.f8237j).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f8235h.size(); i++) {
            String str = this.f8235h.get(i);
            File file = this.f8240m.get(str);
            if (file != null) {
                sb.append(String.format("%0" + length + "d/%d <font color=\"#009900\">CREATED</font>: %s -> %s<br>", Integer.valueOf(i + 1), Integer.valueOf(this.f8237j), str, file.getPath()));
            } else {
                File file2 = this.f8241n.get(str);
                if (file2 != null) {
                    sb.append(String.format("%0" + length + "d/%d <font color=\"#990000\">FAILED CREATE</font>: %s -> %s<br>", Integer.valueOf(i + 1), Integer.valueOf(this.f8237j), str, file2.getPath()));
                } else {
                    sb.append(String.format("%0" + length + "d/%d ONGOING: %s<br>", Integer.valueOf(i + 1), Integer.valueOf(this.f8237j), str));
                }
            }
        }
        for (int i2 = 0; i2 < this.f8236i.size(); i2++) {
            String str2 = this.f8236i.get(i2);
            File file3 = this.f8242o.get(str2);
            if (file3 != null) {
                sb.append(String.format("%0" + length + "d/%d <font color=\"#009900\">SUCCESS</font>: %s -> %s<br>", Integer.valueOf(this.f8235h.size() + i2 + 1), Integer.valueOf(this.f8237j), str2, file3.getPath()));
            } else {
                File file4 = this.f8243p.get(str2);
                if (file4 != null) {
                    sb.append(String.format("%0" + length + "d/%d <font color=\"#990000\">FAILED</font>: %s -> %s<br>", Integer.valueOf(this.f8235h.size() + i2 + 1), Integer.valueOf(this.f8237j), str2, file4.getPath()));
                } else {
                    sb.append(String.format("%0" + length + "d/%d ONGOING: %s<br>", Integer.valueOf(this.f8235h.size() + i2 + 1), Integer.valueOf(this.f8237j), str2));
                }
            }
        }
        return sb.toString();
    }

    @Override // com.sonelli.juicessh.controllers.SftpControllerInterface
    /* renamed from: b */
    public void mo5380b() {
        gj0.m4141b("SftpGetsController", "Start/Resuming sftp download job (" + this.f8231d + ")");
        this.f8232e = EnumC2355g.ACTIVE;
        if (this.f8244q == null) {
            this.f8244q = new vi0(this.f8233f.m5124u(), 0, this.f8231d, this.f8233f.f3567j.m5471w(), this.f8237j, this.f8229b.getPath());
        }
        if (!this.f8234g) {
            this.f8234g = m10150h();
        }
        if (!this.f8234g && this.f8228a != 0) {
            cancel(false);
        }
        for (int i = 0; i < Math.min(1, this.f8238k.size()); i++) {
            this.f8245r.post(new RunnableC2350b());
        }
    }

    @Override // com.sonelli.juicessh.controllers.SftpControllerInterface
    public void cancel(boolean z) {
        gj0.m4141b("SftpGetsController", "Received sftp job (" + this.f8231d + ") cancel request");
        pause();
        if (this.f8228a == 2) {
            gj0.m4142c("SftpGetsController", "Rollbacks are enabled on cancel.");
            m10157o();
        }
        this.f8232e = EnumC2355g.STOPPED;
        this.f8244q.m9239m(z);
    }

    /* renamed from: h */
    public final boolean m10150h() {
        Iterator<String> it = this.f8235h.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            File m10154l = m10154l(next.replaceFirst(this.f8230c, this.f8229b.getPath()), true);
            gj0.m4141b("SftpGetsController", "Creating directory '" + m10154l.getPath() + "'");
            if (m10154l.mkdir()) {
                this.f8244q.m9227a(i, m10155m(next, m10154l.getPath()));
                this.f8240m.put(next, m10154l);
            } else {
                this.f8244q.m9228b(i, m10155m(next, m10154l.getPath()));
                this.f8241n.put(next, m10154l);
                z = true;
            }
            i++;
        }
        return !z;
    }

    /* renamed from: i */
    public final String m10151i(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "$^";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i > strArr.length; i++) {
            sb.append(String.format("|%s", strArr[i]));
        }
        return sb.toString();
    }

    /* renamed from: j */
    public final boolean m10152j() {
        ArrayList arrayList = new ArrayList(this.f8240m.values());
        Collections.sort(arrayList, Collections.reverseOrder());
        Iterator it = arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!file.getPath().equals(this.f8229b.getPath())) {
                gj0.m4141b("SftpGetsController", "ROLLBACK: Deleting directory '" + file.getPath() + "'");
                if (!file.delete()) {
                    gj0.m4142c("SftpGetsController", "ROLLBACK: directory delete failed.");
                    z = true;
                }
            }
        }
        return !z;
    }

    /* renamed from: k */
    public final boolean m10153k() {
        boolean z = false;
        for (File file : this.f8242o.values()) {
            gj0.m4141b("SftpGetsController", "ROLLBACK: Deleting file '" + file.getPath() + "'");
            if (!file.delete()) {
                gj0.m4142c("SftpGetsController", "ROLLBACK: file delete failed.");
                z = true;
            }
        }
        return !z;
    }

    /* renamed from: l */
    public final File m10154l(String str, boolean z) {
        String substring;
        File file = new File(str);
        String name = file.getName();
        String str2 = "";
        if (z) {
            gj0.m4141b("SftpGetsController", str + " is a directory");
            str = str.substring(0, str.length() - (str.endsWith(File.separator) ? 1 : 0));
        } else {
            if (!name.startsWith(".") && name.contains(".")) {
                gj0.m4141b("SftpGetsController", str + " is not a hidden file and has an extension");
                substring = str.substring(0, str.lastIndexOf(".") - 1);
                str2 = str.substring(str.lastIndexOf("."));
            } else if (!name.startsWith(".") || name.length() - name.replaceAll("\\.", "").length() < 2) {
                gj0.m4141b("SftpGetsController", str + " doesn't have an extension");
            } else {
                gj0.m4141b("SftpGetsController", str + " is a hidden file and has an extension");
                substring = str.substring(0, str.lastIndexOf(".") - 1);
                str2 = str.substring(str.lastIndexOf("."));
            }
            str = substring;
        }
        int i = 0;
        while (file.exists()) {
            gj0.m4141b("SftpGetsController", "Local file '" + file.getPath() + "' already exists. Incrementing extension.");
            i++;
            file = new File(String.format("%s (%d)%s", str, Integer.valueOf(i), str2));
        }
        return file;
    }

    /* renamed from: m */
    public final Map.Entry<String, String> m10155m(String str, String str2) {
        return new C2353e(this, str, str2);
    }

    /* renamed from: n */
    public final void m10156n() {
        if (this.f8232e != EnumC2355g.ACTIVE) {
            return;
        }
        try {
            gj0.m4141b("SftpGetsController", "Picking the next queued download. Jobs queued: " + this.f8238k.size());
            int intValue = this.f8238k.pop().intValue();
            gj0.m4141b("SftpGetsController", "Picked job with job index " + intValue + ". (indexes can be re-queued)");
            String str = this.f8236i.get(intValue);
            gj0.m4141b("SftpGetsController", "Index " + intValue + " corresponds to " + str);
            File file = new File(str);
            String parent = file.getParent();
            String name = file.getName();
            gj0.m4141b("SftpGetsController", "Looking up local directory mapping for remote parent dir: " + parent);
            File m10154l = m10154l(String.format("%s%s%s", this.f8240m.get(parent).getPath(), File.separator, name), false);
            this.f8239l.put(str, m10154l);
            gj0.m4141b("SftpGetsController", "Saving " + str + " to " + m10154l.getPath());
            this.f8244q.m9241o(new C2352d());
            gj0.m4142c("SftpGetsController", "TO IMPLEMENT!");
        } catch (NoSuchElementException unused) {
        }
    }

    /* renamed from: o */
    public void m10157o() {
        gj0.m4141b("SftpGetsController", "Rolling back sftp job (" + this.f8231d + ")");
        m10153k();
        m10152j();
    }

    /* renamed from: p */
    public void m10158p(int i) {
        this.f8231d = i;
    }

    @Override // com.sonelli.juicessh.controllers.SftpControllerInterface
    public void pause() {
        gj0.m4141b("SftpGetsController", "Received sftp job (" + this.f8231d + ") pause request");
        this.f8245r.post(new RunnableC2351c());
    }
}
