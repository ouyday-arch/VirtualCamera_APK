package b1;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final float f2129a;

    public a(float f4) {
        this.f2129a = f4;
    }

    @Override // b1.c
    public float a(RectF rectF) {
        return this.f2129a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f2129a == ((a) obj).f2129a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2129a)});
    }
}
