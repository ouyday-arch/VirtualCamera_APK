package g2;

import g2.j;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f3986a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f3987b;

    private b(int i4, byte[] bArr) {
        this.f3986a = i4;
        this.f3987b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.h()) {
            throw new IllegalArgumentException();
        }
        j.b f4 = jVar.f(fVar);
        j.a[] a5 = f4.a();
        int i4 = 0;
        for (j.a aVar : a5) {
            i4 += aVar.a();
        }
        b[] bVarArr = new b[i4];
        int i5 = 0;
        for (j.a aVar2 : a5) {
            int i6 = 0;
            while (i6 < aVar2.a()) {
                int b5 = aVar2.b();
                bVarArr[i5] = new b(b5, new byte[f4.b() + b5]);
                i6++;
                i5++;
            }
        }
        int length = bVarArr[0].f3987b.length;
        int i7 = i4 - 1;
        while (i7 >= 0 && bVarArr[i7].f3987b.length != length) {
            i7--;
        }
        int i8 = i7 + 1;
        int b6 = length - f4.b();
        int i9 = 0;
        for (int i10 = 0; i10 < b6; i10++) {
            int i11 = 0;
            while (i11 < i5) {
                bVarArr[i11].f3987b[i10] = bArr[i9];
                i11++;
                i9++;
            }
        }
        int i12 = i8;
        while (i12 < i5) {
            bVarArr[i12].f3987b[b6] = bArr[i9];
            i12++;
            i9++;
        }
        int length2 = bVarArr[0].f3987b.length;
        while (b6 < length2) {
            int i13 = 0;
            while (i13 < i5) {
                bVarArr[i13].f3987b[i13 < i8 ? b6 : b6 + 1] = bArr[i9];
                i13++;
                i9++;
            }
            b6++;
        }
        return bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f3987b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f3986a;
    }
}
