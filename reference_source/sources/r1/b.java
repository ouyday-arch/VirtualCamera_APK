package r1;

import r1.e;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f5758a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f5759b;

    private b(int i4, byte[] bArr) {
        this.f5758a = i4;
        this.f5759b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, e eVar) {
        e.c d5 = eVar.d();
        e.b[] a5 = d5.a();
        int i4 = 0;
        for (e.b bVar : a5) {
            i4 += bVar.a();
        }
        b[] bVarArr = new b[i4];
        int i5 = 0;
        for (e.b bVar2 : a5) {
            int i6 = 0;
            while (i6 < bVar2.a()) {
                int b5 = bVar2.b();
                bVarArr[i5] = new b(b5, new byte[d5.b() + b5]);
                i6++;
                i5++;
            }
        }
        int length = bVarArr[0].f5759b.length - d5.b();
        int i7 = length - 1;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = 0;
            while (i10 < i5) {
                bVarArr[i10].f5759b[i9] = bArr[i8];
                i10++;
                i8++;
            }
        }
        boolean z4 = eVar.i() == 24;
        int i11 = z4 ? 8 : i5;
        int i12 = 0;
        while (i12 < i11) {
            bVarArr[i12].f5759b[i7] = bArr[i8];
            i12++;
            i8++;
        }
        int length2 = bVarArr[0].f5759b.length;
        while (length < length2) {
            int i13 = 0;
            while (i13 < i5) {
                int i14 = z4 ? (i13 + 8) % i5 : i13;
                bVarArr[i14].f5759b[(!z4 || i14 <= 7) ? length : length - 1] = bArr[i8];
                i13++;
                i8++;
            }
            length++;
        }
        if (i8 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f5759b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f5758a;
    }
}
