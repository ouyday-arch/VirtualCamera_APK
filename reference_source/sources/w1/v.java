package w1;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f6398a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f6399b = new StringBuilder();

    private int a(n1.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6398a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l4 = aVar.l();
        int i4 = iArr[1];
        int i5 = 0;
        for (int i6 = 0; i6 < 2 && i4 < l4; i6++) {
            int k4 = y.k(aVar, iArr2, i4, y.f6410h);
            sb.append((char) ((k4 % 10) + 48));
            for (int i7 : iArr2) {
                i4 += i7;
            }
            if (k4 >= 10) {
                i5 |= 1 << (1 - i6);
            }
            if (i6 != 1) {
                i4 = aVar.k(aVar.j(i4));
            }
        }
        if (sb.length() != 2) {
            throw g1.m.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i5) {
            return i4;
        }
        throw g1.m.a();
    }

    private static Map<g1.r, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(g1.r.class);
        enumMap.put((EnumMap) g1.r.ISSUE_NUMBER, (g1.r) Integer.valueOf(str));
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1.q b(int i4, n1.a aVar, int[] iArr) {
        StringBuilder sb = this.f6399b;
        sb.setLength(0);
        int a5 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<g1.r, Object> c5 = c(sb2);
        float f4 = i4;
        g1.q qVar = new g1.q(sb2, null, new g1.s[]{new g1.s((iArr[0] + iArr[1]) / 2.0f, f4), new g1.s(a5, f4)}, g1.a.UPC_EAN_EXTENSION);
        if (c5 != null) {
            qVar.g(c5);
        }
        return qVar;
    }
}
