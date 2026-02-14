package v1;

import g1.d;
import g1.h;
import java.util.Map;
import p1.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final p1.c f6278a = new p1.c(p1.a.f5419o);

    private void a(byte[] bArr, int i4, int i5, int i6, int i7) {
        int i8 = i5 + i6;
        int i9 = i7 == 0 ? 1 : 2;
        int[] iArr = new int[i8 / i9];
        for (int i10 = 0; i10 < i8; i10++) {
            if (i7 == 0 || i10 % 2 == i7 - 1) {
                iArr[i10 / i9] = bArr[i10 + i4] & 255;
            }
        }
        try {
            this.f6278a.a(iArr, i6 / i9);
            for (int i11 = 0; i11 < i5; i11++) {
                if (i7 == 0 || i11 % 2 == i7 - 1) {
                    bArr[i11 + i4] = (byte) iArr[i11 / i9];
                }
            }
        } catch (e unused) {
            throw d.a();
        }
    }

    public n1.e b(n1.b bVar, Map<g1.e, ?> map) {
        int i4;
        byte[] a5 = new a(bVar).a();
        a(a5, 0, 10, 10, 0);
        int i5 = a5[0] & 15;
        if (i5 == 2 || i5 == 3 || i5 == 4) {
            a(a5, 20, 84, 40, 1);
            a(a5, 20, 84, 40, 2);
            i4 = 94;
        } else {
            if (i5 != 5) {
                throw h.a();
            }
            a(a5, 20, 68, 56, 1);
            a(a5, 20, 68, 56, 2);
            i4 = 78;
        }
        byte[] bArr = new byte[i4];
        System.arraycopy(a5, 0, bArr, 0, 10);
        System.arraycopy(a5, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i5);
    }
}
