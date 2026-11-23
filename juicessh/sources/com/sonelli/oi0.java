package com.sonelli;

import com.sonelli.juicessh.models.Purchase;
import com.sonelli.juicessh.models.User;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: SQLiteOpenHelper.java */
/* loaded from: classes.dex */
public class oi0 {

    /* compiled from: SQLiteOpenHelper.java */
    /* renamed from: com.sonelli.oi0$a */
    /* loaded from: classes.dex */
    public static class C1659a implements Comparator<Purchase> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Purchase purchase, Purchase purchase2) {
            if (purchase.time.longValue() < purchase2.time.longValue()) {
                return -1;
            }
            return purchase.time.equals(purchase2.time) ? 0 : 1;
        }
    }

    /* renamed from: a */
    public static String m7044a() {
        return new String(new BigInteger(BigInteger.valueOf(10471755074L).toString() + BigInteger.valueOf(47679379561L).toString() + BigInteger.valueOf(57882041102L).toString() + BigInteger.valueOf(44340073873L).toString() + BigInteger.valueOf(28680799803L).toString() + BigInteger.valueOf(9687621075819L).toString()).toByteArray());
    }

    /* renamed from: b */
    public static String m7045b() {
        return new String(new BigInteger(BigInteger.valueOf(1361606516837L).toString() + BigInteger.valueOf(6105031042448L).toString() + BigInteger.valueOf(8668161119879L).toString() + BigInteger.valueOf(5161693098030L).toString() + BigInteger.valueOf(7152043972751L).toString() + BigInteger.valueOf(6981286209935L).toString() + BigInteger.valueOf(1499438042579L).toString() + BigInteger.valueOf(6951474617685L).toString() + BigInteger.valueOf(2927390277267L).toString() + BigInteger.valueOf(74624871794L).toString()).toByteArray());
    }

    /* renamed from: c */
    public static String m7046c() {
        return new String(new BigInteger(BigInteger.valueOf(273787029672522L).toString() + BigInteger.valueOf(244175256918197L).toString() + BigInteger.valueOf(53428575588L).toString()).toByteArray());
    }

    /* renamed from: d */
    public static boolean m7047d(Object obj) {
        // [OfflineProFix merged] pro check always passes (was Xposed hook oi0.d(Object) => true)
        return true;
        /*
        if (!obj.getClass().getName().equals(User.class.getName())) {
            return false;
        }
        try {
            if (!((User) obj).m5531H()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (Purchase purchase : ((User) obj).purchases) {
                if (purchase.product.equals(m7044a())) {
                    arrayList.add(purchase);
                }
            }
            Collections.sort(arrayList, new C1659a());
            if (arrayList.size() > 0) {
                if (((Purchase) arrayList.get(arrayList.size() - 1)).state.intValue() == 0) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        */
    }
}
