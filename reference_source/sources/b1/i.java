package b1;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    private final float f2182a;

    public i(float f4) {
        this.f2182a = f4;
    }

    @Override // b1.c
    public float a(RectF rectF) {
        return this.f2182a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f2182a == ((i) obj).f2182a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2182a)});
    }
}
