package w1;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class s implements g1.u {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f6395a = Pattern.compile("[0-9]+");

    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(boolean[] zArr, int i4, int[] iArr, boolean z4) {
        int i5 = 0;
        for (int i6 : iArr) {
            int i7 = 0;
            while (i7 < i6) {
                zArr[i4] = z4;
                i7++;
                i4++;
            }
            i5 += i6;
            z4 = !z4;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(String str) {
        if (!f6395a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    private static n1.b g(boolean[] zArr, int i4, int i5, int i6) {
        int length = zArr.length;
        int i7 = i6 + length;
        int max = Math.max(i4, i7);
        int max2 = Math.max(1, i5);
        int i8 = max / i7;
        int i9 = (max - (length * i8)) / 2;
        n1.b bVar = new n1.b(max, max2);
        int i10 = 0;
        while (i10 < length) {
            if (zArr[i10]) {
                bVar.o(i9, 0, i8, max2);
            }
            i10++;
            i9 += i8;
        }
        return bVar;
    }

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g1.g, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i4 < 0 || i5 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i4 + 'x' + i5);
        }
        Collection<g1.a> f4 = f();
        if (f4 != null && !f4.contains(aVar)) {
            throw new IllegalArgumentException("Can only encode " + f4 + ", but got " + aVar);
        }
        int e4 = e();
        if (map != null) {
            g1.g gVar = g1.g.MARGIN;
            if (map.containsKey(gVar)) {
                e4 = Integer.parseInt(map.get(gVar).toString());
            }
        }
        return g(d(str), i4, i5, e4);
    }

    public abstract boolean[] d(String str);

    public int e() {
        return 10;
    }

    protected abstract Collection<g1.a> f();
}
