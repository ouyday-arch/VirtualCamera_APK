package l1;

import android.content.Intent;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f4496a = Pattern.compile(",");

    /* renamed from: b, reason: collision with root package name */
    static final Set<g1.a> f4497b;

    /* renamed from: c, reason: collision with root package name */
    static final Set<g1.a> f4498c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<g1.a> f4499d;

    /* renamed from: e, reason: collision with root package name */
    static final Set<g1.a> f4500e;

    /* renamed from: f, reason: collision with root package name */
    static final Set<g1.a> f4501f;

    /* renamed from: g, reason: collision with root package name */
    static final Set<g1.a> f4502g;

    /* renamed from: h, reason: collision with root package name */
    static final Set<g1.a> f4503h;

    /* renamed from: i, reason: collision with root package name */
    private static final Map<String, Set<g1.a>> f4504i;

    static {
        EnumSet of = EnumSet.of(g1.a.QR_CODE);
        f4500e = of;
        EnumSet of2 = EnumSet.of(g1.a.DATA_MATRIX);
        f4501f = of2;
        EnumSet of3 = EnumSet.of(g1.a.AZTEC);
        f4502g = of3;
        EnumSet of4 = EnumSet.of(g1.a.PDF_417);
        f4503h = of4;
        EnumSet of5 = EnumSet.of(g1.a.UPC_A, g1.a.UPC_E, g1.a.EAN_13, g1.a.EAN_8, g1.a.RSS_14, g1.a.RSS_EXPANDED);
        f4497b = of5;
        EnumSet of6 = EnumSet.of(g1.a.CODE_39, g1.a.CODE_93, g1.a.CODE_128, g1.a.ITF, g1.a.CODABAR);
        f4498c = of6;
        EnumSet copyOf = EnumSet.copyOf((Collection) of5);
        f4499d = copyOf;
        copyOf.addAll(of6);
        HashMap hashMap = new HashMap();
        f4504i = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of5);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("DATA_MATRIX_MODE", of2);
        hashMap.put("AZTEC_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }

    public static Set<g1.a> a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return b(stringExtra != null ? Arrays.asList(f4496a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    private static Set<g1.a> b(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet noneOf = EnumSet.noneOf(g1.a.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    noneOf.add(g1.a.valueOf(it.next()));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f4504i.get(str);
        }
        return null;
    }
}
