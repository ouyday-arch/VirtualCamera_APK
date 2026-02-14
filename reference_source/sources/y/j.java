package y;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private ViewParent f6530a;

    /* renamed from: b, reason: collision with root package name */
    private ViewParent f6531b;

    /* renamed from: c, reason: collision with root package name */
    private final View f6532c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6533d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f6534e;

    public j(View view) {
        this.f6532c = view;
    }

    private boolean h(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        ViewParent i9;
        int i10;
        int i11;
        int[] iArr3;
        if (!m() || (i9 = i(i8)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f6532c.getLocationInWindow(iArr);
            i10 = iArr[0];
            i11 = iArr[1];
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (iArr2 == null) {
            int[] j4 = j();
            j4[0] = 0;
            j4[1] = 0;
            iArr3 = j4;
        } else {
            iArr3 = iArr2;
        }
        s.d(i9, this.f6532c, i4, i5, i6, i7, i8, iArr3);
        if (iArr != null) {
            this.f6532c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i10;
            iArr[1] = iArr[1] - i11;
        }
        return true;
    }

    private ViewParent i(int i4) {
        if (i4 == 0) {
            return this.f6530a;
        }
        if (i4 != 1) {
            return null;
        }
        return this.f6531b;
    }

    private int[] j() {
        if (this.f6534e == null) {
            this.f6534e = new int[2];
        }
        return this.f6534e;
    }

    private void o(int i4, ViewParent viewParent) {
        if (i4 == 0) {
            this.f6530a = viewParent;
        } else {
            if (i4 != 1) {
                return;
            }
            this.f6531b = viewParent;
        }
    }

    public boolean a(float f4, float f5, boolean z4) {
        ViewParent i4;
        if (!m() || (i4 = i(0)) == null) {
            return false;
        }
        return s.a(i4, this.f6532c, f4, f5, z4);
    }

    public boolean b(float f4, float f5) {
        ViewParent i4;
        if (!m() || (i4 = i(0)) == null) {
            return false;
        }
        return s.b(i4, this.f6532c, f4, f5);
    }

    public boolean c(int i4, int i5, int[] iArr, int[] iArr2) {
        return d(i4, i5, iArr, iArr2, 0);
    }

    public boolean d(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        ViewParent i7;
        int i8;
        int i9;
        if (!m() || (i7 = i(i6)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f6532c.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i9 = iArr2[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        s.c(i7, this.f6532c, i4, i5, iArr, i6);
        if (iArr2 != null) {
            this.f6532c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i9;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        h(i4, i5, i6, i7, iArr, i8, iArr2);
    }

    public boolean f(int i4, int i5, int i6, int i7, int[] iArr) {
        return h(i4, i5, i6, i7, iArr, 0, null);
    }

    public boolean g(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        return h(i4, i5, i6, i7, iArr, i8, null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i4) {
        return i(i4) != null;
    }

    public boolean m() {
        return this.f6533d;
    }

    public void n(boolean z4) {
        if (this.f6533d) {
            p.p0(this.f6532c);
        }
        this.f6533d = z4;
    }

    public boolean p(int i4) {
        return q(i4, 0);
    }

    public boolean q(int i4, int i5) {
        if (l(i5)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f6532c;
        for (ViewParent parent = this.f6532c.getParent(); parent != null; parent = parent.getParent()) {
            if (s.f(parent, view, this.f6532c, i4, i5)) {
                o(i5, parent);
                s.e(parent, view, this.f6532c, i4, i5);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i4) {
        ViewParent i5 = i(i4);
        if (i5 != null) {
            s.g(i5, this.f6532c, i4);
            o(i4, null);
        }
    }
}
