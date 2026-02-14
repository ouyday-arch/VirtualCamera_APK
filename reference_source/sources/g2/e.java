package g2;

import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final p1.c f3999a = new p1.c(p1.a.f5416l);

    private void a(byte[] bArr, int i4) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = bArr[i5] & 255;
        }
        try {
            this.f3999a.a(iArr, bArr.length - i4);
            for (int i6 = 0; i6 < i4; i6++) {
                bArr[i6] = (byte) iArr[i6];
            }
        } catch (p1.e unused) {
            throw g1.d.a();
        }
    }

    private n1.e b(a aVar, Map<g1.e, ?> map) {
        j e4 = aVar.e();
        f d5 = aVar.d().d();
        b[] b5 = b.b(aVar.c(), e4, d5);
        int i4 = 0;
        for (b bVar : b5) {
            i4 += bVar.c();
        }
        byte[] bArr = new byte[i4];
        int i5 = 0;
        for (b bVar2 : b5) {
            byte[] a5 = bVar2.a();
            int c5 = bVar2.c();
            a(a5, c5);
            int i6 = 0;
            while (i6 < c5) {
                bArr[i5] = a5[i6];
                i6++;
                i5++;
            }
        }
        return d.a(bArr, e4, d5, map);
    }

    public n1.e c(n1.b bVar, Map<g1.e, ?> map) {
        g1.d e4;
        a aVar = new a(bVar);
        g1.h hVar = null;
        try {
            return b(aVar, map);
        } catch (g1.d e5) {
            e4 = e5;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                n1.e b5 = b(aVar, map);
                b5.m(new i(true));
                return b5;
            } catch (g1.d | g1.h unused) {
                if (hVar != null) {
                    throw hVar;
                }
                throw e4;
            }
        } catch (g1.h e6) {
            e4 = null;
            hVar = e6;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            n1.e b52 = b(aVar, map);
            b52.m(new i(true));
            return b52;
        }
    }
}
