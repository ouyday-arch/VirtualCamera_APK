package b1;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final c f2130a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2131b;

    public b(float f4, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f2130a;
            f4 += ((b) cVar).f2131b;
        }
        this.f2130a = cVar;
        this.f2131b = f4;
    }

    @Override // b1.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f2130a.a(rectF) + this.f2131b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2130a.equals(bVar.f2130a) && this.f2131b == bVar.f2131b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2130a, Float.valueOf(this.f2131b)});
    }
}
