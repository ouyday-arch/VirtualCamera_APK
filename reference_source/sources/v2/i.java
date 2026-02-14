package v2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class i extends h {
    public static <T> List<T> c(T[] tArr) {
        e3.f.e(tArr, "<this>");
        List<T> a5 = k.a(tArr);
        e3.f.d(a5, "asList(...)");
        return a5;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, int i4, int i5, int i6) {
        e3.f.e(bArr, "<this>");
        e3.f.e(bArr2, "destination");
        System.arraycopy(bArr, i5, bArr2, i4, i6 - i5);
        return bArr2;
    }

    public static <T> T[] e(T[] tArr, T[] tArr2, int i4, int i5, int i6) {
        e3.f.e(tArr, "<this>");
        e3.f.e(tArr2, "destination");
        System.arraycopy(tArr, i5, tArr2, i4, i6 - i5);
        return tArr2;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7, Object obj) {
        byte[] d5;
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = bArr.length;
        }
        d5 = d(bArr, bArr2, i4, i5, i6);
        return d5;
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i4, int i5, int i6, int i7, Object obj) {
        Object[] e4;
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = objArr.length;
        }
        e4 = e(objArr, objArr2, i4, i5, i6);
        return e4;
    }

    public static byte[] h(byte[] bArr, int i4, int i5) {
        e3.f.e(bArr, "<this>");
        g.b(i5, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4, i5);
        e3.f.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static <T> T[] i(T[] tArr, int i4, int i5) {
        e3.f.e(tArr, "<this>");
        g.b(i5, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i4, i5);
        e3.f.d(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static void j(byte[] bArr, byte b5, int i4, int i5) {
        e3.f.e(bArr, "<this>");
        Arrays.fill(bArr, i4, i5, b5);
    }

    public static <T> void k(T[] tArr, T t4, int i4, int i5) {
        e3.f.e(tArr, "<this>");
        Arrays.fill(tArr, i4, i5, t4);
    }

    public static /* synthetic */ void l(Object[] objArr, Object obj, int i4, int i5, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = objArr.length;
        }
        k(objArr, obj, i4, i5);
    }

    public static final <T> void m(T[] tArr, Comparator<? super T> comparator) {
        e3.f.e(tArr, "<this>");
        e3.f.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
