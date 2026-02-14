package x1;

import g1.s;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f6478a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f6479b;

    /* renamed from: c, reason: collision with root package name */
    private final s[] f6480c;

    public c(int i4, int[] iArr, int i5, int i6, int i7) {
        this.f6478a = i4;
        this.f6479b = iArr;
        float f4 = i7;
        this.f6480c = new s[]{new s(i5, f4), new s(i6, f4)};
    }

    public s[] a() {
        return this.f6480c;
    }

    public int[] b() {
        return this.f6479b;
    }

    public int c() {
        return this.f6478a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f6478a == ((c) obj).f6478a;
    }

    public int hashCode() {
        return this.f6478a;
    }
}
