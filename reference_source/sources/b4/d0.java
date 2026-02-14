package b4;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class d0 extends g {

    /* renamed from: g, reason: collision with root package name */
    private final transient byte[][] f2334g;

    /* renamed from: h, reason: collision with root package name */
    private final transient int[] f2335h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(byte[][] bArr, int[] iArr) {
        super(g.f2338f.f());
        e3.f.e(bArr, "segments");
        e3.f.e(iArr, "directory");
        this.f2334g = bArr;
        this.f2335h = iArr;
    }

    private final g I() {
        return new g(H());
    }

    @Override // b4.g
    public g A(int i4, int i5) {
        Object[] i6;
        int d5 = b.d(this, i5);
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i4 + " < 0").toString());
        }
        if (!(d5 <= y())) {
            throw new IllegalArgumentException(("endIndex=" + d5 + " > length(" + y() + ')').toString());
        }
        int i7 = d5 - i4;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + d5 + " < beginIndex=" + i4).toString());
        }
        if (i4 == 0 && d5 == y()) {
            return this;
        }
        if (i4 == d5) {
            return g.f2338f;
        }
        int b5 = c4.d.b(this, i4);
        int b6 = c4.d.b(this, d5 - 1);
        i6 = v2.i.i(G(), b5, b6 + 1);
        byte[][] bArr = (byte[][]) i6;
        int[] iArr = new int[bArr.length * 2];
        if (b5 <= b6) {
            int i8 = 0;
            int i9 = b5;
            while (true) {
                iArr[i8] = Math.min(F()[i9] - i4, i7);
                int i10 = i8 + 1;
                iArr[i8 + bArr.length] = F()[G().length + i9];
                if (i9 == b6) {
                    break;
                }
                i9++;
                i8 = i10;
            }
        }
        int i11 = b5 != 0 ? F()[b5 - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i4 - i11);
        return new d0(bArr, iArr);
    }

    @Override // b4.g
    public g C() {
        return I().C();
    }

    @Override // b4.g
    public void E(d dVar, int i4, int i5) {
        e3.f.e(dVar, "buffer");
        int i6 = i4 + i5;
        int b5 = c4.d.b(this, i4);
        while (i4 < i6) {
            int i7 = b5 == 0 ? 0 : F()[b5 - 1];
            int i8 = F()[b5] - i7;
            int i9 = F()[G().length + b5];
            int min = Math.min(i6, i8 + i7) - i4;
            int i10 = i9 + (i4 - i7);
            b0 b0Var = new b0(G()[b5], i10, i10 + min, true, false);
            b0 b0Var2 = dVar.f2325b;
            if (b0Var2 == null) {
                b0Var.f2306g = b0Var;
                b0Var.f2305f = b0Var;
                dVar.f2325b = b0Var;
            } else {
                e3.f.b(b0Var2);
                b0 b0Var3 = b0Var2.f2306g;
                e3.f.b(b0Var3);
                b0Var3.c(b0Var);
            }
            i4 += min;
            b5++;
        }
        dVar.b0(dVar.c0() + i5);
    }

    public final int[] F() {
        return this.f2335h;
    }

    public final byte[][] G() {
        return this.f2334g;
    }

    public byte[] H() {
        byte[] bArr = new byte[y()];
        int length = G().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = F()[length + i4];
            int i8 = F()[i4];
            int i9 = i8 - i5;
            v2.i.d(G()[i4], bArr, i6, i7, i7 + i9);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }

    @Override // b4.g
    public String a() {
        return I().a();
    }

    @Override // b4.g
    public g c(String str) {
        e3.f.e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = G().length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = F()[length + i4];
            int i7 = F()[i4];
            messageDigest.update(G()[i4], i6, i7 - i5);
            i4++;
            i5 = i7;
        }
        byte[] digest = messageDigest.digest();
        e3.f.b(digest);
        return new g(digest);
    }

    @Override // b4.g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.y() == y() && s(0, gVar, 0, y())) {
                return true;
            }
        }
        return false;
    }

    @Override // b4.g
    public int h() {
        return F()[G().length - 1];
    }

    @Override // b4.g
    public int hashCode() {
        int g4 = g();
        if (g4 != 0) {
            return g4;
        }
        int length = G().length;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i4 < length) {
            int i7 = F()[length + i4];
            int i8 = F()[i4];
            byte[] bArr = G()[i4];
            int i9 = (i8 - i6) + i7;
            while (i7 < i9) {
                i5 = (i5 * 31) + bArr[i7];
                i7++;
            }
            i4++;
            i6 = i8;
        }
        u(i5);
        return i5;
    }

    @Override // b4.g
    public String j() {
        return I().j();
    }

    @Override // b4.g
    public int l(byte[] bArr, int i4) {
        e3.f.e(bArr, "other");
        return I().l(bArr, i4);
    }

    @Override // b4.g
    public byte[] n() {
        return H();
    }

    @Override // b4.g
    public byte o(int i4) {
        b.b(F()[G().length - 1], i4, 1L);
        int b5 = c4.d.b(this, i4);
        return G()[b5][(i4 - (b5 == 0 ? 0 : F()[b5 - 1])) + F()[G().length + b5]];
    }

    @Override // b4.g
    public int q(byte[] bArr, int i4) {
        e3.f.e(bArr, "other");
        return I().q(bArr, i4);
    }

    @Override // b4.g
    public boolean s(int i4, g gVar, int i5, int i6) {
        e3.f.e(gVar, "other");
        if (i4 < 0 || i4 > y() - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int b5 = c4.d.b(this, i4);
        while (i4 < i7) {
            int i8 = b5 == 0 ? 0 : F()[b5 - 1];
            int i9 = F()[b5] - i8;
            int i10 = F()[G().length + b5];
            int min = Math.min(i7, i9 + i8) - i4;
            if (!gVar.t(i5, G()[b5], i10 + (i4 - i8), min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            b5++;
        }
        return true;
    }

    @Override // b4.g
    public boolean t(int i4, byte[] bArr, int i5, int i6) {
        e3.f.e(bArr, "other");
        if (i4 < 0 || i4 > y() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int b5 = c4.d.b(this, i4);
        while (i4 < i7) {
            int i8 = b5 == 0 ? 0 : F()[b5 - 1];
            int i9 = F()[b5] - i8;
            int i10 = F()[G().length + b5];
            int min = Math.min(i7, i9 + i8) - i4;
            if (!b.a(G()[b5], i10 + (i4 - i8), bArr, i5, min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            b5++;
        }
        return true;
    }

    @Override // b4.g
    public String toString() {
        return I().toString();
    }
}
