package g3;

import g3.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends k {
    public static int b(int i4, int i5) {
        return i4 < i5 ? i5 : i4;
    }

    public static int c(int i4, int i5) {
        return i4 > i5 ? i5 : i4;
    }

    public static int d(int i4, int i5, int i6) {
        if (i5 <= i6) {
            return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i6 + " is less than minimum " + i5 + '.');
    }

    public static long e(long j4, long j5, long j6) {
        if (j5 <= j6) {
            return j4 < j5 ? j5 : j4 > j6 ? j6 : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j6 + " is less than minimum " + j5 + '.');
    }

    public static d f(int i4, int i5) {
        return d.f4044e.a(i4, i5, -1);
    }

    public static d g(d dVar, int i4) {
        e3.f.e(dVar, "<this>");
        k.a(i4 > 0, Integer.valueOf(i4));
        d.a aVar = d.f4044e;
        int a5 = dVar.a();
        int b5 = dVar.b();
        if (dVar.c() <= 0) {
            i4 = -i4;
        }
        return aVar.a(a5, b5, i4);
    }

    public static f h(int i4, int i5) {
        return i5 <= Integer.MIN_VALUE ? f.f4052f.a() : new f(i4, i5 - 1);
    }
}
