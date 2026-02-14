package g3;

import java.util.NoSuchElementException;
import v2.b0;

/* loaded from: classes.dex */
public final class e extends b0 {

    /* renamed from: b, reason: collision with root package name */
    private final int f4048b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4049c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4050d;

    /* renamed from: e, reason: collision with root package name */
    private int f4051e;

    public e(int i4, int i5, int i6) {
        this.f4048b = i6;
        this.f4049c = i5;
        boolean z4 = true;
        if (i6 <= 0 ? i4 < i5 : i4 > i5) {
            z4 = false;
        }
        this.f4050d = z4;
        this.f4051e = z4 ? i4 : i5;
    }

    @Override // v2.b0
    public int a() {
        int i4 = this.f4051e;
        if (i4 != this.f4049c) {
            this.f4051e = this.f4048b + i4;
        } else {
            if (!this.f4050d) {
                throw new NoSuchElementException();
            }
            this.f4050d = false;
        }
        return i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f4050d;
    }
}
