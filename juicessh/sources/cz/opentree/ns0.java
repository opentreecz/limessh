package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes.dex */
public class ns0 {

    /* renamed from: a */
    public static final Hashtable f5359a;

    /* renamed from: b */
    public static final Hashtable f5360b;

    /* renamed from: c */
    public static final Hashtable f5361c;

    static {
        Hashtable hashtable = new Hashtable();
        f5359a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        f5360b = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        f5361c = hashtable3;
        BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316");
        BigInteger bigInteger4 = new BigInteger("166");
        BigInteger bigInteger5 = ECConstants.f8873b;
        gv0.C1079f c1079f = new gv0.C1079f(bigInteger, bigInteger3, bigInteger4, bigInteger2, bigInteger5);
        m6778b(c1079f);
        du0 du0Var = new du0(c1079f, m6777a(c1079f, new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger2, bigInteger5);
        aq0 aq0Var = CryptoProObjectIdentifiers.f8722b;
        hashtable2.put(aq0Var, du0Var);
        BigInteger bigInteger6 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger7 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        gv0.C1079f c1079f2 = new gv0.C1079f(bigInteger6, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), bigInteger7, bigInteger5);
        m6778b(c1079f2);
        du0 du0Var2 = new du0(c1079f2, m6777a(c1079f2, new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger7, bigInteger5);
        aq0 aq0Var2 = CryptoProObjectIdentifiers.f8725e;
        hashtable2.put(aq0Var2, du0Var2);
        BigInteger bigInteger8 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        BigInteger bigInteger9 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        gv0.C1079f c1079f3 = new gv0.C1079f(bigInteger8, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), bigInteger9, bigInteger5);
        m6778b(c1079f3);
        du0 du0Var3 = new du0(c1079f3, m6777a(c1079f3, new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124")), bigInteger9, bigInteger5);
        aq0 aq0Var3 = CryptoProObjectIdentifiers.f8723c;
        hashtable2.put(aq0Var3, du0Var3);
        BigInteger bigInteger10 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger11 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        gv0.C1079f c1079f4 = new gv0.C1079f(bigInteger10, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger11, bigInteger5);
        m6778b(c1079f4);
        du0 du0Var4 = new du0(c1079f4, m6777a(c1079f4, new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger11, bigInteger5);
        aq0 aq0Var4 = CryptoProObjectIdentifiers.f8726f;
        hashtable2.put(aq0Var4, du0Var4);
        BigInteger bigInteger12 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger13 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        gv0.C1079f c1079f5 = new gv0.C1079f(bigInteger12, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger13, bigInteger5);
        m6778b(c1079f5);
        du0 du0Var5 = new du0(c1079f5, m6777a(c1079f5, new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger13, bigInteger5);
        aq0 aq0Var5 = CryptoProObjectIdentifiers.f8724d;
        hashtable2.put(aq0Var5, du0Var5);
        BigInteger bigInteger14 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", 16);
        BigInteger bigInteger15 = new BigInteger("400000000000000000000000000000000FD8CDDFC87B6635C115AF556C360C67", 16);
        BigInteger bigInteger16 = new BigInteger("C2173F1513981673AF4892C23035A27CE25E2013BF95AA33B22C656F277E7335", 16);
        BigInteger bigInteger17 = new BigInteger("295F9BAE7428ED9CCC20E7C359A9D41A22FCCD9108E17BF7BA9337A6F8AE9513", 16);
        BigInteger bigInteger18 = ECConstants.f8875d;
        gv0.C1079f c1079f6 = new gv0.C1079f(bigInteger14, bigInteger16, bigInteger17, bigInteger15, bigInteger18);
        m6778b(c1079f6);
        du0 du0Var6 = new du0(c1079f6, m6777a(c1079f6, new BigInteger("91E38443A5E82C0D880923425712B2BB658B9196932E02C78B2582FE742DAA28", 16), new BigInteger("32879423AB1A0375895786C4BB46E9565FDE0B5344766740AF268ADB32322E5C", 16)), bigInteger15, bigInteger18);
        aq0 aq0Var6 = RosstandartObjectIdentifiers.f8772e;
        hashtable2.put(aq0Var6, du0Var6);
        BigInteger bigInteger19 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger bigInteger20 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF27E69532F48D89116FF22B8D4E0560609B4B38ABFAD2B85DCACDB1411F10B275", 16);
        gv0.C1079f c1079f7 = new gv0.C1079f(bigInteger19, new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC4", 16), new BigInteger("E8C2505DEDFC86DDC1BD0B2B6667F1DA34B82574761CB0E879BD081CFD0B6265EE3CB090F30D27614CB4574010DA90DD862EF9D4EBEE4761503190785A71C760", 16), bigInteger20, bigInteger5);
        m6778b(c1079f7);
        du0 du0Var7 = new du0(c1079f7, m6777a(c1079f7, new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003"), new BigInteger("7503CFE87A836AE3A61B8816E25450E6CE5E1C93ACF1ABC1778064FDCBEFA921DF1626BE4FD036E93D75E6A50E3A41E98028FE5FC235F5B889A589CB5215F2A4", 16)), bigInteger20, bigInteger5);
        aq0 aq0Var7 = RosstandartObjectIdentifiers.f8774g;
        hashtable2.put(aq0Var7, du0Var7);
        BigInteger bigInteger21 = new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006F", 16);
        BigInteger bigInteger22 = new BigInteger("800000000000000000000000000000000000000000000000000000000000000149A1EC142565A545ACFDB77BD9D40CFA8B996712101BEA0EC6346C54374F25BD", 16);
        gv0.C1079f c1079f8 = new gv0.C1079f(bigInteger21, new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006C", 16), new BigInteger("687D1B459DC841457E3E06CF6F5E2517B97C7D614AF138BCBF85DC806C4B289F3E965D2DB1416D217F8B276FAD1AB69C50F78BEE1FA3106EFB8CCBC7C5140116", 16), bigInteger22, bigInteger5);
        m6778b(c1079f8);
        du0 du0Var8 = new du0(c1079f8, m6777a(c1079f8, new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002"), new BigInteger("1A8F7EDA389B094C2C071E3647A8940F3C123B697578C213BE6DD9E6C8EC7335DCB228FD1EDF4A39152CBCAAF8C0398828041055F94CEEEC7E21340780FE41BD", 16)), bigInteger22, bigInteger5);
        aq0 aq0Var8 = RosstandartObjectIdentifiers.f8775h;
        hashtable2.put(aq0Var8, du0Var8);
        BigInteger bigInteger23 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger bigInteger24 = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC98CDBA46506AB004C33A9FF5147502CC8EDA9E7A769A12694623CEF47F023ED", 16);
        gv0.C1079f c1079f9 = new gv0.C1079f(bigInteger23, new BigInteger("DC9203E514A721875485A529D2C722FB187BC8980EB866644DE41C68E143064546E861C0E2C9EDD92ADE71F46FCF50FF2AD97F951FDA9F2A2EB6546F39689BD3", 16), new BigInteger("B4C4EE28CEBC6C2C8AC12952CF37F16AC7EFB6A9F69F4B57FFDA2E4F0DE5ADE038CBC2FFF719D2C18DE0284B8BFEF3B52B8CC7A5F5BF0A3C8D2319A5312557E1", 16), bigInteger24, bigInteger18);
        m6778b(c1079f9);
        du0 du0Var9 = new du0(c1079f9, m6777a(c1079f9, new BigInteger("E2E31EDFC23DE7BDEBE241CE593EF5DE2295B7A9CBAEF021D385F7074CEA043AA27272A7AE602BF2A7B9033DB9ED3610C6FB85487EAE97AAC5BC7928C1950148", 16), new BigInteger("F5CE40D95B5EB899ABBCCFF5911CB8577939804D6527378B8C108C3D2090FF9BE18E2D33E3021ED2EF32D85822423B6304F726AA854BAE07D0396E9A9ADDC40F", 16)), bigInteger24, bigInteger18);
        aq0 aq0Var9 = RosstandartObjectIdentifiers.f8776i;
        hashtable2.put(aq0Var9, du0Var9);
        hashtable.put("GostR3410-2001-CryptoPro-A", aq0Var);
        hashtable.put("GostR3410-2001-CryptoPro-B", aq0Var3);
        hashtable.put("GostR3410-2001-CryptoPro-C", aq0Var5);
        hashtable.put("GostR3410-2001-CryptoPro-XchA", aq0Var2);
        hashtable.put("GostR3410-2001-CryptoPro-XchB", aq0Var4);
        hashtable.put("Tc26-Gost-3410-12-256-paramSetA", aq0Var6);
        hashtable.put("Tc26-Gost-3410-12-512-paramSetA", aq0Var7);
        hashtable.put("Tc26-Gost-3410-12-512-paramSetB", aq0Var8);
        hashtable.put("Tc26-Gost-3410-12-512-paramSetC", aq0Var9);
        hashtable3.put(aq0Var, "GostR3410-2001-CryptoPro-A");
        hashtable3.put(aq0Var3, "GostR3410-2001-CryptoPro-B");
        hashtable3.put(aq0Var5, "GostR3410-2001-CryptoPro-C");
        hashtable3.put(aq0Var2, "GostR3410-2001-CryptoPro-XchA");
        hashtable3.put(aq0Var4, "GostR3410-2001-CryptoPro-XchB");
        hashtable3.put(aq0Var6, "Tc26-Gost-3410-12-256-paramSetA");
        hashtable3.put(aq0Var7, "Tc26-Gost-3410-12-512-paramSetA");
        hashtable3.put(aq0Var8, "Tc26-Gost-3410-12-512-paramSetB");
        hashtable3.put(aq0Var9, "Tc26-Gost-3410-12-512-paramSetC");
    }

    /* renamed from: a */
    public static iv0 m6777a(gv0 gv0Var, BigInteger bigInteger, BigInteger bigInteger2) {
        iv0 mo4262f = gv0Var.mo4262f(bigInteger, bigInteger2);
        pv0.m7553a(mo4262f);
        return mo4262f;
    }

    /* renamed from: b */
    public static gv0 m6778b(gv0 gv0Var) {
        return gv0Var;
    }

    /* renamed from: c */
    public static du0 m6779c(String str) {
        aq0 aq0Var = (aq0) f5359a.get(str);
        if (aq0Var != null) {
            return (du0) f5360b.get(aq0Var);
        }
        return null;
    }

    /* renamed from: d */
    public static du0 m6780d(aq0 aq0Var) {
        return (du0) f5360b.get(aq0Var);
    }

    /* renamed from: e */
    public static aq0 m6781e(String str) {
        return (aq0) f5359a.get(str);
    }
}
