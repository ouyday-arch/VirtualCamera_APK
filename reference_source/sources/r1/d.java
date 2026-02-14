package r1;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final p1.c f5774a = new p1.c(p1.a.f5417m);

    private void a(byte[] bArr, int i4) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = bArr[i5] & 255;
        }
        try {
            this.f5774a.a(iArr, bArr.length - i4);
            for (int i6 = 0; i6 < i4; i6++) {
                bArr[i6] = (byte) iArr[i6];
            }
        } catch (p1.e unused) {
            throw g1.d.a();
        }
    }

    public n1.e b(n1.b bVar) {
        a aVar = new a(bVar);
        b[] b5 = b.b(aVar.c(), aVar.b());
        int i4 = 0;
        for (b bVar2 : b5) {
            i4 += bVar2.c();
        }
        byte[] bArr = new byte[i4];
        int length = b5.length;
        for (int i5 = 0; i5 < length; i5++) {
            b bVar3 = b5[i5];
            byte[] a5 = bVar3.a();
            int c5 = bVar3.c();
            a(a5, c5);
            for (int i6 = 0; i6 < c5; i6++) {
                bArr[(i6 * length) + i5] = a5[i6];
            }
        }
        return c.a(bArr);
    }
}
