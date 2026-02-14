package g3;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends v2.l {

    /* renamed from: b, reason: collision with root package name */
    private final int f4038b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4039c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4040d;

    /* renamed from: e, reason: collision with root package name */
    private int f4041e;

    public b(char c5, char c6, int i4) {
        this.f4038b = i4;
        this.f4039c = c6;
        boolean z4 = true;
        if (i4 <= 0 ? e3.f.f(c5, c6) < 0 : e3.f.f(c5, c6) > 0) {
            z4 = false;
        }
        this.f4040d = z4;
        this.f4041e = z4 ? c5 : c6;
    }

    @Override // v2.l
    public char a() {
        int i4 = this.f4041e;
        if (i4 != this.f4039c) {
            this.f4041e = this.f4038b + i4;
        } else {
            if (!this.f4040d) {
                throw new NoSuchElementException();
            }
            this.f4040d = false;
        }
        return (char) i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f4040d;
    }
}
