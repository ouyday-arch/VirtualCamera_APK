package g1;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private final int f3947a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3948b;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(int i4, int i5) {
        this.f3947a = i4;
        this.f3948b = i5;
    }

    public final int a() {
        return this.f3948b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i4, byte[] bArr);

    public final int d() {
        return this.f3947a;
    }

    public j e() {
        return new i(this);
    }

    public boolean f() {
        return false;
    }

    public j g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i4 = this.f3947a;
        byte[] bArr = new byte[i4];
        StringBuilder sb = new StringBuilder(this.f3948b * (i4 + 1));
        for (int i5 = 0; i5 < this.f3948b; i5++) {
            bArr = c(i5, bArr);
            for (int i6 = 0; i6 < this.f3947a; i6++) {
                int i7 = bArr[i6] & 255;
                sb.append(i7 < 64 ? '#' : i7 < 128 ? '+' : i7 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
