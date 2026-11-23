package com.sonelli;

import androidx.media.AudioAttributesCompat;
import com.sonelli.libssh.sftp_attributes_struct;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import java.nio.file.attribute.PosixFilePermission;

/* compiled from: SSHSftpResolvedAttributes.java */
/* loaded from: classes.dex */
public class lk0 {

    /* renamed from: A */
    public static final int f4849A;

    /* renamed from: z */
    public static final PosixFilePermission[] f4850z;

    /* renamed from: a */
    public String f4851a;

    /* renamed from: b */
    public String f4852b;

    /* renamed from: c */
    public String f4853c;

    /* renamed from: d */
    public String f4854d;

    /* renamed from: e */
    public String f4855e;

    /* renamed from: f */
    public String f4856f;

    /* renamed from: g */
    public String f4857g;

    /* renamed from: h */
    public Short f4858h;

    /* renamed from: i */
    public int f4859i;

    /* renamed from: j */
    public String f4860j;

    /* renamed from: k */
    public int f4861k;

    /* renamed from: l */
    public int f4862l;

    /* renamed from: m */
    public long f4863m;

    /* renamed from: n */
    public int f4864n;

    /* renamed from: o */
    public int f4865o;

    /* renamed from: p */
    public int f4866p;

    /* renamed from: q */
    public long f4867q;

    /* renamed from: r */
    public int f4868r;

    /* renamed from: s */
    public int f4869s;

    /* renamed from: t */
    public long f4870t;

    /* renamed from: u */
    public int f4871u;

    /* renamed from: v */
    public long f4872v;

    /* renamed from: w */
    public int f4873w;

    /* renamed from: x */
    public int f4874x;

    /* renamed from: y */
    public int f4875y;

    static {
        PosixFilePermission[] values = PosixFilePermission.values();
        f4850z = values;
        f4849A = values.length;
    }

    public lk0(sftp_attributes_struct sftp_attributes_structVar) {
        Pointer pointer = sftp_attributes_structVar.name;
        if (pointer != null) {
            this.f4851a = pointer.getString(0L);
        }
        Pointer pointer2 = sftp_attributes_structVar.longname;
        if (pointer2 != null) {
            this.f4852b = pointer2.getString(0L);
        }
        Pointer pointer3 = sftp_attributes_structVar.owner;
        if (pointer3 != null) {
            this.f4853c = pointer3.getString(0L);
        }
        Pointer pointer4 = sftp_attributes_structVar.group;
        if (pointer4 != null) {
            this.f4854d = pointer4.getString(0L);
        }
        ssh_string_struct.ByReference byReference = sftp_attributes_structVar.acl;
        if (byReference != null) {
            this.f4855e = byReference.toString();
        }
        ssh_string_struct.ByReference byReference2 = sftp_attributes_structVar.extended_type;
        if (byReference2 != null) {
            this.f4856f = byReference2.toString();
        }
        ssh_string_struct.ByReference byReference3 = sftp_attributes_structVar.extended_data;
        if (byReference3 != null) {
            this.f4857g = byReference3.toString();
        }
        this.f4861k = sftp_attributes_structVar.flags;
        this.f4862l = sftp_attributes_structVar.type;
        this.f4863m = sftp_attributes_structVar.size;
        this.f4864n = sftp_attributes_structVar.uid;
        this.f4865o = sftp_attributes_structVar.gid;
        int i = sftp_attributes_structVar.permissions;
        this.f4866p = i;
        this.f4867q = sftp_attributes_structVar.atime64;
        this.f4868r = sftp_attributes_structVar.atime;
        this.f4869s = sftp_attributes_structVar.atime_nseconds;
        this.f4870t = sftp_attributes_structVar.createtime;
        this.f4871u = sftp_attributes_structVar.createtime_nseconds;
        this.f4872v = sftp_attributes_structVar.mtime64;
        this.f4873w = sftp_attributes_structVar.mtime;
        this.f4874x = sftp_attributes_structVar.mtime_nseconds;
        this.f4875y = sftp_attributes_structVar.extended_count;
        Short valueOf = Short.valueOf((short) (i & AudioAttributesCompat.FLAG_ALL));
        this.f4858h = valueOf;
        int shortValue = (((valueOf.shortValue() >>> 9) & 1) * 1000) + (((this.f4858h.shortValue() >>> 6) & 7) * 100) + (((this.f4858h.shortValue() >>> 3) & 7) * 10) + (this.f4858h.shortValue() & 7);
        this.f4859i = shortValue;
        this.f4860j = m6249a(shortValue);
    }

    /* renamed from: a */
    public String m6249a(int i) {
        char[] charArray = Integer.toString(i).toCharArray();
        char[] cArr = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
        for (int length = charArray.length - 1; length >= 0; length--) {
            int i2 = charArray[length] - '0';
            if (length == charArray.length - 1) {
                if ((i2 & 1) != 0) {
                    cArr[8] = 'x';
                }
                if ((i2 & 2) != 0) {
                    cArr[7] = 'w';
                }
                if ((i2 & 4) != 0) {
                    cArr[6] = 'r';
                }
            } else if (length == charArray.length - 2) {
                if ((i2 & 1) != 0) {
                    cArr[5] = 'x';
                }
                if ((i2 & 2) != 0) {
                    cArr[4] = 'w';
                }
                if ((i2 & 4) != 0) {
                    cArr[3] = 'r';
                }
            } else if (length == charArray.length - 3) {
                if ((i2 & 1) != 0) {
                    cArr[2] = 'x';
                }
                if ((i2 & 2) != 0) {
                    cArr[1] = 'w';
                }
                if ((i2 & 4) != 0) {
                    cArr[0] = 'r';
                }
            }
        }
        return new String(cArr);
    }
}
