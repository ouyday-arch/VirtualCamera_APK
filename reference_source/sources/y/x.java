package y;

import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6566a;

    x(Object obj) {
        this.f6566a = obj;
    }

    public static x h(WindowInsets windowInsets) {
        Objects.requireNonNull(windowInsets);
        return new x(windowInsets);
    }

    public int a() {
        return ((WindowInsets) this.f6566a).getSystemWindowInsetBottom();
    }

    public int b() {
        return ((WindowInsets) this.f6566a).getSystemWindowInsetLeft();
    }

    public int c() {
        return ((WindowInsets) this.f6566a).getSystemWindowInsetRight();
    }

    public int d() {
        return ((WindowInsets) this.f6566a).getSystemWindowInsetTop();
    }

    public boolean e() {
        return ((WindowInsets) this.f6566a).isConsumed();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return x.c.a(this.f6566a, ((x) obj).f6566a);
        }
        return false;
    }

    public x f(int i4, int i5, int i6, int i7) {
        return new x(((WindowInsets) this.f6566a).replaceSystemWindowInsets(i4, i5, i6, i7));
    }

    public WindowInsets g() {
        return (WindowInsets) this.f6566a;
    }

    public int hashCode() {
        Object obj = this.f6566a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
